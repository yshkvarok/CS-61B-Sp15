import java.util.AbstractList;
import java.lang.IllegalArgumentException;

public class ArrayList61B<E> extends AbstractList<E> {
	public ArrayList61B(int initialCapacity) {
		if (initialCapacity < 1) {
			throw new IllegalArgumentException();
		}
		array = (E[]) new Object[initialCapacity];
		arraySize = 0;
	}

	public ArrayList61B() {
		array = (E[]) new Object[1];
		arraySize = 0;
	}

	public E get(int index) {
		if (index < 0 || index > arraySize - 1) {
			throw new IllegalArgumentException();
		}
		return array[index];
	}

	public boolean add(E item) {
		if (arraySize == array.length) {
			E[] newArray = (E[]) new Object[array.length * 2];
			for (int i = 0; i < array.length; i++) {
				newArray[i] = array[i];
			}
			array = newArray;
		}
		array[arraySize] = item;
		arraySize++;
		return true;
	}

	public int size() {
		return arraySize;
	}

	private int arraySize; // 1 -> n
	private E[] array;     // 0 -> n - 1
}