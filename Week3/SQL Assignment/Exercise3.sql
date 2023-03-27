/*
Show the most recent five orders that were purchased from account numbers that have spent more than $70,000 with AdventureWorks.
*/

--CONNECT TO DATABASE
USE AdventureWorks2008R2;

SELECT TOP 5 soh.SalesOrderID, soh.AccountNumber, soh.OrderDate
FROM Sales.SalesOrderHeader soh
INNER JOIN (
SELECT AccountNumber, SUM(SubTotal) as TotalSales
FROM Sales.SalesOrderHeader
GROUP BY AccountNumber
HAVING SUM(SubTotal) > 70000
) sub ON soh.AccountNumber = sub.AccountNumber
ORDER BY soh.OrderDate DESC;
