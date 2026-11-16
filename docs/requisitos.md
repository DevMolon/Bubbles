# BUBBLES
## Especificação de Requisitos de Software

**Versão:** 0.2 
**Projeto:** Bubbles — Jogo da Velha Multijogador
**Curso:** Engenharia de Software — PIT II  
**Status:** Especificação consolidada para desenvolvimento

---

# 1. Visão geral do projeto

O Bubbles é um jogo da velha multiplayer com identidade visual fofa, colorida e divertida, desenvolvido para proporcionar partidas entre dois jogadores.

O jogo terá versões para navegadores de computadores, navegadores de dispositivos Android e aplicativo Android distribuído inicialmente por APK.

O sistema permitirá partidas locais entre dispositivos conectados à mesma rede Wi-Fi, sem necessidade de internet, e partidas online com busca automática de adversários.

O projeto também contará com cadastro de usuários, perfis individuais, avatares, sistema de rating competitivo e ligas determinadas pela pontuação dos jogadores.

# 2. Requisitos funcionais (RF)

## 2.1. Funcionamento do jogo

**RF01.** O sistema deverá disponibilizar um jogo da velha com tabuleiro de nove posições, organizado em três linhas e três colunas.

**RF02.** O sistema deverá permitir partidas entre dois jogadores.

**RF03.** O sistema deverá permitir que cada jogador marque uma posição livre do tabuleiro durante seu turno.

**RF04.** O sistema deverá impedir que uma posição já ocupada seja selecionada novamente.

**RF05.** O sistema deverá alternar automaticamente os turnos entre os jogadores.

**RF06.** O sistema deverá identificar a vitória quando um jogador completar uma sequência de três posições na horizontal, vertical ou diagonal.

**RF07.** O sistema deverá identificar automaticamente o empate natural quando todas as posições estiverem preenchidas sem que exista um vencedor.

**RF08.** O sistema deverá utilizar bolhas coloridas como peças do jogo, substituindo os tradicionais símbolos X e O.

**RF09.** O sistema deverá atribuir automaticamente uma cor diferente para cada jogador no início de cada partida, mantendo a associação durante toda a partida.

**RF10.** O sistema deverá selecionar as cores dos jogadores a partir de uma paleta própria, permitindo variações entre partidas diferentes.

**RF11.** O sistema deverá apresentar o resultado da partida em uma sobreposição (overlay) sobre o próprio tabuleiro, identificando o vencedor pelo nickname ou exibindo a mensagem de empate.

## 2.2. Cadastro e autenticação

**RF12.** O sistema deverá permitir o cadastro de novos usuários mediante nickname e senha, sendo o endereço de e-mail opcional.

**RF13.** O sistema deverá impedir o cadastro de nicknames duplicados.

**RF14.** O sistema deverá permitir o login utilizando nickname e senha.

**RF15.** O sistema deverá exigir autenticação para acessar as funcionalidades do jogo, incluindo as modalidades local e online.

**RF16.** O sistema deverá permitir que o usuário encerre sua sessão por meio da funcionalidade de logout.

**RF17.** O sistema deverá armazenar as senhas utilizando mecanismos seguros de hash, sem armazená-las em texto puro.

**RF18.** O sistema deverá validar as credenciais dos usuários e controlar o acesso às funcionalidades conforme o estado de autenticação.

## 2.3. Perfil e avatar

**RF19.** O sistema deverá disponibilizar um perfil individual para cada usuário.

**RF20.** O perfil deverá apresentar nickname, rating competitivo e liga atual do jogador.

**RF21.** O sistema deverá permitir que o usuário selecione uma imagem da galeria do dispositivo ou dos arquivos do computador para utilizar como avatar.

**RF22.** O sistema deverá permitir que o usuário altere seu avatar posteriormente.

**RF23.** O sistema deverá sincronizar o avatar com a conta do usuário, permitindo sua visualização em outros dispositivos quando houver conexão com a internet.

