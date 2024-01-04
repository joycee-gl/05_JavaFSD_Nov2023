# Test Case-01

Inputs
------------
	Input Array
		{ 3, 8, 10, 12, 14, 16, 19, 27, 32, 42 }
	Search Element : 14 
Iteration : 1 
	Start Index : 0 
	End Index : 9 
	Middle Index : 4 
	Middle Index Element : 14 

	Search Element and the identified middle element value are one and the same 14 
	Returning the middle element value index which is 4, as the search element's index value


# Test Case-02

Inputs
------------
	Input Array
		{ 3, 8, 10, 12, 14, 16, 19, 27, 32, 42 }
	Search Element : 10 
Iteration : 1 
	Start Index : 0 
	End Index : 9 
	Middle Index : 4 
	Middle Index Element : 14 

	Search element 10 is less than the middle element 14 
	Search element may be present on the left side
	Updating the endIndex from 9 to 3 

Iteration : 2 
	Start Index : 0 
	End Index : 3 
	Middle Index : 1 
	Middle Index Element : 8 

	Search element 10 is greater than the middle element 8 
	Search element may be present on the right side
	Updating the startIndex from 0 to 2 

Iteration : 3 
	Start Index : 2 
	End Index : 3 
	Middle Index : 2 
	Middle Index Element : 10 

	Search Element and the identified middle element value are one and the same 10 
	Returning the middle element value index which is 2, as the search element's index value


# Test Case-03

Inputs
------------
	Input Array
		{ 3, 8, 10, 12, 14, 16, 19, 27, 32, 42 }
	Search Element : 32 
Iteration : 1 
	Start Index : 0 
	End Index : 9 
	Middle Index : 4 
	Middle Index Element : 14 

	Search element 32 is greater than the middle element 14 
	Search element may be present on the right side
	Updating the startIndex from 0 to 5 

Iteration : 2 
	Start Index : 5 
	End Index : 9 
	Middle Index : 7 
	Middle Index Element : 27 

	Search element 32 is greater than the middle element 27 
	Search element may be present on the right side
	Updating the startIndex from 5 to 8 

Iteration : 3 
	Start Index : 8 
	End Index : 9 
	Middle Index : 8 
	Middle Index Element : 32 

	Search Element and the identified middle element value are one and the same 32 
	Returning the middle element value index which is 8, as the search element's index value


# Test Case-04

Inputs
------------
	Input Array
		{ 3, 8, 10, 12, 14, 16, 19, 27, 32, 42 }
	Search Element : 92 
Search element 92 not within range of values in the sorted array, so returning the default index -1 
