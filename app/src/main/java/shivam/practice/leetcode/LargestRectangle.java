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
        int[] ar = {1,1};
        Integer maxArea = largestRectangle.largestRectangleArea2(ar);
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

    public int largestRectangleArea2(int[] heights) {
        int[] ls = new int[heights.length];
        int[] rs = new int[heights.length];
        int maxArea = -1;
        Stack<Integer> stack = new Stack();
        for(int i=0 ;i<heights.length; i++){
            while(!stack.empty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(stack.empty())
                ls[i] = 0;
            else
                ls[i] = stack.peek() + 1;
            stack.push(i);
        }

        stack.clear();

        for(int i=heights.length-1 ;i>=0; i--){
            while(!stack.empty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(stack.empty())
                rs[i] = heights.length-1;
            else
                rs[i] = stack.peek() - 1;
            stack.push(i);
        }

        for(int i=0; i<heights.length; i++){
            maxArea = Math.max(maxArea, ((rs[i] - ls[i] + 1) * heights[i]));
        }

        return maxArea;
    }
}
