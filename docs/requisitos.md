# Bubbles — Especificação de Requisitos

**Projeto:** Bubbles  
**Versão:** 0.1 — Especificação inicial  
**Curso:** Engenharia de Software — PIT II

## 1. Visão geral

O Bubbles é um jogo da velha digital para dois jogadores, com identidade visual fofa, colorida e divertida. O jogo será disponibilizado em navegadores de computadores e dispositivos Android, além de um aplicativo Android distribuído inicialmente por APK.

O sistema oferecerá partidas locais entre dispositivos conectados à mesma rede Wi-Fi e partidas online com busca automática de adversários.

## 2. Requisitos funcionais

### 2.1. Funcionamento do jogo

- RF01 — O sistema deverá apresentar um menu principal com as modalidades disponíveis.
- RF02 — O sistema deverá disponibilizar um tabuleiro de jogo da velha com nove posições.
- RF03 — O sistema deverá permitir partidas entre dois jogadores.
- RF04 — As peças serão representadas por bolhas coloridas, substituindo os tradicionais X e O.
- RF05 — Cada jogador receberá automaticamente uma cor diferente no início da partida.
- RF06 — O sistema deverá alternar os turnos automaticamente.
- RF07 — O sistema deverá impedir jogadas em posições já ocupadas.
- RF08 — O sistema deverá identificar vitórias e empates.
- RF09 — O sistema deverá apresentar o resultado sobre o próprio tabuleiro.
- RF10 — Após o encerramento, deverá oferecer opções para jogar novamente ou retornar ao menu.

### 2.2. Cadastro e autenticação

- RF11 — O sistema deverá permitir a criação de contas mediante conexão com a internet.
- RF12 — O cadastro deverá exigir nickname e senha, permitindo o fornecimento opcional de e-mail.
- RF13 — Cada nickname deverá ser único.
- RF14 — O sistema deverá permitir login utilizando nickname e senha.
- RF15 — O sistema deverá permitir autenticação offline em dispositivos nos quais a conta já tenha sido autenticada anteriormente.
- RF16 — O sistema deverá permitir logout.
- RF17 — O sistema deverá manter a identificação do jogador associada à sua conta.

### 2.3. Perfil e avatar

- RF18 — Cada jogador deverá possuir um perfil associado à sua conta.
- RF19 — O jogador deverá poder selecionar uma imagem da galeria do celular ou dos arquivos do computador para utilizar como avatar.
- RF20 — O jogador deverá poder alterar seu avatar posteriormente.
- RF21 — O avatar e o nickname deverão aparecer durante as partidas.

### 2.4. Partidas locais

- RF22 — O sistema deverá permitir partidas entre dois dispositivos conectados à mesma rede Wi-Fi.
- RF23 — O sistema deverá buscar automaticamente outro dispositivo disponível na rede local.
- RF24 — O sistema deverá informar quando encontrar um adversário.
- RF25 — As partidas locais deverão funcionar sem conexão com a internet, desde que as contas já estejam autenticadas nos respectivos dispositivos.

### 2.5. Partidas online

- RF26 — O sistema deverá permitir partidas entre jogadores conectados pela internet.
- RF27 — O sistema deverá buscar automaticamente adversários disponíveis.
- RF28 — O sistema deverá informar quando encontrar um adversário.
- RF29 — O sistema deverá apresentar informações sobre o estado da conexão.
- RF30 — O sistema deverá permitir que o jogador abandone uma partida.

### 2.6. Revanche e encerramento

- RF31 — O jogador poderá solicitar uma revanche após o encerramento da partida.
- RF32 — O adversário deverá aceitar a revanche para que uma nova partida seja iniciada.
- RF33 — Caso a revanche seja recusada, cada jogador poderá escolher independentemente entre procurar outro adversário ou retornar ao menu.
- RF34 — O resultado da partida anterior deverá permanecer inalterado.

### 2.7. Desconexões

- RF35 — O sistema deverá detectar a desconexão de um participante durante uma partida.
- RF36 — A partida deverá ser pausada imediatamente.
- RF37 — O sistema deverá iniciar um prazo de 10 segundos para reconexão.
- RF38 — O sistema deverá permitir a retomada da partida dentro desse prazo, preservando o estado anterior.
- RF39 — Se o prazo expirar sem reconexão, a partida deverá ser encerrada.
- RF40 — O sistema deverá informar o motivo do encerramento.

