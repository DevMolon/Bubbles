# BUBBLES
## Especificação de Requisitos de Software

**Versão:** 0.5  
**Projeto:** Bubbles — Jogo da Velha com Sistema Competitivo  
**Curso:** Engenharia de Software — PIT II  
**Status:** Especificação revisada conforme o escopo do MVP e a implementação do projeto.

---

# 1. Visão geral do projeto

O Bubbles é uma aplicação de jogo da velha com identidade visual fofa, colorida e divertida, desenvolvida para proporcionar partidas entre dois jogadores no mesmo dispositivo.

O sistema oferece cadastro e autenticação de jogadores, perfil individual, histórico de partidas, atualização de rating competitivo, classificação por ligas e ranking geral.

A aplicação utiliza Java e Spring Boot no back-end, com arquitetura MVC, e HTML, CSS e JavaScript na interface. A persistência é realizada por meio do Spring Data JPA, utilizando o banco de dados relacional configurado no projeto.

O sistema também possui uma opção de inicialização desktop por meio do JavaFX WebView.

O desenvolvimento prioriza simplicidade, organização, funcionalidade e atendimento aos requisitos técnicos e acadêmicos do PIT II.

# 2. Requisitos funcionais (RF)

Os requisitos funcionais descrevem os serviços e comportamentos que o sistema deverá oferecer.

## 2.1. Cadastro e autenticação

**RF01.** O sistema deverá permitir o cadastro de jogadores utilizando nickname e senha, com endereço de e-mail opcional.

**RF02.** O sistema deverá impedir o cadastro de nicknames duplicados.

**RF03.** O sistema deverá validar o nickname, exigindo preenchimento e respeitando o limite de 30 caracteres.

**RF04.** O sistema deverá exigir uma senha com, no mínimo, oito caracteres durante o cadastro.

**RF05.** O sistema deverá armazenar as senhas utilizando hash BCrypt, sem armazená-las em texto puro.

**RF06.** O sistema deverá permitir a autenticação utilizando nickname e senha.

**RF07.** O sistema deverá manter os dados de identificação do jogador autenticado durante a sessão.

**RF08.** O sistema deverá permitir o encerramento da sessão por meio da funcionalidade de logout.

**RF09.** O sistema deverá impedir o acesso às funcionalidades individuais quando não houver autenticação válida.

## 2.2. Página inicial e navegação

**RF10.** O sistema deverá disponibilizar uma página inicial para jogadores autenticados.

**RF11.** O sistema deverá redirecionar jogadores não autenticados para a página de login ao tentarem acessar a página inicial.

**RF12.** A página inicial deverá disponibilizar acesso às funcionalidades principais do sistema, conforme a interface implementada.

## 2.3. Funcionamento do jogo

**RF13.** O sistema deverá disponibilizar um tabuleiro de jogo da velha com nove posições, organizadas em três linhas e três colunas.

**RF14.** O sistema deverá permitir partidas entre dois jogadores autenticados utilizando o mesmo dispositivo.

**RF15.** O sistema deverá identificar o primeiro jogador pela cor azul e o segundo pela cor rosa.

**RF16.** O sistema deverá iniciar cada partida com a vez do jogador azul.

**RF17.** O sistema deverá permitir que o jogador atual realize uma jogada selecionando uma posição livre do tabuleiro.

**RF18.** O sistema deverá alternar automaticamente os jogadores após cada jogada válida.

**RF19.** O sistema deverá impedir jogadas em posições ocupadas.

**RF20.** O sistema deverá impedir jogadas fora dos limites do tabuleiro.

**RF21.** O sistema deverá impedir novas jogadas quando a partida já estiver finalizada.

**RF22.** O sistema deverá identificar automaticamente vitórias por combinações horizontais, verticais ou diagonais.

**RF23.** O sistema deverá identificar automaticamente o empate quando as nove posições estiverem preenchidas sem que exista um vencedor.

**RF24.** O sistema deverá disponibilizar o estado atualizado do tabuleiro após cada jogada.

**RF25.** O sistema deverá disponibilizar a identificação do jogador da vez, a quantidade de jogadas realizadas e o resultado atual da partida.

**RF26.** O sistema deverá permitir a reinicialização da partida, criando um novo estado de jogo.

## 2.4. Controle dos participantes

**RF27.** O sistema deverá permitir a autenticação de um segundo jogador antes do início da partida.

