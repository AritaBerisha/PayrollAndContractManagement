drop database if exists WagesAndContractsManagmentDB;
create database WagesAndContractsManagmentDB;
use WagesAndContractsManagmentDB;

CREATE TABLE Employees (
    Employee_id INTEGER,
    Employee_name VARCHAR(20),
    Employee_surname VARCHAR(20),
    Employee_date_of_birth DATE,
    Employee_date_of_hire DATE,
    Employee_phone_number VARCHAR(15),
    Employee_email VARCHAR(30),
    Employee_address VARCHAR(30),
    Employee_qualifications VARCHAR(100),
    Hours_worked TIME,
    Days_worked INTEGER,
    PRIMARY KEY (Employee_id)
);

CREATE TABLE Positions (
    Position_id INTEGER,
    Position_title VARCHAR(30),
    Position_description VARCHAR(100),
    job_location VARCHAR(30),
    hour_rate TIME,
    Employee_brutto_salary REAL,
    PRIMARY KEY (Position_id)
);

CREATE TABLE Contracts (
    Contract_id INTEGER,
    Employee_id INTEGER,
    Position_id INTEGER,
    Contract_date_begin DATE,
    Contract_date_due DATE,
    Vacation_days INTEGER,
    PRIMARY KEY (Contract_id),
    FOREIGN KEY (Employee_id)
        REFERENCES Employees (Employee_id),
    FOREIGN KEY (Position_id)
        REFERENCES Positions (Position_id)
);

CREATE TABLE Payment_Frequency (
    Payment_frequency_id INTEGER,
    Frequency_description VARCHAR(10),
    PRIMARY KEY (Payment_frequency_id)
);

CREATE TABLE Payment (
    Payment_id INTEGER,
    Contract_id INTEGER,
    Payment_period DATE,
    Payment_date DATE,
    Employee_netto_salary REAL,
    Payment_frequency_id INTEGER,
    PRIMARY KEY (Payment_id),
    FOREIGN KEY (Contract_id)
        REFERENCES Contracts (Contract_id),
    FOREIGN KEY (Payment_frequency_id)
        REFERENCES Payment_Frequency (Payment_frequency_id)
);

CREATE TABLE Payment_Deduction (
    Payment_id INTEGER,
    Tax_amount REAL,
    Superannuation_fund BOOLEAN,
    FOREIGN KEY (Payment_id)
        REFERENCES Payment (Payment_id)
);

CREATE TABLE Payment_Bonus (
    Payment_id INTEGER,
    Bonus_amount REAL,
    FOREIGN KEY (Payment_id)
        REFERENCES Payment (Payment_id)
);







