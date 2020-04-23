DROP TABLE IF EXISTS cliente;

create table cliente(
    id_cliente BEGIN AUTO_INCREMENT NOT NULL,
    nome VARCHAR(155) NULL,
    renda DOUBLE NULL,
    PRIMERY KEY (id_cliente));
)