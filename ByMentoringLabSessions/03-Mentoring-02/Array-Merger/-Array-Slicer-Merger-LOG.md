
# Scenario-01
	- Left Sliced Array less than Right Sliced Array
```
Input Values
	Original Array
		{ 21, 28, 13, 19, 34, 47 }

	Left Index : 0
	Middle Index : 1
	Right Index : 5
	Left Sub-Array [LSA]
		{ 21, 28 }

	Right Sub-Array [RSA]
		{ 13, 19, 34, 47 }

Initial Values
------------------
	Left Sub-Array Pointer [LSA Pointer] -> 0
	Right Sub-Array Pointer [RSA Pointer] -> 0
	Merged Array Pointer -> [MA Pointer]0

Phase - Comparison & Initial Merge
------------------------------------

	Comparing elements LSA [LSA Pointer] and RSA [RSA Pointer]
		LSA Pointer : 0
		RSA Pointer : 0

		Comparing elements LSA [0] and RSA [0]
			Comparing elements 21 and 13 to find out the Minimum Element
				13 < 21
			Minimum Element 13 originates from RSA
			Minimum Element 13 will be added to the Merged Array
			RSA Pointer & MA Pointer will be incremented
		Outcomes
			Merged Array 
				{ 13, 0, 0, 0, 0, 0 }
			LSA Pointer [NoChange] -> 0
			RSA Pointer [Incremented] -> 1
			MA  Pointer [Incremented] -> 1

	Comparing elements LSA [LSA Pointer] and RSA [RSA Pointer]
		LSA Pointer : 0
		RSA Pointer : 1

		Comparing elements LSA [0] and RSA [1]
			Comparing elements 21 and 19 to find out the Minimum Element
				19 < 21
			Minimum Element 19 originates from RSA
			Minimum Element 19 will be added to the Merged Array
			RSA Pointer & MA Pointer will be incremented
		Outcomes
			Merged Array 
				{ 13, 19, 0, 0, 0, 0 }
			LSA Pointer [NoChange] -> 0
			RSA Pointer [Incremented] -> 2
			MA  Pointer [Incremented] -> 2

	Comparing elements LSA [LSA Pointer] and RSA [RSA Pointer]
		LSA Pointer : 0
		RSA Pointer : 2

		Comparing elements LSA [0] and RSA [2]
			Comparing elements 21 and 34 to find out the Minimum Element
				21 < 34
			Minimum Element 21 originates from LSA
			Minimum Element 21 will be added to the Merged Array
			LSA Pointer & MA Pointer will be incremented
		Outcomes
			Merged Array 
				{ 13, 19, 21, 0, 0, 0 }
			LSA Pointer [Incremented] -> 1
			RSA Pointer [NoChange] -> 2
			MA  Pointer [Incremented] -> 3

	Comparing elements LSA [LSA Pointer] and RSA [RSA Pointer]
		LSA Pointer : 1
		RSA Pointer : 2

		Comparing elements LSA [1] and RSA [2]
			Comparing elements 28 and 34 to find out the Minimum Element
				28 < 34
			Minimum Element 28 originates from LSA
			Minimum Element 28 will be added to the Merged Array
			LSA Pointer & MA Pointer will be incremented
		Outcomes
			Merged Array 
				{ 13, 19, 21, 28, 0, 0 }
			LSA Pointer [Incremented] -> 2
			RSA Pointer [NoChange] -> 2
			MA  Pointer [Incremented] -> 4

Phase - Pending Elements Copy
------------------------------
	For Left Sub Array
		All elements from the LSA copied
		No more copy action is applicable

	For Right Sub Array
		Pending elements available in the RSA from index 2
			Pending Elements { 34, 47 }

		Copy them to the merged array one by one
			Copying the element 34 to the merged array
			Merged Array 
				{ 13, 19, 21, 28, 34, 0 }

			Copying the element 47 to the merged array
			Merged Array 
				{ 13, 19, 21, 28, 34, 47 }


```
-------------------------------------------------------------------------

# Scenario-02
	- Left Sliced Array greater than Right Sliced Array
