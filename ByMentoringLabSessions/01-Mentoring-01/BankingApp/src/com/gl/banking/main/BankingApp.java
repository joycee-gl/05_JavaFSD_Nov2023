package com.gl.banking.main;

import java.util.Scanner;

import com.gl.banking.model.Customer;
import com.gl.banking.service.IndianBank;

public class BankingApp {
	
	public void launch() {
		
		Scanner userInput = new Scanner(System.in);
		
		//setting the customer data
		
		Customer paul = new Customer();
		
		paul.setBankAccountNo("101011");
		paul.setPassword("pass157");
		
		//prompt for user input of account details
		
		System.out.println("Enter your bank account no: ");
		String bankAccountNo = userInput.nextLine();
		
		System.out.println("Enter the password: ");
		String password = userInput.nextLine();
		
		if(bankAccountNo.equals(paul.getBankAccountNo()) 
				&& (password.equals(paul.getPassword()))) {
			
			// do while for continuously accepting user input, 
			// till option 4 is entered by user
			
			IndianBank bank = new IndianBank();
			
			int userSelectedOption = -1;
			
			do {
				
				System.out.println("******* Welcome to Indian Bank ********");
				
				System.out.println("1. Deposit");
				
				System.out.println("2. Withdraw");
				
				System.out.println("3. Transfer");
				
				System.out.println("4. Logout");
				
				System.out.println("Enter the option (1/2/3/4): ");
				
				userSelectedOption = userInput.nextInt();
				
				switch(userSelectedOption) {
				
					case 1 : {
						
						bank.deposit();
						break;
					}
					
					case 2 : {
						
						bank.withdraw();
						break;
					}
					
					case 3 :{
						
						bank.transfer();
						break;
					}
					
					case 4 : {
						userInput.close();
						bank.logout();
						break;
					}
					
					default : {
						System.out.println("Invalid option");
						break;
					}
				
				}
				
				
			} while (userSelectedOption != 4);
			
			
			
		} else {
			
			System.out.println("Invalid credentials.");
		}
		
	}
	
	public static void main(String[] args) {
		
		BankingApp app = new BankingApp();
		app.launch();
		
	}

}
