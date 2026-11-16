# BUBBLES
## Especificação de Requisitos de Software

**Versão:** 0.4  
**Projeto:** Bubbles — Jogo da Velha com Sistema Competitivo  
**Curso:** Engenharia de Software — PIT II  
**Status:** Escopo simplificado para implementação do MVP

---

# 1. Visão geral do projeto

O Bubbles é um jogo da velha com identidade visual fofa, colorida e divertida, desenvolvido para proporcionar partidas entre dois jogadores.

A versão inicial será uma aplicação web, acessível por navegadores de computadores e dispositivos Android, permitindo partidas entre dois jogadores no mesmo dispositivo.

O sistema contará com cadastro e autenticação de usuários, perfil individual, registro de partidas, sistema de rating, ligas competitivas e tabela de classificação.

A aplicação utilizará front-end em HTML, CSS e JavaScript, back-end em Java com Spring Boot, arquitetura MVC e banco de dados relacional SQLite.

O projeto será desenvolvido priorizando simplicidade, funcionalidade, organização e atendimento aos requisitos técnicos do PIT II.

# 2. Requisitos funcionais (RF)

## 2.1. Funcionamento do jogo

**RF01.** O sistema deverá disponibilizar um jogo da velha com tabuleiro de nove posições, organizado em três linhas e três colunas.

**RF02.** O sistema deverá permitir partidas entre dois jogadores utilizando o mesmo dispositivo.

**RF03.** O sistema deverá permitir que cada jogador marque uma posição livre durante seu turno.

**RF04.** O sistema deverá impedir a seleção de posições já ocupadas.

**RF05.** O sistema deverá alternar automaticamente os turnos entre os jogadores.

**RF06.** O sistema deverá identificar vitórias por combinações horizontais, verticais ou diagonais.

**RF07.** O sistema deverá identificar automaticamente o empate natural quando todas as posições estiverem preenchidas sem vencedor.

**RF08.** O sistema deverá utilizar bolhas coloridas como peças, substituindo os tradicionais símbolos X e O.

**RF09.** O sistema deverá atribuir uma cor diferente para cada jogador no início da partida, mantendo a identificação visual durante todo o jogo.

**RF10.** O sistema deverá apresentar o resultado da partida em uma sobreposição sobre o tabuleiro, identificando o vencedor ou informando o empate.

## 2.2. Cadastro e autenticação

**RF11.** O sistema deverá permitir o cadastro de usuários mediante nickname e senha, sendo o endereço de e-mail opcional.

**RF12.** O sistema deverá impedir o cadastro de nicknames duplicados.

**RF13.** O sistema deverá permitir o login utilizando nickname e senha.

**RF14.** O sistema deverá exigir autenticação para acessar as funcionalidades individuais do sistema.

**RF15.** O sistema deverá disponibilizar a funcionalidade de logout.

**RF16.** O sistema deverá armazenar as senhas utilizando mecanismos seguros de hash, sem armazená-las em texto puro.

## 2.3. Perfil do jogador

**RF17.** O sistema deverá disponibilizar um perfil individual para cada usuário.

**RF18.** O perfil deverá apresentar nickname, rating competitivo e liga atual.

**RF19.** O sistema deverá utilizar uma imagem padrão como avatar inicial do jogador.

## 2.4. Partidas e resultados

**RF20.** O sistema deverá permitir que os dois jogadores realizem suas jogadas alternadamente no mesmo dispositivo.

**RF21.** O sistema deverá permitir a identificação dos jogadores participantes de cada partida.

**RF22.** O sistema deverá registrar automaticamente o resultado da partida após seu encerramento.

**RF23.** O sistema deverá disponibilizar uma funcionalidade para iniciar uma nova partida.

**RF24.** O sistema deverá disponibilizar uma opção para retornar ao menu principal após o encerramento da partida.

## 2.5. Rating e classificação competitiva

**RF25.** O sistema deverá disponibilizar um rating numérico individual para cada jogador.

**RF26.** Todos os jogadores deverão iniciar com rating de 100 pontos.

**RF27.** O sistema deverá utilizar o algoritmo Glicko original como referência para calcular as alterações de rating.

**RF28.** O cálculo deverá considerar o resultado das partidas e o desvio do rating (RD), conforme os parâmetros definidos para a implementação.

**RF29.** O sistema deverá considerar vitórias, derrotas e empates naturais no cálculo do rating.

**RF30.** O sistema deverá atualizar automaticamente a liga do jogador conforme seu rating.

