CREATE DEFINER=`root`@`localhost` PROCEDURE `ListSupplierRatingDetails`()
BEGIN

select 
	supp_id as SUPPLIER_ID,
    supp_name as SUPPLIER_NAME,
    AverageRating,
    CASE
		WHEN AverageRating = 5 THEN 'Excellent Service'
		WHEN AverageRating > 4 THEN 'Good Service'
        WHEN AverageRating > 2 THEN 'Average Service'
        ELSE 'Poor Service'
    END as Type_of_Service
from 
	(

		select 
			s.supp_id,
			s.supp_name,
			avg(r.rat_ratstars) as AverageRating
			
		from 
			rating r
			inner join `order` o
			inner join supplier_pricing sp
			inner join supplier s on (
					r.ord_id = o.ord_id
					and o.pricing_id = sp.pricing_id
					and sp.supp_id = s.supp_id
			
			)
		group by
			supp_id
		order by
			supp_id
		
) as R_O_SP_S ;


END