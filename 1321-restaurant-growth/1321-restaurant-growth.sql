# Write your MySQL query statement below
select distinct visited_on,
sum(amount) over w as amount,
round((sum(amount) over w)/7, 2) as average_amount
from customer

window w as(
    order by visited_on
    range between interval 6 day preceding and current row
)
limit 6,999

