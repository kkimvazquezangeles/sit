CREATE TABLE IF NOT EXISTS PERSONAL(
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    NOMBRE VARCHAR(50) NOT NULL,
    APELLIDO_PATERNO VARCHAR(50) NOT NULL,
    APELLIDO_MATERNO VARCHAR(50) NOT NULL
);

INSERT INTO PERSONAL(ID, NOMBRE, APELLIDO_PATERNO, APELLIDO_MATERNO) VALUES
(1, 'GAMALIEL', 'VAZQUEZ', 'ZUÑIGA'),
(2, 'JORGE', 'PEREZ', 'PEREZ'),
(3, 'JUAN', 'CRUZ', 'CRUZ');