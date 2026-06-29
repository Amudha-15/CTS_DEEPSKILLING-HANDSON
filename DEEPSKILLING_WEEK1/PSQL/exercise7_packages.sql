-- Exercise 7: Packages
-- Scenario 1: CustomerManagement package
CREATE OR REPLACE PACKAGE CustomerManagement AS
  PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER);
  PROCEDURE UpdateCustomerName(p_id NUMBER, p_name VARCHAR2);
  FUNCTION GetCustomerBalance(p_id NUMBER) RETURN NUMBER;
END CustomerManagement;
/
CREATE OR REPLACE PACKAGE BODY CustomerManagement AS
  PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER) IS
  BEGIN
    INSERT INTO Customers(CustomerID, Name, DOB, Balance, LastModified)
    VALUES(p_id, p_name, p_dob, p_balance, SYSDATE);
    COMMIT;
  EXCEPTION WHEN DUP_VAL_ON_INDEX THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('CustomerManagement.AddCustomer: Duplicate ID '||p_id);
  END AddCustomer;

  PROCEDURE UpdateCustomerName(p_id NUMBER, p_name VARCHAR2) IS
  BEGIN
    UPDATE Customers SET Name = p_name, LastModified = SYSDATE WHERE CustomerID = p_id;
    COMMIT;
  END UpdateCustomerName;

  FUNCTION GetCustomerBalance(p_id NUMBER) RETURN NUMBER IS
    v_bal NUMBER;
  BEGIN
    SELECT Balance INTO v_bal FROM Customers WHERE CustomerID = p_id;
    RETURN v_bal;
  EXCEPTION WHEN NO_DATA_FOUND THEN
    RETURN NULL;
  END GetCustomerBalance;
END CustomerManagement;
/

-- Scenario 2: EmployeeManagement package
CREATE OR REPLACE PACKAGE EmployeeManagement AS
  PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_position VARCHAR2, p_salary NUMBER, p_department VARCHAR2, p_hiredate DATE);
  PROCEDURE UpdateEmployeeDetails(p_id NUMBER, p_position VARCHAR2, p_salary NUMBER);
  FUNCTION CalculateAnnualSalary(p_id NUMBER) RETURN NUMBER;
END EmployeeManagement;
/
CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS
  PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_position VARCHAR2, p_salary NUMBER, p_department VARCHAR2, p_hiredate DATE) IS
  BEGIN
    INSERT INTO Employees(EmployeeID, Name, Position, Salary, Department, HireDate)
    VALUES(p_id, p_name, p_position, p_salary, p_department, p_hiredate);
    COMMIT;
  EXCEPTION WHEN DUP_VAL_ON_INDEX THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('EmployeeManagement.HireEmployee: Duplicate ID '||p_id);
  END HireEmployee;

  PROCEDURE UpdateEmployeeDetails(p_id NUMBER, p_position VARCHAR2, p_salary NUMBER) IS
  BEGIN
    UPDATE Employees SET Position = p_position, Salary = p_salary WHERE EmployeeID = p_id;
    COMMIT;
  END UpdateEmployeeDetails;

  FUNCTION CalculateAnnualSalary(p_id NUMBER) RETURN NUMBER IS
    v_salary NUMBER;
  BEGIN
    SELECT Salary INTO v_salary FROM Employees WHERE EmployeeID = p_id;
    RETURN v_salary;
  EXCEPTION WHEN NO_DATA_FOUND THEN
    RETURN NULL;
  END CalculateAnnualSalary;
END EmployeeManagement;
/

-- Scenario 3: AccountOperations package
CREATE OR REPLACE PACKAGE AccountOperations AS
  PROCEDURE OpenAccount(p_accountid NUMBER, p_customerid NUMBER, p_accttype VARCHAR2, p_balance NUMBER);
  PROCEDURE CloseAccount(p_accountid NUMBER);
  FUNCTION GetTotalBalance(p_customerid NUMBER) RETURN NUMBER;
END AccountOperations;
/
CREATE OR REPLACE PACKAGE BODY AccountOperations AS
  PROCEDURE OpenAccount(p_accountid NUMBER, p_customerid NUMBER, p_accttype VARCHAR2, p_balance NUMBER) IS
  BEGIN
    INSERT INTO Accounts(AccountID, CustomerID, AccountType, Balance, LastModified)
    VALUES(p_accountid, p_customerid, p_accttype, p_balance, SYSDATE);
    COMMIT;
  EXCEPTION WHEN DUP_VAL_ON_INDEX THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('AccountOperations.OpenAccount: Duplicate AccountID '||p_accountid);
  END OpenAccount;

  PROCEDURE CloseAccount(p_accountid NUMBER) IS
  BEGIN
    DELETE FROM Accounts WHERE AccountID = p_accountid;
    COMMIT;
  END CloseAccount;

  FUNCTION GetTotalBalance(p_customerid NUMBER) RETURN NUMBER IS
    v_total NUMBER;
  BEGIN
    SELECT NVL(SUM(Balance),0) INTO v_total FROM Accounts WHERE CustomerID = p_customerid;
    RETURN v_total;
  END GetTotalBalance;
END AccountOperations;
/
