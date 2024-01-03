# Scenario-01
	- For the sorted array that is not rotated
```
Finding pivot for the following array 
	{ 9, 12, 15, 21, 33, 42, 57 }
The array is sorted, but NOT Rotated 
	This is because the firstElement (9) is less thant the lastElement (57) 
Returning the pivot as -1 

```
-------------------------------------------------------------------------
# Scenario-02
	- When the pivot is present at the end
```
Finding pivot for the following array 
	{ 12, 15, 21, 33, 42, 57, 9 }
Iterations 
	Iteration 1 
		Input Values: 
			Input Array is 
				{ 12, 15, 21, 33, 42, 57, 9 }
			Start-Index is 0 
			End-Index is 6 
			Middle-Index 3 
			Start-Index Element is 12 
			Middle-Index Element is 33 
			Potential Pivot Element (MiddleElement + 1) Index is 4 
			Potential Pivot Element (MiddleElement + 1) is 42 

		Observations 
			Start-Index Element is 12 
			Middle-Index Element is 33 
			Start-Index Element (12) value is less than or equals to the Middle-Index Element (33) 
				This means that the Pivot can be potentially present on the Right Side 
				Reset the Start-Index to (MiddleIndex + 1) 
					Start-Index is updated to 4 
	Iteration 2 
		Input Values: 
			Input Array is 
				{ 12, 15, 21, 33, 42, 57, 9 }
			Start-Index is 4 
			End-Index is 6 
			Middle-Index 5 
			Start-Index Element is 42 
			Middle-Index Element is 57 
			Potential Pivot Element (MiddleElement + 1) Index is 6 
			Potential Pivot Element (MiddleElement + 1) is 9 

		Observations 
			Middle-Index Element is 57 
			Element After 'Middle-Index Element' is 9 
				This can be the potential pivot element 
			Middle-Index Element (57) is greater than the 'The Potential Pivot Element' (9) 
				This means that a steep situation is encounterd because of the element 9 
				Return the index of the element 9, which is 6, as the pivot / pivot index 

```
-------------------------------------------------------------------------
# Scenario-03
	- When the pivot is present in-between
```
Finding pivot for the following array 
	{ 33, 42, 57, 9, 12, 15, 21 }
Iterations 
	Iteration 1 
		Input Values: 
			Input Array is 
				{ 33, 42, 57, 9, 12, 15, 21 }
			Start-Index is 0 
			End-Index is 6 
			Middle-Index 3 
			Start-Index Element is 33 
			Middle-Index Element is 9 
			Potential Pivot Element (MiddleElement + 1) Index is 4 
			Potential Pivot Element (MiddleElement + 1) is 12 

		Observations 
			Start-Index Element is 33 
			Middle-Index Element is 9 
			Start-Index Element (33) value is greater than Middle-Index Element (9) 
				This means that the Pivot can be potentially present on the Left Side 
				Reset the End-Index to (MiddleIndex - 1) 
					End-Index is updated to 2 
	Iteration 2 
		Input Values: 
			Input Array is 
				{ 33, 42, 57, 9, 12, 15, 21 }
			Start-Index is 0 
			End-Index is 2 
			Middle-Index 1 
			Start-Index Element is 33 
			Middle-Index Element is 42 
			Potential Pivot Element (MiddleElement + 1) Index is 2 
			Potential Pivot Element (MiddleElement + 1) is 57 

		Observations 
			Start-Index Element is 33 
			Middle-Index Element is 42 
			Start-Index Element (33) value is less than or equals to the Middle-Index Element (42) 
				This means that the Pivot can be potentially present on the Right Side 
				Reset the Start-Index to (MiddleIndex + 1) 
					Start-Index is updated to 2 
	Iteration 3 
		Input Values: 
			Input Array is 
				{ 33, 42, 57, 9, 12, 15, 21 }
			Start-Index is 2 
			End-Index is 2 
			Middle-Index 2 
			Start-Index Element is 57 
			Middle-Index Element is 57 
			Potential Pivot Element (MiddleElement + 1) Index is 3 
			Potential Pivot Element (MiddleElement + 1) is 9 

		Observations 
			Middle-Index Element is 57 
			Element After 'Middle-Index Element' is 9 
				This can be the potential pivot element 
			Middle-Index Element (57) is greater than the 'The Potential Pivot Element' (9) 
				This means that a steep situation is encounterd because of the element 9 
				Return the index of the element 9, which is 3, as the pivot / pivot index 

```
-------------------------------------------------------------------------
# Scenario-04
	- When the pivot is present in-between the left side and mid point
