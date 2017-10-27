/** AListPrinterLauncher
 *  @author Josh Hug
 */

public class AListPrinterLauncher {
    public static void main(String[] args) {
        AList L  = new AList();
        L.insertBack(5);
        L.insertBack(10);
        L.insertBack(-3);
        
        AList.AListIterator ali = L.new AListIterator();
        System.out.println(ali.printNext()); // 5
        System.out.println(ali.printNext()); // 10
        System.out.println(ali.printNext()); // -3 
        System.out.println(ali.printNext());  
    }
} 