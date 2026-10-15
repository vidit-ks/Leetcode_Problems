# Write your MySQL query statement below
with emp as (
    select name, salary, departmentId,
    dense_rank() over(
        partition by departmentId
        order by salary desc
    )as rnk
    from employee
)
    
select d.name as Department, e.name as Employee, e.salary as Salary
from department d
join emp e 
on d.id=e.departmentID
where e.rnk<4
order by Department