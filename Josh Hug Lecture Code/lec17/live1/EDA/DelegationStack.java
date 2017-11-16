import java.util.LinkedList;

public class DelegationStack<Zerp>{
	LinkedList<Zerp> secretList;

	public DelegationStack() {
		secretList = new LinkedList<Zerp>();
	}

	public void put(Zerp x) {
		secretList.add(0, x);
	}

	public Zerp pop() {
		/* Invariant: Top element is in position 0. */
		return secretList.remove(0);
	}
}