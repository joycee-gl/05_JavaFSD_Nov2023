package com.gl.banking.service;

public class OTPGenerator {
	
	public int generate() {
		
		double random = Math.random();
		
		int otp = (int)(random * 10000);
		
		if(otp <= 999) {
			otp = otp + 1000;
		}
		
		return otp;
	}
	
	public static void main(String[] args) {
		
		OTPGenerator generator = new OTPGenerator();
		int otp = generator.generate();
		
		System.out.println("OTP generated is : " + otp);
	}

}
