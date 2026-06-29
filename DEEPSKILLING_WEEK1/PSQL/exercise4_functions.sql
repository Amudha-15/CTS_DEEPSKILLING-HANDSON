-- Exercise 4: Functions
-- Scenario 1: CalculateAge
CREATE OR REPLACE FUNCTION CalculateAge(p_dob DATE) RETURN NUMBER IS
BEGIN
  RETURN FLOOR(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
END CalculateAge;
/

-- Scenario 2: CalculateMonthlyInstallment
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
  p_principal     IN NUMBER,
  p_annual_rate   IN NUMBER,
  p_duration_years IN NUMBER
) RETURN NUMBER IS
  v_r NUMBER;
  v_n NUMBER;
  v_payment NUMBER;
BEGIN
  IF p_principal <= 0 OR p_annual_rate <= 0 OR p_duration_years <= 0 THEN
    RETURN 0;
  END IF;

  v_r := p_annual_rate / 100 / 12;
  v_n := p_duration_years * 12;

  v_payment := p_principal * v_r / (1 - POWER(1 + v_r, -v_n));
  RETURN v_payment;
END CalculateMonthlyInstallment;
/

-- Scenario 3: HasSufficientBalance
CREATE OR REPLACE FUNCTION HasSufficientBalance(
  p_account_id IN NUMBER,
  p_amount     IN NUMBER
) RETURN BOOLEAN IS
  v_balance NUMBER;
BEGIN
  SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_account_id;
  RETURN v_balance >= p_amount;
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    RETURN FALSE;
  WHEN OTHERS THEN
    RETURN FALSE;
END HasSufficientBalance;
/
