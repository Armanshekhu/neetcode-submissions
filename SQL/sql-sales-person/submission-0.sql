-- -- Write your query below
-- select s.name from sales_person as s
-- left join orders as o
-- on s.sales_id = o.sales_id
-- left join company as c
-- on s.com_id = c.com_id 
-- where is not c.name = 'CRIMSON';

select s.name
from sales_person s
where not exists(
    select 1
    from orders o
    join company c
    on o.com_id = c.com_id
    where s.sales_id = o.sales_id
    and c.name = 'CRIMSON'
);