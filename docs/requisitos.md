# BUBBLES
## Especificação de Requisitos de Software

**Versão:** 0.3  
**Projeto:** Bubbles — Jogo da Velha Multijogador  
**Curso:** Engenharia de Software — PIT II  
**Status:** Especificação revisada para desenvolvimento

---

# 1. Visão geral do projeto

O Bubbles é um jogo da velha multijogador com identidade visual fofa, colorida e divertida, desenvolvido para proporcionar partidas entre dois jogadores.

A solução terá como plataforma principal o navegador, com compatibilidade prevista para computadores e dispositivos Android. Também está prevista a disponibilização de um aplicativo Android por meio de APK.

O sistema permitirá partidas locais entre dispositivos conectados à mesma rede Wi-Fi e partidas online com busca automática de adversários.

Além do jogo, contará com cadastro e autenticação de usuários, perfis individuais, avatares, histórico de partidas, classificação competitiva, sistema de rating e ligas.

A aplicação será desenvolvida com front-end em HTML, CSS e JavaScript, back-end em Java, arquitetura MVC e banco de dados relacional.

# 2. Requisitos funcionais (RF)

## 2.1. Funcionamento do jogo

**RF01.** O sistema deverá disponibilizar um jogo da velha com tabuleiro de nove posições, organizado em três linhas e três colunas.

**RF02.** O sistema deverá permitir partidas entre dois jogadores, alternando automaticamente os turnos.

**RF03.** O sistema deverá permitir que cada jogador marque uma posição livre, impedindo a seleção de posições já ocupadas.

**RF04.** O sistema deverá identificar automaticamente vitórias por combinações horizontais, verticais ou diagonais e empates naturais quando todas as posições estiverem preenchidas sem vencedor.

**RF05.** O sistema deverá utilizar bolhas coloridas como peças, substituindo os tradicionais símbolos X e O.

**RF06.** O sistema deverá atribuir cores diferentes aos jogadores no início de cada partida, mantendo sua identificação visual até o encerramento.

**RF07.** O sistema deverá apresentar o resultado da partida em uma sobreposição sobre o tabuleiro, identificando o vencedor pelo nickname ou informando o empate.

## 2.2. Cadastro e autenticação

**RF08.** O sistema deverá permitir o cadastro de usuários mediante nickname e senha, sendo o endereço de e-mail opcional.

**RF09.** O sistema deverá impedir nicknames duplicados e permitir o login por nickname e senha.

**RF10.** O sistema deverá exigir autenticação para acessar as funcionalidades do jogo, incluindo as modalidades local e online.

**RF11.** O sistema deverá disponibilizar a funcionalidade de logout.

**RF12.** O sistema deverá armazenar as senhas utilizando hash seguro, sem mantê-las em texto puro.

## 2.3. Perfil e avatar

**RF13.** O sistema deverá disponibilizar um perfil individual contendo nickname, avatar, rating competitivo e liga atual.

**RF14.** O sistema deverá permitir selecionar e alterar o avatar utilizando imagens dos arquivos do computador ou da galeria do dispositivo.

**RF15.** O sistema deverá sincronizar o avatar com a conta do usuário quando houver conexão com a internet.

**RF16.** O sistema deverá apresentar o avatar e o nickname dos jogadores durante as partidas, quando disponíveis.

## 2.4. Partidas locais

**RF17.** O sistema deverá permitir partidas entre dois dispositivos conectados à mesma rede Wi-Fi, sem exigir conexão com a internet.

**RF18.** O sistema deverá permitir o acesso offline às contas previamente autenticadas nos respectivos dispositivos.

**RF19.** O sistema deverá procurar automaticamente dispositivos disponíveis na mesma rede Wi-Fi, sem exigir códigos ou convites manuais.

## 2.5. Partidas online e matchmaking

**RF20.** O sistema deverá permitir partidas online entre jogadores conectados à internet.

**RF21.** O sistema deverá disponibilizar busca automática de adversários, sem exigir convites ou códigos de partida.

**RF22.** O sistema deverá priorizar adversários com ratings semelhantes, ampliando progressivamente a faixa de busca quando necessário.

**RF23.** Caso não encontre adversários com ratings próximos, o sistema deverá selecionar o adversário disponível com rating mais próximo.

**RF24.** O sistema deverá informar quando um adversário for encontrado e a partida estiver sendo estabelecida.

**RF25.** O sistema deverá utilizar comunicação P2P nas partidas online, com os mecanismos auxiliares necessários para estabelecimento e manutenção da conexão.

## 2.6. Empates, desistência e revanche

**RF26.** O sistema deverá permitir que qualquer jogador solicite um empate durante uma partida.

**RF27.** O adversário deverá poder aceitar ou recusar o pedido, sem que a partida seja pausada enquanto aguarda a resposta.

