-- Display the Id and Name of the Product ordered after “2021-10-05”.
select 
	p.pro_id,
    p.pro_name
from 
	`order` o 
    inner join supplier_pricing sp
    inner join product p on (
		o.pricing_id = sp.pricing_id
        and sp.pro_id = p.pro_id
        and o.ord_date > '2021-10-05'
    )
group by
	p.pro_id

