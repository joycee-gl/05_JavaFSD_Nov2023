package paymoney.tgt.determinator;

import java.util.Scanner;

public class PayMoneyTargetDeterminator {
	
	//transaction list
	
	//scanner for input
	
	//constructor - initialize the scanner
	
	//daily target
	
	Integer[] transactionsList;
	
	Integer dailyTarget;
	
	Scanner input;
	
	public PayMoneyTargetDeterminator() {
		
		input = new Scanner(System.in);
	}
	
	// add a method - collect transaction values from user
	// size of the transactions list - input
	
	// get each transaction value - input

	private void collectTransactionList() {
		
		System.out.println("Transactions list : ");
		
		System.out.println("Enter the size of the transactions list: ");
		Integer transactionListSize = input.nextInt();
		
		transactionsList = new Integer[transactionListSize];
		
		for (int index = 0; index < transactionListSize; index++) {
			// 1 / 5
			System.out.printf("Enter the transaction value : %d / %d ",
					(index + 1), transactionListSize);
			System.out.println();
			
			transactionsList[index] = input.nextInt();
	
		}
		
	}
	
	//method for collecting daily target - input
	
	private void collectDailyTarget() {
		
		System.out.println("Enter the value for daily target : ");
		dailyTarget = input.nextInt();
	}
	
	public void determine() {
		
		collectTransactionList();
		
		collectDailyTarget();
		
		determineTarget();
		
	}
	
	void determineTarget() {
		
		int currentSumOfTransactionValues = 0;
		
		boolean dailyTargetAchieved = false;
		
		//counter for transactions
		int counter = 0;
		
		//iterate through the transactions
		
		for (int index = 0; index < transactionsList.length; index++) {
			
			//update counter
			counter++; 
						
			// get the value of each transaction
			int transactionValue = transactionsList[index];
			
			//compute the sum in each iteration
			currentSumOfTransactionValues = currentSumOfTransactionValues + transactionValue;
			
			System.out.printf("Current sum of transaction values : %d", 
					currentSumOfTransactionValues);
			System.out.println();
			
			if(currentSumOfTransactionValues >= dailyTarget) {
				
				dailyTargetAchieved = true;
				break;
			}
			
		}
		
		//display result
			// target achieved after N transactions
			// target not achieved
		
		if(dailyTargetAchieved) {
			
			System.out.printf("Daily target of %d achieved after %d transactions",
					dailyTarget, counter);
			System.out.println();
			
		} else {
			
			System.out.printf("Daily target of %d not achieved", dailyTarget);
			System.out.println();
		}
		
	}

}
