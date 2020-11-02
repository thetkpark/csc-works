-- Sethanant Pipatpakorn 62130500230
-- Nov 02, 2020

create trigger No_Employee_Younger_than_15
    no cascade before insert
    on EMPLOYEE
    REFERENCING NEW as newEmployee
    for each row mode DB2SQL NOT SECURED
    when ( year(CURRENT_DATE - newEmployee.BIRTHDATE) <= 15 )
    set newEmployee.BIRTHDATE = CURRENT_DATE - 20 years;

INSERT INTO EMPLOYEE
VALUES ('444444', 'Tony', 'M', 'Jackson', 'A00', null, null, 'Dev', 15, 'M', '2010-05-24', 10000, 100, 100);

SELECT * FROM EMPLOYEE WHERE EMPNO = '444444';

SELECT EMPNO, FIRSTNME, BIRTHDATE FROM EMPLOYEE ORDER BY BIRTHDATE DESC;
UPDATE EMPLOYEE SET BIRTHDATE = '2018-07-14' WHERE EMPNO = '000270';

create trigger salary_not_more_than_salary_of_his_manager
    after update of SALARY
    on EMPLOYEE
    referencing NEW as newrecords
    for each row mode db2sql not secured
    when ( newrecords.SALARY > all
            (SELECT M.SALARY FROM EMPLOYEE M JOIN DEPARTMENT D ON D.MGRNO = M.EMPNO
            WHERE newrecords.workdept = D.DEPTNO
            )
        )
    update EMPLOYEE set SALARY = (SELECT SALARY FROM EMPLOYEE WHERE EMPNO = (
        SELECT D.MGRNO FROM EMPLOYEE M JOIN DEPARTMENT D ON D.DEPTNO = M.WORKDEPT
        WHERE newrecords.workdept = D.DEPTNO ORDER BY M.SALARY DESC LIMIT 1
        )) WHERE EMPNO = newrecords.EMPNO;

UPDATE EMPLOYEE SET SALARY = 90000 WHERE EMPNO = '200340';
SELECT e.EMPNO, e.FIRSTNME, e.SALARY, m.EMPNO, m.FIRSTNME, m.SALARY, DEPTNO
FROM EMPLOYEE e, DEPARTMENT d, EMPLOYEE m
WHERE e.WORKDEPT = d.DEPTNO AND d.DEPTNO = m.WORKDEPT AND  e.EMPNO = '200340';

create trigger insert_back_after_deletation
    after delete
    on DEPARTMENT
    referencing OLD as deletedRecord
    for each row
    INSERT INTO DEPARTMENT values (deletedRecord.DEPTNO, deletedRecord.DEPTNAME, deletedRecord.MGRNO, deletedRecord.ADMRDEPT, 'X');


SELECT * FROM DEPARTMENT;
DELETE FROM DEPARTMENT WHERE DEPTNO = 'J22';