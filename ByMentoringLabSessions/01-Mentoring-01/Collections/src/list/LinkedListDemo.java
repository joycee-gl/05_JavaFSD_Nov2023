package list;
import java.util.LinkedList;

public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList<String> placesList = new LinkedList<String>();

        placesList.add("Frisco");
        placesList.add("Boston");
        placesList.add("England");
        placesList.add("Denver");
        placesList.add("California");

        System.out.println("Initial contents of linked list: " + placesList);

        placesList.remove("Frisco");
        placesList.remove(3);
        
        placesList.add(2, "Alaska");
        
        System.out.println("Contents of linked list: " + placesList);

        String placeName = placesList.get(1);
        placesList.set(1, placeName + " -> United Kingdom");

        System.out.println("Final contents of linked list: " + placesList);
    }
}