```
Input Values
	Original Array
		{ 13, 18, 42, 47, 15, 19 }

	Left Index : 0
	Middle Index : 3
	Right Index : 5
	Left Sub-Array [LSA]
		{ 13, 18, 42, 47 }

	Right Sub-Array [RSA]
		{ 15, 19 }

Initial Values
------------------
	Left Sub-Array Pointer [LSA Pointer] -> 0
	Right Sub-Array Pointer [RSA Pointer] -> 0
	Merged Array Pointer -> [MA Pointer]0

Phase - Comparison & Initial Merge
------------------------------------

	Comparing elements LSA [LSA Pointer] and RSA [RSA Pointer]
		LSA Pointer : 0
		RSA Pointer : 0

		Comparing elements LSA [0] and RSA [0]
			Comparing elements 13 and 15 to find out the Minimum Element
				13 < 15
			Minimum Element 13 originates from LSA
			Minimum Element 13 will be added to the Merged Array
			LSA Pointer & MA Pointer will be incremented
		Outcomes
			Merged Array 
				{ 13, 0, 0, 0, 0, 0 }
			LSA Pointer [Incremented] -> 1
			RSA Pointer [NoChange] -> 0
			MA  Pointer [Incremented] -> 1

	Comparing elements LSA [LSA Pointer] and RSA [RSA Pointer]
		LSA Pointer : 1
		RSA Pointer : 0

		Comparing elements LSA [1] and RSA [0]
			Comparing elements 18 and 15 to find out the Minimum Element
				15 < 18
			Minimum Element 15 originates from RSA
			Minimum Element 15 will be added to the Merged Array
			RSA Pointer & MA Pointer will be incremented
		Outcomes
			Merged Array 
				{ 13, 15, 0, 0, 0, 0 }
			LSA Pointer [NoChange] -> 1
			RSA Pointer [Incremented] -> 1
			MA  Pointer [Incremented] -> 2

	Comparing elements LSA [LSA Pointer] and RSA [RSA Pointer]
		LSA Pointer : 1
		RSA Pointer : 1

		Comparing elements LSA [1] and RSA [1]
			Comparing elements 18 and 19 to find out the Minimum Element
				18 < 19
			Minimum Element 18 originates from LSA
			Minimum Element 18 will be added to the Merged Array
			LSA Pointer & MA Pointer will be incremented
		Outcomes
			Merged Array 
				{ 13, 15, 18, 0, 0, 0 }
			LSA Pointer [Incremented] -> 2
			RSA Pointer [NoChange] -> 1
			MA  Pointer [Incremented] -> 3

	Comparing elements LSA [LSA Pointer] and RSA [RSA Pointer]
		LSA Pointer : 2
		RSA Pointer : 1

		Comparing elements LSA [2] and RSA [1]
			Comparing elements 42 and 19 to find out the Minimum Element
				19 < 42
			Minimum Element 19 originates from RSA
			Minimum Element 19 will be added to the Merged Array
			RSA Pointer & MA Pointer will be incremented
		Outcomes
			Merged Array 
				{ 13, 15, 18, 19, 0, 0 }
			LSA Pointer [NoChange] -> 2
			RSA Pointer [Incremented] -> 2
			MA  Pointer [Incremented] -> 4

Phase - Pending Elements Copy
------------------------------
	For Left Sub Array
		Pending elements available in the LSA from index 2
			Pending Elements { 42, 47 }

		Copy them to the merged array one by one
			Copying the element 42 to the Merged Array
			Merged Array 
				{ 13, 15, 18, 19, 42, 0 }


			Copying the element 47 to the Merged Array
			Merged Array 
				{ 13, 15, 18, 19, 42, 47 }


	For Right Sub Array
		All elements from the RSA copied
		No more copy action is applicable

```
-------------------------------------------------------------------------

# Scenario-03
	- Left Sliced Array is equal to Right Sliced Array