**RF24.** O sistema deverá apresentar o avatar e o nickname dos jogadores durante as partidas, quando disponíveis.

## 2.4. Partidas locais

**RF25.** O sistema deverá permitir partidas entre dois dispositivos conectados à mesma rede Wi-Fi, sem exigir conexão com a internet.

**RF26.** O sistema deverá permitir o acesso offline às contas previamente autenticadas nos respectivos dispositivos.

**RF27.** O sistema deverá procurar automaticamente outros dispositivos disponíveis na mesma rede Wi-Fi para iniciar uma partida local, sem exigir que os jogadores informem códigos ou convites manualmente.

## 2.5. Partidas online e matchmaking

**RF28.** O sistema deverá permitir partidas online entre jogadores conectados à internet.

**RF29.** O sistema deverá disponibilizar busca automática de adversários, sem exigir convites ou códigos de partida.

**RF30.** O sistema deverá priorizar adversários com ratings semelhantes durante o processo de matchmaking.

**RF31.** Caso não encontre adversários com ratings próximos, o sistema deverá ampliar progressivamente a faixa de busca, selecionando, quando necessário, o adversário disponível com rating mais próximo.

**RF32.** O sistema deverá informar aos jogadores quando um adversário for encontrado e uma partida estiver sendo estabelecida.

**RF33.** O sistema deverá utilizar comunicação entre os dispositivos por meio de uma arquitetura P2P para as partidas online, com os mecanismos auxiliares necessários para estabelecimento e manutenção da conexão.

## 2.6. Empates, desistência e revanche

**RF34.** O sistema deverá permitir que qualquer jogador solicite um empate durante uma partida.

**RF35.** O sistema deverá apresentar ao adversário a possibilidade de aceitar ou recusar o pedido de empate, mantendo a partida em andamento enquanto aguarda a resposta.

**RF36.** Caso o pedido de empate seja aceito, o sistema deverá encerrar a partida como empate negociado, sem alterar o rating de nenhum dos jogadores.

**RF37.** Caso o pedido de empate seja recusado, o sistema deverá continuar a partida normalmente.

**RF38.** O sistema deverá permitir que qualquer jogador solicite desistência durante uma partida, apresentando uma confirmação antes de efetivar a ação.

**RF39.** Caso a desistência seja confirmada, o sistema deverá encerrar a partida, atribuindo derrota ao jogador que desistiu e vitória ao adversário.

**RF40.** O sistema deverá permitir que o vencedor solicite uma revanche após o encerramento da partida.

**RF41.** O sistema deverá iniciar uma nova partida somente após o adversário aceitar a solicitação de revanche.

**RF42.** Caso a revanche seja recusada, o sistema deverá disponibilizar individualmente aos jogadores as opções de procurar automaticamente um novo adversário ou retornar ao menu principal.

**RF43.** A decisão de um jogador após a recusa da revanche não deverá obrigar o outro a tomar a mesma decisão.

**RF44.** O sistema deverá preservar o resultado da partida anterior, impedindo que solicitações repetidas de revanche provoquem partidas duplicadas ou alterem resultados já registrados.

## 2.7. Desconexões e reconexões

**RF45.** O sistema deverá identificar a desconexão de um jogador durante uma partida local ou online.

**RF46.** Ao identificar a desconexão, o sistema deverá pausar a partida e iniciar um período de tolerância de 10 segundos para a reconexão.

**RF47.** Caso o jogador reconecte dentro do período estabelecido, o sistema deverá restaurar o estado anterior da partida, permitindo sua continuidade.

**RF48.** Caso o jogador não reconecte dentro dos 10 segundos, o sistema deverá encerrar a partida, atribuindo derrota ao jogador desconectado e vitória ao adversário.

**RF49.** Em partidas online, caso ocorra uma falha geral do servidor ou da infraestrutura responsável pela partida, o sistema não deverá atribuir vitória ou derrota aos jogadores nem alterar seus ratings.

