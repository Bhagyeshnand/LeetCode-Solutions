CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
set N = N - 1;
  RETURN (
      # Write your MySQL query statement below.
      select distinct salary
      from Employee
      Order by salary desc
      limit 1 OFFSET N
  );
END