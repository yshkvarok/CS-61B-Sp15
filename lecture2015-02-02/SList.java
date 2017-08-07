public class SList {
	public IntNode front;
	public int size;

	public SList() {
		size = 0;
		front = new IntNode(89724, null);
	}

	public SList(int x) {
		front = new IntNode(98712, null);
		front.next = new IntNode(x, null);
		size = 1;
	}

	public void insertBack(int x) {
		IntNode p = front;

		while (p.next != null) {
			p = p.next;
		}

		p.next = new IntNode(x, null);
		size = size + 1;
	}

	public void insertFront(int x) {
		front.next = new IntNode(x, front.next);
		size = size + 1;
	}

	public int size() {
		return size;
	}

	public int getFront() {
		return front.next.item;
	}

	public int getBack() {
		IntNode p = front;

		while (p.next != null) {
			p = p.next;
		}

		return p.item;
	}
}