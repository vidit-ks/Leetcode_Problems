# Write your MySQL query statement 
(select u.name as results
from users u
join movierating mr
on mr.user_id=u.user_id
group by u.user_id
order by count(mr.user_id) desc,u.name
limit 1)
union all
(select m.title as results
from movies m
join movierating mr
on m.movie_id=mr.movie_id
where month(mr.created_at)='02' and year(mr.created_at)='2020'
group by m.movie_id
order by avg(mr.rating) desc, m.title
limit 1)