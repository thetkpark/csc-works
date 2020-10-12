-- Sethanant Pipatpakorn 62130500230 Oct 12, 2020
-- Lab 4 Subquery

-- 1.1) Find department that has no employee.
SELECT DEPTNAME
FROM DEPARTMENT
WHERE DEPTNO NOT IN (SELECT WORKDEPT FROM EMPLOYEE);

-- 1.2) Show name of employee who earns the most in this company.
SELECT FIRSTNME, LASTNAME, SALARY
FROM EMPLOYEE e1
WHERE SALARY >= ALL (SELECT SALARY FROM EMPLOYEE);

SELECT FIRSTNME, LASTNAME, SALARY
FROM EMPLOYEE
WHERE SALARY = (SELECT MAX(SALARY) FROM EMPLOYEE);

SELECT e1.FIRSTNME, e1.LASTNAME, e1.SALARY
FROM EMPLOYEE e1, (SELECT MAX(SALARY) AS m FROM EMPLOYEE) e2
WHERE e1.SALARY = e2.m;

-- 2.) Find employee who earn more than the salary of the manager of the department which name starts with "PLA"
SELECT e.FIRSTNME, e.LASTNAME, e.SALARY, d.DEPTNAME
FROM EMPLOYEE e, DEPARTMENT d
WHERE e.WORKDEPT = d.DEPTNO AND e.SALARY > ALL (
    SELECT SALARY FROM DEPARTMENT dept, EMPLOYEE em
    WHERE dept.MGRNO = em.EMPNO AND dept.DEPTNAME LIKE 'PLA%'
    );

-- Mine
-- SELECT e.FIRSTNME, e.LASTNAME, e.SALARY, d.DEPTNAME
-- FROM EMPLOYEE e, DEPARTMENT d
-- WHERE e.WORKDEPT = d.DEPTNO AND e.SALARY >= (
--     SELECT SALARY FROM DEPARTMENT dept, EMPLOYEE em
--     WHERE dept.MGRNO = em.EMPNO AND em.WORKDEPT = e.WORKDEPT AND dept.DEPTNAME LIKE 'PLA%'
--     );

-- 3.) Show employee who works on every project controlled by deprtment C01
SELECT e.FIRSTNME, e.LASTNAME, pj.PROJNAME
FROM EMPLOYEE e, EMPPROJACT ac, PROJECT pj
WHERE NOT EXISTS(
    SELECT PROJNO FROM PROJECT WHERE DEPTNO = 'C01'
    EXCEPT
    SELECT PROJNO FROM EMPPROJACT act WHERE act.EMPNO = e.EMPNO
    ) AND e.EMPNO = ac.EMPNO AND ac.PROJNO = pj.PROJNO;

-- 4.) Show name of employee who acts for the most number of projects
-- Part 1
SELECT MAX(C) FROM (SELECT EMPNO, COUNT(DISTINCT PROJNO) AS c FROM EMPPROJACT GROUP BY EMPNO) AS ec;

-- Part 2
SELECT FIRSTNME
FROM (SELECT MAX(C) AS mx FROM (SELECT EMPNO, COUNT(DISTINCT PROJNO) AS c FROM EMPPROJACT GROUP BY EMPNO)) AS ec,
     (SELECT FIRSTNME, COUNT(DISTINCT PROJNO) AS c2
     FROM EMPLOYEE, EMPPROJACT
     WHERE EMPLOYEE.EMPNO = EMPPROJACT.EMPNO
     GROUP BY EMPLOYEE.EMPNO, FIRSTNME) AS ec2
WHERE ec2.c2 = ec.mx;

-- 5.) Among employees who earns the most of each department, who has the least salary
SELECT *
FROM EMPLOYEE
WHERE SALARY = (SELECT MIN(d.max) FROM (SELECT MAX(SALARY) as max FROM EMPLOYEE GROUP BY WORKDEPT) AS d);