**RF28.** Caso o empate seja aceito, a partida deverá ser encerrada sem alterações nos ratings dos jogadores. Caso seja recusado, deverá continuar normalmente.

**RF29.** O sistema deverá permitir a desistência mediante confirmação do jogador, atribuindo derrota a quem desistiu e vitória ao adversário.

**RF30.** O sistema deverá permitir a solicitação de revanche, iniciando uma nova partida somente após a aceitação do adversário.

**RF31.** Caso a revanche seja recusada, cada jogador deverá poder escolher independentemente entre procurar outro adversário ou retornar ao menu principal.

**RF32.** O sistema deverá preservar o resultado anterior, impedindo que solicitações repetidas de revanche provoquem partidas duplicadas ou alterem resultados já registrados.

## 2.7. Desconexões e reconexões

**RF33.** O sistema deverá identificar a desconexão de um jogador durante uma partida local ou online.

**RF34.** Ao identificar a desconexão, deverá pausar a partida e conceder 10 segundos para a reconexão.

**RF35.** Caso o jogador reconecte dentro do período estabelecido, o sistema deverá restaurar o estado anterior da partida.

**RF36.** Caso não ocorra reconexão dentro dos 10 segundos, o sistema deverá encerrar a partida, atribuindo derrota ao jogador desconectado e vitória ao adversário.

**RF37.** Em caso de falha geral do servidor ou da infraestrutura online, o sistema não deverá atribuir vitória ou derrota nem alterar os ratings.

## 2.8. Rating e ligas competitivas

**RF38.** O sistema deverá disponibilizar um rating numérico individual e global para cada usuário, compartilhado entre os dispositivos conectados à conta.

**RF39.** Todos os jogadores deverão iniciar com rating de 100 pontos.

**RF40.** O sistema deverá utilizar o algoritmo Glicko original para calcular as alterações de rating após partidas online competitivas válidas.

**RF41.** O cálculo deverá considerar o resultado das partidas, a diferença entre os ratings dos adversários e o desvio do rating (RD).

**RF42.** O sistema deverá aumentar progressivamente o RD durante períodos de inatividade, sem descontar automaticamente pontos do rating.

**RF43.** O sistema deverá atualizar o rating após vitórias, derrotas e empates naturais em partidas online competitivas válidas.

**RF44.** Empates negociados aceitos não deverão alterar os ratings.

**RF45.** Partidas locais não deverão alterar o rating dos jogadores.

**RF46.** Desistências e desconexões individuais que resultem em derrota deverão seguir as regras de atualização de rating das partidas online competitivas.

**RF47.** O sistema deverá atualizar automaticamente a liga do jogador conforme seu rating, permitindo progressão e rebaixamento.

## 2.9. Persistência e classificação

**RF48.** O sistema deverá utilizar um banco de dados relacional para armazenar persistentemente as informações da aplicação.

**RF49.** O sistema deverá armazenar os dados de cadastro dos jogadores, incluindo nickname, hash da senha e informações opcionais do perfil.

**RF50.** O sistema deverá registrar o histórico das partidas, incluindo modalidade, participantes, resultado, datas e informações necessárias à identificação da partida.

**RF51.** O sistema deverá armazenar os ratings dos jogadores e seus respectivos dados necessários ao cálculo e à atualização do Glicko.

**RF52.** O sistema deverá disponibilizar uma tabela de classificação (leaderboard), ordenada pelo rating global dos jogadores.

**RF53.** O sistema deverá manter os registros das partidas e dos ratings mesmo após o encerramento da sessão ou reinicialização da aplicação.

**RF54.** O sistema deverá preservar a integridade dos registros, evitando duplicidade de partidas e alterações indevidas nos resultados.

**RF55.** O sistema deverá utilizar operações de persistência com validação de dados e relacionamentos entre as entidades.

# 3. Regras de negócio (RN)

**RN01.** Cada partida deverá envolver exatamente dois jogadores, com uma jogada por turno.

**RN02.** Uma posição ocupada não poderá receber outra marcação durante a mesma partida.

**RN03.** A partida deverá terminar após uma vitória, empate natural, empate negociado aceito ou desistência confirmada.

**RN04.** O nickname deverá ser único no sistema e o e-mail será opcional.

**RN05.** O cadastro de novas contas exigirá conexão com a internet.

**RN06.** Uma conta previamente autenticada poderá ser utilizada offline no mesmo dispositivo, desde que suas credenciais locais estejam protegidas. O primeiro acesso em outro dispositivo exigirá conexão com a internet.

**RN07.** Alterações de senha realizadas em outro dispositivo deverão ser sincronizadas quando houver conexão. Até a sincronização, o dispositivo offline poderá utilizar temporariamente a credencial anteriormente validada.

**RN08.** Partidas locais poderão ocorrer sem internet, desde que os dispositivos estejam na mesma rede Wi-Fi e os jogadores tenham sido previamente autenticados.

