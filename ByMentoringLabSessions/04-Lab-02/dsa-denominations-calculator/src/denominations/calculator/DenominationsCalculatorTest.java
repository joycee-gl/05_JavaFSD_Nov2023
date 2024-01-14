package denominations.calculator;

import java.util.Arrays;

public class DenominationsCalculatorTest {
	
	public static void main(String[] args) {
		
		test1();
//		test2();
	}
	
	static void test1() {
		
		Integer[] denominations = {5, 1, 10};
		int paymentAmount = 12;
		
		System.out.printf("For denominations %s and for payment amount %d", 
				Arrays.toString(denominations), paymentAmount);
		System.out.println();
		
		DenominationsCalculator calculator = 
				new DenominationsCalculator(denominations, paymentAmount);
		
		calculator.calculate();
		
	}
	
	static void test2() {
		
		Integer[] denominations = {12, 5, 123, 18};

		int paymentAmount = 160;
		
		System.out.printf("For denominations %s and for payment amount %d", 
				Arrays.toString(denominations), paymentAmount);
		System.out.println();
		
		DenominationsCalculator calculator = 
				new DenominationsCalculator(denominations, paymentAmount);
		
		calculator.calculate();
		
	}

}
