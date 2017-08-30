
public class DoubleChain {
	
	private DNode head;
	
	public DoubleChain(double val) {
		head = new DNode(val);
	}

	public DNode getFront() {
		return head;
	}

	/** Returns the last item in the DoubleChain. */		
	public DNode getBack() {
		DNode backNode = head;

		while (backNode.next != null) {
			backNode = backNode.next;
		}
		return backNode;
	}
	
	/** Adds D to the front of the DoubleChain. */	
	public void insertFront(double d) {
		DNode newHead = new DNode(d);
		newHead.next = head;
		head.prev = newHead;
		head = newHead;
	}
	
	/** Adds D to the back of the DoubleChain. */	
	public void insertBack(double d) {
		DNode backNode = this.getBack();
		DNode newNode = new DNode(d);

		backNode.next = newNode;
		newNode.prev = backNode;
	}
	
	/** Removes the last item in the DoubleChain and returns it. 
	  * This is an extra challenge problem. */
	public DNode deleteBack() {
		DNode backNode = head;

		while (backNode.next != null) {
			backNode = backNode.next;
		}

		backNode.prev.next = null;
		backNode.prev = null;

		return backNode;
	}

	public DNode deleteByIndex(int i) {
		DNode iNode = head;

		if (i == 0) {
			iNode.next.prev = null;
			head = iNode.next;
			return iNode;
		}

		for (int index = 0; index < i; index++)
			iNode = iNode.next;

		if (iNode.next != null)
			iNode.next.prev = iNode.prev;

		iNode.prev.next = iNode.next;

		return iNode;
	}
	
	/** Returns a string representation of the DoubleChain. 
	  * This is an extra challenge problem. */
	public String toString() {
		String list = "<[";

		DNode iter = head;
		list += iter.val;

		while (iter.next != null) {
			iter = iter.next;
			list += ", " + iter.val;
		}
		list += "]>";

		return list;
	}

	public static class DNode {
		public DNode prev;
		public DNode next;
		public double val;
		
		private DNode(double val) {
			this(null, val, null);
		}
		
		private DNode(DNode prev, double val, DNode next) {
			this.prev = prev;
			this.val = val;
			this.next = next;
		}

		/** Helper method for testing
		  */
		public double value() {
			return val;
		}
	}
	
}