**RN09.** Partidas online exigirão conexão com a internet.

**RN10.** O pedido de empate não deverá interromper a partida. Somente será válido como empate negociado após a aceitação expressa do adversário.

**RN11.** A desistência voluntária somente produzirá efeito após confirmação.

**RN12.** A revanche dependerá da aceitação do adversário. Caso seja recusada, cada jogador poderá decidir independentemente como prosseguir.

**RN13.** A desconexão individual deverá seguir o procedimento de pausa, tolerância de 10 segundos e encerramento por derrota caso não ocorra reconexão.

**RN14.** Falhas gerais da infraestrutura não deverão produzir resultados competitivos nem alterações de rating.

**RN15.** Somente partidas online competitivas válidas poderão modificar o rating.

**RN16.** O rating inicial será de 100 pontos para todos os jogadores e será único e global.

**RN17.** O sistema de rating deverá utilizar o Glicko original, considerando rating e RD.

**RN18.** Empates naturais deverão ser considerados resultados empatados pelo Glicko. Empates negociados aceitos não modificarão os ratings.

**RN19.** As partidas locais não poderão interferir no rating ou na liga competitiva.

**RN20.** As ligas serão determinadas exclusivamente pelo rating individual, independentemente da quantidade de jogadores ativos.

**RN21.** O histórico das partidas deverá ser persistido no banco de dados, mesmo que não seja apresentado no perfil individual.

**RN22.** A classificação deverá refletir os ratings persistidos dos jogadores, sem depender de dados armazenados exclusivamente no navegador.

# 4. Classificação competitiva

O Bubbles utilizará cinco ligas, determinadas pela pontuação global do jogador.

| Liga | Faixa de rating |
|---|---:|
| Bronze | 100–199 |
| Prata | 200–349 |
| Ouro | 350–549 |
| Platina | 550–799 |
| Diamante | 800 ou mais |

Todos os jogadores iniciarão na liga Bronze, com 100 pontos.

A progressão e o rebaixamento ocorrerão automaticamente conforme as alterações do rating.

As faixas são uma configuração própria do Bubbles e poderão ser ajustadas futuramente.

# 5. Requisitos não funcionais (RNF)

**RNF01 — Usabilidade:** a interface deverá ser simples, intuitiva, agradável e adequada à identidade visual do Bubbles.

**RNF02 — IHC:** o sistema deverá apresentar menus claros, navegação intuitiva, telas organizadas e mensagens compreensíveis de sucesso, erro e orientação.

**RNF03 — Feedback visual:** a interface deverá informar o estado da partida, incluindo placar, turnos, resultados, desconexões e reconexões, além de indicadores de tempo quando aplicáveis.

**RNF04 — Consistência:** os elementos visuais e comportamentais deverão manter padrões consistentes entre as telas.

**RNF05 — Compatibilidade:** a aplicação deverá ser compatível com navegadores de computadores e dispositivos Android, além de prever a distribuição de aplicativo Android por APK.

**RNF06 — Segurança:** o sistema deverá proteger credenciais, validar requisições e impedir operações não autorizadas.

**RNF07 — Segurança da comunicação:** dados sensíveis transmitidos pela internet deverão utilizar mecanismos adequados de proteção criptográfica.

**RNF08 — Integridade:** o sistema deverá preservar a consistência dos dados, partidas, resultados e ratings, evitando alterações indevidas.

**RNF09 — Confiabilidade:** o sistema deverá tratar falhas de comunicação, desconexões e erros de processamento sem comprometer indevidamente os registros.

**RNF10 — Manutenibilidade:** o código deverá ser organizado em componentes que facilitem correções, testes e futuras ampliações.

**RNF11 — Eficiência:** as operações de interface, jogadas, consultas e gravações deverão apresentar tempos de resposta adequados à experiência de jogo.

# 6. Arquitetura e tecnologias

**ARQ01.** O front-end deverá utilizar HTML, CSS e JavaScript.

**ARQ02.** O back-end deverá utilizar Java, com Spring Boot como tecnologia de desenvolvimento.

**ARQ03.** A aplicação deverá seguir a arquitetura MVC, organizando as responsabilidades em:

- **Model:** entidades, regras de negócio e persistência dos dados.
- **View:** interface apresentada ao usuário.
- **Controller:** recebimento de requisições, validações e coordenação das operações.

**ARQ04.** A aplicação deverá utilizar um banco de dados relacional, com SQLite como SGBD previsto para o projeto.

**ARQ05.** O projeto deverá utilizar mecanismos de persistência que permitam o relacionamento entre jogadores, partidas, participações e ratings.

**ARQ06.** Os testes automatizados deverão utilizar JUnit, contemplando as principais regras de negócio do sistema.

