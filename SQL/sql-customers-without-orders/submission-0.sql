-- Write your query below
-- select customers.name 
-- from customers
-- left join orders
-- on customers.id = orders.customer_id 
-- where orders.customer_id is null;

select name 
from customers
where id not in (
    select customer_id
    from orders
);
