# DOCUMENTAÇÃO DE INTERFACE HUMANO-COMPUTADOR (IHC)
## Projeto Bubbles — Versão 1.0

### 1. Introdução

O projeto Bubbles apresenta uma interface web para um jogo da velha com temática visual inspirada em bolhas e elementos de praia. A proposta é oferecer uma experiência simples, intuitiva e agradável, permitindo que dois jogadores participem de uma partida no mesmo dispositivo.

A interface foi planejada para facilitar a navegação entre as funcionalidades do sistema, apresentar informações de maneira organizada e fornecer respostas visuais às ações realizadas pelos jogadores.

### 2. Objetivos da interface

A interface do Bubbles tem como principais objetivos:

- Facilitar a utilização do sistema por meio de elementos visuais intuitivos.
- Permitir o acesso às funcionalidades de cadastro, login, jogo, perfil e ranking.
- Apresentar informações importantes de maneira clara e organizada.
- Fornecer mensagens de confirmação, orientação e erro.
- Diferenciar visualmente os dois participantes da partida.
- Adaptar a apresentação das telas a diferentes tamanhos de dispositivos.

### 3. Identidade visual

A identidade visual do Bubbles utiliza uma combinação de cores suaves e elementos gráficos lúdicos, buscando transmitir uma experiência descontraída e amigável.

As principais características visuais identificadas nos arquivos CSS são:

- **Cores:** predominância de rosa, azul, roxo e branco.
- **Planos de fundo:** utilização de gradientes em tons de rosa e azul.
- **Elementos:** cartões com cantos arredondados, botões destacados e campos de formulário.
- **Tipografia:** títulos e textos organizados para facilitar a leitura.
- **Temática:** elementos de bolhas e cenário de praia na tela do jogo.
- **Animações:** efeitos visuais relacionados ao ambiente e à comemoração de vitórias.

A identidade visual busca manter consistência entre as diferentes telas do sistema.

### 4. Estrutura das interfaces

#### 4.1. Tela de cadastro

A tela de cadastro permite que um novo jogador crie sua conta no sistema.

Os campos identificados na implementação são:

- Nickname;
- Senha;
- E-mail opcional.

A interface utiliza um formulário centralizado, com campos de entrada, botão de confirmação e elementos de navegação.

O sistema apresenta mensagens de erro quando ocorre algum problema durante o cadastro, como nickname duplicado ou informações inválidas.

#### 4.2. Tela de login

A tela de login permite que o jogador acesse sua conta utilizando nickname e senha.

A interface segue o padrão visual dos formulários do sistema, mantendo consistência com a tela de cadastro.

Quando a autenticação é realizada com sucesso, o jogador é direcionado à página inicial. Caso as credenciais estejam incorretas, o sistema apresenta uma mensagem informativa.

#### 4.3. Página inicial

A página inicial funciona como ponto central de navegação do Bubbles.

Sua estrutura visual apresenta um painel principal, identificação do jogador e opções de acesso às funcionalidades disponíveis.

As opções identificadas no sistema incluem:

- Acessar o jogo;
- Consultar o perfil;
- Consultar o ranking;
- Encerrar a sessão.

A organização em cartões e botões busca facilitar a identificação das funcionalidades.

#### 4.4. Tela do jogo

A tela do jogo é a principal interface de interação do Bubbles.

Ela utiliza a temática Bubbles - Beach Arcade, com elementos visuais inspirados em praia, mar, areia e bolhas.

A interface apresenta:

- Tabuleiro com nove posições, organizadas em três linhas e três colunas;
- Identificação dos jogadores;
- Diferenciação entre as cores azul e rosa;
- Indicação do jogador da vez;
- Mensagens sobre o andamento da partida;
- Formulário para autenticação do segundo jogador;
- Opções de iniciar, reiniciar ou encerrar a participação do segundo jogador;
- Indicação do resultado da partida.

As posições do tabuleiro são atualizadas conforme as jogadas realizadas. O JavaScript também atualiza visualmente as posições ocupadas e desabilita os campos que não podem mais receber jogadas.

Quando ocorre uma vitória, a interface pode apresentar uma animação comemorativa com bolhas.

#### 4.5. Tela de perfil

A tela de perfil reúne informações relacionadas ao jogador.

A estrutura visual identificada no CSS contempla:

- Identificação do jogador;
- Informações estatísticas;
- Rating competitivo;
- Classificação por liga;
- Histórico de partidas;
- Resultados de vitórias, derrotas e empates.

O histórico é apresentado em uma estrutura organizada, permitindo a consulta das partidas registradas.

#### 4.6. Tela de ranking

A tela de ranking apresenta a classificação geral dos jogadores.

A interface utiliza uma tabela para organizar os participantes e suas posições.

Os elementos visuais identificados incluem:

