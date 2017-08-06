public class SListLauncher {
	public static void main(String[] args) {
		SList x = new SList(100);
		System.out.println(x.front.item);

		x.insertBack(5);
		System.out.println(x.front.next.item);

		SList y = x;
		System.out.println(y.front.next.item);

		x.insertFront(99);
		System.out.println(x.front.item);
		System.out.println(x.front.next.item);
		System.out.println(x.front.next.next.item);

		//x = new SList();
		//System.out.println(x.size());
	}
}