-- Exercise 3: Stored Procedures
-- Scenario 1: ProcessMonthlyInterest
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
  UPDATE Accounts
  SET Balance = Balance * 1.01
  WHERE UPPER(AccountType) = 'SAVINGS';
  COMMIT;
EXCEPTION WHEN OTHERS THEN
  ROLLBACK;
  DBMS_OUTPUT.PUT_LINE('ProcessMonthlyInterest FAILED: '||SQLERRM);
  RAISE;
END ProcessMonthlyInterest;
/

-- Scenario 2: UpdateEmployeeBonus
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
  p_department IN VARCHAR2,
  p_bonus_pct  IN NUMBER
) IS
BEGIN
  UPDATE Employees
  SET Salary = Salary * (1 + p_bonus_pct/100)
  WHERE Department = p_department;
  COMMIT;
EXCEPTION WHEN OTHERS THEN
  ROLLBACK;
  DBMS_OUTPUT.PUT_LINE('UpdateEmployeeBonus FAILED: '||SQLERRM);
  RAISE;
END UpdateEmployeeBonus;
/

-- Scenario 3: TransferFunds
CREATE OR REPLACE PROCEDURE TransferFunds(
  p_from IN NUMBER,
  p_to   IN NUMBER,
  p_amt  IN NUMBER
) IS
  v_balance NUMBER;
BEGIN
  SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_from FOR UPDATE;
  IF v_balance < p_amt THEN
    RAISE_APPLICATION_ERROR(-20002,'Not enough balance to transfer');
  END IF;

  UPDATE Accounts SET Balance = Balance - p_amt WHERE AccountID = p_from;
  UPDATE Accounts SET Balance = Balance + p_amt WHERE AccountID = p_to;

  COMMIT;
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('TransferFunds FAILED: '||SQLERRM);
    RAISE;
END TransferFunds;
/
