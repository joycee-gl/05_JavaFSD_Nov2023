package list;
import java.util.ArrayList;

public class ArrayListDemo {

    public static void main(String[] args) {
        ArrayList<String> places = new ArrayList<String>();

        System.out.println("Initial size of array list: " + places.size());

        places.add("Arizona");
        places.add("Berlin");
        places.add("Jordan");
        places.add("Cambodia");
        places.add("Sweden");
        places.add("Romania");
        places.add(2, "Kenya");
        
        System.out.println("Size of array list : " + places.size());

        System.out.println("Contents of array list : " + places);

        places.remove("Kenya");
        places.remove(1);
        
        System.out.println("Size of array list : " + places.size());

        places.add("Cambodia");

        System.out.println("Contents of array list: " + places);
    }
}