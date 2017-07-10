public class Sort {
	public static void sort(String[] a) {
		sort(a, 0);
	}

	public static int indexOfSmallest(String[] a, int start) {
		int minDex = start;
		int i = start;

		while (i < a.length) {
			int compareResult = a[i].compareTo(a[minDex]);

			if (compareResult < 0) {
				minDex = i;
			}
			i = i + 1;
		}
		return minDex;
	}

	private static void sort(String[] a, int start) {
		if (start == a.length)
			return;
		// Find the smallest thing
		int mindex = indexOfSmallest(a, start);
		
		// Swap it to the front
		// Recursively sort the rest
		sort(a, start + 1);
	}

	

	public static void print(String[] a) {
		
	}

	public static void main(String[] args) {
		
	}
}