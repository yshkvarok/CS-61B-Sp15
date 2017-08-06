import org.junit.Test;
import static org.junit.Assert.*;

public class SListTest {

	@Test
	public void testOperationsOnEmptyList() {
		SList L = new SList();
		L.insertBack(85);

		L = new SList();
		L.insertFront(99);
		assertEquals(1, L.size());
	}

	@Test
	public void testEmptyList() {
		SList L = new SList();
	}

	@Test
	public void testSize() {
		SList L = new SList();
		assertEquals(0, L.size());
	}

	@Test
	public void testGetting() {
		SList L = new SList();
		L.insertFront(99);
		L.insertBack(100);

		assertEquals(99, L.getFront());
		assertEquals(100, L.getBack());

		L.insertFront(5);
		assertEquals(5, L.getFront());

		L.insertBack(8);
		assertEquals(8, L.getBack());
	}

	public static void main(String[] args) {
		jh61b.junit.textui.runClasses(SListTest.class);
	}
}