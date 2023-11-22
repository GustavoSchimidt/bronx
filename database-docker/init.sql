CREATE DATABASE bronx;

CREATE TABLE zoologico (
    id_zoologico bigserial PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    localizacao VARCHAR(50),
    capacidade INT
);

CREATE TABLE animal (
    id_animal bigserial PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    especie VARCHAR(50) NOT NULL,
    idade INT,
    peso DECIMAL(5,2),
    localizacao VARCHAR(50),
    informacoes_adicionais TEXT,
    id_zoologico INT,
    FOREIGN KEY (id_zoologico) REFERENCES zoologico(id_zoologico)
);
