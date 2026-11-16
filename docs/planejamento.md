# BUBBLES
## Planejamento do Projeto

**Versão:** 0.4  
**Projeto:** Bubbles — Jogo da Velha com Sistema Competitivo  
**Curso:** Engenharia de Software — PIT II  
**Status:** Planejamento revisado para desenvolvimento do MVP

---

# 1. Objetivo do projeto

O projeto Bubbles tem como objetivo desenvolver uma aplicação web de jogo da velha, com identidade visual fofa, colorida e divertida, permitindo partidas entre dois jogadores no mesmo dispositivo.

A aplicação contará com cadastro e autenticação de usuários, perfil individual, registro persistente das partidas, sistema de rating competitivo e classificação global.

O desenvolvimento priorizará uma solução funcional, simples e organizada, contemplando os requisitos técnicos e acadêmicos estabelecidos para o PIT II.

# 2. Escopo do projeto

A versão inicial contemplará:

- Cadastro e autenticação de jogadores.
- Perfil básico com nickname, rating e liga.
- Jogo da velha com tabuleiro 3×3 e peças em formato de bolhas coloridas.
- Partidas entre dois jogadores no mesmo dispositivo.
- Identificação automática de vitórias e empates.
- Registro persistente das partidas.
- Sistema de rating baseado no Glicko original.
- Classificação global dos jogadores.
- Interface web adaptável a computadores e dispositivos Android.

As funcionalidades serão desenvolvidas considerando a simplicidade de utilização e a integridade dos dados.

# 3. Tecnologias previstas

| Componente | Tecnologia |
|---|---|
| Linguagem do back-end | Java |
| Framework | Spring Boot |
| Arquitetura | MVC |
| Front-end | HTML, CSS e JavaScript |
| Interface e templates | Thymeleaf |
| Persistência | Spring Data JPA |
| Banco de dados | SQLite |
| Testes automatizados | JUnit |
| Controle de versão | Git e GitHub |

As tecnologias escolhidas permitem desenvolver uma aplicação organizada, com separação de responsabilidades e persistência relacional.

# 4. Arquitetura do sistema

O sistema utilizará o padrão arquitetural MVC, organizado em três componentes principais:

**Model:** responsável pelas entidades, regras de negócio e persistência dos dados, incluindo jogadores, partidas, participações e ratings.

**View:** responsável pela apresentação das telas, menus, tabuleiro, mensagens e demais elementos da interface.

**Controller:** responsável por receber requisições, validar informações e coordenar as operações entre a interface e as regras de negócio.

A arquitetura deverá facilitar a manutenção, os testes e futuras ampliações.

# 5. Planejamento das etapas de desenvolvimento

## Etapa 1 — Revisão e definição do escopo

- Revisar o projeto inicialmente planejado.
- Simplificar os requisitos funcionais e não funcionais.
- Definir as funcionalidades obrigatórias do MVP.
- Registrar as funcionalidades adiadas para versões futuras.

## Etapa 2 — Modelagem e documentação

- Elaborar o diagrama de classes UML.
- Elaborar o diagrama de casos de uso.
- Elaborar os diagramas de sequência e atividades.
- Desenvolver o modelo conceitual do banco de dados.
- Desenvolver o modelo lógico normalizado.
- Elaborar o diagrama de classes de persistência.
- Criar o dicionário de dados.
- Definir as telas, navegação e elementos de IHC.
- Elaborar o protótipo da interface.

## Etapa 3 — Preparação do ambiente

- Criar o projeto Java utilizando Spring Boot.
- Configurar as dependências necessárias.
- Organizar a estrutura MVC.
- Configurar a conexão com SQLite.
- Preparar o ambiente de testes com JUnit.
- Organizar os arquivos e diretórios no GitHub.

## Etapa 4 — Desenvolvimento do sistema

- Implementar as entidades e os relacionamentos do banco.
- Desenvolver cadastro, login e logout.
- Desenvolver o perfil básico dos jogadores.
- Implementar o tabuleiro e as regras do jogo.
- Desenvolver a alternância de turnos.
- Implementar a identificação de vitórias e empates.
- Implementar o registro persistente das partidas.
- Desenvolver o cálculo do rating pelo Glicko original.
- Implementar as ligas e a classificação global.
- Desenvolver a interface e o feedback visual.

## Etapa 5 — Testes e validação

- Criar testes automatizados das principais regras de negócio.
- Testar cadastro e autenticação.
- Verificar a persistência dos dados.
- Testar jogadas, vitórias e empates.
- Validar os cálculos de rating.
- Verificar a classificação global.
- Disponibilizar a aplicação para avaliação de cinco colegas ou usuários.
- Registrar sugestões, falhas e problemas identificados.
- Aplicar as correções pertinentes.

## Etapa 6 — Documentação e entrega

- Revisar a documentação técnica.
- Atualizar o repositório GitHub.
- Elaborar as instruções de utilização.
- Organizar os registros das avaliações individuais.
- Elaborar o laudo de qualidade.
- Registrar as funcionalidades não testadas e suas justificativas.
- Produzir os vídeos demonstrativos solicitados.
- Revisar os materiais antes da entrega final.

# 6. Funcionalidades futuras

Em razão da simplificação do escopo, algumas funcionalidades anteriormente previstas foram adiadas para versões posteriores:

- Partidas entre dispositivos pela mesma rede Wi-Fi.
- Multiplayer online por comunicação P2P.
- Matchmaking automático.
- Descoberta automática de dispositivos.
- Autenticação offline e sincronização de credenciais.
- Avatares personalizados e sincronizados.
- Aplicativo Android distribuído por APK.
- Recursos adicionais de interação entre jogadores.

Essas funcionalidades não fazem parte da implementação inicial do PIT II.

# 7. Critérios de conclusão

O MVP será considerado concluído quando apresentar:

- Cadastro e autenticação funcionais.
- Jogo da velha funcional para dois jogadores no mesmo dispositivo.
- Interface com identidade visual do Bubbles.
- Banco de dados relacional funcionando.
- Registro persistente das partidas.
- Rating e classificação global.
- Arquitetura MVC organizada.
- Testes automatizados executados.
- Documentação técnica correspondente à implementação.
- Avaliações dos cinco participantes e laudo de qualidade, conforme as exigências da atividade.

# 8. Considerações finais

O planejamento revisado estabelece uma abordagem simplificada para o desenvolvimento do Bubbles, priorizando a implementação das funcionalidades essenciais e o cumprimento dos requisitos técnicos do PIT II.

A redução do escopo busca tornar o desenvolvimento mais viável dentro do prazo acadêmico, evitando complexidade desnecessária e permitindo maior atenção à qualidade da solução.

As etapas serão executadas progressivamente, mantendo a documentação, os modelos, o código-fonte e os testes coerentes entre si.

As funcionalidades adiadas permanecerão registradas como possibilidades de evolução futura, sem serem consideradas entregas implementadas na versão inicial.