**RF28.** O sistema deverá impedir que o mesmo jogador utilize sua própria conta como segundo participante.

**RF29.** O sistema deverá impedir o início da partida quando o segundo jogador não estiver autenticado.

**RF30.** O sistema deverá permitir a desconexão do segundo jogador, removendo sua identificação da sessão e reiniciando o estado da partida.

## 2.5. Registro e persistência das partidas

**RF31.** O sistema deverá registrar automaticamente uma partida após sua conclusão.

**RF32.** O sistema deverá registrar a data e o horário da partida.

**RF33.** O sistema deverá registrar os dois jogadores participantes, suas respectivas cores e seus resultados individuais.

**RF34.** O sistema deverá armazenar o rating anterior e posterior de cada participante.

**RF35.** O sistema deverá impedir o registro duplicado da mesma partida durante a sessão de jogo.

**RF36.** O sistema deverá manter os registros das partidas e participações armazenados persistentemente no banco de dados.

## 2.6. Rating e classificação competitiva

**RF37.** O sistema deverá atribuir um rating inicial de 100 pontos a cada jogador cadastrado.

**RF38.** O sistema deverá utilizar o serviço de cálculo de rating baseado no método Glicko, considerando o rating, o desvio de rating (RD) e o resultado da partida.

**RF39.** O sistema deverá considerar vitórias, derrotas e empates nos cálculos de atualização do rating.

**RF40.** O sistema deverá atualizar o rating e o RD dos dois jogadores após o registro de uma partida concluída.

**RF41.** O sistema deverá limitar os valores de RD entre 30 e 350, conforme os parâmetros definidos na implementação.

**RF42.** O sistema deverá determinar a classificação do jogador conforme seu rating atual.

**RF43.** O sistema deverá disponibilizar uma classificação global dos jogadores autenticados.

**RF44.** O sistema deverá ordenar o ranking pelo rating em ordem decrescente.

**RF45.** O sistema deverá utilizar o nickname em ordem crescente como critério de desempate no ranking.

## 2.7. Perfil e histórico

**RF46.** O sistema deverá permitir que jogadores autenticados consultem seu perfil individual.

**RF47.** O perfil deverá apresentar o nickname e a classificação competitiva do jogador, incluindo seu rating.

**RF48.** O sistema deverá disponibilizar o histórico de partidas do jogador.

**RF49.** O histórico deverá apresentar as participações em partidas, incluindo os resultados registrados.

**RF50.** O sistema deverá organizar o histórico da partida mais recente para a mais antiga.

**RF51.** O sistema deverá impedir o acesso ao perfil sem autenticação.

**RF52.** O sistema deverá encerrar a sessão quando o jogador identificado não for encontrado no banco de dados durante a consulta ao perfil.

---

# 3. Regras de negócio (RN)

As regras de negócio definem as condições e restrições que orientam o funcionamento do Bubbles.

**RN01.** Cada partida deverá envolver dois jogadores diferentes.

**RN02.** Cada jogador deverá realizar uma jogada por turno.

**RN03.** O primeiro jogador utilizará a cor azul e o segundo utilizará a cor rosa.

**RN04.** Uma posição ocupada não poderá receber outra marcação durante a mesma partida.

**RN05.** A partida deverá ser encerrada quando houver uma vitória ou empate.

**RN06.** O nickname deverá ser único no sistema.

**RN07.** O endereço de e-mail será opcional no cadastro.

**RN08.** A senha deverá possuir pelo menos oito caracteres e ser armazenada por meio de hash BCrypt.

**RN09.** Todos os jogadores deverão iniciar com rating de 100 pontos.

**RN10.** O RD inicial dos jogadores será de 350 pontos.

**RN11.** O cálculo do rating deverá considerar os resultados das partidas e os parâmetros do método Glicko implementado.

**RN12.** Os resultados individuais deverão ser definidos da seguinte maneira:
- Vitória: o jogador vencedor recebe VITORIA.
- Derrota: o jogador adversário recebe DERROTA.
- Empate: ambos recebem EMPATE.

**RN13.** O RD deverá respeitar o limite mínimo de 30 e máximo de 350.

**RN14.** O rating não poderá assumir valores negativos.

**RN15.** A classificação competitiva será determinada exclusivamente pelo rating atual do jogador.

**RN16.** Jogadores com rating inferior a 100 permanecerão sem classificação.

