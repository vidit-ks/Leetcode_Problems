# Write your MySQL query statement below
select product_id, new_price as price
from(select product_id,new_price,
row_number() over(
    partition by product_id
    order by change_date desc
)rnk
from products
where change_date<='2019-08-16'
)t
where rnk=1

union

select product_id, 10 as price
from products
group by product_id
having min(change_date)>'2019-08-16';