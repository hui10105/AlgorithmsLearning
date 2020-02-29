package stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackTest {
    Stack stack;

    @BeforeEach
    void setUp(){
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("Beans.xml");
        stack = (Stack)context.getBean("resizingArrayStack");
        stack.push("Let");
        stack.push("us");
        stack.push("begin");
        stack.push("!!");
    }

    @Test
    void push() throws Exception {
        assertEquals(stack.size(), 4);
        stack.push("Hello");
        assertEquals(stack.size(), 5);
        assertEquals(stack.pop(), "Hello");
        assertEquals(stack.size(), 4);
        stack.push("Algorithm");
        assertEquals(stack.pop(), "Algorithm");

        assertFalse(stack.isEmpty());

        assertEquals(stack.pop(), "!!");
        assertEquals(stack.pop(), "begin");
        assertEquals(stack.pop(), "us");
        assertEquals(stack.pop(), "Let");
        assertTrue(stack.isEmpty());
        Exception e = assertThrows(Exception.class, ()->{stack.pop();});
        assertEquals(e.getMessage(), "Empty stack can't pop!");
    }
}
