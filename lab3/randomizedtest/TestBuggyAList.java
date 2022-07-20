package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE

    @Test
    public  void testThreeAddRemove(){
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> buggy = new BuggyAList<>();

        for (int i = 4; i <= 6; i++) {
            correct.addLast(i);
            buggy.addLast(i);
        }
        assertEquals(correct.size(),buggy.size());



        assertEquals(correct.removeLast(),buggy.removeLast());
        assertEquals(correct.removeLast(),buggy.removeLast());
        assertEquals(correct.removeLast(),buggy.removeLast());

    }
    @Test
    public void randomizedTest(){
        //AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> buggyAList = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                //L.addLast(randVal);
                buggyAList.addLast(randVal);

                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = buggyAList.size();
                System.out.println("size: " + size);
            }
            else if (operationNumber==2&&buggyAList.size()>0){

//                System.out.println("L.getLast=="+L.getLast());
//                System.out.println("L.remove->"+L.removeLast());
                System.out.println("buggy.getLast=="+buggyAList.getLast());
                System.out.println("buggy.remove->"+buggyAList.removeLast());
            }
        }

    }
}
