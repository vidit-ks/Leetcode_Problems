# Write your MySQL query statement below
select id,
case 
    when id=(select max(id) from seat) and id%2=1 then student
    when id%2=1 then (select student from seat s where s.id=seat.id+1)
    else (select student from seat s where s.id=seat.id-1)
end as student
from seat;
