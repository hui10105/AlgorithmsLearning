package stack;

import edu.princeton.cs.algs4.StdOut;

public class GetBinaryFromInt {
    public static void main(String[] args){
        int n = 50;

        LinkedStack<Integer> stack = new LinkedStack<Integer>();
        while (n > 0) {
            stack.push(n % 2);
            n = n / 2;
        }

        for (int digit : stack) {
            StdOut.print(digit);
        }

        StdOut.println();
    }
}
