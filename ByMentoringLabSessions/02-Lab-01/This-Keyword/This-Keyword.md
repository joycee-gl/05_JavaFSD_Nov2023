## Code reference
    - 'This-Keyword-Demo' at https://github.com/queenjoychristy/JC-Life/tree/main/IT/ByTechnicalResources/Java/ByConcepts/Core/This-Keyword


## Notes 

- Mobile.java
	- Execution at line 14
	
		- owner ->
			- Constructor method parameter name is owner
			- object's attribute is also owner
			
			- conflict happens
				because of the same name (owner)
				
			- How to resolve the conflict
				- way -1
					- to refer to the constructor method parameter name
                        - simply refer as owner
					- to refer to the object's attribute
						- this.owner
							
				- way-2
					- change the names of the properties so that they are not the same
						- Refer Mobile2.java


- Employee.java
    - performAppraisal(Employee e1, Employeee2)
        - in Lines 10 and 15
            - where we compare scores, we need to use this. for clarity as to which object's score are we referring to
            - in this particular case, even without 'this.' the code works, however it will be unclear as to which objct are we referring to, when we use the score in the comparison with other objects passed as input to the method
        - this.score -> indicates current object's score
        - and e1.score and e2.score refer to the score of employee objects e1 and e2
