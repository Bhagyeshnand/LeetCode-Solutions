# Write your MySQL query statement below
with temp as (
    select class, count(student) as number
    from Courses
    group by class
)
select class
from temp
where number >= 5;