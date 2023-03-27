/*
Create a function that takes as inputs a 
SalesOrderID, 
a Currency Code, 
and a date, 
and returns a table of all the SalesOrderDetail rows for that Sales Order including 
Quantity, ProductID, UnitPrice, and the unit price converted to the target currency based on the end of day rate for the date provided. 
Exchange rates can be found in the Sales.CurrencyRate table. 
( Use AdventureWorks)
*/

--CONNECT TO DATABASE;
USE AdventureWorks2008R2;

-- FUNCTION
GO
CREATE FUNCTION Sales.uf_getProducts(@SalesOrderID int, @CurrencyCode nchar(3), @CurrencyRateDate datetime)
RETURNS TABLE
AS
RETURN
SELECT sod.ProductID, sod.OrderQty, sod.UnitPrice, sod.UnitPrice * scr.EndOfDayRate AS 'Converted Price'
FROM Sales.SalesOrderDetail AS sod
JOIN Sales.CurrencyRate AS scr
ON scr.ToCurrencyCode = @CurrencyCode
AND scr.CurrencyRateDate = @CurrencyRateDate
WHERE sod.SalesOrderID = @SalesOrderID
GROUP BY sod.ProductID, sod.OrderQty, sod.UnitPrice, scr.EndOfDayRate;
GO

--SELECT * FROM Sales.uf_getProducts(43659, 'EUR', '2012-07-01');


