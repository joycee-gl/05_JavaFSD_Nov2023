package dsa.bracketsbalancer;

import java.util.Set;
import java.util.Stack;

public class BalancedBracketsChecker {
	
	//bracket expression
	
	private String bracketExpression;
	
	public BalancedBracketsChecker(String bracketExpression) {
		this.bracketExpression = bracketExpression;
	}
	
	public Boolean check() {
	    
        int length = bracketExpression.length();
        if ((length % 2) != 0) {
            
            System.out.printf("Bracket Expression doesn't have Even Number of Characters : %d", 
                length);
            System.out.println();
            return false;			
        }		
        
        
        Stack<Character> stack = new Stack<Character>();
        
        Set<Character> openBracketsSet 
            = BalancedBracketsUtils.getOpenBracketCharsSet();
        Set<Character> closeBracketsSet 
            = BalancedBracketsUtils.getCloseBracketCharsSet();

        
        for (int index = 0; index < bracketExpression.length(); index ++) {
            
            char visitedChar = bracketExpression.charAt(index);
            
            System.out.printf("Visited Character : %c", visitedChar);
            System.out.println();			
            
            if (openBracketsSet.contains(visitedChar)) {
                
                System.out.printf("Pushing the Character %c to the Stack", visitedChar);
                System.out.println();
                stack.push(visitedChar);
                
            } else if (closeBracketsSet.contains(visitedChar)) {

                Character closeBracketChar = visitedChar;				
                Character poppedOutItem = stack.pop();
                System.out.printf("Popped out Character %c", poppedOutItem);
                System.out.println();
                
                Character potentialOpenBracketChar = poppedOutItem;

                Character openBracketChar 
                    = BalancedBracketsUtils.getOpenBracketChar(closeBracketChar);				
                                
                if (potentialOpenBracketChar.equals(openBracketChar)) {

	                System.out.println("Matched Bracket");
                    continue;
                }else {
                    
	                System.out.println("Invalid Bracket");
                    break;
                }
           
            } else {            
            	
            	System.out.println("Invalid character encountered");
            	break;
            }
            

        }
        
        
        boolean empty = stack.isEmpty();
        
        if (empty) {

            System.out.println("Stack is Empty");
            System.out.printf("The given expression is valid : %s ", bracketExpression);
            System.out.println();

            return true;
            
        }else {

            System.out.println("Stack is NOT Empty");
            System.out.printf("The given expression is NOT Valid : %s ", bracketExpression);
            System.out.println();		

            return false;	
        }		

        
        

        
    }


}
