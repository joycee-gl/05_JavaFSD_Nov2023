package set;
import java.util.TreeSet;

public class TreeSetDemo {

    public static void main(String[] args) {
        TreeSet<String> planets = new TreeSet<String>();

        planets.add("Mercury");
        planets.add("Venus");
        planets.add("Jupiter");
        planets.add("Saturn");
        planets.add("Neptune");
        
        planets.add("Saturn");
		
        System.out.println(planets);
        
    }
}