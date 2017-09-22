public class MaxSList extends SList {
	private int max = -Integer.MIN_VALUE;

	public MaxSList() {
		super();
	}

	public MaxSList(int x) {
		super(x);
		max = x;
	}

	public int max() {
		return max;
	}

	@Override
	public void insertFront(int x) {
		System.out.println("MaxSList insertFront() was called.\n");
		super.insertFront(x);
		if (x > max) {
			max = x;
		}
	}

	@Override
	public void insertBack(int x) {
		super.insertBack(x);
		if (x > max) {
			max = x;
		}
	}
}