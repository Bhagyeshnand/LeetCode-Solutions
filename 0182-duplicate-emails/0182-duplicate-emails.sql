# Write your MySQL query statement below
select email
from Person
Group by email
having count(distinct id) > 1