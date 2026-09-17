# Write your MySQL query statement below
select employee_id 
from employees
where manager_id not in(select employee_id from employees)
group by salary

having salary<30000
order by employee_id;