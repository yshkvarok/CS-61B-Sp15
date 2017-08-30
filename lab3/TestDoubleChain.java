import static org.junit.Assert.*;

import org.junit.Test;

/** Perform tests of the DoubleChain class
 */

public class TestDoubleChain {

    /** Tests the constructor of DoubleChain */
    @Test
    public void testConstructor() {
        DoubleChain d = new DoubleChain(5);
        assertEquals(5,d.getFront().val, 1e-6);
        assertEquals(null, d.getFront().prev);
        assertEquals(null, d.getFront().next);
    }

    /** Tests some basic DoubleChain operations. */
    @Test
    public void testBasicOperations() {
        DoubleChain d = new DoubleChain(5);
        assertEquals(5, d.getFront().val, 1e-11);
        assertEquals(5, d.getBack().val, 1e-11);

        d.insertFront(2);
        d.insertFront(1);
        d.insertBack(7);
        d.insertBack(8);
        assertEquals(1, d.getFront().val, 1e-11);
        assertEquals(8, d.getBack().val, 1e-11);
    }

    @Test
    public void testToString() {
        DoubleChain d = new DoubleChain(1);
        d.insertBack(2.1);
        d.insertBack(3.3);
        d.insertBack(4.6);
        d.insertBack(5.2);

        assertEquals("<[1.0, 2.1, 3.3, 4.6, 5.2]>", d.toString());
    }

    @Test
    public void testDeleteBack() {
        DoubleChain d = new DoubleChain(1);
        d.insertBack(2.1);
        d.insertBack(3.3);
        d.insertBack(4.6);
        d.insertBack(5.2);
        d.deleteBack();

        assertEquals(4.6, d.getBack().value(), 0.0f);
    }

    @Test
    public void testDeleteByIndex() {
        DoubleChain d = new DoubleChain(3);
        d.insertBack(2.1);
        d.insertBack(3.3);
        d.insertBack(4.6);
        d.insertBack(5.2);
        d.deleteByIndex(4);

        assertEquals("<[3.0, 2.1, 3.3, 4.6]>", d.toString());
    }

    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestDoubleChain.class);
    }
}
