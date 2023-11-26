package set;
import java.util.HashSet;

public class HashSetDemo {

    public static void main(String[] args) {
        HashSet<String> planets = new HashSet<String>();

        planets.add("Mercury");
        planets.add("Venus");
        planets.add("Jupiter");
        planets.add("Saturn");
        planets.add("Neptune");
        
        // Duplicate will be rejected
        
        boolean outcome = planets.add("Saturn");
        if (!outcome) {
        	System.out.println("Element not added ...");
        }
        
        System.out.println(planets);
    }
}