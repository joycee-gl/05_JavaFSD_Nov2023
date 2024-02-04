package dsa.bracketsbalancer;

public class BracketPair {

	//open char
	//close char
	
	private Character openChar;
	private Character closeChar;
	
	public BracketPair(Character openChar, Character closeChar) {
		this.openChar = openChar;
		this.closeChar = closeChar;
	}

	public Character getOpenChar() {
		return openChar;
	}

	public void setOpenChar(Character openChar) {
		this.openChar = openChar;
	}

	public Character getCloseChar() {
		return closeChar;
	}

	public void setCloseChar(Character closeChar) {
		this.closeChar = closeChar;
	}
	
	public String toString() {
		
		return String.format(" '%c' , '%c'", openChar, closeChar);
	}
	
}
