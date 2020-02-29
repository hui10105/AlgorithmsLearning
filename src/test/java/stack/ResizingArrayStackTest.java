package stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResizingArrayStackTest {
    ResizingArrayStack resizingArrayStack;

    @BeforeEach
    void setUp(){
        resizingArrayStack = new ResizingArrayStack<>("Let");
        resizingArrayStack.push("us");
        resizingArrayStack.push("begin");
        resizingArrayStack.push("!!");
    }

    @Test
    void push() throws Exception {
        assertEquals(resizingArrayStack.size(), 4);
        resizingArrayStack.push("Hello");
        assertEquals(resizingArrayStack.size(), 5);
        assertEquals(resizingArrayStack.pop(), "Hello");
        assertEquals(resizingArrayStack.size(), 4);
        resizingArrayStack.push("Algorithm");
        assertEquals(resizingArrayStack.pop(), "Algorithm");

        assertFalse(resizingArrayStack.isEmpty());

        assertEquals(resizingArrayStack.pop(), "!!");
        assertEquals(resizingArrayStack.pop(), "begin");
        assertEquals(resizingArrayStack.pop(), "us");
        assertEquals(resizingArrayStack.pop(), "Let");
        assertTrue(resizingArrayStack.isEmpty());
        Exception e = assertThrows(Exception.class, ()->{resizingArrayStack.pop();});
        assertEquals(e.getMessage(), "Empty stack can't pop!");
    }
}