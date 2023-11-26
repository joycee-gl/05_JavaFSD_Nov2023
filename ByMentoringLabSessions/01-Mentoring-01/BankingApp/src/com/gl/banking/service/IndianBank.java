package com.gl.banking.service;

import java.util.Scanner;

import com.gl.banking.interfaces.IInternetBanking;
import com.gl.banking.model.Customer;

public class IndianBank implements IInternetBanking {
	
	int balanceAmount = 1000;
	
	Scanner userInput = new Scanner(System.in);
	
	public void deposit() {
		
		System.out.println("Enter the amount you wish to deposit: ");
		int depositAmount = userInput.nextInt();
		
		if(depositAmount > 0) {
			//allow deposit
			int currentAmount = balanceAmount + depositAmount;
			balanceAmount = currentAmount;
			
			System.out.println("Deposit operation is successful.");
			System.out.println("Balance is now : " + balanceAmount);
			
		} else {
			
			System.out.println("Deposit amount should be greater than 0");
		}
		
	}
	
	public void withdraw() {
		
		System.out.println("Enter the amount to withdraw: ");
		int withdrawalAmount = userInput.nextInt();
		
		if(withdrawalAmount > 0 ) {
			
			//suppose the balance in account is 800
			// if request for withdraw of 1100, that is not allowed
			
			int currentAmount = balanceAmount - withdrawalAmount;
			
			if(currentAmount >= 0) {
				
				//allow withdrawal
				balanceAmount = currentAmount;
				System.out.println("Withdrawal operation is successful.");
				System.out.println("Balance is now: " +balanceAmount);
				
			} else {
				
				//don't allow 
				System.out.println("Insufficient funds in account.");
			}
			
			
		} else {
			
			System.out.println("Withdrawal amount should be greater than 0");
		}
		
	}
	
	public void transfer() {
		
		System.out.println("**OTP generation process**");
		
		OTPGenerator generator = new OTPGenerator();
		int otp = generator.generate();
		
		System.out.println("OTP generated is : " + otp);
		
		System.out.println("Enter the OTP for transfer: ");
		int userEnteredOTP = userInput.nextInt();
		
		if(otp == userEnteredOTP) {
			
			//we need to get the target account no for transfer
			// and also the amount
			
			//integer followed by String - read issue with Scanner
			userInput.nextLine();
			
			System.out.println("Enter the target account no: ");
			String targetAccountNo = userInput.nextLine();
			
			System.out.println("Enter the amount to transfer: ");
			int transferAmount = userInput.nextInt();
			
			Customer targetCustomer = new Customer();
			targetCustomer.setBankAccountNo(targetAccountNo);
			
			if(transferAmount > 0) {
				
				int currentAmount = balanceAmount - transferAmount;
				
				if(currentAmount >= 0) {
					
					//allow transfer
					balanceAmount = currentAmount;
					System.out.println("Transfer done successfully to the target account no: " 
											+ targetCustomer.getBankAccountNo());
					System.out.println("Balance is now : " + balanceAmount);
					
				} else {
					
					System.out.println("Insufficient funds.");
				}
				
			} else {
				
				System.out.println("Amount to transfer should be greater than 0");
			}
			
		} else {
			
			System.out.println("OTP entered does not match with the generated OTP. Please check.");
		}
		
	}
	
	public void logout() {
		
		userInput.close();
		System.out.println("Logging out from Banking application.");
	}
	
	public static void main(String[] args) {
		
		IndianBank bank = new IndianBank();
		//bank.deposit();
		//bank.withdraw();
		bank.transfer();
		//bank.logout();
		
	}

}
