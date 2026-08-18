# Write your MySQL query statement below
select s.user_id, round(avg(if(c.action="confirmed",1.00,0)),2) as confirmation_rate
from signups as s
left join confirmations c
using(user_id)
group by user_id;