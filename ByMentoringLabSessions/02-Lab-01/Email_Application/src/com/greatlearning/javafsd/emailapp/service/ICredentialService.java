package com.greatlearning.javafsd.emailapp.service;

import com.greatlearning.javafsd.emailapp.model.Employee;

public interface ICredentialService {

    String generatePassword();

    String generateEmailAddress(String firstName, String lastName, int departmentCode);

    void displayCredentials(Employee employee);

}