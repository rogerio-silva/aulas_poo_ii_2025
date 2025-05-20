CREATE SEQUENCE pessoa_id_seq
  INCREMENT BY 1
  START WITH 1;

CREATE TABLE pessoas (
    id BIGINT NOT NULL DEFAULT nextval('pessoa_id_seq'),
    nome VARCHAR(255) NOT NULL,
    idade INT NOT NULL,
    cpf VARCHAR(14)  NOT NULL,
    telefone VARCHAR(15) NOT NULL,
    email VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);
