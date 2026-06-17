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

document.getElementById("imagem").addEventListener("change", function () {
    document.getElementById("previewImagem").src = this.value;
});

document.getElementById("formCadastro").addEventListener("submit", async function(e) {
    e.preventDefault();

    const dados = new URLSearchParams();
    dados.append("titulo", this.titulo.value);
    dados.append("autor", this.autor.value);
    dados.append("categoria", this.categoria.value);
    dados.append("resumo", this.resumo.value);
    dados.append("conteudo_completo", this.conteudo_completo.value);
    dados.append("imagem", document.getElementById("imagem").value);

    const resposta = await fetch(`${API}/cadastrar`, {
        method: "POST",
        body: dados,
        credentials: "include"
    });

    const resultado = await resposta.json();

    if (resposta.status === 200) {
        document.getElementById("mensagem").innerHTML =
            `<div class="alert alert-success">
                    Notícia cadastrada com sucesso! Redirecionando para a Home...
                </div>`;

        this.reset();
        document.getElementById("previewImagem").src = "imagens/padrao.jpg";

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

montarMenu();

async function logout() {
    await fetch("http://localhost:8080/arqweb1-01/logout", {
        method: "POST",
        credentials: "include"
    });

    sessionStorage.removeItem("autenticado");
    window.location.href = "login.html";
}