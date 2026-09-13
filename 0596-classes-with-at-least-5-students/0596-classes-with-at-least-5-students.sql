select distinct class
from courses
group by class
having count(student)>4;
