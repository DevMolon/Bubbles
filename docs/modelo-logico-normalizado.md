# Modelo Lógico Normalizado — Bubbles

**Versão:** 1.0

O banco de dados do sistema Bubbles foi estruturado seguindo os princípios de normalização relacional até a Terceira Forma Normal (3FN), visando reduzir redundâncias, preservar a integridade dos dados e facilitar a manutenção.

## Primeira Forma Normal (1FN)

Todas as tabelas possuem chaves primárias e atributos com valores atômicos, sem campos contendo listas ou conjuntos de informações.

## Segunda Forma Normal (2FN)

Os atributos de cada tabela dependem integralmente de suas respectivas chaves primárias. As informações dos jogadores, partidas e participações foram separadas em entidades próprias.

## Terceira Forma Normal (3FN)

Os atributos não-chave dependem diretamente das chaves primárias, sem dependências transitivas entre atributos não-chave.

O rating atual e o desvio de rating ficam associados ao jogador. Os valores anteriores e posteriores ao confronto ficam registrados em cada participação, preservando o histórico competitivo.

## Tabelas normalizadas

- **JOGADOR:** armazena os dados cadastrais e competitivos dos usuários.
- **PARTIDA:** armazena a identificação e a data de cada partida.
- **PARTICIPACAO:** relaciona jogadores e partidas, registrando cores, resultados e ratings históricos.

## Integridade referencial

A tabela PARTICIPACAO possui chaves estrangeiras que referenciam JOGADOR e PARTIDA. Também será aplicada uma restrição de unicidade para impedir que o mesmo jogador seja registrado duas vezes na mesma partida.

A aplicação deverá validar a presença de exatamente dois participantes antes de concluir uma partida.

## Conclusão

A estrutura proposta atende aos princípios da normalização relacional até a 3FN, considerando as dependências funcionais definidas para o projeto. Ela servirá de base para a implementação física no SQLite.
