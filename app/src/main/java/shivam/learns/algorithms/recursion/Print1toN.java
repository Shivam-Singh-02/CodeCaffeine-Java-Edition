package shivam.learns.algorithms.recursion;

public class Print1toN {
    int print(int n){
        if(n == 1) {
            return 1;
        }
        int num = print(n-1);
        num++;
        System.out.println(num);
        return num;
    }

    public static void main(String[] args) {
        Print1toN print1toN = new Print1toN();
        print1toN.print(5);
    }
}
