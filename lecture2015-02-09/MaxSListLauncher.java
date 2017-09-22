public class MaxSListLauncher {
	public static void main(String[] args) {
		MaxSList msl = new MaxSList();
		msl.insertFront(100);
		msl.insertFront(25);
		System.out.println(msl.getFront());
		System.out.println(msl.getBack());
	}
}