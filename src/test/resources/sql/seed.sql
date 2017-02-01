use rideshare_test;

set FOREIGN_KEY_CHECKS = 0;
truncate table drivers;
truncate table cars;
truncate table passengers;
truncate table cities;
set FOREIGN_KEY_CHECKS = 1;

INSERT INTO cities (name , state, day_rate, night_rate) VALUES
  ('Bangalore','Karnataka',25,50),
  ('indraprastha','delhi',40,80),
  ('indraprastha3','delshi',40,80),
  ('indraprastha4','delh5i',40,80),
  ('indraprastha5','del5whi',40,80);

INSERT INTO drivers (name , age, gender,tickets ,city_id) VALUES
  ('BOB', 23, 'MALE', 0,1),
  ('BOB1', 24, 'MALE', 0,2),
  ('BOB2', 25, 'MALE', 0,3),
  ('SARA', 26, 'FEMALE', 0,4);

INSERT INTO cars (make , model, year, type) VALUES
('Ferrari', 'F30 Spider', 2013, 'LUX'),
('Skoda', 'Laura', 2010, 'BASIC'),
('BMW', 'M3', 2005, 'BASIC'),
('Hindustan Motors', 'Ambassador', 2002, 'LUX');


INSERT INTO passengers (age , name, gender, credit_balance) VALUES
  (22,'Brian','MALE',12300),
  (23,'Brian2','MALE',12300),
  (24,'Brian3','MALE',12300);


