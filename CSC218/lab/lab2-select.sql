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
