package com.greatlearning.javafsd.emailapp.service;

import com.greatlearning.javafsd.emailapp.model.Employee;

public class CredentialServiceImplTest {

    
    public static void main(String[] args) {
        
        //testPasswordGeneration();
    	
    	//testEmailAddressGeneration();
    	
    	testDisplayCredentials();
    }
    
    static void testPasswordGeneration() {
    
        
        testPasswordGeneration01();
    }
    
    static void testPasswordGeneration01() {
        
        
        ICredentialService credentialService 
            = new CredentialServiceImpl();		
        String password = credentialService.generatePassword();		
        System.out.println("Generated Password is -> " + password);
    }
    
    static void testEmailAddressGeneration() {
    	
    	testEmailAddressGeneration01();
    }

    static void testEmailAddressGeneration01() {
    	
    	ICredentialService credentialService 
    		= new CredentialServiceImpl();		
    	String emailAddress = credentialService.generateEmailAddress(
    		"Raghu", "Kishore", 3);		
    	System.out.println("Generated Email Address is -> " + emailAddress);
    	
    }
    
    static void testDisplayCredentials() {
    	
    	testDisplayCredentials01();
    	
    }

    static void testDisplayCredentials01() {
    	
    	ICredentialService credentialService 
    		= new CredentialServiceImpl();		

    	String firstName = "Raghu";
    	String lastName =  "Kishore";
    	int departmentCode = 3;
    	
    	Employee raghu = new Employee(firstName, lastName);

    	
    	String emailAddress = credentialService.generateEmailAddress(
    		firstName, lastName, departmentCode);		
    	
    	// For Email Address
    	raghu.setEmailAddress(emailAddress);


    	// For Password
    	
    	String password = credentialService.generatePassword();				
    	raghu.setPassword(password);
    	
    	credentialService.displayCredentials(raghu);		
    }


}