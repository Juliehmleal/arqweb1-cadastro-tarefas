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
            `;
    }
}

document.getElementById("formLogin").addEventListener("submit", async function(e) {
    e.preventDefault();

    const dados = new URLSearchParams();
    dados.append("login", this.login.value);
    dados.append("senha", this.senha.value);

    const resposta = await fetch(`${API}/login`, {
        method: "POST",
        body: dados,
        credentials: "include"
    });

    const resultado = await resposta.json();

    if (resposta.status === 200) {
        sessionStorage.setItem("autenticado", "true");
        window.location.href = "index.html";
    } else {
        document.getElementById("mensagem").innerHTML = `
                <div class="alert alert-danger">
                    ${resultado.mensagem}
                </div>
            `;
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