## 2.8. Rating e ligas competitivas

**RF50.** O sistema deverá disponibilizar um rating numérico individual e global para cada usuário.

**RF51.** Todos os jogadores deverão iniciar com rating de 100 pontos.

**RF52.** O sistema deverá utilizar o algoritmo Glicko original como referência para calcular as alterações de rating após partidas online competitivas válidas.

**RF53.** O cálculo do rating deverá considerar a pontuação dos jogadores e o desvio do rating (RD), levando em conta a incerteza associada à classificação de cada jogador.

**RF54.** O sistema deverá aumentar progressivamente o RD durante períodos de inatividade, sem descontar automaticamente pontos do rating do jogador.

**RF55.** O sistema deverá atualizar o rating conforme os resultados das partidas: vitórias, derrotas e empates naturais.

**RF56.** O sistema deverá considerar a diferença entre os ratings dos adversários no cálculo das alterações de pontuação.

**RF57.** Empates negociados, aceitos por ambos os jogadores, não deverão provocar alterações nos ratings.

**RF58.** Partidas locais não deverão alterar o rating dos jogadores, independentemente do resultado.

**RF59.** Desistências em partidas online competitivas deverão ser consideradas derrotas para o jogador que desistiu e vitórias para o adversário, com atualização do rating conforme o Glicko.

**RF60.** Desconexões individuais que resultem em derrota após o período de tolerância deverão seguir as regras de atualização do rating aplicáveis às partidas online competitivas.

**RF61.** O sistema deverá atualizar automaticamente a liga do jogador conforme seu rating.

**RF62.** O sistema deverá permitir a progressão e o rebaixamento entre ligas conforme as alterações do rating.

# 3. Regras de negócio (RN)

**RN01.** Cada partida deverá envolver exatamente dois jogadores.

**RN02.** Cada jogador deverá realizar uma jogada por turno.

**RN03.** Uma posição ocupada não poderá receber outra marcação durante a mesma partida.

**RN04.** A partida deverá terminar quando houver uma combinação vencedora, empate natural, empate negociado aceito ou desistência confirmada.

**RN05.** Cada jogador deverá receber uma cor diferente no início de cada partida, mantendo sua identificação visual até o encerramento.

**RN06.** O nickname deverá ser único no sistema.

**RN07.** O endereço de e-mail será opcional no cadastro e poderá ser utilizado futuramente para recuperação de senha.

**RN08.** A senha deverá ser armazenada em formato de hash seguro, nunca em texto puro.

**RN09.** O cadastro de uma nova conta exigirá conexão com a internet.

**RN10.** Uma conta previamente autenticada em determinado dispositivo poderá ser utilizada offline nesse mesmo dispositivo, desde que suas credenciais locais estejam protegidas.

**RN11.** Um dispositivo que nunca tenha autenticado determinada conta precisará de conexão com a internet para realizar seu primeiro acesso.

**RN12.** Caso a senha de uma conta seja alterada em outro dispositivo, o dispositivo que permanecer offline poderá continuar utilizando temporariamente a credencial anteriormente validada, até que ocorra a sincronização com o serviço de autenticação.

**RN13.** Após a sincronização das credenciais, o sistema deverá exigir a senha atualizada nos próximos processos de autenticação.

**RN14.** Partidas locais poderão ocorrer sem internet, desde que os dispositivos estejam conectados à mesma rede Wi-Fi e os jogadores tenham sido previamente autenticados.

**RN15.** Partidas online exigirão conexão com a internet.

**RN16.** O matchmaking deverá priorizar jogadores com ratings próximos, ampliando progressivamente a faixa de busca quando necessário.

**RN17.** O pedido de empate não deverá interromper ou pausar a partida enquanto aguarda a resposta do adversário.

**RN18.** Um empate negociado somente será válido quando o adversário aceitar expressamente a solicitação.

**RN19.** Um empate negociado aceito não deverá alterar o rating de nenhum dos jogadores.

