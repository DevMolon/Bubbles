# Bubbles — Planejamento do Projeto

## 1. Identificação do Projeto

**Nome:** Bubbles

**Tipo:** Jogo digital de estratégia casual.

**Categoria:** Jogo da velha.

**Plataformas:** Navegadores web e dispositivos Android.

**Distribuição Android:** Aplicativo disponibilizado inicialmente por meio de arquivo APK.

**Modalidades:** Multiplayer local e online.

## 2. Descrição do Projeto

O Bubbles consiste no desenvolvimento de uma versão digital do jogo da velha, com uma identidade visual própria, baseada em bolhas coloridas, elementos gráficos divertidos e uma interface intuitiva.

O jogo será desenvolvido para funcionar em navegadores web e dispositivos Android, permitindo partidas entre dois jogadores, tanto localmente quanto pela internet.

Na modalidade online, será estudada a utilização de comunicação peer-to-peer (P2P), permitindo a troca de informações entre os dispositivos dos participantes.

## 3. Objetivo Geral

Desenvolver um jogo da velha multiplataforma, com interface acessível, identidade visual própria e suporte a partidas locais e online entre dois jogadores.

## 4. Objetivos Específicos

- Implementar o tabuleiro e as regras tradicionais do jogo da velha.
- Desenvolver uma interface visual baseada em bolhas coloridas.
- Implementar a alternância de turnos entre os jogadores.
- Identificar automaticamente as condições de vitória e empate.
- Permitir o início de novas partidas.
- Disponibilizar modalidades local e online.
- Desenvolver uma interface adaptável a diferentes tamanhos de tela.
- Investigar e implementar comunicação P2P para partidas online.
- Aplicar mecanismos de validação das jogadas e das mensagens recebidas.
- Disponibilizar o jogo em navegadores e como aplicativo Android.

## 5. Escopo Inicial

O escopo inicial contempla:

- Partidas entre dois jogadores.
- Tabuleiro de três linhas por três colunas.
- Utilização de bolhas coloridas como peças.
- Alternância automática de jogadas.
- Identificação de vitória e empate.
- Possibilidade de reiniciar a partida.
- Modo multiplayer local.
- Modo multiplayer online.
- Interface responsiva.

Não estão previstos inicialmente sistemas de ranking, loja virtual, chat, cadastro obrigatório de usuários ou partidas com mais de dois participantes.

## 6. Plataformas e Distribuição

O projeto será desenvolvido considerando três possibilidades de acesso:

- Computadores por meio de navegadores web.
- Dispositivos Android por meio de navegadores web.
- Dispositivos Android por meio de aplicativo instalado através de arquivo APK.

Inicialmente, não está prevista a publicação do aplicativo na Google Play Store.

## 7. Tecnologias Previstas

As tecnologias abaixo representam possibilidades iniciais, sujeitas à avaliação de viabilidade e compatibilidade com os requisitos do projeto.

- **HTML:** estrutura da interface.
- **CSS:** estilização e apresentação visual.
- **JavaScript:** lógica e interatividade do jogo.
- **Phaser:** possibilidade de utilização como framework para desenvolvimento do jogo.
- **Capacitor:** possibilidade de empacotamento da aplicação web para Android.
- **WebRTC:** possibilidade de utilização na comunicação P2P.
- **Git e GitHub:** controle de versão e disponibilização do código-fonte.

A linguagem do back-end e o sistema gerenciador de banco de dados serão definidos posteriormente, considerando as exigências acadêmicas e as necessidades da aplicação.

## 8. Segurança e Comunicação

A modalidade online deverá considerar mecanismos de segurança para proteger a comunicação entre os participantes.

Serão avaliados recursos de criptografia, validação de mensagens, controle de turnos e verificação da legitimidade das jogadas.

A utilização de comunicação P2P não elimina todos os riscos de segurança. Portanto, deverão ser considerados mecanismos para reduzir possibilidades de manipulação de partidas e comportamentos indevidos dos clientes.

## 9. Considerações Finais

O Bubbles será desenvolvido de maneira incremental, com revisão de requisitos, modelagem, implementação e testes.

Este planejamento representa a proposta inicial do projeto e poderá ser atualizado conforme as necessidades identificadas durante o desenvolvimento e as orientações acadêmicas do PIT II.
