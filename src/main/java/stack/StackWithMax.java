package stack;

import sun.awt.image.ImageWatched;

public class StackWithMax extends LinkedStack {
    private LinkedStack<Double> maxStack = new LinkedStack();

    public void push(double item) throws Exception {
        if(!maxStack.isEmpty() && (maxStack.pop()) > item){
            maxStack.push(maxStack.top());
        } else {
            maxStack.push(item);
        }
        super.push(item);
    }

    @Override
    public Double pop() throws Exception {
        maxStack.pop();
        return (Double) super.pop();
    }
    public double max() throws Exception {
        return maxStack.top();
    }
}