**ARQ07.** O código-fonte deverá ser organizado e disponibilizado em repositório Git público no GitHub.

# 7. Documentação e entregas técnicas

**DOC01.** O projeto deverá apresentar os diagramas UML revisados, incluindo classes, casos de uso, sequência e atividades, conforme aplicável.

**DOC02.** Deverá ser elaborado o diagrama de classes de persistência, representando as entidades, atributos e relacionamentos do banco de dados.

**DOC03.** Deverão ser apresentados os modelos conceitual e lógico normalizado do banco de dados.

**DOC04.** O projeto deverá apresentar a implementação e documentação do modelo físico do banco de dados.

**DOC05.** Deverá ser elaborado um dicionário de dados contendo tabelas, campos, tipos, restrições e relacionamentos.

**DOC06.** Deverão ser documentados os elementos de IHC, incluindo telas, navegação, mensagens e protótipo da interface.

**DOC07.** O repositório deverá conter o código-fonte, arquivos necessários à execução, documentação e instruções de utilização.

**DOC08.** O projeto deverá apresentar os testes automatizados e seus respectivos resultados.

**DOC09.** A solução deverá ser disponibilizada para avaliação de cinco colegas ou usuários, com registro individual de suas opiniões, data, funcionalidades testadas, falhas identificadas e sugestões.

**DOC10.** Deverá ser elaborado um laudo de qualidade contendo o que funcionou, problemas encontrados, correções realizadas, evidências e funcionalidades não testadas, com as respectivas justificativas.

**DOC11.** Deverão ser produzidos os vídeos demonstrativos solicitados na atividade, contemplando a solução e as melhorias realizadas após as avaliações.

# 8. Restrições do projeto

**RE01.** O projeto deverá ser desenvolvido com custo zero durante o PIT II, utilizando ferramentas e serviços gratuitos.

**RE02.** O código-fonte deverá ser disponibilizado em repositório público no GitHub.

**RE03.** O front-end deverá utilizar HTML, CSS e JavaScript.

**RE04.** O back-end deverá utilizar Java e seguir a arquitetura MVC.

**RE05.** A aplicação deverá utilizar um SGBD relacional, não sendo permitido utilizar exclusivamente o armazenamento local do navegador para persistir cadastro, partidas, ratings ou classificação.

**RE06.** O aplicativo Android deverá ser disponibilizado inicialmente por arquivo APK, sem exigência de publicação na Google Play Store.

# 9. Pontos de validação técnica

Os seguintes aspectos deverão ser avaliados durante o desenvolvimento, considerando limitações técnicas, segurança, disponibilidade e restrição de custo zero.

**VT01.** Verificar a viabilidade da descoberta automática de dispositivos na mesma rede Wi-Fi, considerando as limitações dos navegadores.

**VT02.** Avaliar mecanismos seguros de autenticação offline e sincronização de credenciais entre dispositivos.

**VT03.** Definir o armazenamento e a sincronização dos avatares.

**VT04.** Avaliar a comunicação P2P online, incluindo WebRTC, sinalização e mecanismos auxiliares de conectividade.

**VT05.** Definir a solução de matchmaking compatível com a arquitetura e a restrição de custo zero.

**VT06.** Avaliar serviços gratuitos de hospedagem e suas limitações.

**VT07.** Definir os parâmetros técnicos do Glicko original, incluindo RD inicial, valores de referência e critérios de atualização após períodos de inatividade.

**VT08.** Validar mecanismos de proteção contra manipulação de partidas, falsificação de resultados e alterações indevidas de rating.

**VT09.** Definir o tratamento de pedidos de empate pendentes quando a partida terminar por outro motivo antes da resposta do adversário.

**VT10.** Validar o funcionamento das modalidades local e online nos ambientes de navegador e aplicativo Android.

# 10. Funcionalidades futuras

As seguintes funcionalidades poderão ser consideradas em versões posteriores, não constituindo entregas obrigatórias da versão inicial do PIT II:

- Recuperação de senha por e-mail.
- Ampliação das funcionalidades do perfil.
- Novos recursos de personalização.
- Expansão das funcionalidades multiplayer.
- Novos recursos de interação entre jogadores.

# 11. Considerações finais

Esta especificação estabelece os requisitos funcionais, regras de negócio, requisitos não funcionais, arquitetura, restrições e entregas técnicas do projeto Bubbles.

O documento servirá como referência para a elaboração dos modelos UML, modelagem e implementação do banco de dados, desenvolvimento do front-end e back-end, realização dos testes e validação da solução.

Os pontos de validação técnica deverão ser analisados durante o desenvolvimento, sem serem considerados funcionalidades já implementadas ou soluções definitivamente escolhidas.

As alterações realizadas durante o projeto deverão ser documentadas, mantendo a coerência entre requisitos, diagramas, banco de dados, código-fonte e resultados dos testes.