**RN20.** Um empate natural deverá ser considerado resultado empatado para o cálculo do rating pelo Glicko.

**RN21.** A desistência voluntária somente deverá produzir efeito após a confirmação do jogador que solicitou a ação.

**RN22.** A desistência confirmada deverá ser considerada derrota para quem desistiu e vitória para o adversário.

**RN23.** A desistência poderá ocorrer tanto em partidas locais quanto online, mas somente partidas online competitivas poderão alterar o rating.

**RN24.** A solicitação de revanche dependerá da aceitação do adversário.

**RN25.** Caso a revanche seja recusada, cada jogador poderá escolher independentemente entre procurar outro adversário ou retornar ao menu.

**RN26.** A desconexão individual deverá seguir o mesmo procedimento nas partidas locais e online: pausa, tolerância de 10 segundos e encerramento por derrota caso não ocorra reconexão.

**RN27.** Se o jogador reconectar dentro dos 10 segundos, a partida deverá continuar a partir do estado anterior à desconexão.

**RN28.** Em partidas online competitivas, uma desconexão individual que ultrapasse o período de tolerância deverá resultar em derrota para o jogador desconectado e vitória para o adversário.

**RN29.** Falhas gerais da infraestrutura responsável pela partida não deverão produzir resultados competitivos ou alterações de rating.

**RN30.** Somente partidas online competitivas válidas e concluídas poderão modificar o rating.

**RN31.** O rating inicial de todos os jogadores será de 100 pontos.

**RN32.** O rating será único e global, compartilhado entre o navegador do computador, navegador Android e aplicativo Android.

**RN33.** As ligas serão determinadas exclusivamente pelo rating individual do jogador, sem depender da quantidade de jogadores ativos.

**RN34.** O sistema de rating deverá utilizar o Glicko original, considerando rating e RD.

**RN35.** O RD deverá aumentar progressivamente durante a inatividade, sem redução automática do rating numérico.

**RN36.** As ligas poderão ser alteradas automaticamente quando o rating ultrapassar ou deixar de alcançar os limites estabelecidos.

**RN37.** As partidas locais não poderão interferir no rating ou na liga competitiva do jogador.

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

As faixas representam uma configuração inicial própria do Bubbles e poderão ser ajustadas futuramente com base nos resultados observados durante a utilização do jogo.

# 5. Requisitos não funcionais (RNF)

**RNF01 — Usabilidade:** a interface deverá ser simples, intuitiva, agradável e adequada à identidade visual fofa e colorida do Bubbles.

**RNF02 — Consistência visual:** os elementos da interface deverão manter padrões visuais e comportamentais consistentes entre as telas.

**RNF03 — Feedback:** o sistema deverá fornecer respostas visuais claras para ações dos jogadores, incluindo jogadas, erros, vitórias, empates, desconexões e reconexões.

**RNF04 — Compatibilidade:** a solução deverá funcionar em navegadores de computadores e dispositivos Android, além de disponibilizar um aplicativo Android distribuído por APK.

**RNF05 — Segurança de autenticação:** as senhas deverão ser protegidas por hash seguro, e os processos de autenticação deverão utilizar mecanismos apropriados de proteção.

**RNF06 — Segurança da comunicação:** a transmissão de dados sensíveis deverá utilizar mecanismos de proteção criptográfica adequados à modalidade de conexão.

**RNF07 — Validação:** o sistema deverá validar os dados recebidos, especialmente operações relacionadas a autenticação, jogadas, turnos, resultados e atualização de rating.

**RNF08 — Integridade:** o sistema deverá preservar a consistência dos estados das partidas e impedir que mensagens inválidas, repetidas ou incompatíveis provoquem alterações indevidas.

**RNF09 — Confiabilidade:** o sistema deverá tratar falhas de comunicação, desconexões e erros de processamento sem comprometer indevidamente os resultados das partidas.

