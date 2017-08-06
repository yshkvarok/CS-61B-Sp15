public class SListLauncher {
	public static void main(String[] args) {
		SList x = new SList(100);
		//System.out.println(x.front.item);

		x.insertBack(5);
		//System.out.println(x.front.next.item);

		SList y = x;
		//System.out.println(y.front.next.item);

		x.insertFront(99);
		

		//x = new SList();
		//System.out.println(x.size());
	}
}