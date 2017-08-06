public class SList {
	public IntNode front;

	public SList(int x) {
		front = new IntNode(x, null);
	}

	public void insertBack(int x) {
		IntNode p = front;

		while (p.next != null) {
			p = p.next;
		}

		p.next = new IntNode(x, null);
	}

	public void insertFront(int x) {
		front = new IntNode(x, front);
	}
}