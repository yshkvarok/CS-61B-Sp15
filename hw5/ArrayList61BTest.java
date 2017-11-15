import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

/** ArrayList61BTest. You should write additional tests.
 *  @author Josh Hug
 */

public class ArrayList61BTest {
    @Test
    public void basicTest() {
        List<Integer> L = new ArrayList61B<Integer>();
        L.add(5);
        L.add(10);
        L.add(15);
        L.add(20);
        L.add(25);
        System.out.println(L.get(0));
        System.out.println(L.get(1));
        System.out.println(L.get(2));
        System.out.println(L.get(3));
        System.out.println(L.get(4));
        assertTrue(L.contains(5));        
        assertFalse(L.contains(0));
    }

    @Test
    public void test100() {
        List<Integer> L = new ArrayList61B<Integer>();
        for (int i = 0; i < 100; i++) {
            L.add(i);
        }
        for (int i = 0; i < L.size(); i++) {
            assertEquals(i, (int) L.get(i));
        }
    }

    /** Runs tests. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(ArrayList61BTest.class);
    }
}   