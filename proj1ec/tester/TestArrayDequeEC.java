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
        for (int i = 0; i < 100; i++) {
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

        for (int i = 0; i < 1000; i++) {
            sad.addLast(i);
        }
        for (int i = 0; i < 1000; i++) {
            if (!sad.isEmpty()) {
                assertEquals("should be ", i, sad.removeFirst());
            }
        }
    }

}
