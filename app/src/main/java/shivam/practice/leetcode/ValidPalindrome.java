package shivam.practice.leetcode;

import java.util.Arrays;

public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }


    public static boolean isPalindrome(String s) {
        StringBuffer str = new StringBuffer();
        s = s.toLowerCase();
        char t = ':';
        System.out.println((int) t);
        char[] sar = s.toCharArray();
        for(int i=0; i<sar.length; i++){
            char ch = sar[i];
            if(ch < 97 || ch > 122){
                if(ch - 48 >= 0 && ch - 48 <= 9)
                    str.append(ch);

                else
                    System.out.println(ch);

            }else
                str.append(ch);
        }
        System.out.println(str);
        return checkPalindrome(str);
    }

    private static Boolean checkPalindrome(StringBuffer str) {

        Boolean flag = true;
        int len = str.length();
        for(int i=0; i<len/2; i++){
            if(str.charAt(i) != str.charAt(len - i -1))
                flag = false;
        }
        return flag;
    }
}
