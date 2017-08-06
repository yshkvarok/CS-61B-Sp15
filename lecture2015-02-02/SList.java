public class SList {
	public IntNode front;
	public int size;

	public SList() {
		size = 0;
		front = null;
	}

	public SList(int x) {
		front = new IntNode(x, null);
		size = 1;
	}

	public void insertBack(int x) {
		if (front == null) {
			front = new IntNode(x, null);
			size = 1;
			return;
		}

		IntNode p = front;

		while (p.next != null) {
			p = p.next;
		}

		p.next = new IntNode(x, null);
		size = size + 1;
	}

	public void insertFront(int x) {
		front = new IntNode(x, front);
		size = size + 1;
	}

	public int size() {
		return size;
	}

	public int getFront() {
		return front.item;
	}

	public int getBack() {
		IntNode p = front;

		while (p.next != null) {
			p = p.next;
		}

		return p.item;
	}
}