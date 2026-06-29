-- Exercise 1: Control Structures
-- Scenario 1: Apply 1% discount to loan interest rates for customers older than 60
BEGIN
  DECLARE
    v_age PLS_INTEGER;
  BEGIN
    FOR c IN (SELECT CustomerID, DOB FROM Customers) LOOP
      v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, c.DOB) / 12);
      IF v_age > 60 THEN
        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE CustomerID = c.CustomerID;
      END IF;
    END LOOP;
    COMMIT;
  END;
END;
/

-- Scenario 2: Set IsVIP to 'Y' for customers with Balance > 10000
BEGIN
  DECLARE
    v_exists NUMBER;
  BEGIN
    SELECT COUNT(*) INTO v_exists
    FROM USER_TAB_COLS
    WHERE TABLE_NAME = 'CUSTOMERS' AND COLUMN_NAME = 'ISVIP';

    IF v_exists = 0 THEN
      EXECUTE IMMEDIATE 'ALTER TABLE Customers ADD (IsVIP CHAR(1) DEFAULT ''N'')';
    END IF;

    UPDATE Customers
    SET IsVIP = 'Y'
    WHERE Balance > 10000;

    UPDATE Customers
    SET IsVIP = 'N'
    WHERE Balance <= 10000;

    COMMIT;
  END;
END;
/

-- Scenario 3: Print reminders for loans due within next 30 days
BEGIN
  FOR r IN (
    SELECT l.LoanID, l.CustomerID, c.Name, l.EndDate, l.LoanAmount
    FROM Loans l
    JOIN Customers c ON l.CustomerID = c.CustomerID
    WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ORDER BY l.EndDate
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || r.Name ||
      ' (ID=' || r.CustomerID || ') has Loan ' || r.LoanID ||
      ' due on ' || TO_CHAR(r.EndDate,'YYYY-MM-DD') ||
      ' — Amount: ' || r.LoanAmount);
  END LOOP;
END;
/
