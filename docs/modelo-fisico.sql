
PRAGMA foreign_keys = ON;

CREATE TABLE IF NOT EXISTS jogador (
    id_jogador INTEGER PRIMARY KEY AUTOINCREMENT,
    nickname VARCHAR(30) NOT NULL UNIQUE,
    senha_hash VARCHAR(255) NOT NULL,
    email VARCHAR(150),
    rating REAL NOT NULL DEFAULT 100,
    rd REAL NOT NULL DEFAULT 350,
    data_cadastro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    ultima_atualizacao_rating DATETIME
);

CREATE TABLE IF NOT EXISTS partida (
    id_partida INTEGER PRIMARY KEY AUTOINCREMENT,
    data_hora DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS participacao (
    id_participacao INTEGER PRIMARY KEY AUTOINCREMENT,
    id_jogador INTEGER NOT NULL,
    id_partida INTEGER NOT NULL,
    cor_bolha VARCHAR(20) NOT NULL,
    resultado VARCHAR(10) NOT NULL,
    rating_antes REAL NOT NULL,
    rating_depois REAL NOT NULL,

    FOREIGN KEY (id_jogador)
        REFERENCES jogador(id_jogador),

    FOREIGN KEY (id_partida)
        REFERENCES partida(id_partida),

    UNIQUE (id_jogador, id_partida),

    CHECK (resultado IN ('VITORIA', 'DERROTA', 'EMPATE'))
);

CREATE INDEX IF NOT EXISTS idx_participacao_jogador
ON participacao(id_jogador);

CREATE INDEX IF NOT EXISTS idx_participacao_partida
ON participacao(id_partida);
