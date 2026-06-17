const API = "http://localhost:8080/arqweb1-01";

function montarMenu() {
    const logado = sessionStorage.getItem("autenticado") === "true";
    const menu = document.getElementById("menu");

    if (logado) {
        menu.innerHTML = `
                <li class="nav-item"><a class="nav-link" href="index.html">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="sobre.html">Sobre</a></li>
                <li class="nav-item"><a class="nav-link" href="cadastrar.html">Cadastrar Notícia</a></li>
                <li class="nav-item"><a class="nav-link" href="listar.html">Notícias</a></li>
                <li class="nav-item"><a class="nav-link text-danger" href="#" onclick="logout()">Sair</a></li>
            `;
    } else {
        menu.innerHTML = `
                <li class="nav-item"><a class="nav-link" href="index.html">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="sobre.html">Sobre</a></li>
                <li class="nav-item"><a class="nav-link" href="login.html">Login</a></li>
            `;
    }
}

function pegarIdDaUrl() {
    const parametros = new URLSearchParams(window.location.search);
    return parametros.get("id");
}

async function carregarDetalhes() {
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

    document.getElementById("imagem").src = noticia.imagem || "imagens/padrao.jpg";
    document.getElementById("titulo").textContent = noticia.titulo;
    document.getElementById("categoria").textContent = noticia.categoria;
    document.getElementById("autor").textContent = noticia.autor;
    document.getElementById("data").textContent = noticia.data_publicacao;
    document.getElementById("resumo").textContent = noticia.resumo;
    document.getElementById("conteudo").textContent = noticia.conteudo_completo;
    document.getElementById("visualizacoes").textContent = noticia.visualizacoes;

    document.getElementById("btnEditar").href = `editar.html?id=${noticia.id}`;

    if (sessionStorage.getItem("autenticado") !== "true") {
        document.getElementById("btnEditar").style.display = "none";
    }

    document.getElementById("cardNoticia").style.display = "block";
}

async function logout() {
    await fetch(`${API}/logout`, {
        method: "POST",
        credentials: "include"
    });

    sessionStorage.removeItem("autenticado");
    window.location.href = "login.html";
}

montarMenu();
carregarDetalhes();

async function logout() {
    await fetch("http://localhost:8080/arqweb1-01/logout", {
        method: "POST",
        credentials: "include"
    });

    sessionStorage.removeItem("autenticado");
    window.location.href = "login.html";
}

async function logout() {
    await fetch("http://localhost:8080/arqweb1-01/logout", {
        method: "POST",
        credentials: "include"
    });

    sessionStorage.removeItem("autenticado");
    sessionStorage.clear();

    window.location.href = "login.html";
}