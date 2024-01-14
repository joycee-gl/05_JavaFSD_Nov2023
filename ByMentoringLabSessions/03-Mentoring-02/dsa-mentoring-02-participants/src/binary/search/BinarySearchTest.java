package binary.search;

public class BinarySearchTest {
    
    public static void main(String[] args) {

        Integer array[] = { 3, 8, 10, 12, 14, 16, 19, 27, 32, 42 };
        
        print(array);
        
        testScenario1(array);
        
        System.out.println("=====================================");
		
        testScenario2(array);
        
        System.out.println("=====================================");
		
        testScenario3(array);
        
        System.out.println("=====================================");
		
        testScenario4(array);

    }
    
    static void print(Integer[] array) {
    	
    	for (int index = 0; index < array.length; index ++) {
    		
    		if (array[index] != null) {
    			
    			System.out.print(array[index]);
    			
    			if (index != (array.length - 1)) {
    				
    				System.out.print(", ");
    			}
    			
    		}			
    	}
    	
    	System.out.println();
    }
    
    static void testScenario1(Integer[] array) {
    	
    	BinarySearch search = new BinarySearch(array);
    	int searchValue = 14;		
    	search.search(searchValue);
    }
    
    static void testScenario2(Integer[] array) {
    	BinarySearch search = new BinarySearch(array);
    	int searchValue = 10;		
    	search.search(searchValue);
    }
    
    static void testScenario3(Integer[] array) {
    	BinarySearch search = new BinarySearch(array);
    	int searchValue = 32;		
    	search.search(searchValue);
    }
    
    static void testScenario4(Integer[] array) {
    	BinarySearch search = new BinarySearch(array);
    	int searchValue = 92;		
    	search.search(searchValue);
    }
    
    
    
}

