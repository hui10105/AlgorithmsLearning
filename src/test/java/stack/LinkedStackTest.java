package stack;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedStackTest {
    LinkedStack<String> linkedStack;
    @BeforeEach
    void setUp(){
        linkedStack = new LinkedStack<>("Let");
        linkedStack.push("us");
        linkedStack.push("begin");
        linkedStack.push("!!");
    }

    @Test
    void allMethod() throws Exception {
        assertEquals(linkedStack.size(), 4);
        linkedStack.push("Hello");
        assertEquals(linkedStack.size(), 5);
        assertEquals(linkedStack.pop(), "Hello");
        assertEquals(linkedStack.size(), 4);
        linkedStack.push("Algorithm");
        assertEquals(linkedStack.pop(), "Algorithm");

        assertFalse(linkedStack.isEmpty());

        assertEquals(linkedStack.pop(), "!!");
        assertEquals(linkedStack.pop(), "begin");
        assertEquals(linkedStack.pop(), "us");
        assertEquals(linkedStack.pop(), "Let");
        assertTrue(linkedStack.isEmpty());
        Exception e = assertThrows(Exception.class, ()->{linkedStack.pop();});
        assertEquals(e.getMessage(), "Empty stack can't pop!");
    }
}