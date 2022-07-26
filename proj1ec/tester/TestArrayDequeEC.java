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

        int expected = 20;
        sad.addFirst(expected);
        int actual = StdRandom.uniform(6);

        assertEquals("addFirst("+expected+")"+'\n'+
                        "removeFirst()"+'\n',
                expected,
                actual);
    }

    @Test
    public void test2(){
        StudentArrayDeque<Integer> sad =  new StudentArrayDeque<>();
        for (int i = 1; i < 10000; i++) {
            int expected1 =StdRandom.uniform(i);
            sad.addFirst(expected1);
            int expected2 =StdRandom.uniform(i);
            sad.addFirst(expected2);
            int actual = sad.removeFirst();
            assertEquals("addFirst("+expected1+")"+'\n'+
                            "removeFirst()"+'\n',
                                expected1,
                                actual);
        }

    }

}
