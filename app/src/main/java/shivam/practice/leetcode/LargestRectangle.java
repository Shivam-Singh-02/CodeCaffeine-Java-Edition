package shivam.practice.leetcode;

import java.util.AbstractMap;
import java.util.Stack;

/*
This solution uses O(n) extra space in form of a Stack
The total time complexity is O(n) as well since we traverse each element once and push each element at max once in
the Stack.
 */

public class LargestRectangle {

    public static void main(String[] args) {
        LargestRectangle largestRectangle = new LargestRectangle();
        int[] ar = {2,1,5,6,2,3};
        Integer maxArea = largestRectangle.largestRectangleArea(ar);
        System.out.println(maxArea);
    }

    public int largestRectangleArea(int[] heights) {

        Integer maxArea = -1;
        Stack<AbstractMap.SimpleEntry<Integer, Integer>> stack = new Stack();
        for(int i=0; i<heights.length; i++){
            Integer start = i;
            while(!stack.empty() && stack.peek().getValue() > heights[i]){
                AbstractMap.SimpleEntry<Integer, Integer> entry = stack.pop();
                Integer index = entry.getKey();
                Integer height = entry.getValue();
                maxArea = maxArea.compareTo(height * (i - index)) > 0 ? maxArea : height * (i - index);
                start = index;
            }
            stack.push(new AbstractMap.SimpleEntry<>(start, heights[i]));
        }
        for (AbstractMap.SimpleEntry<Integer, Integer> entry : stack) {
            Integer index = entry.getKey();
            Integer height = entry.getValue();
            maxArea = maxArea.compareTo(height * (heights.length - index)) > 0 ? maxArea : height * (heights.length - index);
        }
        return maxArea;
    }
}
