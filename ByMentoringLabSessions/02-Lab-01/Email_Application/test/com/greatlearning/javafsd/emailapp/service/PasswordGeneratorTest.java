package com.greatlearning.javafsd.emailapp.service;

public class PasswordGeneratorTest {

    public static void main(String[] args) {
        
        
		testRun01();
        
        testRun02();
        
    }
    
    static void testRun01() {
        
        PasswordGenerator generator = new PasswordGenerator();
        
        String password = generator.generate();
    
        System.out.println("Generated password -> testRun01 method : " + password);
        
    }
    
    static void testRun02() {
        
        
        for (int index = 1; index <=10; index ++ ) {

            PasswordGenerator generator = new PasswordGenerator();

            String password = generator.generate();
            
            System.out.println("Generated password -> " + password);			
        }
        
        
    }
}    
