package com.greatlearning.javafsd.emailapp.service;

import java.util.Random;

public class PasswordGenerator {

    public String generate() {
            
        String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialCharacters = "~!@#$%^&*()-;+[]|";
        
        String combinedString = 
            capitalLetters + smallLetters + numbers
                + specialCharacters;
            
        Random randomObj = new Random();
        
        StringBuilder passwordBuilder = new StringBuilder();
        
        int length = combinedString.length();
                
        //8 character password
        
        for (int index = 1; index <= 8; index ++) {
            
            int randomIndex = randomObj.nextInt(length);
            
            char charValue = 
                    combinedString.charAt(randomIndex);			
            
            passwordBuilder.append(charValue);						
        }
        
        String password = passwordBuilder.toString();
        
        return password;
    }
}