### 2.8. Rating e classificação

- RF41 — O sistema deverá manter um rating competitivo individual para cada jogador.
- RF42 — Somente partidas online deverão influenciar o rating.
- RF43 — Partidas locais não deverão alterar o rating.
- RF44 — O sistema deverá atualizar o rating conforme os resultados das partidas online.
- RF45 — O cálculo deverá considerar a classificação dos adversários.
- RF46 — O sistema deverá apresentar a liga correspondente ao rating atual.

## 3. Regras de negócio

- RN01 — Cada partida deverá possuir exatamente dois participantes.
- RN02 — O tabuleiro deverá possuir nove posições.
- RN03 — Cada posição poderá receber somente uma peça.
- RN04 — Os jogadores deverão alternar os turnos.
- RN05 — A partida terminará quando houver uma combinação vencedora ou quando todas as posições forem preenchidas sem vencedor.
- RN06 — Cada jogador receberá automaticamente uma cor exclusiva durante a partida.
- RN07 — A cor permanecerá associada ao jogador até o encerramento da partida.
- RN08 — Uma revanche dependerá da aceitação do adversário.
- RN09 — A recusa de revanche permitirá decisões independentes dos participantes.
- RN10 — A partida anterior não poderá ser alterada após seu encerramento.
- RN11 — O prazo máximo para reconexão será de 10 segundos.
- RN12 — A reconexão dentro do prazo deverá preservar o tabuleiro e o turno.
- RN13 — A expiração do prazo de reconexão resultará no encerramento da partida.
- RN14 — Quando a desconexão de um jogador for confirmada e o prazo expirar, o adversário conectado receberá a vitória.
- RN15 — Falhas gerais do servidor não deverão atribuir vitória ou derrota injustamente.
- RN16 — Somente partidas online contabilizarão para o rating.
- RN17 — O rating determinará automaticamente a liga do jogador.
- RN18 — O perfil não deverá apresentar histórico de partidas.

## 4. Sistema de classificação

O Bubbles utilizará cinco ligas competitivas:

- Bronze;
- Prata;
- Ouro;
- Platina;
- Diamante.

A classificação será determinada pelo rating do jogador. As faixas numéricas ainda deverão ser validadas.

## 5. Requisitos não funcionais

- RNF01 — A interface deverá ser intuitiva e de fácil utilização.
- RNF02 — O sistema deverá manter identidade visual consistente.
- RNF03 — A interface deverá ser responsiva.
- RNF04 — O sistema deverá funcionar em navegadores compatíveis com as tecnologias adotadas.
- RNF05 — O sistema deverá oferecer compatibilidade com Android.
- RNF06 — As senhas deverão ser armazenadas utilizando hash seguro.
- RNF07 — A comunicação online deverá utilizar mecanismos adequados de criptografia.
- RNF08 — O sistema deverá validar as operações recebidas para evitar jogadas inválidas e manipulação do estado da partida.
- RNF09 — O sistema deverá tratar erros de comunicação e desconexões.
- RNF10 — O sistema deverá preservar a consistência das partidas entre os participantes.
- RNF11 — O sistema deverá permitir manutenção e evolução.
- RNF12 — O projeto deverá ser desenvolvido e demonstrado sem custos financeiros obrigatórios.

## 6. Restrições do projeto

- O projeto deverá utilizar ferramentas e serviços gratuitos.
- O código-fonte deverá ficar disponível em repositório público no GitHub.
- O front-end deverá utilizar HTML, CSS e JavaScript.
- O back-end deverá utilizar uma linguagem compatível com as opções indicadas na situação-problema do PIT II.
- A arquitetura deverá considerar o padrão MVC.
- O banco de dados deverá utilizar um SGBD adequado ao projeto.

## 7. Funcionalidades futuras ou fora do escopo inicial

- Recuperação de senha por e-mail.
- Funcionalidades adicionais de competição ainda não especificadas.

## 8. Pontos que exigem validação técnica

- Descoberta automática de dispositivos na rede Wi-Fi por navegadores e Android.
- Autenticação offline segura e sincronização de dados.
- Armazenamento e sincronização dos avatares.
- Comunicação P2P nas partidas online.
- Serviço gratuito de matchmaking e sinalização.
- Hospedagem gratuita e limites de utilização.
- Cálculo matemático do rating e definição das faixas das ligas.