**RF31.** O sistema deverá disponibilizar uma tabela de classificação global, ordenada pelo rating dos jogadores.

## 2.6. Histórico e persistência

**RF32.** O sistema deverá utilizar banco de dados relacional para armazenar persistentemente as informações da aplicação.

**RF33.** O sistema deverá armazenar os dados de cadastro dos jogadores, incluindo nickname, hash da senha e informações do perfil.

**RF34.** O sistema deverá registrar o histórico das partidas, incluindo participantes, resultado e datas.

**RF35.** O sistema deverá armazenar os ratings atuais e os dados necessários para seus cálculos.

**RF36.** O sistema deverá manter os registros das partidas e dos ratings mesmo após o encerramento da sessão ou reinicialização da aplicação.

**RF37.** O sistema deverá preservar a integridade dos registros, evitando duplicidade de partidas e alterações indevidas nos resultados.

# 3. Regras de negócio (RN)

**RN01.** Cada partida deverá envolver exatamente dois jogadores.

**RN02.** Cada jogador deverá realizar uma jogada por turno.

**RN03.** Uma posição ocupada não poderá receber outra marcação durante a mesma partida.

**RN04.** A partida deverá terminar quando houver uma vitória ou empate natural.

**RN05.** O nickname deverá ser único no sistema.

**RN06.** O endereço de e-mail será opcional no cadastro.

**RN07.** As senhas deverão ser armazenadas em formato de hash seguro, nunca em texto puro.

**RN08.** O rating inicial de todos os jogadores será de 100 pontos.

**RN09.** O rating deverá ser atualizado conforme os resultados das partidas, utilizando o Glicko original.

**RN10.** O cálculo do rating deverá considerar rating e RD, conforme os parâmetros técnicos estabelecidos para o projeto.

**RN11.** Empates naturais deverão ser considerados resultados empatados no cálculo do Glicko.

**RN12.** As ligas serão determinadas exclusivamente pelo rating individual do jogador.

**RN13.** A classificação deverá apresentar os jogadores ordenados por rating, considerando os dados persistidos no banco.

**RN14.** Toda partida concluída deverá possuir seu resultado registrado no banco de dados.

**RN15.** As operações de cadastro, autenticação, registro de partidas e atualização de rating deverão preservar a integridade dos dados.

# 4. Classificação competitiva

O Bubbles utilizará cinco ligas, determinadas pela pontuação do jogador.

| Liga | Faixa de rating |
|---|---:|
| Bronze | 100–199 |
| Prata | 200–349 |
| Ouro | 350–549 |
| Platina | 550–799 |
| Diamante | 800 ou mais |

Todos os jogadores iniciarão na liga Bronze, com 100 pontos.

A progressão e o rebaixamento ocorrerão automaticamente conforme as alterações do rating.

As faixas são configurações próprias do Bubbles e poderão ser ajustadas futuramente.

# 5. Requisitos não funcionais (RNF)

**RNF01 — Usabilidade:** a interface deverá ser simples, intuitiva, agradável e adequada à identidade visual do Bubbles.

**RNF02 — IHC:** o sistema deverá apresentar menus claros, navegação intuitiva, telas organizadas e mensagens compreensíveis.

**RNF03 — Feedback visual:** a interface deverá informar os turnos, as jogadas realizadas, os resultados e os erros de operação.

**RNF04 — Consistência visual:** os elementos da interface deverão manter padrões visuais e comportamentais consistentes.

**RNF05 — Compatibilidade:** a aplicação deverá funcionar em navegadores de computadores e dispositivos Android.

**RNF06 — Segurança:** o sistema deverá proteger credenciais, validar os dados recebidos e impedir operações não autorizadas.

**RNF07 — Integridade:** o sistema deverá preservar a consistência dos dados, partidas, resultados e ratings.

**RNF08 — Confiabilidade:** o sistema deverá tratar erros de processamento e falhas de persistência sem comprometer indevidamente os registros.

**RNF09 — Manutenibilidade:** o código deverá ser organizado em componentes que facilitem correções, testes e futuras ampliações.

**RNF10 — Eficiência:** as operações de interface, jogadas, consultas e gravações deverão apresentar tempos de resposta adequados.

# 6. Arquitetura e tecnologias

**ARQ01.** O front-end deverá utilizar HTML, CSS e JavaScript.

**ARQ02.** O back-end deverá utilizar Java com Spring Boot.

