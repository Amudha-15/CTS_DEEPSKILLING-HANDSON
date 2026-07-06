-- Employee Table SQL Script
-- Execute this in MySQL to create the employee table

CREATE TABLE employee (
    emp_id INT PRIMARY KEY AUTO_INCREMENT,
    emp_name VARCHAR(100) NOT NULL,
    emp_salary DOUBLE,
    emp_designation VARCHAR(50)
);

-- Sample data for testing
INSERT INTO employee (emp_name, emp_salary, emp_designation) VALUES ('John Smith', 50000.00, 'Senior Developer');
INSERT INTO employee (emp_name, emp_salary, emp_designation) VALUES ('Jane Doe', 45000.00, 'Developer');
INSERT INTO employee (emp_name, emp_salary, emp_designation) VALUES ('Mike Johnson', 60000.00, 'Lead Developer');
INSERT INTO employee (emp_name, emp_salary, emp_designation) VALUES ('Sarah Williams', 55000.00, 'Software Architect');

-- View the inserted data
SELECT * FROM employee;
