# BUBBLES
## Planejamento do Projeto

**Versão:** 0.5  
**Projeto:** Bubbles — Jogo da Velha com Sistema Competitivo  
**Curso:** Engenharia de Software — PIT II  
**Status:** Planejamento atualizado conforme o desenvolvimento do MVP

---

# 1. Objetivo do projeto

O projeto Bubbles tem como objetivo desenvolver uma aplicação de jogo da velha com identidade visual fofa, colorida e divertida, permitindo partidas entre dois jogadores no mesmo dispositivo.

A aplicação oferece cadastro e autenticação de jogadores, perfil individual, histórico de partidas, sistema de rating competitivo e classificação global.

O desenvolvimento prioriza uma solução funcional, organizada e de fácil utilização, contemplando os requisitos técnicos e acadêmicos estabelecidos para o PIT II.

# 2. Escopo do projeto

O MVP contempla as seguintes funcionalidades:

- Cadastro de jogadores com nickname, senha e e-mail opcional.
- Autenticação e encerramento de sessão.
- Perfil individual com nickname, rating e classificação.
- Jogo da velha com tabuleiro 3×3 e peças representadas por bolhas coloridas.
- Partidas entre dois jogadores autenticados no mesmo dispositivo.
- Alternância automática de turnos.
- Validação das jogadas.
- Identificação automática de vitórias e empates.
- Reinicialização da partida e desconexão do segundo jogador.
- Registro persistente das partidas.
- Histórico individual de participações.
- Sistema de atualização de rating baseado no método Glicko.
- Classificação global dos jogadores.
- Interface visual adaptável, com identidade própria do Bubbles.

O sistema utiliza uma sessão compartilhada para controlar os dois participantes durante a partida. Não faz parte do MVP a realização de partidas online entre dispositivos diferentes.

# 3. Tecnologias utilizadas e previstas

| Componente | Tecnologia |
|---|---|
| Linguagem principal | Java |
| Framework de aplicação | Spring Boot |
| Arquitetura | MVC |
| Controle de requisições | Spring MVC |
| Front-end | HTML, CSS e JavaScript |
| Templates e páginas | Thymeleaf |
| Persistência | Spring Data JPA |
| Mapeamento objeto-relacional | Jakarta Persistence (JPA) |
| Banco de dados | SQLite, conforme configuração do projeto |
| Segurança de senhas | BCryptPasswordEncoder |
| Interface desktop | JavaFX WebView |
| Testes automatizados | JUnit 5 e Mockito |
| Controle de versão | Git e GitHub |
| Diagramas UML | PlantUML |

A aplicação utiliza Java e Spring Boot no back-end, com separação entre controladores, serviços, repositórios e entidades. O front-end é construído com HTML, CSS e JavaScript, permitindo a interação com as funcionalidades do sistema.

A aplicação também possui uma inicialização desktop com JavaFX WebView, que carrega a interface web disponibilizada pelo servidor Spring Boot.

# 4. Arquitetura do sistema

O projeto utiliza o padrão arquitetural MVC (Model-View-Controller), com divisão de responsabilidades entre as principais camadas.

**Model:** representa os dados, entidades, regras de negócio e operações de persistência. Inclui jogadores, partidas, participações, cálculo de rating, classificação e serviços relacionados.

**View:** responsável pela apresentação das páginas, menus, formulários, tabuleiro, mensagens e elementos visuais. Utiliza HTML, CSS, JavaScript e templates.

**Controller:** recebe as requisições, verifica as informações necessárias, controla as sessões e coordena as operações entre a interface e os serviços.

Além dessa organização, o projeto possui repositórios responsáveis pelo acesso aos dados por meio do Spring Data JPA.

A separação das responsabilidades busca facilitar a manutenção, a organização do código e a realização de testes.

# 5. Funcionalidades e regras de negócio

## 5.1 Cadastro e autenticação

O sistema permite cadastrar jogadores utilizando nickname e senha, com e-mail opcional.

As senhas são armazenadas por meio de hash BCrypt, e o nickname deve ser único.

Após a autenticação, o sistema mantém os dados necessários na sessão para controlar o acesso às páginas e funcionalidades.

## 5.2 Partidas

As partidas são realizadas entre dois jogadores autenticados no mesmo dispositivo.

O tabuleiro possui nove posições, distribuídas em três linhas e três colunas.

O primeiro jogador utiliza a cor azul e o segundo utiliza a cor rosa.

O sistema controla os turnos, impede jogadas inválidas e identifica automaticamente as condições de vitória e empate.

## 5.3 Registro e histórico

Após a conclusão de uma partida, o sistema registra as informações necessárias para manter o histórico dos participantes.

São armazenados dados como:

- Identificação da partida.
- Data e horário.
- Jogadores participantes.
- Cor utilizada por cada jogador.
- Resultado individual.
- Rating anterior e posterior de cada participante.

O histórico é disponibilizado na página de perfil e organizado da partida mais recente para a mais antiga.

## 5.4 Sistema de rating e classificação

O Bubbles utiliza um serviço de cálculo de rating baseado no método Glicko.

O sistema considera o resultado da partida, o rating e o desvio de rating (RD) dos jogadores para calcular os novos valores.

As classificações são determinadas conforme as faixas de rating estabelecidas no serviço de ligas:

- Sem classificação.
- Bronze.
- Prata.
- Ouro.
- Platina.
- Diamante.

O ranking geral apresenta os jogadores ordenados pelo rating em ordem decrescente, utilizando o nickname em ordem crescente como critério de desempate.

# 6. Planejamento das etapas de desenvolvimento

## Etapa 1 — Revisão e definição do escopo

