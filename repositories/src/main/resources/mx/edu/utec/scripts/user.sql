CREATE TABLE IF NOT EXISTS USER (
    USERNAME VARCHAR(25) PRIMARY KEY,
    PASSWORD VARCHAR(70) NOT NULL,
    ENABLED BIT NOT NULL,
    PERSONAL_ID BIGINT NOT NULL
);
               
INSERT INTO USER (USERNAME, PASSWORD, ENABLED, PERSONAL_ID) VALUES
('jperez@utec.edu.mx', '123456', 1, 2),
('jcruz@utec.edu.mx', '123456', 1, 3),
('jsoto@utec.edu.mx', '123456', 1, 4),
('juribe@utec.edu.mx', '123456', 1, 5),
('jvazquez@utec.edu.mx', '$2a$10$GqqtbEuDi8YXzI1n8Zoqv.Upp61NP/Jy1fvPiMAgtcsyFuwc7N.AK', 1, 1);

CREATE TABLE IF NOT EXISTS USER_ROLE (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    USERNAME VARCHAR(25) NOT NULL,
    ROLE VARCHAR(25) NOT NULL
);

INSERT INTO USER_ROLE (ID, USERNAME, ROLE) VALUES
(1, 'jperez@utec.edu.mx', 'DIRECTOR'),
(6, 'jperez@utec.edu.mx', 'PROFESOR'),
(2, 'jcruz@utec.edu.mx', 'TUTOR'),
(3, 'jvazquez@utec.edu.mx', 'PSICOLOGO'),
(4, 'jsoto@utec.edu.mx', 'PROFESOR'),
(5, 'juribe@utec.edu.mx', 'PSICOLOGO');