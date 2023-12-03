package com.greatlearning.javafsd.emailapp.service;

import com.greatlearning.javafsd.emailapp.utils.EmailApplicationUtils;

public class EmailAddressGenerator {
    
    public String generate(String firstName, String lastName, int departmentCode) {
                
        String departmentName = EmailApplicationUtils.getDepartmentName(departmentCode);
        
        // Concatenate strings
        StringBuilder emailAddressBuilder = new StringBuilder();
        
        emailAddressBuilder.append(firstName.toLowerCase());
        emailAddressBuilder.append(".");
        emailAddressBuilder.append(lastName.toLowerCase());
        emailAddressBuilder.append("@");
        emailAddressBuilder.append(departmentName);
        emailAddressBuilder.append(".gl.com");
        
        String emailAddress = emailAddressBuilder.toString();
                        
        return emailAddress;		
    }
    
    
}