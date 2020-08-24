-- 1 - 4 is SELECT * FOR each tables
-- 5.) Find female employees. Show their name, date of birth, phone, and salary
SELECT FIRSTNME, LASTNAME, BIRTHDATE, PHONENO, SALARY
FROM EMPLOYEE
WHERE SEX = 'F';

-- 6.) Find name, job, and salary of employee who earns more than $80000
SELECT FIRSTNME, LASTNAME, JOB, SALARY
FROM EMPLOYEE
WHERE SALARY > 80000;

-- 6.2) Is there any woman in the answer
SELECT FIRSTNME, LASTNAME, JOB, SALARY, SEX
FROM EMPLOYEE
WHERE SALARY > 80000 AND SEX = 'F';

-- 6.3) Order the result of 6.2 by salary. Show the highest salary first
SELECT FIRSTNME, LASTNAME, JOB, SALARY
FROM EMPLOYEE
WHERE SALARY > 80000
ORDER BY SALARY DESC;

-- 7.) Show name, job, salary, and hiredate of the top three most salary employees
SELECT FIRSTNME, LASTNAME, JOB, SALARY, HIREDATE
FROM EMPLOYEE
ORDER BY SALARY DESC
FETCH FIRST 3 ROWS ONLY; -- SAME AS LIMIT 3

-- 8.) Show name and their total income
SELECT FIRSTNME, LASTNAME, SALARY, BONUS, COMM, SALARY + BONUS + COMM AS TOTAL
FROM EMPLOYEE;

-- 9.) SHow only person who earn the total income more than 100,000

