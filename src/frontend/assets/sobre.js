function montarMenu() {
    const logado = sessionStorage.getItem("autenticado") === "true";
    const menu = document.getElementById("menu");

    if (logado) {
        menu.innerHTML = `
                <li class="nav-item"><a class="nav-link" href="index.html">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="sobre.html">Sobre</a></li>
                <li class="nav-item"><a class="nav-link" href="cadastrar.html">Cadastrar Notícias</a></li>
                <li class="nav-item"><a class="nav-link" href="listar.html">Notícias</a></li>
                <li class="nav-item"><a class="nav-link text-danger" href="#" onclick="logout()">Sair</a></li>
            `;
    } else {
        menu.innerHTML = `
                <li class="nav-item"><a class="nav-link" href="index.html">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="listar.html">Noticias</a></li>
                <li class="nav-item"><a class="nav-link" href="login.html">Login</a></li>
            `;
    }
}

async function logout() {
    await fetch("http://localhost:8080/arqweb1-01/logout", {
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