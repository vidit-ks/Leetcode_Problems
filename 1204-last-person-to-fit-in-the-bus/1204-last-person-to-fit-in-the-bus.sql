# Write your MySQL query statement below
select person_name 
from (select *, sum(weight) over(order by turn) as total_weight
from queue)t
where total_weight<=1000
order by total_weight desc
limit 1;