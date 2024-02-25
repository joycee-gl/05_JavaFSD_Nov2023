-- Display customer name and gender whose names start or end with character 'A'.

-- like operator

select 
	cus_name,
    cus_gender
from customer 
where
	cus_name like 'A%'
    or cus_name like '%A'
