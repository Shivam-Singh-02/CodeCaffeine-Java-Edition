package shivam.practice.leetcode;

public class NextPermutation {
    /*
    Leetcode - https://leetcode.com/problems/next-permutation/description/
    The catch here is to use reverse instead of sort, sort takes at best nlogn while reverse will take O(n), though
    both are accepted solution, reverse is faster and beats 100%
     */
    public void nextPermutation(int[] nums) {
        int d = -1;
        for(int i= nums.length-1 ; i>0; i--){
            if(nums[i-1] < nums[i] ){
                d = i-1;
                break;
            }
        }
        if(d == -1)
            reverse(nums, 0);
        else{
            int smallestGreater = d;
            for(int i=nums.length -1 ; i > d; i--){
                if(nums[i] > nums[d] && nums[smallestGreater] < nums[i]){
                    int temp = nums[i];
                    nums[i] = nums[d];
                    nums[d] = temp;
                    break;
                }
            }
            reverse(nums,d+1);
        }
    }

    public void reverse(int[] nums, int start) {
        int last = nums.length - 1;
        while(start < last){
            int temp = nums[start];
            nums[start] = nums[last];
            nums[last] = temp;
            start++;
            last--;
        }
    }
}