**RNF10 — Manutenibilidade:** o código deverá ser organizado de forma a facilitar correções, atualizações e futuras ampliações.

**RNF11 — Portabilidade:** a solução deverá permitir utilização nos ambientes de navegador e aplicativo Android previstos no projeto.

**RNF12 — Eficiência:** as operações de interface, jogadas e comunicação deverão apresentar tempos de resposta adequados à experiência de jogo.

# 6. Restrições do projeto

**RE01.** O projeto deverá ser desenvolvido com custo zero durante o PIT II, utilizando ferramentas, serviços e recursos gratuitos.

**RE02.** O código-fonte deverá ser disponibilizado em repositório público no GitHub.

**RE03.** O front-end deverá utilizar HTML, CSS e JavaScript.

**RE04.** O back-end deverá utilizar uma das linguagens ou tecnologias admitidas na situação-problema: Java, PHP, C#, .NET ou Python.

**RE05.** O desenvolvimento do back-end deverá utilizar um padrão arquitetural indicado no material didático, com MVC como referência recomendada.

**RE06.** A aplicação deverá utilizar um sistema gerenciador de banco de dados adequado ao projeto.

**RE07.** O aplicativo Android deverá ser disponibilizado inicialmente por meio de arquivo APK, sem exigência de publicação na Google Play Store.

# 7. Funcionalidades futuras

As seguintes funcionalidades poderão ser consideradas em versões posteriores, não fazendo parte das entregas obrigatórias do escopo inicial do PIT II:

- Recuperação de senha por e-mail.
- Ampliação das funcionalidades do perfil.
- Melhorias no sistema competitivo.
- Novos recursos de personalização.
- Expansão das funcionalidades multiplayer.
- Novos recursos de interação entre jogadores.

# 8. Pontos de validação técnica

Alguns requisitos dependem de avaliação técnica durante o projeto, especialmente em razão das limitações de navegadores, redes locais e serviços gratuitos.

**VT01.** Verificar a viabilidade de descoberta automática de dispositivos na mesma rede Wi-Fi, considerando as limitações de segurança dos navegadores.

**VT02.** Avaliar mecanismos seguros de autenticação offline e sincronização de credenciais entre dispositivos.

**VT03.** Definir os mecanismos de armazenamento e sincronização dos avatares.

**VT04.** Avaliar a comunicação P2P online, incluindo WebRTC, sinalização e mecanismos auxiliares de conectividade.

**VT05.** Definir uma solução de matchmaking compatível com a arquitetura escolhida e com a restrição de custo zero.

**VT06.** Avaliar serviços gratuitos de hospedagem e banco de dados, considerando suas limitações, disponibilidade e possibilidade de manutenção.

**VT07.** Definir os parâmetros técnicos do Glicko original, incluindo o RD inicial, os valores de referência e os critérios de atualização após cada período de inatividade.

**VT08.** Validar mecanismos de proteção contra manipulação de partidas, falsificação de resultados e alterações indevidas de rating.

**VT09.** Definir o comportamento técnico para solicitações de empate pendentes quando a partida terminar por outro motivo antes da resposta do adversário.

**VT10.** Validar o funcionamento das modalidades local e online nos ambientes de navegador e aplicativo Android.

# 9. Considerações finais

Esta especificação reúne os requisitos funcionais, regras de negócio, requisitos não funcionais e restrições iniciais do projeto Bubbles.

O documento servirá como referência para a revisão dos modelos UML, modelagem do banco de dados, desenvolvimento do front-end e back-end, implementação das funcionalidades e realização dos testes.

Os pontos de validação técnica deverão ser analisados durante o planejamento da arquitetura e o desenvolvimento, sem serem tratados como funcionalidades já implementadas ou soluções tecnológicas definitivamente escolhidas.

A especificação poderá receber ajustes durante o ciclo de desenvolvimento, desde que as alterações sejam documentadas e mantenham a coerência entre requisitos, modelos, código e testes.
