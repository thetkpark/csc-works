-- 5 Questions for aggregate functions
-- 5 Questions for set operations.
-- 1.) Show average salary of male and female employees.
SELECT sex, DECIMAL(AVG(SALARY), 9, 2)
FROM EMPLOYEE
GROUP BY SEX;
-- another solution using union
    SELECT 'Female' AS Gender, DECIMAL(AVG(SALARY), 9, 2) AS average_salary
    FROM EMPLOYEE
    WHERE sex = 'F'
UNION
    SELECT 'Male' AS Gender, DECIMAL(AVG(SALARY), 9, 2) AS average_salary
    FROM EMPLOYEE
    WHERE sex = 'M';

-- 2.) Show the highest and lowest salary of each department and its number of employees
SELECT WORKDEPT, MAX(SALARY) AS max_salary, MIN(SALARY) AS min_salary, COUNT(*) AS the_number_of_employees
FROM EMPLOYEE
GROUP BY WORKDEPT;
-- better Answer
SELECT DEPTNAME, MAX(SALARY) AS max_salary, MIN(SALARY) AS min_salary, COUNT(*) AS the_number_of_employees
FROM EMPLOYEE, DEPARTMENT
WHERE WORKDEPT = DEPTNO
GROUP BY DEPTNO, DEPTNAME;

-- 3.) How many departments are responsible for project(s)
SELECT COUNT(DISTINCT DEPTNO)
FROM PROJECT;

-- 4.) Show the number of employees who work on each project. Show project title, and the number of employees.
-- Order the result by showing the project that has the most number of employees first.
SELECT PROJECT.PROJNAME, COUNT(DISTINCT EMPNO) AS number_of_employees
FROM EMPPROJACT, PROJECT
WHERE PROJECT.PROJNO = EMPPROJACT.PROJNO
GROUP BY PROJECT.PROJNO, PROJNAME
ORDER BY number_of_employees DESC;

-- 5.) Show name of department having the employee who earns the most
SELECT DEPTNAME, SALARY
FROM EMPLOYEE, DEPARTMENT
WHERE DEPTNO = WORKDEPT
ORDER BY SALARY DESC
FETCH FIRST 1 ROWS ONLY;

-- 6.) Which department has the highest average salary
SELECT WORKDEPT, DEPTNAME, AVG(SALARY) as avg_salary
FROM EMPLOYEE, DEPARTMENT
WHERE WORKDEPT = DEPTNO
GROUP BY WORKDEPT, DEPTNAME
ORDER BY avg_salary DESC
FETCH FIRST 1 ROWS ONLY;

-- 7.) There is a table named staff
SELECT * FROM DB2INST1.staff;

-- 8.) Show name of everyone in this company IN A SINGLE COLUMN
SELECT FIRSTNME FROM EMPLOYEE
    UNION
SELECT NAME FROM DB2INST1.STAFF;

-- 9.) Is there anyone who are both employee and staff? If so, show the name
SELECT UPPER(FIRSTNME) FROM EMPLOYEE
    INTERSECT
SELECT UPPER(NAME) FROM DB2INST1.STAFF;

-- 10.) Show employees who are not staff
SELECT UPPER(FIRSTNME) FROM EMPLOYEE
    EXCEPT -- The difference
SELECT UPPER(NAME) FROM DB2INST1.STAFF;