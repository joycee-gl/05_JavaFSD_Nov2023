package iteration;
import java.util.ArrayList;

public class ForEachDemo {

    public static void main(String[] args) {
        ArrayList<Integer> arrList = new ArrayList<Integer>();

        arrList.add(10);
        arrList.add(20);
        arrList.add(30);
        arrList.add(40);
        arrList.add(50);
        
        System.out.println("Contents of array list : ");
        for (int val : arrList) {
        	System.out.println(val);
        }
            
        System.out.println();

	}
}