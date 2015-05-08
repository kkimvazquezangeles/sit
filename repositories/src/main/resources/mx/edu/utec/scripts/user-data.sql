INSERT INTO USER (USERNAME, PASSWORD, ENABLED, PERSONAL_ID) VALUES
('k2509o@hotmail.com', '123456', 1, 1),
('betotsol@gmail.com', '123456', 1, 3),
('jsoto@utec.edu.mx', '123456', 1, 4),
('juribe@utec.edu.mx', '123456', 1, 5),
('jvazquez@utec.edu.mx', '123456', 1, 2);
--$2a$10$GqqtbEuDi8YXzI1n8Zoqv.Upp61NP/Jy1fvPiMAgtcsyFuwc7N.AK

INSERT INTO USER_ROLE (ID, USERNAME, ROLE) VALUES
(1, 'k2509o@hotmail.com', 'DIRECTOR'),
(6, 'betotsol@gmail.com', 'PROFESOR'),
(2, 'betotsol@gmail.com', 'TUTOR'),
(3, 'jvazquez@utec.edu.mx', 'PROFESOR'),
(4, 'jsoto@utec.edu.mx', 'PROFESOR'),
(5, 'juribe@utec.edu.mx', 'PSICOLOGO');