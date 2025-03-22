package shivam.practice.leetcode;

import java.util.HashMap;
import java.util.Stack;

public class MaximalRectangle {

    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        MaximalRectangle maximalRectangle = new MaximalRectangle();

        maximalRectangle.maximalRectangle(matrix);
    }
    public int maximalRectangle(char[][] matrix) {
        int maxRectangle = -1;
        for(int i =0; i<matrix.length; i++){
            int[] height = new int[matrix[0].length];
            for(int j=0; j<matrix[0].length; j++){
                int k=i;
                int count = 0;
                while(k >= 0 && matrix[k--][j] == '1'){
                    count++;
                }
                height[j] = count;
            }
            int maxAr = maxArea(height);
            maxRectangle = maxRectangle > maxAr ? maxRectangle : maxAr;

        }
        return maxRectangle;
    }

    public static int maxArea(int[] height) {
        java.util.Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxArea = -1;
        for(int i=0; i<height.length; i++) {
            int start = i;
            while (!stack.isEmpty() && height[i] <= stack.peek() ){
                Integer h = stack.pop();
                int area = h * (i - map.get(h));
                maxArea = area > maxArea ? area : maxArea;
                start = map.get(h);
            }
            map.put(height[i], start);
            stack.push(height[i]);
        }
        while (!stack.isEmpty()){
            Integer h = stack.pop();
            int area = h * (height.length - map.get(h));
            maxArea = area > maxArea ? area : maxArea;
        }

        System.out.println("MaxArea - "+maxArea);
        return maxArea;
    }
}


