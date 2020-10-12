Sethanant Pipatpakorn 62130500230

Oct 9, 2020

1.) 

```sql
SELECT employee.name, COUNT(*) as num
FROM work-on, employee
WHERE work-on.empno = employee.empno, num >= 4
GROUP BY work-on.empno, employee.name
ORDER BY num DESC
```

2.)

```sql
SELECT name
FROM Project
WHERE name NOT IN (SELECT DISTINCT projid FROM work-on) AND YEAR(startdate) = 2020
```

3.) 

```sql
SELECT e.name, 'Normal' as Level
FROM employee e, department d 
WHERE e.deptno = d.deptno AND d.deptname = 'Financial' AND e.salary BETWEEN 15000 AND 40000
UNION
SELECT e.name, 'High' as Level
FROM employee e, department d 
WHERE e.deptno = d.deptno AND d.deptname = 'Financial' AND e.salary BETWEEN 40001 AND 80000
UNION
SELECT e.name, 'Very High' as Level
FROM employee e, department d 
WHERE e.deptno = d.deptno AND d.deptname = 'Financial' AND e.salary > 80000
```

4.)

```sql
SELECT e.name, e.salary, d.deptname
FROM employee e, department d
WHERE e.deptno = d.deptno, e.salary > (SELECT salary FROM employee e, department d WHERE e.deptno = d.deptno AND d.deptname = 'Financial' ORDER BY salary DESC LIMIT 1) 
```

5.)

```sql
SELECT e.name, e.salary, d.deptname
FROM employee e, department d
WHERE e.deptno = d.deptno, e.salary > (SELECT salary FROM employee e, department d WHERE e.deptno = d.deptno AND d.deptname = 'Financial' ORDER BY salary LIMIT 1)
```

