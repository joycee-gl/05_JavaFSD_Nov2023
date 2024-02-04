package dsa.bracketsbalancer;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BalancedBracketsUtils {
	
	// '[',']'
	//'{','}'
	// '(', ')'
	//'<', '>"

	//Set<BracketPair> predefined brackets collection
	//populate predefined brackets collection
	
	//Get open bracket characters - Set<Character>
		//iterate predefined brackets collection - populate set with open bracket charcters
	
	//Get close bracket characters - Set<Character>
		//iterate predefined brackets collection - populate set with open bracket charcters
	
	
	//Get open char fr a particular close char
		//iterate predefined brackets collection - get the open char for given close char
	
	
	public static Set<BracketPair> getAllPredefinedBrackets(){

		Set<BracketPair> predefinedBrackets = new HashSet<BracketPair>();
				
		// Round brackets / Function brackets
		predefinedBrackets.add(new BracketPair('(', ')'));
		
		// Square Brackets / Array brackets
		predefinedBrackets.add(new BracketPair('[', ']'));
		
		// Curly brackets / Braces
		predefinedBrackets.add(new BracketPair('{', '}'));
		
		// Angle Brackets 
		predefinedBrackets.add(new BracketPair('<', '>'));
		
		return predefinedBrackets;
		
	}	

	public static Set<Character> getOpenBracketCharsSet(){		
	    
	    Set<BracketPair> predefinedBrackets = getAllPredefinedBrackets();
	    
	    Set<Character> result = new HashSet<Character>();
	    
	    Iterator<BracketPair> iterator = predefinedBrackets.iterator();
	    
	    while (iterator.hasNext()) {
	        
	        BracketPair bracketPair = iterator.next();
	        
	        result.add(bracketPair.getOpenChar());			
	    }		
	    return result;
	}	     
	
	
	public static Set<Character> getCloseBracketCharsSet(){
	    
	    Set<BracketPair> predefinedBrackets = getAllPredefinedBrackets();
	    
	    Set<Character> result = new HashSet<Character>();
	    
	    Iterator<BracketPair> iterator = predefinedBrackets.iterator();
	    
	    while (iterator.hasNext()) {
	        
	        BracketPair bracketPair = iterator.next();
	        
	        result.add(bracketPair.getCloseChar());			
	    }		
	    return result;
	}

	
	public static Character getOpenBracketChar(Character closeBracket) {
	    
	    Set<BracketPair> predefinedBrackets = getAllPredefinedBrackets();
	    
	    for (BracketPair predefinedBracket : predefinedBrackets) {
	        
	        if (predefinedBracket.getCloseChar().equals(closeBracket)) {
	            return predefinedBracket.getOpenChar();
	        }
	    }
	    return null;
	}        

}
