package shivam.practice.leetcode;


import java.util.Arrays;

/*
Leetcode - https://leetcode.com/problems/next-greater-element-iii/description/
Here the catch is -
so if you look closely we are finding the first such occurrence of digit d which is greater
than digit left to it, which mean everything right to such digit d would either be greater
than or equal to such d; for example 1234765443, here you'll find d as 7 which is greater
than it's immediate left digit, else all other digits right of 7 are either equal or greater
than their immediate left digits. That means either equal or ascending order, hence the
reverse makes it in descending order. Hope that explains.
 */
public class NextGreaterElement3 {
    public static int nextGreaterElement(int n) {
        int d = -1;
        char[] ar = String.valueOf(n).toCharArray();
        // to find the first digit smaller than it's next right digit
        for(int i= ar.length-1; i > 0; i-- ){
            if(ar[i-1] < ar[i]){
                d = i-1;
                break;
            }
        }
        if(d == -1)
            return -1;
        // find the smallest greater digit greater than d in the right of d
        int smallestGreater = -1;
        for(int i=d+1; i<ar.length; i++){
            if(ar[i] > ar[d]){
                if(smallestGreater == -1)
                    smallestGreater = i;
                else if(ar[smallestGreater] > ar[i])
                    smallestGreater = i;
            }
        }

        //swap d with smallest greater digit of d
        char temp = ar[d];
        ar[d] = ar[smallestGreater];
        ar[smallestGreater] = temp;

        //Sort the rest of the digits from d
        Arrays.sort(ar, d, ar.length);

        long ans = Long.parseLong(String.valueOf(ar));

        ans = ans <= Integer.MAX_VALUE ? ans : -1;

        return (int) ans;
    }

    public static void main(String[] args) {
        int n = 123476542;

        int[] ar = {1,2,3};

        Arrays.sort(ar);

        int ans = NextGreaterElement3.nextGreaterElement2(n);
        System.out.println(ans);
    }
    public static int nextGreaterElement2(int n) {
        char[] number = (n + "").toCharArray();
        int i = -1;
        //1. find backwards
        for(i = number.length - 1; i > 0; i--)
            if(number[i - 1] < number[i])
                break;
        if(i == 0)
            return -1;
        //2. first, second
        int first = i - 1, second = i;
        //3. find the next greater than first, backward
        for(i = number.length - 1; i > first; i--) {
            if(number[i] > number[first]) {
                char temp = number[i];
                number[i] = number[first];
                number[first] = temp;
                break;
            }
        }
        //4. reverse after second
        reverse(number, second);

        //5. Transform back
        long val = Long.parseLong(new String(number));
        return (val <= Integer.MAX_VALUE) ? (int) val : -1;

    }

    private static void reverse(char[] a,int i)//reverse the number after the number we have found
    {
        int first = i;
        int last = a.length-1;
        while(first<last)
        {
            char t = a[first];
            a[first] = a[last];
            a[last] = t;
            first ++;
            last --;
        }
    }
}
