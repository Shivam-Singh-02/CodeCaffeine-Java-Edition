package shivam.learns.algorithms.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NumberOfBeautifulSubsets {

    public static void main(String[] args) {
        NumberOfBeautifulSubsets numberOfBeautifulSubsets =
                new NumberOfBeautifulSubsets();

        int[] nums = {16,28,82,77,41,22,85,44,97,31,63,2,94,14,47,72};

        int beautifulSubsets = numberOfBeautifulSubsets.beautifulSubsets(nums, 93);
        System.out.println("Beautiful Subsets are - " + beautifulSubsets);
    }

    public int beautifulSubsets(int[] nums, int k) {
        List<Integer> li =
                Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());
        Collections.sort(li);
        return solve(li ,new ArrayList(), 0, k);

    }

    public int solve(List<Integer> input, List<Integer> output, Integer count, Integer k){
        if(input.size() == 0){
            if(output.size() != 0)
                count++;
            System.out.println(output);
            return count;
        }
        List<Integer> output1 = new ArrayList<>(output);
        List<Integer> output2 = new ArrayList<>(output);

        List<Integer> input1 = new ArrayList<>(input);
        input1.remove(0);

        count = solve(input1, output1, count, k);
        if(!output2.contains(input.get(0) - k)) {
            output2.add(input.get(0));

            count = solve(input1, output2, count, k);
        }

        return count;
    }

}