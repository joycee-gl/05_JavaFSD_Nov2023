package iteration;
import java.util.*;

public class IteratorDemo {

    public static void main(String[] args) {
        ArrayList<String> places = new ArrayList<String>();

        places.add("Chicago");
        places.add("Arizona");
        places.add("Seattle");
        places.add("Boston");
        places.add("Denver");
        places.add("Frisco");

        System.out.println("Array list contents : ");
        Iterator<String> itr = places.iterator();
        while (itr.hasNext()) {
            String place = itr.next();
            System.out.println(place);
        }
        System.out.println();

    }
}