- Posição no ranking;
- Nickname;
- Rating;
- Identificação da liga;
- Destaques visuais para as posições;
- Mensagem para situações em que não existem jogadores cadastrados no ranking.

A organização permite comparar os resultados dos participantes de maneira objetiva.

### 5. Navegação e fluxo de utilização

O fluxo principal de navegação do sistema é organizado da seguinte maneira:

1. O jogador acessa a tela de login.
2. Caso ainda não possua uma conta, pode acessar o cadastro.
3. Após realizar a autenticação, é direcionado à página inicial.
4. Na página inicial, pode acessar o jogo, o perfil ou o ranking.
5. Para iniciar uma partida, o jogador principal autentica o segundo participante.
6. Com os dois jogadores autenticados, a partida pode ser iniciada.
7. Durante a partida, os jogadores realizam suas jogadas alternadamente.
8. Ao término, o resultado é registrado e os ratings são atualizados.
9. Os jogadores podem consultar suas informações e o ranking.

### 6. Usabilidade e experiência do usuário

A interface considera princípios de usabilidade para tornar a interação mais simples e compreensível.

**Consistência:** as telas utilizam elementos visuais semelhantes, como cores, cartões, botões e formulários.

**Visibilidade do estado do sistema:** durante a partida, são apresentadas informações sobre o jogador da vez e o resultado.

**Prevenção de erros:** posições ocupadas são desabilitadas, e jogadas inválidas são rejeitadas pelo sistema.

**Feedback:** mensagens informam o resultado de operações como cadastro, login e realização de jogadas.

**Facilidade de navegação:** as funcionalidades são organizadas em páginas específicas, acessíveis por meio da navegação do sistema.

**Reconhecimento:** os jogadores são diferenciados pelas cores azul e rosa, facilitando a identificação durante a partida.

### 7. Mensagens de erro e feedback

O sistema utiliza mensagens para informar o usuário sobre o resultado de suas operações.

Entre as situações previstas ou identificadas na implementação estão:

| Situação | Resposta do sistema |
|---|---|
| Cadastro realizado | Mensagem de confirmação |
| Nickname já utilizado | Mensagem de erro |
| Dados de login incorretos | Mensagem de autenticação inválida |
| Acesso sem autenticação | Redirecionamento para login |
| Segundo jogador não autenticado | Impedimento de iniciar a partida |
| Tentativa de utilizar a mesma conta | Bloqueio da operação |
| Jogada em posição ocupada | Rejeição da jogada |
| Jogada inválida | Mensagem de erro |
| Vitória ou empate | Apresentação do resultado |
| Partida registrada | Indicação de registro concluído |

As mensagens devem ser apresentadas de maneira objetiva, evitando termos técnicos desnecessários para o usuário.

### 8. Responsividade

Os estilos CSS incluem regras de adaptação para diferentes dimensões de tela.

Foram identificadas configurações específicas para dispositivos com largura reduzida, incluindo ajustes na disposição dos elementos e nos componentes das páginas.

A responsividade busca manter a legibilidade, a organização dos formulários e a facilidade de interação em computadores e dispositivos móveis.

A validação efetiva em diferentes aparelhos ainda deve ser realizada durante os testes da interface.

### 9. Acessibilidade

O projeto considera aspectos básicos de acessibilidade na construção das interfaces.

Entre os cuidados identificados ou recomendados estão:

- Manter contraste adequado entre textos e fundos.
- Utilizar textos objetivos nas mensagens.
- Manter dimensões apropriadas para botões e campos.
- Evitar depender exclusivamente das cores para comunicar informações.
- Preservar a organização visual dos elementos.
- Respeitar a preferência do usuário por redução de movimento, por meio da configuração `prefers-reduced-motion` identificada no CSS do jogo.

A verificação completa de acessibilidade depende de testes adicionais com as páginas renderizadas.

### 10. Recursos de interação

O sistema utiliza HTML, CSS e JavaScript para estruturar e apresentar as interfaces.

Na tela do jogo, o JavaScript realiza requisições assíncronas ao back-end por meio de `fetch`, enviando os dados das jogadas para a rota `/jogo/jogada-ajax`.

Após receber a resposta, a interface atualiza o tabuleiro, o jogador da vez, as mensagens e o resultado, sem depender necessariamente do recarregamento completo da página.

Esse comportamento contribui para uma experiência de interação mais fluida.

### 11. Considerações finais

A interface do Bubbles busca combinar simplicidade, organização e identidade visual própria, proporcionando uma experiência de utilização adequada à proposta de um jogo da velha competitivo.

A separação das funcionalidades em telas específicas, a utilização de feedback visual, a diferenciação dos participantes e a adaptação dos componentes contribuem para a usabilidade do sistema.

A documentação poderá ser complementada após a conferência dos arquivos HTML, a captura das telas finais e a realização de testes de usabilidade e acessibilidade.
