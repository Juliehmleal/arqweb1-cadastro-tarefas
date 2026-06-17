const API = "http://localhost:8080/arqweb1-01";

function montarMenu() {
    const logado = sessionStorage.getItem("autenticado") === "true";
    const menu = document.getElementById("menu");

    if (!logado) {
        window.location.href = "login.html";
        return;
    }

    menu.innerHTML = `
            <li class="nav-item"><a class="nav-link" href="index.html">Home</a></li>
            <li class="nav-item"><a class="nav-link" href="sobre.html">Sobre</a></li>
            <li class="nav-item"><a class="nav-link" href="cadastrar.html">Cadastrar Notícia</a></li>
            <li class="nav-item"><a class="nav-link" href="listar.html">Notícias</a></li>
            <li class="nav-item"><a class="nav-link text-danger" href="#" onclick="logout()">Sair</a></li>
        `;
}

function pegarIdDaUrl() {
    const parametros = new URLSearchParams(window.location.search);
    return parametros.get("id");
}

async function carregarNoticia() {
    const id = pegarIdDaUrl();

    if (!id) {
        document.getElementById("mensagem").innerHTML =
            `<div class="alert alert-danger">ID da notícia não informado.</div>`;
        return;
    }

    const resposta = await fetch(`${API}/detalhes?id=${id}`, {
        credentials: "include"
    });

    const noticia = await resposta.json();

    if (resposta.status !== 200) {
        document.getElementById("mensagem").innerHTML =
            `<div class="alert alert-danger">${noticia.mensagem}</div>`;
        return;
    }

    document.getElementById("id").value = noticia.id;
    document.getElementById("titulo").value = noticia.titulo;
    document.getElementById("autor").value = noticia.autor;
    document.getElementById("categoria").value = noticia.categoria;
    document.getElementById("resumo").value = noticia.resumo;
    document.getElementById("conteudo").value = noticia.conteudo_completo;

    if (noticia.imagem) {
        document.getElementById("imagem").value = noticia.imagem;
        document.getElementById("previewImagem").src = noticia.imagem;
    }
}

document.getElementById("imagem").addEventListener("change", function () {
    document.getElementById("previewImagem").src = this.value;
});

document.getElementById("formEditar").addEventListener("submit", async function(e) {
    e.preventDefault();

    const dados = new URLSearchParams();

    dados.append("id", document.getElementById("id").value);
    dados.append("titulo", document.getElementById("titulo").value);
    dados.append("autor", document.getElementById("autor").value);
    dados.append("categoria", document.getElementById("categoria").value);
    dados.append("resumo", document.getElementById("resumo").value);
    dados.append("conteudo_completo", document.getElementById("conteudo").value);
    dados.append("imagem", document.getElementById("imagem").value);

    const resposta = await fetch(`${API}/editar`, {
        method: "POST",
        body: dados,
        credentials: "include"
    });

    const resultado = await resposta.json();

    if (resposta.status === 200) {
        document.getElementById("mensagem").innerHTML =
            `<div class="alert alert-success">
                    Notícia atualizada com sucesso! Redirecionando para a Home...
                </div>`;

        setTimeout(() => {
            window.location.href = "index.html";
        }, 2000);
    }

    if (resposta.status === 400) {
        let erros = "";

        if (resultado.problemas) {
            resultado.problemas.forEach(p => erros += `<li>${p}</li>`);
        }

        document.getElementById("mensagem").innerHTML =
            `<div class="alert alert-danger">
                    <strong>${resultado.mensagem}</strong>
                    <ul>${erros}</ul>
                </div>`;
    }

    if (resposta.status === 401) {
        sessionStorage.removeItem("autenticado");
        window.location.href = "login.html";
    }
});

async function logout() {
    await fetch(`${API}/logout`, {
        method: "POST",
        credentials: "include"
    });

    sessionStorage.removeItem("autenticado");
    window.location.href = "login.html";
}

async function excluirNoticia() {

    const id = document.getElementById("id").value;

    if (!confirm("Deseja realmente excluir esta notícia?")) {
        return;
    }

    const dados = new URLSearchParams();
    dados.append("id", id);

    const resposta = await fetch(`${API}/excluir`, {
        method: "POST",
        body: dados,
        credentials: "include"
    });

    const resultado = await resposta.json();

    if (resposta.status === 200) {

        document.getElementById("mensagem").innerHTML = `
            <div class="alert alert-success">
                Notícia excluída com sucesso!
            </div>
        `;

        setTimeout(() => {
            window.location.href = "index.html";
        }, 1500);
    }

    if (resposta.status === 400) {

        document.getElementById("mensagem").innerHTML = `
            <div class="alert alert-danger">
                ${resultado.mensagem}
            </div>
        `;
    }

    if (resposta.status === 401) {

        sessionStorage.removeItem("autenticado");
        window.location.href = "login.html";
    }
}

montarMenu();
carregarNoticia();

