package sorts;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Sorts
 *
 * @author rhzhou
 * @date 2020/2/27 21:25
 */
public class SortsTest {

    @Test
    public void testInsertionSort(){
        Integer[] in = {3,1,2,5};
        Sorts.insertionSort(in);
        System.out.println(Arrays.toString(in));
    }

    @Test
    public void testShellSort(){
        Integer[] in = {81, 94, 11, 96,12, 35,17,95,28,58, 41, 75, 15};
        Sorts.shellSort(in);
        System.out.println(Arrays.toString(in));
    }

    @Test
    public void test(){
        int i = 123;
        int a = i>>1;
        System.out.println(i);
        System.out.println(a);
    }
}
