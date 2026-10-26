-- Write your query below
-- select * 
-- from person  
-- full outer join address
-- on person.person_id = address.person_id;

select p.first_name, p.last_name, a.city, a.state
from person as p 
left join address as a
on p.person_id = a.person_id;