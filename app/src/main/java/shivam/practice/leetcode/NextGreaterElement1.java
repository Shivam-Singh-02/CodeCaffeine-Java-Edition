package shivam.practice.leetcode;


import java.util.*;

public class NextGreaterElement1 {

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};

        NextGreaterElement1.nextGreaterElement(nums1, nums2);
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack();
        HashMap<Integer, Integer> ans = new HashMap();
        for(int i=nums2.length-1; i>=0; i--) {
            while (!stack.empty() && stack.peek() < nums2[i]) {
                stack.pop();
            }

            if(stack.empty())
                ans.put(nums2[i], -1);
            else
                ans.put(nums2[i], stack.peek());

            stack.push(nums2[i]);
        }

        int[] finalAns = new int[nums1.length];

        for(int i=0; i<nums1.length; i++){
            finalAns[i] = ans.get(nums1[i]);
        }

        return finalAns;

    }
}
