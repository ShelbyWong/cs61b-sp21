package tester;

import static org.junit.Assert.*;

import edu.princeton.cs.introcs.StdRandom;
import org.junit.Test;
import student.Deque;
import student.StudentArrayDeque;

public class TestArrayDequeEC {


    @Test
    public void test(){

        StudentArrayDeque<Integer> st = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ad = new ArrayDequeSolution<>();

        int n;
        String s = "";
        for (int i = 0; i < 1000; i++) {
            int opt = StdRandom.uniform(0,4);
            switch (opt){
                case 0:
                    n = StdRandom.uniform(0, 100);
                    st.addFirst(n);
                    ad.addFirst(n);
                    s += "addFirst(" + n + ")\n";
                    break;
                case 1:
                    // addLast
                     n = StdRandom.uniform(0, 100);
                    st.addLast(n);
                    ad.addLast(n);
                    s += "addLast(" + n + ")\n";
                    break;
                case 2:
                    if (st.isEmpty()){
                        continue;
                    }
                    s += "removeFirst()\n";
                    assertEquals(s, ad.removeFirst(), st.removeFirst());
                    break;
                case 3:
                    if (st.isEmpty()){
                        continue;
                    }
                    s += "removeLast()\n";
                    assertEquals(s, ad.removeLast(), st.removeLast());
            }

        }
    }

}
