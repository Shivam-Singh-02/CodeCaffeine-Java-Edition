package shivam.practice.leetcode;

import java.util.Stack;

/*

Idea is to use 2 passes of the array to cover for the left elements
 */

public class NextGreaterElemenet2 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack();
        int[] ans = new int[n];
        for(int i=2*n-1; i>=0; i--) {
            while (!stack.empty() && stack.peek() <= nums[i%n]) {
                stack.pop();
            }
            if(stack.empty())
                ans[i%n] = -1;
            else
                ans[i%n] = stack.peek();

            stack.push(nums[i%n]);
        }
        return ans;
    }
}
