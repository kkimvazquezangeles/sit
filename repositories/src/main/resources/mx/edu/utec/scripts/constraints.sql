ALTER TABLE ALUMNO ADD CONSTRAINT FK8909251 FOREIGN KEY(CARRERA_ID) REFERENCES CARRERA(ID) NOCHECK;
ALTER TABLE PERIODOALUMNO ADD CONSTRAINT FK8909252 FOREIGN KEY(PERIODO_ID) REFERENCES PERIODO(ID) NOCHECK;
ALTER TABLE PERIODOALUMNO ADD CONSTRAINT FK8909253 FOREIGN KEY(ALUMNO_ID) REFERENCES ALUMNO(ID) NOCHECK;
ALTER TABLE PERIODOALUMNO ADD CONSTRAINT FK8909254 FOREIGN KEY(GRADO_ID) REFERENCES GRADO(ID) NOCHECK;
ALTER TABLE PERIODOALUMNO ADD CONSTRAINT FK8909255 FOREIGN KEY(GRUPO_ID) REFERENCES GRUPO(ID) NOCHECK;
ALTER TABLE PERIODOPERSONAL ADD CONSTRAINT FK8909256 FOREIGN KEY(PERIODO_ID) REFERENCES PERIODO(ID) NOCHECK;
ALTER TABLE PERIODOPERSONAL ADD CONSTRAINT FK8909257 FOREIGN KEY(PERSONAL_ID) REFERENCES PERSONAL(ID) NOCHECK;
ALTER TABLE PERIODOPERSONAL ADD CONSTRAINT FK8909258 FOREIGN KEY(CARRERA_ID) REFERENCES CARRERA(ID) NOCHECK;
ALTER TABLE TUTORIA ADD CONSTRAINT FK8909259 FOREIGN KEY(PERIODO_ALUMNO_ID) REFERENCES PERIODOALUMNO(ID) NOCHECK;
ALTER TABLE TUTORIA ADD CONSTRAINT FK89092510 FOREIGN KEY(PERIODO_ALUMNO_ID) REFERENCES PERIODOALUMNO(ID) NOCHECK;
ALTER TABLE TUTORIA ADD CONSTRAINT FK89092511 FOREIGN KEY(CANALIZADOR_ID) REFERENCES PERSONAL(ID) NOCHECK;
ALTER TABLE TUTORIADETALLE ADD CONSTRAINT FK89092512 FOREIGN KEY(TUTORIA_ID) REFERENCES TUTORIA(ID) NOCHECK;
ALTER TABLE TUTORIADETALLE ADD CONSTRAINT FK89092513 FOREIGN KEY(REGISTRADO_POR_ID) REFERENCES PERSONAL(ID) NOCHECK;