**ARQ03.** A aplicação deverá seguir a arquitetura MVC, organizando suas responsabilidades em:

- **Model:** entidades, regras de negócio e persistência dos dados.
- **View:** interface apresentada ao usuário.
- **Controller:** recebimento de requisições, validações e coordenação das operações.

**ARQ04.** A aplicação deverá utilizar SQLite como sistema gerenciador de banco de dados relacional.

**ARQ05.** A persistência deverá utilizar mecanismos que permitam o relacionamento entre jogadores, partidas e ratings.

**ARQ06.** Os testes automatizados deverão utilizar JUnit, contemplando as principais regras de negócio.

**ARQ07.** O código-fonte deverá ser organizado e disponibilizado em repositório público no GitHub.

# 7. Documentação e entregas técnicas

**DOC01.** O projeto deverá apresentar os diagramas UML revisados, incluindo classes, casos de uso, sequência e atividades.

**DOC02.** Deverá ser elaborado o diagrama de classes de persistência, representando entidades, atributos e relacionamentos.

**DOC03.** Deverão ser apresentados os modelos conceitual e lógico normalizado do banco de dados.

**DOC04.** O projeto deverá apresentar a implementação e documentação do modelo físico do banco de dados.

**DOC05.** Deverá ser elaborado um dicionário de dados contendo tabelas, campos, tipos, restrições e relacionamentos.

**DOC06.** Deverão ser documentados os elementos de IHC, incluindo telas, navegação, mensagens e protótipo da interface.

**DOC07.** O repositório deverá conter código-fonte, arquivos necessários à execução, documentação e instruções de utilização.

**DOC08.** O projeto deverá apresentar os testes automatizados e seus respectivos resultados.

**DOC09.** A solução deverá ser disponibilizada para avaliação de cinco colegas ou usuários, com registro individual de opiniões, data, funcionalidades testadas, falhas identificadas e sugestões.

**DOC10.** Deverá ser elaborado um laudo de qualidade contendo o que funcionou, problemas encontrados, correções realizadas, evidências e funcionalidades não testadas, com as respectivas justificativas.

**DOC11.** Deverão ser produzidos os vídeos demonstrativos solicitados na atividade, contemplando a solução e as melhorias realizadas após as avaliações.

# 8. Restrições do projeto

**RE01.** O projeto deverá ser desenvolvido com custo zero durante o PIT II, utilizando ferramentas e serviços gratuitos.

**RE02.** O código-fonte deverá ser disponibilizado em repositório público no GitHub.

**RE03.** O front-end deverá utilizar HTML, CSS e JavaScript.

**RE04.** O back-end deverá utilizar Java com Spring Boot e seguir a arquitetura MVC.

**RE05.** A aplicação deverá utilizar SQLite como banco de dados relacional.

**RE06.** Não será permitido utilizar exclusivamente o armazenamento local do navegador para persistir cadastros, partidas, ratings ou classificação.

# 9. Funcionalidades futuras

As seguintes funcionalidades ficam fora do escopo de implementação inicial do PIT II e poderão ser consideradas em versões posteriores:

- Multiplayer entre dispositivos pela rede Wi-Fi.
- Multiplayer online por meio de comunicação P2P.
- Busca automática de adversários e matchmaking.
- Descoberta automática de dispositivos na rede local.
- Autenticação offline e sincronização de credenciais.
- Upload e sincronização de avatares personalizados.
- Aplicativo Android distribuído por APK.
- Solicitação de empate, desistência e revanche entre jogadores remotos.
- Recursos adicionais de interação e personalização.

Essas funcionalidades não serão consideradas entregas implementadas na versão inicial.

# 10. Considerações finais

Esta especificação estabelece o escopo funcional e técnico da versão inicial do Bubbles, priorizando uma aplicação web simples, funcional e documentada.

A solução será desenvolvida com Java, Spring Boot, arquitetura MVC, HTML, CSS, JavaScript e SQLite, contemplando cadastro, autenticação, jogo, persistência de partidas, rating e classificação.

O documento servirá como referência para a elaboração dos diagramas UML, modelagem do banco de dados, desenvolvimento, testes automatizados e validação da aplicação.

As funcionalidades adiadas permanecerão registradas como possibilidades futuras, não fazendo parte das entregas obrigatórias da versão inicial.

Qualquer alteração posterior deverá ser documentada, mantendo a coerência entre requisitos, modelos, código-fonte e resultados dos testes.
