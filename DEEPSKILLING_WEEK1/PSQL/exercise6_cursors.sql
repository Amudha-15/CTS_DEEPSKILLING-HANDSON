-- Exercise 6: Cursors
-- Scenario 1: GenerateMonthlyStatements (explicit cursor)
DECLARE
  CURSOR c_tx IS
    SELECT t.TransactionID, t.AccountID, t.TransactionDate, t.Amount, t.TransactionType, a.CustomerID, c.Name
    FROM Transactions t
    JOIN Accounts a ON t.AccountID = a.AccountID
    JOIN Customers c ON a.CustomerID = c.CustomerID
    WHERE TRUNC(t.TransactionDate,'MM') = TRUNC(SYSDATE,'MM')
    ORDER BY a.CustomerID, t.TransactionDate;
BEGIN
  FOR r IN c_tx LOOP
    DBMS_OUTPUT.PUT_LINE('Customer: ' || r.Name || ' (ID='||r.CustomerID||')'
      || ' | Account: ' || r.AccountID
      || ' | Date: ' || TO_CHAR(r.TransactionDate,'YYYY-MM-DD')
      || ' | ' || r.TransactionType || ' | Amount: ' || r.Amount);
  END LOOP;
END;
/

-- Scenario 2: ApplyAnnualFee (explicit cursor)
DECLARE
  CURSOR c_accts IS SELECT AccountID, Balance FROM Accounts FOR UPDATE;
  v_fee NUMBER := 100; -- annual fee amount
BEGIN
  FOR a IN c_accts LOOP
    UPDATE Accounts
    SET Balance = Balance - v_fee, LastModified = SYSDATE
    WHERE AccountID = a.AccountID;
  END LOOP;
  COMMIT;
END;
/

-- Scenario 3: UpdateLoanInterestRates (explicit cursor)
DECLARE
  CURSOR c_loans IS SELECT LoanID, LoanAmount, InterestRate FROM Loans FOR UPDATE;
BEGIN
  FOR l IN c_loans LOOP
    IF l.LoanAmount > 10000 THEN
      UPDATE Loans SET InterestRate = InterestRate - 0.5 WHERE LoanID = l.LoanID;
    ELSE
      UPDATE Loans SET InterestRate = InterestRate - 0.25 WHERE LoanID = l.LoanID;
    END IF;
  END LOOP;
  COMMIT;
END;
/
