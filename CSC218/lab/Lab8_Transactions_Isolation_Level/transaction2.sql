-- 1.) Read uncommitted -> Uncommitted Read (UR) -> Lost Update
-- Example 1
SET CURRENT ISOLATION UR;
COMMIT;
-- It prevent this statement to update because of the uncommited transaction (T1)
-- It's a lock mechanism
UPDATE EMPLOYEE SET SALARY = 50000 WHERE EMPNO = '000020';
SELECT FIRSTNME, LASTNAME, SALARY FROM EMPLOYEE WHERE EMPNO = '000020';

UPDATE EMPLOYEE SET SALARY = 30000 WHERE EMPNO = '000020';
COMMIT;
SELECT FIRSTNME, LASTNAME, SALARY FROM EMPLOYEE WHERE EMPNO = '000020';

-- Example 1.1
SET CURRENT ISOLATION UR;
COMMIT;

UPDATE EMPLOYEE SET SALARY = 70000 WHERE EMPNO = '000020';
SELECT FIRSTNME, LASTNAME, SALARY FROM EMPLOYEE WHERE EMPNO = '000020';
COMMIT;


-- 2.) Read committed -> Cursor Stability (CS) -> Dirty Read
-- Example 2
SET CURRENT ISOLATION CS;
COMMIT;
-- See the old states of the records (New value is not committed yet)
SELECT FIRSTNME, LASTNAME, SALARY FROM EMPLOYEE WHERE EMPNO IN ('000030', '000020');


-- 3.) Repeatable read -> Read Stability (RS) -> Incorrect Sum
-- Example 3
SELECT FIRSTNME, LASTNAME, SALARY FROM EMPLOYEE WHERE EMPNO IN ('000030', '000020');

SET CURRENT ISOLATION RS;
COMMIT;
-- Below statement is not allow because two records in T1 is lock due to the SELECT statement in T1
UPDATE EMPLOYEE SET SALARY = 80000 WHERE EMPNO = '000020';
COMMIT;

UPDATE EMPLOYEE SET SALARY = 22000 WHERE EMPNO = '000040';
ROLLBACK;


-- 4.) Serializable -> Repeatable Read (RR) -> Phantom Read
-- Example 4
SET CURRENT ISOLATION RR;
COMMIT;
-- Not run because in T1, SELECT statement which involve all record with FIRSTNAME of 's%' is not committed yet
-- Prevent Phantom Read or insertion or update that affect the previous SELECT statement on another transaction.
UPDATE EMPLOYEE SET FIRSTNME = 'SOMSAK' WHERE EMPNO = '000020';
COMMIT;

-- Example 4.2 DELETE
-- Problem of level 3. This statement is blocked by level 3 not 4
-- Higher isolation level implied the functionality of the lower isolation level
DELETE FROM EMPLOYEE WHERE EMPNO = '000020';
ROLLBACK;

-- Example 4.3
SELECT * FROM EMPLOYEE WHERE FIRSTNME LIKE  'S%';
COMMIT;