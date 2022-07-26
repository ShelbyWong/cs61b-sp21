package deque;

import org.junit.Test;

import java.util.Comparator;


public class MADTest {
    @Test
    public void MADGetTest(){
        MaxArrayDeque<Integer> mad = new MaxArrayDeque<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        mad.addLast(0);
        mad.addLast(1);
        System.out.println(mad.removeLast());
        System.out.println(mad.removeLast());
    }
}
