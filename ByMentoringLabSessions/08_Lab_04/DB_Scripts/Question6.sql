select * from supplier_pricing;

select 
	pro_id,
    min(supp_price) as Minimum_Price_Of_Product
from 
	supplier_pricing
group by
	pro_id;
    
    
select 
	p.cat_id,
    p.pro_name
from 
	product p;
    
-- PRODUCT table inner join prev query from supplier_pricing


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
    
	) as SP on sp.pro_id = p.pro_id;


select 
	c.cat_name as Category_Name,
    P_SP.cat_id as Category_ID,
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
	c.cat_id