```
Input Values
	Original Array
		{ 3, 4, 11, 19, 2, 9, 13, 18 }

	Left Index : 0
	Middle Index : 3
	Right Index : 7
	Left Sub-Array [LSA]
		{ 3, 4, 11, 19 }

	Right Sub-Array [RSA]
		{ 2, 9, 13, 18 }

Initial Values
------------------
	Left Sub-Array Pointer [LSA Pointer] -> 0
	Right Sub-Array Pointer [RSA Pointer] -> 0
	Merged Array Pointer -> [MA Pointer]0

Phase - Comparison & Initial Merge
------------------------------------

	Comparing elements LSA [LSA Pointer] and RSA [RSA Pointer]
		LSA Pointer : 0
		RSA Pointer : 0

		Comparing elements LSA [0] and RSA [0]
			Comparing elements 3 and 2 to find out the Minimum Element
				2 < 3
			Minimum Element 2 originates from RSA
			Minimum Element 2 will be added to the Merged Array
			RSA Pointer & MA Pointer will be incremented
		Outcomes
			Merged Array 
				{ 2, 0, 0, 0, 0, 0, 0, 0 }
			LSA Pointer [NoChange] -> 0
			RSA Pointer [Incremented] -> 1
			MA  Pointer [Incremented] -> 1

	Comparing elements LSA [LSA Pointer] and RSA [RSA Pointer]
		LSA Pointer : 0
		RSA Pointer : 1

		Comparing elements LSA [0] and RSA [1]
			Comparing elements 3 and 9 to find out the Minimum Element
				3 < 9
			Minimum Element 3 originates from LSA
			Minimum Element 3 will be added to the Merged Array
			LSA Pointer & MA Pointer will be incremented
		Outcomes
			Merged Array 
				{ 2, 3, 0, 0, 0, 0, 0, 0 }
			LSA Pointer [Incremented] -> 1
			RSA Pointer [NoChange] -> 1
			MA  Pointer [Incremented] -> 2

	Comparing elements LSA [LSA Pointer] and RSA [RSA Pointer]
		LSA Pointer : 1
		RSA Pointer : 1

		Comparing elements LSA [1] and RSA [1]
			Comparing elements 4 and 9 to find out the Minimum Element
				4 < 9
			Minimum Element 4 originates from LSA
			Minimum Element 4 will be added to the Merged Array
			LSA Pointer & MA Pointer will be incremented
		Outcomes
			Merged Array 
				{ 2, 3, 4, 0, 0, 0, 0, 0 }
			LSA Pointer [Incremented] -> 2
			RSA Pointer [NoChange] -> 1
			MA  Pointer [Incremented] -> 3

	Comparing elements LSA [LSA Pointer] and RSA [RSA Pointer]
		LSA Pointer : 2
		RSA Pointer : 1

		Comparing elements LSA [2] and RSA [1]
			Comparing elements 11 and 9 to find out the Minimum Element
				9 < 11
			Minimum Element 9 originates from RSA
			Minimum Element 9 will be added to the Merged Array
			RSA Pointer & MA Pointer will be incremented
		Outcomes
			Merged Array 
				{ 2, 3, 4, 9, 0, 0, 0, 0 }
			LSA Pointer [NoChange] -> 2
			RSA Pointer [Incremented] -> 2
			MA  Pointer [Incremented] -> 4

	Comparing elements LSA [LSA Pointer] and RSA [RSA Pointer]
		LSA Pointer : 2
		RSA Pointer : 2

		Comparing elements LSA [2] and RSA [2]
			Comparing elements 11 and 13 to find out the Minimum Element
				11 < 13
			Minimum Element 11 originates from LSA
			Minimum Element 11 will be added to the Merged Array
			LSA Pointer & MA Pointer will be incremented
		Outcomes
			Merged Array 
				{ 2, 3, 4, 9, 11, 0, 0, 0 }
			LSA Pointer [Incremented] -> 3
			RSA Pointer [NoChange] -> 2
			MA  Pointer [Incremented] -> 5

	Comparing elements LSA [LSA Pointer] and RSA [RSA Pointer]
		LSA Pointer : 3
		RSA Pointer : 2

		Comparing elements LSA [3] and RSA [2]
			Comparing elements 19 and 13 to find out the Minimum Element
				13 < 19
			Minimum Element 13 originates from RSA
			Minimum Element 13 will be added to the Merged Array
			RSA Pointer & MA Pointer will be incremented
		Outcomes
			Merged Array 
				{ 2, 3, 4, 9, 11, 13, 0, 0 }
			LSA Pointer [NoChange] -> 3
			RSA Pointer [Incremented] -> 3
			MA  Pointer [Incremented] -> 6

	Comparing elements LSA [LSA Pointer] and RSA [RSA Pointer]
		LSA Pointer : 3
		RSA Pointer : 3

		Comparing elements LSA [3] and RSA [3]
			Comparing elements 19 and 18 to find out the Minimum Element
				18 < 19
			Minimum Element 18 originates from RSA
			Minimum Element 18 will be added to the Merged Array
			RSA Pointer & MA Pointer will be incremented
		Outcomes
			Merged Array 
				{ 2, 3, 4, 9, 11, 13, 18, 0 }
			LSA Pointer [NoChange] -> 3
			RSA Pointer [Incremented] -> 4
			MA  Pointer [Incremented] -> 7

Phase - Pending Elements Copy
------------------------------
	For Left Sub Array
		Pending elements available in the LSA from index 3
			Pending Elements { 19 }

		Copy them to the merged array one by one
			Copying the element 19 to the Merged Array
			Merged Array 
				{ 2, 3, 4, 9, 11, 13, 18, 19 }


	For Right Sub Array
		All elements from the RSA copied
		No more copy action is applicable

```
-------------------------------------------------------------------------
