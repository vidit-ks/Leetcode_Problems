# Write your MySQL query statement below
select round(sum(if(order_date=customer_pref_delivery_date, 1,0))/count(*)*100.0,2) as immediate_percentage
from(
    select *,
    row_number() over(
        partition by customer_id
        order by order_date
    )as rnk
    from delivery
)t
where rnk=1;