
document.addEventListener("DOMContentLoaded", function () {

    const formularios = document.querySelectorAll(
        'form[action*="/jogo/jogada"]'
    );

    let enviandoJogada = false;

    formularios.forEach(function (formulario) {

        formulario.addEventListener("submit", async function (evento) {

            evento.preventDefault();

            if (enviandoJogada) {
                return;
            }

            const dados = new FormData(formulario);
            const botao = formulario.querySelector("button");

            enviandoJogada = true;

            if (botao) {
                botao.disabled = true;
            }

            try {

                const resposta = await fetch("/jogo/jogada-ajax", {
                    method: "POST",
                    body: dados,
                    headers: {
                        "X-Requested-With": "XMLHttpRequest"
                    }
                });

                const dadosResposta = await resposta.json();

                if (!resposta.ok || !dadosResposta.sucesso) {
                    throw new Error(
                        dadosResposta.mensagem || "Não foi possível realizar a jogada."
                    );
                }

                atualizarTabuleiro(dadosResposta);

            } catch (erro) {

                alert(erro.message);

                if (botao) {
                    botao.disabled = false;
                }

            } finally {
                enviandoJogada = false;
            }

        });

    });

    function atualizarTabuleiro(dados) {

        const celulas = document.querySelectorAll(".celula");

        dados.tabuleiro.forEach(function (linha, i) {

            linha.forEach(function (valor, j) {

                const indice = i * 3 + j;
                const celula = celulas[indice];

                if (!celula) {
                    return;
                }

                celula.classList.remove("azul", "rosa");
                celula.replaceChildren();

                if (valor === "AZUL") {

                    celula.classList.add("azul");

                    const marcador = document.createElement("span");
                    marcador.className = "marcador-azul";

                    celula.appendChild(marcador);

                } else if (valor === "ROSA") {

                    celula.classList.add("rosa");

                    const marcador = document.createElement("span");
                    marcador.className = "marcador-rosa";

                    celula.appendChild(marcador);
                }

                celula.disabled =
                    valor !== null ||
                    dados.resultado !== "EM_ANDAMENTO";

            });

        });

        atualizarTurno(dados);
        atualizarResultado(dados);
    }

    function atualizarTurno(dados) {

        const turno = document.querySelector(".turno");

        if (!turno) {
            return;
        }

        if (dados.resultado !== "EM_ANDAMENTO") {
            turno.style.display = "none";
            return;
        }

        turno.style.display = "";

        const cor = dados.jogadorAtual === "AZUL" ? "azul" : "rosa";

        turno.innerHTML =
            'Vez de: <span class="' + cor + '">' +
            '<span class="marcador-' + cor + '"></span> ' +
            (cor === "azul" ? "Azul" : "Rosa") +
            '</span>';
    }

    function atualizarResultado(dados) {

        let mensagem = document.querySelector(".mensagem");

        if (dados.resultado === "EM_ANDAMENTO") {
            return;
        }

        if (!mensagem) {
            mensagem = document.createElement("div");
            mensagem.className = "mensagem";

            const tabuleiro = document.querySelector(".tabuleiro");

            tabuleiro.parentNode.insertBefore(mensagem, tabuleiro);
        }

        mensagem.className = "mensagem";

        if (dados.resultado === "VITORIA_AZUL" ||
            dados.resultado === "VITORIA_ROSA") {

            mensagem.classList.add("vitoria");
        }

        const titulo = document.createElement("h2");
        const texto = document.createElement("p");

        if (dados.resultado === "VITORIA_AZUL") {
            titulo.textContent = "Azul venceu!";
        } else if (dados.resultado === "VITORIA_ROSA") {
            titulo.textContent = "Rosa venceu!";
        } else {
            titulo.textContent = "Deu empate!";
        }

        texto.textContent = "Partida registrada!";

        mensagem.replaceChildren(titulo, texto);

        if (dados.resultado === "VITORIA_AZUL" ||
            dados.resultado === "VITORIA_ROSA") {

            iniciarCelebracao();
        }
    }

    function iniciarCelebracao() {

        if (document.querySelector(".celebracao")) {
            return;
        }

        const celebracao = document.createElement("div");
        celebracao.className = "celebracao";
        celebracao.setAttribute("aria-hidden", "true");

        for (let i = 0; i < 12; i++) {
            const bolha = document.createElement("span");
            bolha.className = "bolha-festa";
            celebracao.appendChild(bolha);
        }

        document.body.appendChild(celebracao);
    }

});
