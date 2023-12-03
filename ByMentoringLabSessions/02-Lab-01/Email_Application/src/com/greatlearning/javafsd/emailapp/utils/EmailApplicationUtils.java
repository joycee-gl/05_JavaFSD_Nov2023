package com.greatlearning.javafsd.emailapp.utils;

public class EmailApplicationUtils {
	
	public static String getDepartmentName(int departmentCode) {
        
        String departmentName = "";
        
        switch (departmentCode) {
            
            case 1: {
                departmentName = "technical";
                break;
            }
            case 2: {
                departmentName = "admin";
                break;				
            }
            case 3: {
                departmentName = "hr";
                break;				
            }
            case 4: {
                departmentName = "legal";
                break;				
            }
            
            default : {
                
                System.out.println("Invalid department option chosen. Please choose a value "
                        + "between 1 and 4");
                System.exit(-1);
            }
        }		
        
        return departmentName;
    }

}
