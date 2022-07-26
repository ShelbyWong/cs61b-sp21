package tester;

import static org.junit.Assert.*;

import edu.princeton.cs.introcs.StdRandom;
import org.junit.Test;
import student.Deque;
import student.StudentArrayDeque;

public class TestArrayDequeEC {

    @Test
    public void test1(){
        StudentArrayDeque<Integer> sad =  new StudentArrayDeque<>();
        for (int i = 0; i < 1000; i++) {
            double uniform = i*StdRandom.uniform();

            if ((int)uniform<i/2){
                sad.addLast((int)uniform);
            }else {
                sad.addFirst((int)uniform);
            }
        }
        sad.printDeque();
    }

    @Test
    public void test2(){
        StudentArrayDeque<Integer> sad =  new StudentArrayDeque<>();
        for (int i = 1; i < 100; i++) {
            int expected =StdRandom.uniform(i);
            sad.addFirst(expected);
            int actual = sad.removeFirst();
            assertEquals("addFirst("+expected+")"+'\n'+
                            "removeFirst()"+'\n',
                                expected,
                                actual);
        }

    }

}