**RN17.** O ranking deverá utilizar o rating em ordem decrescente e o nickname em ordem crescente para desempate.

**RN18.** Cada participação deverá estar vinculada a um único jogador e a uma única partida.

**RN19.** Cada partida concluída deverá possuir duas participações registradas, uma para cada jogador.

**RN20.** O registro da partida deverá atualizar os dados competitivos dos dois participantes de maneira transacional.

**RN21.** O sistema deverá impedir que a mesma partida seja registrada novamente durante a sessão correspondente.

---

# 4. Classificação competitiva

O Bubbles utiliza cinco ligas competitivas, determinadas conforme o rating individual do jogador.

| Classificação | Faixa de rating |
|---|---:|
| Sem classificação | Abaixo de 100 |
| Bronze | 100 a 199 |
| Prata | 200 a 349 |
| Ouro | 350 a 549 |
| Platina | 550 a 799 |
| Diamante | 800 ou mais |

Todos os jogadores iniciam com rating de 100 pontos, correspondendo à liga Bronze.

A classificação é recalculada conforme o rating atual do jogador.

As faixas são regras próprias do Bubbles e podem ser modificadas em versões futuras.

---

# 5. Requisitos não funcionais (RNF)

Os requisitos não funcionais definem características de qualidade e condições gerais de funcionamento da aplicação.

**RNF01 — Usabilidade:** a interface deverá ser simples, intuitiva, agradável e adequada à identidade visual do Bubbles.

**RNF02 — Interface humano-computador:** o sistema deverá apresentar menus organizados, navegação compreensível, telas consistentes e mensagens claras.

**RNF03 — Feedback visual:** a interface deverá informar os turnos, as jogadas realizadas, os resultados e os erros de operação.

**RNF04 — Consistência visual:** os componentes da interface deverão manter padrões visuais e comportamentais consistentes.

**RNF05 — Responsividade:** a interface deverá adaptar sua apresentação a diferentes dimensões de tela, conforme os recursos implementados no CSS.

**RNF06 — Compatibilidade:** a aplicação deverá ser compatível com navegadores modernos de computadores e dispositivos móveis, sujeita à validação prática.

**RNF07 — Segurança:** o sistema deverá proteger as credenciais, validar os dados recebidos e controlar o acesso às funcionalidades autenticadas.

**RNF08 — Integridade:** o sistema deverá preservar a consistência dos dados dos jogadores, partidas, participações e ratings.

**RNF09 — Confiabilidade:** a aplicação deverá tratar erros de processamento e persistência sem comprometer indevidamente os registros.

**RNF10 — Manutenibilidade:** o código deverá ser organizado em componentes com responsabilidades definidas, facilitando correções, testes e futuras ampliações.

**RNF11 — Eficiência:** as operações de navegação, jogadas, consultas e gravações deverão apresentar tempos de resposta adequados à utilização da aplicação.

**RNF12 — Testabilidade:** os principais serviços e regras de negócio deverão permitir a execução de testes automatizados.

**RNF13 — Acessibilidade:** a interface deverá buscar legibilidade, clareza de mensagens e facilidade de interação, respeitando as limitações dos dispositivos utilizados.

---

# 6. Arquitetura e tecnologias

**ARQ01.** O back-end deverá utilizar Java com Spring Boot.

**ARQ02.** A aplicação deverá seguir o padrão arquitetural MVC, separando responsabilidades entre Model, View e Controller.

**ARQ03.** O front-end deverá utilizar HTML, CSS e JavaScript.

**ARQ04.** A camada de apresentação deverá utilizar os mecanismos de templates configurados no projeto.

**ARQ05.** A persistência deverá utilizar Spring Data JPA e Jakarta Persistence.

**ARQ06.** O banco de dados deverá utilizar o sistema relacional configurado para o projeto, com SQLite previsto no planejamento.

**ARQ07.** Os testes automatizados deverão utilizar JUnit 5 e Mockito.

**ARQ08.** O projeto deverá manter separação entre controladores, serviços, repositórios e entidades.

**ARQ09.** A aplicação deverá disponibilizar os recursos necessários à inicialização desktop por meio de JavaFX WebView, conforme a implementação existente.

**ARQ10.** O código-fonte deverá ser organizado e disponibilizado em repositório GitHub.

---

# 7. Documentação e entregas técnicas

