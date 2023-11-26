package set;
import java.util.LinkedHashSet;

public class LinkedHashSetDemo {

	public static void main(String[] args) {
		
		LinkedHashSet<String> planets = new LinkedHashSet<String>();
		
		planets.add("Mercury");
        planets.add("Venus");
        planets.add("Jupiter");
        planets.add("Saturn");
        planets.add("Neptune");
        
        planets.add("Saturn");

        System.out.println(planets);
		
	}
}
