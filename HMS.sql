DROP DATABASE IF EXISTS Hospital;
CREATE DATABASE Hospital;
USE Hospital;

--
-- Table structure for table `Users`
--

DROP TABLE IF EXISTS `Admins`;
CREATE TABLE `Admins` (
  `id` INT(11) NOT NULL auto_increment,
  `firstname` VARCHAR(50) NOT NULL default '',
  `lastname` VARCHAR(50) NOT NULL default '',
   `username` VARCHAR(50) NOT NULL default '',
  `password` VARCHAR(50) NOT NULL default '',
  `email` VARCHAR(50) NOT NULL default '',
  `position` VARCHAR(50) NOT NULL default '',
  `telephone` VARCHAR(50) NOT NULL default '',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;


INSERT INTO `Admins` VALUES ("0","Teric","Simons","Teric123","admin123","tericsimons12@gmail.com","Receptionist","876-891-0011");


DROP TABLE IF EXISTS `Patients`;
CREATE TABLE `Patients` (
  `id` INT(11) NOT NULL auto_increment,
  `name` VARCHAR(50) NOT NULL default '',
  `occupation` VARCHAR(50) NOT NULL default '',
  `email` VARCHAR(50) NOT NULL default '',
  `gender` VARCHAR(50) NOT NULL default '',
  `telephone` VARCHAR(50) NOT NULL default '',
  `symptoms` VARCHAR(100) NOT NULL default '',
  `blood` VARCHAR(50) NOT NULL default '',
  `address` VARCHAR(100) NOT NULL default '',
  `doctor_seen` VARCHAR(50) NOT NULL default '',
  `amount_paid` VARCHAR(50) NOT NULL default '',
  `app_date` VARCHAR(50) NOT NULL default '',
`Receptionist` VARCHAR(50) NOT NULL default '',
`Doctor Remarks` VARCHAR(50) NOT NULL default '',
`Medications` VARCHAR(50) NOT NULL default '',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;
INSERT INTO Patients (name, occupation, email, gender, telephone, symptoms, blood, address, doctor_seen, amount_paid, app_date, Receptionist)
VALUES 
('John Smith', 'Engineer', 'john.smith@example.com', 'Male', '+1 (555) 123-4567', 'Fever, Headache', 'A+', '123 Main St, Anytown USA', 'MR. HART', 100.00, '2023-04-10', 'Ms. Claire'),
('Jane Doe', 'Teacher', 'jane.doe@example.com', 'Female', '+1 (555) 987-6543', 'Cough, Fatigue', 'B-', '456 Elm St, Anytown USA', 'MR. DOUGLAS', 150.00, '2023-04-12', 'Ms. Lily'),
('Bob Johnson', 'Accountant', 'bob.johnson@example.com', 'Male', '+1 (555) 555-5555', 'Sore Throat', 'O+', '789 Oak St, Anytown USA', 'MR. HART', 75.00, '2023-04-15', 'Ms. Claire'),
('Alice Green', 'Nurse', 'alice.green@example.com', 'Female', '+1 (555) 222-3333', 'Chest Pain', 'AB+', '567 Pine St, Anytown USA', 'MR. DOUGLAS', 200.00, '2023-04-17', 'Ms. Lily'),
('David Lee', 'Lawyer', 'david.lee@example.com', 'Male', '+1 (555) 444-4444', 'Shortness of Breath', 'A-', '890 Maple St, Anytown USA', 'MR. HART', 125.00, '2023-04-20', 'Ms. Lily'),
('Samantha White', 'Journalist', 'samantha.white@example.com', 'Female', '+1 (555) 555-1212', 'Dizziness', 'O-', '123 Cedar St, Anytown USA', 'MR. DOUGLAS', 175.00, '2023-04-22', 'Ms. Claire'),
('Frank Brown', 'Electrician', 'frank.brown@example.com', 'Male', '+1 (555) 123-4567', 'Nausea', 'B+', '456 Birch St, Anytown USA', 'MR. HART', 100.00, '2023-04-25', 'Ms. Lily'),
('Emily Taylor', 'Graphic Designer', 'emily.taylor@example.com', 'Female', '+1 (555) 987-6543', 'Joint Pain', 'A+', '789 Willow St, Anytown USA', 'MR. DOUGLAS', 150.00, '2023-04-27', 'Ms. Lily'),
('Max Wilson', 'Software Developer', 'max.wilson@example.com', 'Male', '+1 (555) 555-5555', 'Rash', 'O-', '567 Oak St, Anytown USA', 'MR. DOUGLAS', 75.00, '2023-04-30', 'Ms. Lily'),
('Sophie Clark', 'Marketing Manager', 'sophie.clark@example.com', 'Female', '+1 (555) 222-3333', 'Fever', 'AB+', '890 Pine St, Anytown USA', 'MR. DOUGLAS', 200.00, '2023-05-02', 'Ms. Claire');


DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `name` VARCHAR(50) NOT NULL default '',
  `email` VARCHAR(50) NOT NULL default '',
  `feedback` VARCHAR(100) NOT NULL default ''
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `equipments`;
CREATE TABLE `equipments` (
`ID` INT(11) NOT NULL auto_increment,
  `name` VARCHAR(50),
  `quantity` int,
  `price` double,
  `latest` VARCHAR(100),
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

INSERT INTO equipments (name, quantity, price, latest)
VALUES 
('ECG Machine', 5, 2500.00, '2023-04-15'),
('X-Ray Machine', 2, 7500.00, '2023-04-20'),
('Ultrasound Machine', 3, 5000.00, '2023-04-13'),
('Defibrillator', 8, 3000.00, '2023-04-18'),
('Patient Monitor', 10, 1500.00, '2023-04-14'),
('Ventilator', 6, 8000.00, '2023-04-21'),
('Infusion Pump', 15, 500.00, '2023-04-16'),
('Oxygen Concentrator', 20, 1000.00, '2023-04-12'),
('Anesthesia Machine', 7, 7000.00, '2023-04-19'),
('Autoclave', 4, 2000.00, '2023-04-22'),
('Blood Gas Analyzer', 3, 5000.00, '2023-04-17'),
('Surgical Instruments', 12, 150.00, '2023-04-24'),
('Syringe Pump', 9, 750.00, '2023-04-11'),
('Glucometer', 11, 50.00, '2023-04-23'),
('Wheelchair', 14, 500.00, '2023-04-13'),
('Crutches', 16, 100.00, '2023-04-26'),
('Stretcher', 1, 1500.00, '2023-04-14'),
('Thermometer', 19, 20.00, '2023-04-28'),
('Gown', 20, 10.00, '2023-04-15'),
('Mask', 18, 5.00, '2023-04-30');