**DOC01.** O projeto deverá apresentar o diagrama de casos de uso UML.

**DOC02.** O projeto deverá apresentar o diagrama de classes UML.

**DOC03.** O projeto deverá apresentar o diagrama de sequência UML.

**DOC04.** O projeto deverá apresentar o diagrama de atividades UML.

**DOC05.** Deverá ser elaborado o diagrama de classes de persistência, representando entidades, atributos e relacionamentos.

**DOC06.** Deverão ser apresentados os modelos conceitual e lógico normalizado do banco de dados.

**DOC07.** O projeto deverá apresentar a implementação e documentação do modelo físico do banco de dados.

**DOC08.** Deverá ser elaborado um dicionário de dados contendo tabelas, campos, tipos, restrições e relacionamentos.

**DOC09.** Deverão ser documentados os elementos de IHC, incluindo telas, navegação, mensagens e interação.

**DOC10.** Deverá ser apresentado o protótipo da interface.

**DOC11.** O repositório deverá conter o código-fonte, os arquivos necessários à execução e a documentação do projeto.

**DOC12.** O projeto deverá apresentar instruções de instalação, inicialização e utilização.

**DOC13.** Deverão ser apresentados os testes automatizados e seus respectivos resultados de execução.

**DOC14.** A aplicação deverá ser disponibilizada para avaliação de cinco colegas ou usuários, conforme as exigências da atividade.

**DOC15.** Deverão ser registrados individualmente os resultados das avaliações, incluindo data, funcionalidades testadas, opiniões, falhas identificadas e sugestões.

**DOC16.** Deverá ser elaborado um laudo de qualidade contendo os resultados das avaliações, problemas encontrados, correções realizadas, evidências e funcionalidades não testadas, com suas respectivas justificativas.

**DOC17.** Deverão ser produzidos os vídeos demonstrativos solicitados na atividade, apresentando a solução e as melhorias realizadas após as avaliações.

---

# 8. Restrições do projeto (RE)

**RE01.** O projeto deverá utilizar ferramentas e tecnologias gratuitas durante o desenvolvimento acadêmico, respeitando as condições estabelecidas para o PIT II.

**RE02.** O código-fonte deverá ser disponibilizado em repositório público no GitHub, conforme a orientação da atividade.

**RE03.** O front-end deverá utilizar HTML, CSS e JavaScript.

**RE04.** O back-end deverá utilizar Java com Spring Boot.

**RE05.** A arquitetura deverá seguir o padrão MVC.

**RE06.** A persistência deverá utilizar banco de dados relacional, com SQLite previsto para o projeto.

**RE07.** Não será permitido utilizar exclusivamente o armazenamento local do navegador para persistir cadastros, partidas, ratings ou classificação.

**RE08.** A versão inicial deverá contemplar partidas entre dois jogadores no mesmo dispositivo, não sendo obrigatório desenvolver comunicação entre dispositivos diferentes.

---

# 9. Funcionalidades futuras

As seguintes funcionalidades ficam fora do escopo inicial do PIT II e poderão ser consideradas em versões posteriores:

- Partidas entre dispositivos pela mesma rede Wi-Fi.
- Multiplayer online.
- Comunicação P2P.
- Matchmaking automático.
- Descoberta automática de dispositivos na rede local.
- Autenticação offline e sincronização de credenciais.
- Upload e sincronização de avatares personalizados.
- Aplicativo Android distribuído por APK.
- Solicitação de empate e revanche entre jogadores remotos.
- Recursos adicionais de interação e personalização.

Essas funcionalidades não serão consideradas entregas implementadas na versão inicial.

---

# 10. Considerações finais

Esta especificação estabelece os requisitos funcionais, regras de negócio, requisitos não funcionais, restrições e entregas técnicas do Bubbles.

A versão inicial prioriza o desenvolvimento de uma aplicação organizada, com cadastro, autenticação, partidas entre dois jogadores no mesmo dispositivo, persistência dos resultados, sistema de rating, classificação competitiva e histórico individual.

O documento servirá como referência para a modelagem UML, documentação do banco de dados, desenvolvimento, testes automatizados e validação da aplicação.

Os requisitos deverão permanecer coerentes com o código-fonte e com os resultados efetivamente obtidos durante os testes.

Qualquer alteração posterior deverá ser registrada, mantendo a consistência entre a especificação, os modelos, a implementação e a documentação final.
