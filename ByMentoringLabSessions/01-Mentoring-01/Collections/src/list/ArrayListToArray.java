package list;
import java.util.ArrayList;

public class ArrayListToArray {

    public static void main(String[] args) {
        ArrayList<Integer> arrList = new ArrayList<Integer>();

        arrList.add(30);
        arrList.add(50);
        arrList.add(70);
        arrList.add(10);

        System.out.println("Contents of array list: " + arrList);

        Integer intArr[] = new Integer[arrList.size()];
        intArr = arrList.toArray(intArr);

        System.out.println("Contents of array: ");
        for (int intVal : intArr) {
        	System.out.println(intVal);
        }
        
    }
}