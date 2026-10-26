-- Write your query below

select s.seller_name 
from seller as s
left join orders as o
on s.seller_id = o.seller_id
and o.sale_date >= '2020-01-01'
and o.sale_date < '2021-01-01'
where o.order_id is null
order by s.seller_name asc;
