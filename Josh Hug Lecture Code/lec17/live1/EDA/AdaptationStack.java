import java.util.List;

public class AdaptationStack<Zerp> {
	List<Zerp> secretList;

	public AdaptationStack(List<Zerp> listToUse) {
		secretList = listToUse;
	}

	public void put(Zerp x) {
		secretList.add(0, x);
	}

	public Zerp pop() {
		/* Invariant: Top element is in position 0. */
		return secretList.remove(0);
	}

	public static void main(String[] args) {
		ExtensionStack<Integer> list = new ExtensionStack<Integer>();
		list.put(5);
		list.put(10);
		list.pop();
		list.pop();
	}
}