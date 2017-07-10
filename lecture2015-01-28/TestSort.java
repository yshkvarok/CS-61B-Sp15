import org.junit.Test;
import org.junit.Assert;

public class TestSort {
	
	/** Tests the Sort.sort method. */
	@Test
	public void testSort() {
		String[] input = {"a", "huge", "tiny", "scorpion"};
		Sort.sort(input);
		String[] expected = {"a", "huge", "scorpion", "tiny"};

		assertArrayEquals(expected, input);
	}

	/** Tests the indexOfSmallest method. */
	@Test
	public void testIndexOfSmallest() {
		String[] input = {"a", "huge", "tiny", "scorpion"};
		int actual = Sort.indexOfSmallest(input, 0);
		int expected = 0;

		assertEquals(expected, actual);

		actual = Sort.indexOfSmallest(input, 2);
		expected = 3;
		assertEquals(expected, actual);
	}

	public static void main(String[] args) {
		testIndexOfSmallest();
		//testSort();
	}
}