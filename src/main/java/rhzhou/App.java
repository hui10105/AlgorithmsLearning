package rhzhou;

import stack.LinkedStack;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
        LinkedStack<Double> a = new LinkedStack();
        a.pop();
        if(!a.isEmpty() && a.pop() > 0){
            System.out.println("Right!");
        } else {
            System.out.println("Wrong!");
        }
    }

    private <T>void Test(T t){
        //T[] ts = new T[];
    }
}