```
Finding pivot for the following array 
	{ 81, 91, 9, 12, 33, 42, 57, 66, 72 }
Iterations 
	Iteration 1 
		Input Values: 
			Input Array is 
				{ 81, 91, 9, 12, 33, 42, 57, 66, 72 }
			Start-Index is 0 
			End-Index is 8 
			Middle-Index 4 
			Start-Index Element is 81 
			Middle-Index Element is 33 
			Potential Pivot Element (MiddleElement + 1) Index is 5 
			Potential Pivot Element (MiddleElement + 1) is 42 

		Observations 
			Start-Index Element is 81 
			Middle-Index Element is 33 
			Start-Index Element (81) value is greater than Middle-Index Element (33) 
				This means that the Pivot can be potentially present on the Left Side 
				Reset the End-Index to (MiddleIndex - 1) 
					End-Index is updated to 3 
	Iteration 2 
		Input Values: 
			Input Array is 
				{ 81, 91, 9, 12, 33, 42, 57, 66, 72 }
			Start-Index is 0 
			End-Index is 3 
			Middle-Index 1 
			Start-Index Element is 81 
			Middle-Index Element is 91 
			Potential Pivot Element (MiddleElement + 1) Index is 2 
			Potential Pivot Element (MiddleElement + 1) is 9 

		Observations 
			Middle-Index Element is 91 
			Element After 'Middle-Index Element' is 9 
				This can be the potential pivot element 
			Middle-Index Element (91) is greater than the 'The Potential Pivot Element' (9) 
				This means that a steep situation is encounterd because of the element 9 
				Return the index of the element 9, which is 2, as the pivot / pivot index 

```
-------------------------------------------------------------------------
# Scenario-05
	- When the pivot is present in-between the mid point and the right side
```
Finding pivot for the following array 
	{ 33, 42, 57, 66, 72, 9, 12 }
Iterations 
	Iteration 1 
		Input Values: 
			Input Array is 
				{ 33, 42, 57, 66, 72, 9, 12 }
			Start-Index is 0 
			End-Index is 6 
			Middle-Index 3 
			Start-Index Element is 33 
			Middle-Index Element is 66 
			Potential Pivot Element (MiddleElement + 1) Index is 4 
			Potential Pivot Element (MiddleElement + 1) is 72 

		Observations 
			Start-Index Element is 33 
			Middle-Index Element is 66 
			Start-Index Element (33) value is less than or equals to the Middle-Index Element (66) 
				This means that the Pivot can be potentially present on the Right Side 
				Reset the Start-Index to (MiddleIndex + 1) 
					Start-Index is updated to 4 
	Iteration 2 
		Input Values: 
			Input Array is 
				{ 33, 42, 57, 66, 72, 9, 12 }
			Start-Index is 4 
			End-Index is 6 
			Middle-Index 5 
			Start-Index Element is 72 
			Middle-Index Element is 9 
			Potential Pivot Element (MiddleElement + 1) Index is 6 
			Potential Pivot Element (MiddleElement + 1) is 12 

		Observations 
			Start-Index Element is 72 
			Middle-Index Element is 9 
			Start-Index Element (72) value is greater than Middle-Index Element (9) 
				This means that the Pivot can be potentially present on the Left Side 
				Reset the End-Index to (MiddleIndex - 1) 
					End-Index is updated to 4 
	Iteration 3 
		Input Values: 
			Input Array is 
				{ 33, 42, 57, 66, 72, 9, 12 }
			Start-Index is 4 
			End-Index is 4 
			Middle-Index 4 
			Start-Index Element is 72 
			Middle-Index Element is 72 
			Potential Pivot Element (MiddleElement + 1) Index is 5 
			Potential Pivot Element (MiddleElement + 1) is 9 

		Observations 
			Middle-Index Element is 72 
			Element After 'Middle-Index Element' is 9 
				This can be the potential pivot element 
			Middle-Index Element (72) is greater than the 'The Potential Pivot Element' (9) 
				This means that a steep situation is encounterd because of the element 9 
				Return the index of the element 9, which is 5, as the pivot / pivot index 

```
-------------------------------------------------------------------------
