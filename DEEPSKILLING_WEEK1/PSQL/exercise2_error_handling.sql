-- Exercise 2: Error Handling
-- Scenario 1: SafeTransferFunds
CREATE OR REPLACE PROCEDURE SafeTransferFunds(
  p_from_acct IN NUMBER,
  p_to_acct   IN NUMBER,
  p_amount    IN NUMBER
) IS
  v_balance NUMBER;
BEGIN
  SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_from_acct FOR UPDATE;

  IF v_balance < p_amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in source account');
  END IF;

  UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_from_acct;
  UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_to_acct;

  COMMIT;
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('SafeTransferFunds FAILED: ' || SQLERRM);
    RAISE;
END SafeTransferFunds;
/

-- Scenario 2: UpdateSalary
CREATE OR REPLACE PROCEDURE UpdateSalary(
  p_employee_id IN NUMBER,
  p_pct_increase IN NUMBER
) IS
  v_exists NUMBER;
BEGIN
  SELECT COUNT(*) INTO v_exists FROM Employees WHERE EmployeeID = p_employee_id;
  IF v_exists = 0 THEN
    DBMS_OUTPUT.PUT_LINE('UpdateSalary ERROR: Employee ID '||p_employee_id||' does not exist.');
    RETURN;
  END IF;

  UPDATE Employees
  SET Salary = Salary * (1 + p_pct_increase/100)
  WHERE EmployeeID = p_employee_id;

  COMMIT;
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('UpdateSalary FAILED: '||SQLERRM);
    RAISE;
END UpdateSalary;
/

-- Scenario 3: AddNewCustomer
CREATE OR REPLACE PROCEDURE AddNewCustomer(
  p_id      IN NUMBER,
  p_name    IN VARCHAR2,
  p_dob     IN DATE,
  p_balance IN NUMBER
) IS
BEGIN
  INSERT INTO Customers(CustomerID, Name, DOB, Balance, LastModified)
  VALUES(p_id, p_name, p_dob, p_balance, SYSDATE);
  COMMIT;
EXCEPTION
  WHEN DUP_VAL_ON_INDEX THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('AddNewCustomer ERROR: Customer with ID '||p_id||' already exists.');
  WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('AddNewCustomer FAILED: '||SQLERRM);
    RAISE;
END AddNewCustomer;
/
