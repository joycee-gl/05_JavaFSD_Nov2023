package com.gl.banking.model;

public class Customer {
	
	private String bankAccountNo;
	
	private String password;
	
	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}
	
	public String getBankAccountNo() {
		return bankAccountNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public static void main(String[] args) {
		
		Customer rahul = new Customer();
		
		rahul.setBankAccountNo("107891");
		rahul.setPassword("pass348");
		
		System.out.println(rahul.getBankAccountNo());
		System.out.println(rahul.getPassword());
	}
	
}
