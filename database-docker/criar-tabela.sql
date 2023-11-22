-- Tabela Zoológico
CREATE TABLE Zoologico (
    ID_Zoologico bigserial PRIMARY KEY,
    Nome VARCHAR(50) NOT NULL,
    Localizacao VARCHAR(50),
    Capacidade INT
);

-- Tabela Animal
CREATE TABLE Animal (
    ID_Animal bigserial PRIMARY KEY,
    Nome VARCHAR(50) NOT NULL,
    Especie VARCHAR(50) NOT NULL,
    Idade INT,
    Peso DECIMAL(5,2),
    Informacoes_Adicionais TEXT,
    ID_Zoologico INT,
    FOREIGN KEY (ID_Zoologico) REFERENCES Zoologico(ID_Zoologico)
);
