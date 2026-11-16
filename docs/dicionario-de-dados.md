# Dicionário de Dados — Bubbles

**Versão:** 1.0  
**Banco de dados:** SQLite

## 1. Tabela: jogador

Armazena os dados cadastrais e competitivos dos usuários.

| Campo | Tipo | Restrição | Descrição |
|---|---|---|---|
| id_jogador | INTEGER | PK, AUTOINCREMENT | Identificador único do jogador. |
| nickname | VARCHAR(30) | NOT NULL, UNIQUE | Nome de usuário. |
| senha_hash | VARCHAR(255) | NOT NULL | Hash seguro da senha. |
| email | VARCHAR(150) | Opcional | Endereço eletrônico do jogador. |
| rating | REAL | NOT NULL, DEFAULT 100 | Rating competitivo atual. |
| rd | REAL | NOT NULL, DEFAULT 350 | Desvio de rating utilizado pelo Glicko. |
| data_cadastro | DATETIME | NOT NULL | Data de criação da conta. |
| ultima_atualizacao_rating | DATETIME | Opcional | Data da última atualização do rating. |

## 2. Tabela: partida

Registra as partidas concluídas pelos jogadores.

| Campo | Tipo | Restrição | Descrição |
|---|---|---|---|
| id_partida | INTEGER | PK, AUTOINCREMENT | Identificador único da partida. |
| data_hora | DATETIME | NOT NULL | Data e horário do registro da partida. |

## 3. Tabela: participacao

Relaciona os jogadores às partidas e armazena os resultados individuais.

| Campo | Tipo | Restrição | Descrição |
|---|---|---|---|
| id_participacao | INTEGER | PK, AUTOINCREMENT | Identificador da participação. |
| id_jogador | INTEGER | FK, NOT NULL | Referência ao jogador participante. |
| id_partida | INTEGER | FK, NOT NULL | Referência à partida correspondente. |
| cor_bolha | VARCHAR(20) | NOT NULL | Cor utilizada pelo jogador. |
| resultado | VARCHAR(10) | NOT NULL | Resultado individual: VITORIA, DERROTA ou EMPATE. |
| rating_antes | REAL | NOT NULL | Rating antes da partida. |
| rating_depois | REAL | NOT NULL | Rating depois da partida. |

## 4. Relacionamentos

- Um jogador pode possuir várias participações.
- Uma partida possui exatamente dois participantes quando concluída.
- Cada participação pertence a um único jogador e a uma única partida.
- As chaves estrangeiras garantem a integridade referencial entre as tabelas.

## 5. Restrições de integridade

- O nickname deve ser único.
- Os campos obrigatórios não podem receber valores nulos.
- O mesmo jogador não pode aparecer duas vezes na mesma partida.
- O resultado deve ser VITORIA, DERROTA ou EMPATE.
- Uma partida só pode ser concluída com dois participantes.
- Os valores de rating devem ser atualizados de acordo com as regras do sistema Glicko.

## 6. Índices

Foram previstos índices para os campos de relacionamento `id_jogador` e `id_partida` na tabela `participacao`, facilitando consultas ao histórico de partidas.

## 7. Considerações finais

O dicionário de dados documenta a estrutura prevista para o banco relacional SQLite do Bubbles, servindo como referência para a implementação, manutenção e compreensão dos dados armazenados.
