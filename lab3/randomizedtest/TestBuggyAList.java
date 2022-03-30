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
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> noResize = new AListNoResizing<>();
        BuggyAList<Integer> buggyAList = new BuggyAList<>();


        for (int x = 4; x < 7; x++){
            noResize.addLast(x);
            buggyAList.addLast(x);
        }

        assertEquals(noResize.size(), buggyAList.size());

        assertEquals(noResize.removeLast(), buggyAList.removeLast());
        assertEquals(noResize.removeLast(), buggyAList.removeLast());
        assertEquals(noResize.removeLast(), buggyAList.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int b_size = B.size();
                System.out.println("size: " + size);
                assertEquals(size, b_size);
            } else if (operationNumber == 2 && L.size() > 0) {
                //getLast
                L.getLast();
                B.getLast();
                System.out.println("getLast");
                assertEquals(L.getLast(), B.getLast());
            }
            else if (operationNumber == 3 && L.size() > 0) {
                //removeLast
                L.removeLast();
                B.removeLast();
                System.out.println("removeLast");
            }

        }
    }
}
