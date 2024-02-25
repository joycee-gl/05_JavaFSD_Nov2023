select 
	P_SP.cat_id as Category_ID,
    c.cat_name as Category_Name,
    min(Minimum_Price_Of_Product)
from
	category c
    inner join (
		
        select 
			p.cat_id,
			p.pro_name,
			sp.pro_id,
			Minimum_Price_Of_Product
		from 
			product p
		inner join (
			
				select 
					pro_id,
					min(supp_price) as Minimum_Price_Of_Product
				from 
					supplier_pricing
				group by
					pro_id
			
			) as SP on sp.pro_id = p.pro_id
        
    ) as  P_SP on c.cat_id = P_SP.cat_id
group by
	c.cat_id;


