import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Iterator;

/** ULLMapTest. You should write additional tests.
 *  @author Josh Hug
 */

public class ULLMapTest {
    @Test
    public void testGet() {
    	ULLMap<String, String> um = new ULLMap<String, String>();
        um.put("Gracias", "Dios Basado");
        um.put("Gracias1", "Dios Basado1");
        um.put("Gracias2", "Dios Basado2");
        um.put("Gracias3", "Dios Basado3");
        assertEquals(4, um.size());
        assertEquals(true, um.containsKey("Gracias3"));
        um.clear();
        assertEquals(0, um.size());
        assertEquals(false, um.containsKey("Gracias3"));
    }

    @Test
    public void testContainsKey() {
    	ULLMap<Integer, String> um = new ULLMap<Integer, String>();
    	um.put(1, "Hi");
    	um.put(2, "Hello");
    	um.put(3, "How are you");
    	assertTrue(um.containsKey(3));
    }

    @Test
    public void testBasic() {
        ULLMap<String, String> um = new ULLMap<String, String>();
        um.put("Gracias", "Dios Basado");
        um.put("Black", "Boi");
        assertEquals(um.get("Gracias"), "Dios Basado");
        assertEquals(um.get("Black"), "Boi");
    }

    @Test
    public void testToString() {
    	ULLMap<Integer, String> um = new ULLMap<Integer, String>();
        um.put(5, "Dios Basado");
        um.put(6, "Boi");
        um.put(7, "WAT Up");
        um.put(8, "yea boi");
        um.put(9, "asas");
        um.put(1, "aaa");

        assertEquals("567891", um.toString());

   		Iterator<Integer> iter1 = um.iterator();
   		assertEquals(5, (int) iter1.next());
   		assertEquals(6, (int) iter1.next());
   		assertEquals(7, (int) iter1.next());
    }
    
    @Test
    public void testGet2() {
        ULLMap<Integer, String> um = new ULLMap<Integer, String>();
        um.put(0, "zero");
        um.put(1, "one");
        um.put(2, "two");
        
        assertEquals("zero", um.get(0));
    }

    @Test
    public <K, V> void testInvert() {
    	ULLMap<Integer, String> um = new ULLMap<Integer, String>();
    	um.put(0, "zero");
        um.put(1, "one");
        um.put(2, "two");

        ULLMap newMap = ULLMap.inverse(um);
        assertEquals("zeroonetwo", newMap.toString());
    }
    

    /** Runs tests. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(ULLMapTest.class);
    }
} 