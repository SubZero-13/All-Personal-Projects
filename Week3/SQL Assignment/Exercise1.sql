USE AdventureWorks2008R2;
/*
Q 1.1
Display the number of records in the [SalesPerson] table. 
(Schema(s) involved: Sales)
*/
SELECT COUNT(*) AS 'No. of Records'
FROM Sales.SalesPerson;

/*
Q 1.2
Select both the FirstName and LastName of records from the Person table where 
the FirstName begins with the letter ‘B’. 
(Schema(s) involved: Person)
*/
SELECT FirstName + ' ' + LastName AS 'Full Name'
FROM Person.Person
WHERE FirstName LIKE 'B%';

/*
Q 1.3
Select a list of FirstName and LastName for employees where 
Title is one of Design Engineer, Tool Designer or Marketing Assistant. 
(Schema(s) involved: HumanResources, Person)
*/
SELECT p.FirstName + ' ' + p.LastName AS 'Full Name'
FROM Person.Person AS p, HumanResources.Employee AS e
WHERE e.BusinessEntityID = p.BusinessEntityID 
AND e.JobTitle IN ('Design Engineer','Tool Designer','Marketing Assistant');

/*
Q 1.4
Display the Name and Color of the Product with the maximum weight. 
(Schema(s) involved: Production)
*/
SELECT Name, Color, Weight 
FROM Production.Product
WHERE [Weight] = (SELECT MAX([Weight]) FROM Production.Product);


/*
Q 1.5
Display Description and MaxQty fields from the SpecialOffer table. 
Some of the MaxQty values are NULL, in this case display the value 0.00 instead. 
(Schema(s) involved: Sales)
*/
SELECT Description, COALESCE(MaxQty, 0.00)  AS 'Maximum Quantity' 
FROM Sales.SpecialOffer;


/*
Q 1.6
Display the overall Average of the [CurrencyRate].[AverageRate] values for the exchange rate ‘USD’ to ‘GBP’ for the year 2005 i.e. FromCurrencyCode = ‘USD’ and ToCurrencyCode = ‘GBP’. 
Note: The field [CurrencyRate].[AverageRate] is defined as 'Average exchange rate for the day.' 
(Schema(s) involved: Sales)
*/

SELECT AVG(c.AverageRate) AS 'Average exchange rate for the day'
FROM Sales.CurrencyRate AS c 
WHERE c.FromCurrencyCode = 'USD' AND c.ToCurrencyCode = 'GBP' AND YEAR(CurrencyRateDate) = 2005;

/*
Q 1.7
Display the FirstName and LastName of records from the Person table 
where FirstName contains the letters ‘ss’. 
Display an additional column with sequential numbers for each row returned beginning at integer 1. 
(Schema(s) involved: Person)
*/

SELECT ROW_NUMBER() OVER
( ORDER BY FirstName, LastName) AS 'sequential numbers', FirstName , LastName
FROM Person.Person
WHERE FirstName LIKE '%ss%';


/*
Q 1.8
Sales people receive various commission rates that belong to 1 of 4 bands. 
(Schema(s) involved: Sales)
Display the [SalesPersonID] with an additional column entitled ‘Commission Band’ indicating the appropriate band as above.
*/

SELECT BusinessEntityID AS 'SalesPersonID',
	CASE
		WHEN CommissionPct = 0.0 then 'BAND 0'
		WHEN CommissionPct > 0.0 AND CommissionPct <=0.01 then 'BAND 1'
		WHEN CommissionPct > 0.01 AND CommissionPct <=0.015 then 'BAND 2'
		WHEN CommissionPct > 0.015 then 'BAND 3'
		END AS 'Commission Band'
FROM Sales.SalesPerson;


/*
Q 1.9
Display the managerial hierarchy from Ruth Ellerbrock (person type – EM) up to CEO Ken Sanchez. 
Hint: use [uspGetEmployeeManagers] 
(Schema(s) involved: [Person], [HumanResources])
*/

DECLARE @ID int;
SELECT @ID = BusinessEntityID 
FROM Person.Person 
WHERE FirstName = 'Ruth' 
	AND LastName = 'Ellerbrock'
	AND PersonType = 'EM';
EXEC dbo.uspGetEmployeeManagers @BusinessEntityID = @ID;


/*
Q 1.10
Display the ProductId of the product with the largest stock level. 
Hint: Use the Scalar-valued function [dbo]. [UfnGetStock]. 
(Schema(s) involved: Production)
*/

--sp_helptext 'ufnGetStock'

SELECT MAX(dbo.ufnGetStock(ProductID)) FROM Production.Product;


