package homeworks.DequesAndRandomizedQueues_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomizedQueueTest {

    @Test
    void test1(){
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        System.out.println(rq.size());//        ==> 0
        System.out.println(rq.size());  ;//      ==> 0
        System.out.println(rq.isEmpty());  ;//   ==> true
        System.out.println(rq.size());      ;//  ==> 0
        rq.enqueue(17);//
        System.out.println(rq.dequeue())   ;//  ==> 17
        System.out.println(rq.isEmpty())   ;//  ==> true
        rq.enqueue(10);//
        System.out.println(rq.dequeue()) ;//    ==> 10
        System.out.println(rq.isEmpty())    ;// ==> true
        rq.enqueue(6);//
    }

}