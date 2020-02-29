package stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Evaluate {
    public static void main(String[] args) throws Exception {
        LinkedStack<String> ops = new LinkedStack<>();
        LinkedStack<Double> vals = new LinkedStack<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("(")) {
            } else if (s.equals("+")) {
                ops.push(s);
            } else if (s.equals("*")) {
                ops.push(s);
            } else if (s.equals(")")) {
                String op = ops.pop();
                if (op.equals("+")) {
                    vals.push(vals.pop() + vals.pop());
                } else if (op.equals("*")) {
                    vals.push(vals.pop() * vals.pop());
                }
            } else if(s.equals("=")){
                break;
            } else {
                vals.push(Double.parseDouble(s));
            }
        }
        StdOut.println(vals.pop());
    }
}
