CREATE TABLE IF NOT EXISTS CUATRIMESTREMATERIA(
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    PERIODO_PERSONAL_ID BIGINT NOT NULL,
    CUATRIMESTRE_ID BIGINT NOT NULL,
    GRUPO_ID BIGINT NOT NULL,
    MATERIA_ID BIGINT NOT NULL,
    CARRERA_ID BIGINT NOT NULL
);

INSERT INTO CUATRIMESTREMATERIA(ID, PERIODO_PERSONAL_ID, CUATRIMESTRE_ID, GRUPO_ID, MATERIA_ID, CARRERA_ID)VALUES
                                (1, 2,                   1,               1,        1,          1),
                                (2, 2,                   1,               2,        1,          1),
                                (3, 2,                   2,               1,        2,          1),
                                (4, 3,                   4,               5,        3,          1);

