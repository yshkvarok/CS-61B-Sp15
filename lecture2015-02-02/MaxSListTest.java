import org.junit.Test;
import static org.junit.Assert.*;

public class MaxSListTest {

	@Test
	public void testOperationsOnEmptyList() {
		MaxSList L = new MaxSList();
		L.insertBack(85);

		L = new MaxSList();
		L.insertFront(99);
		assertEquals(1, L.size());
	}

	@Test
	public void testEmptyList() {
		MaxSList L = new MaxSList();
	}

	@Test
	public void testSize() {
		MaxSList L = new MaxSList();
		assertEquals(0, L.size());
	}

	@Test
	public void testGetting() {
		MaxSList L = new MaxSList();
		L.insertFront(99);
		L.insertBack(100);

		assertEquals(99, L.getFront());
		assertEquals(100, L.getBack());

		L.insertFront(5);
		assertEquals(5, L.getFront());

		L.insertBack(8);
		assertEquals(8, L.getBack());
	}

	@Test
	public void testMax() {
		MaxSList L = new MaxSList();
		L.insertBack(50);
		L.insertBack(49);
		L.insertBack(51);
		assertEquals(51, L.max());
	}

	public static void main(String[] args) {
		jh61b.junit.textui.runClasses(MaxSListTest.class);
	}
}