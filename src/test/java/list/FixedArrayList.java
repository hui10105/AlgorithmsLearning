package list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
/**
 * FixedArrayList
 *
 * @author rhzhou
 * @date 2018/12/25 21:53
 */
public class FixedArrayList {
    List list;
    @BeforeEach
    void setUp(){
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("Beans.xml");
        list = (List)context.getBean("resizingArrayStack");
    }

    @Test
    void insertTest() throws Exception {
        //assertThrows(IllegalArgumentException.class, list.insert(1, -1));
    }
}