- Revisar a proposta inicial do projeto.
- Adequar os requisitos funcionais e não funcionais.
- Definir as funcionalidades essenciais do MVP.
- Registrar as funcionalidades adiadas para versões futuras.
- Manter o escopo compatível com o prazo e as exigências acadêmicas.

## Etapa 2 — Modelagem e documentação

- Elaborar o diagrama de casos de uso.
- Elaborar o diagrama de classes.
- Elaborar o diagrama de sequência.
- Elaborar o diagrama de atividades.
- Revisar o modelo conceitual do banco de dados.
- Revisar o modelo lógico normalizado.
- Revisar o projeto físico do banco de dados.
- Elaborar ou revisar o dicionário de dados.
- Documentar os elementos de IHC.
- Organizar as telas, mensagens e navegação.
- Elaborar e revisar o protótipo da interface.

## Etapa 3 — Preparação do ambiente

- Criar e configurar o projeto Java com Spring Boot.
- Organizar a arquitetura MVC.
- Configurar as dependências necessárias.
- Configurar a persistência com Spring Data JPA.
- Preparar o ambiente de testes com JUnit 5 e Mockito.
- Organizar os diretórios e arquivos do projeto.
- Disponibilizar o código-fonte no GitHub.

## Etapa 4 — Desenvolvimento do sistema

- Implementar as entidades e os relacionamentos.
- Desenvolver cadastro, login e logout.
- Implementar o controle de sessões.
- Desenvolver a página inicial e o perfil.
- Implementar o tabuleiro e as regras do jogo.
- Desenvolver a autenticação do segundo jogador.
- Implementar a alternância de turnos.
- Identificar vitórias e empates.
- Desenvolver a reinicialização da partida.
- Implementar o registro persistente das partidas.
- Desenvolver o cálculo de rating.
- Implementar as classificações e o ranking global.
- Desenvolver a interface e os feedbacks visuais.
- Integrar o front-end ao back-end.

## Etapa 5 — Testes e validação

- Desenvolver testes automatizados das principais funcionalidades.
- Testar cadastro e autenticação.
- Verificar o funcionamento das sessões.
- Testar as regras do jogo.
- Verificar a persistência das partidas.
- Validar o cálculo de rating.
- Testar o perfil e o histórico.
- Verificar a classificação global.
- Avaliar o funcionamento da interface.
- Disponibilizar a aplicação para avaliação de cinco colegas ou usuários.
- Registrar sugestões, falhas e problemas identificados.
- Aplicar as correções pertinentes.

## Etapa 6 — Documentação e entrega

- Revisar a documentação técnica.
- Atualizar os diagramas conforme a implementação.
- Revisar os requisitos funcionais e não funcionais.
- Atualizar o repositório GitHub.
- Elaborar instruções de utilização.
- Organizar os registros das avaliações individuais.
- Elaborar o laudo de qualidade.
- Registrar funcionalidades não testadas e suas justificativas.
- Produzir os vídeos demonstrativos solicitados.
- Conferir os materiais e preparar a entrega final.

# 7. Testes automatizados

O projeto possui testes desenvolvidos com JUnit 5 e Mockito, contemplando diferentes componentes da aplicação.

Até o momento, foram recebidos 12 arquivos de testes, contendo 53 métodos de teste.

As principais áreas contempladas são:

- Inicialização da aplicação.
- Cadastro e autenticação.
- Cálculo de rating.
- Classificação por ligas.
- Controle de acesso.
- Funcionamento das partidas.
- Persistência de resultados.
- Perfil e histórico.
- Consulta ao ranking.

A execução dos testes e seus respectivos resultados deverão ser verificados e registrados antes da entrega final.

# 8. Funcionalidades futuras

Em razão da simplificação do escopo, algumas funcionalidades foram adiadas para versões posteriores:

- Partidas entre dispositivos pela mesma rede Wi-Fi.
- Multiplayer online.
- Comunicação P2P.
- Matchmaking automático.
- Descoberta automática de dispositivos.
- Autenticação offline e sincronização de credenciais.
- Avatares personalizados e sincronizados.
- Aplicativo Android distribuído por APK.
- Recursos adicionais de interação entre jogadores.

Essas funcionalidades não fazem parte das entregas previstas para o MVP do PIT II.

# 9. Critérios de conclusão

O MVP será considerado concluído quando apresentar:

- Cadastro e autenticação funcionais.
- Partidas entre dois jogadores no mesmo dispositivo.
- Tabuleiro e regras do jogo funcionando corretamente.
- Interface com identidade visual do Bubbles.
- Persistência dos dados e resultados das partidas.
- Perfil individual e histórico.
- Sistema de rating e classificação global.
- Arquitetura MVC organizada.
- Testes automatizados executados e documentados.
- Documentação técnica coerente com a implementação.
- Avaliação por cinco participantes e respectivo laudo de qualidade, conforme as exigências da atividade.
- Materiais demonstrativos e documentação final organizados.

# 10. Considerações finais

O planejamento revisado do Bubbles estabelece uma abordagem objetiva para o desenvolvimento e a conclusão do MVP no PIT II.

A definição de um escopo reduzido permite concentrar os esforços nas funcionalidades essenciais do jogo, priorizando a organização arquitetural, a integridade dos dados, a experiência de utilização e a qualidade da implementação.

O projeto será desenvolvido e documentado progressivamente, mantendo os requisitos, diagramas UML, modelos de dados, código-fonte e testes coerentes entre si.

As funcionalidades adiadas permanecerão registradas como possibilidades de evolução futura, sem serem consideradas entregas implementadas na versão inicial.
