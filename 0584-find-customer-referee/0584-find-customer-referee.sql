# Write your MySQL query statement below
select name
from Customer
where referee_id is Null or referee_id <> 2;