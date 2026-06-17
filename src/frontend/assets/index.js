const API = "http://localhost:8080/arqweb1-01";

function montarMenu() {
    const logado = sessionStorage.getItem("autenticado") === "true";

    const menu = document.getElementById("menu");
    const areaLogin = document.getElementById("areaLogin");

    if (logado) {
        menu.innerHTML = `
            <li class="nav-item"><a class="nav-link" href="index.html">Home</a></li>
            <li class="nav-item"><a class="nav-link" href="sobre.html">Sobre</a></li>
            <li class="nav-item"><a class="nav-link" href="cadastrar.html">Cadastrar Notícia</a></li>
            <li class="nav-item"><a class="nav-link" href="listar.html">Notícias</a></li>
            <li class="nav-item"><a class="nav-link text-danger" href="#" onclick="logout()">Sair</a></li>
        `;

        areaLogin.innerHTML = " ";
    } else {
        menu.innerHTML = `
            <li class="nav-item">
                <a class="nav-link" href="index.html">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="sobre.html">Sobre</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="listar.html">Notícias</a>
            </li>
        `;

        areaLogin.innerHTML = `
            <a href="login.html" class="btn btn-outline-primary">Login</a>
        `;
    }
}

async function carregarNoticias() {
    const resposta = await fetch(`${API}/listar`, {
        credentials: "include"
    });

    const noticias = await resposta.json();

    renderizarNoticias(noticias);
}

function renderizarNoticias(noticias) {
    const lista = document.getElementById("listaNoticias");
    const mensagem = document.getElementById("mensagem");

    lista.innerHTML = "";
    mensagem.innerHTML = "";

    if (noticias.length === 0) {
        mensagem.innerHTML = `
            <div style="display:flex; justify-content:center; align-items:center; min-height:60vh;">
                <div style="text-align:center;">
                    <h2 style="color:#666; font-size:2rem;">Não tem Notícias</h2>
                    <p style="color:#999; margin-top:1rem;">Nenhuma notícia disponível no momento.</p>
                </div>
            </div>
        `;
        return;
    }

    const logado = sessionStorage.getItem("autenticado") === "true";

    noticias.forEach(n => {
        lista.innerHTML += `
            <div class="col-md-4 mb-4 d-flex align-items-stretch">
                <div class="card w-100">
                    <img src="${n.imagem}" class="card-img-top" alt="imagem ${n.categoria}">
                    <div class="card-body d-flex flex-column">
                        <h5 class="card-title">${n.titulo}</h5>
                        <h6 class="card-subtitle mb-2 text-muted">${n.categoria}</h6>
                        <p class="card-text">${n.resumo}</p>

                        <a href="detalhes.html?id=${n.id}" class="btn btn-primary m-2">
                            Ler Notícia
                        </a>

                        ${logado ? `
                            <a href="editar.html?id=${n.id}" class="btn btn-secondary m-2">
                                Editar
                            </a>
                        ` : ""}
                    </div>
                </div>
            </div>
        `;
    });
}

function buscarNoticias() {
    const termo = document.getElementById("campoBusca").value.toLowerCase();

    fetch(`${API}/listar`, {
        credentials: "include"
    })
        .then(resposta => resposta.json())
        .then(noticias => {
            const filtradas = noticias.filter(n =>
                n.titulo.toLowerCase().includes(termo) ||
                n.resumo.toLowerCase().includes(termo) ||
                n.categoria.toLowerCase().includes(termo)
            );

            renderizarNoticias(filtradas);
        });
}

async function logout() {
    const resposta = await fetch(`${API}/logout`, {
        method: "POST",
        credentials: "include"
    });

    if (resposta.status === 200) {
        sessionStorage.removeItem("autenticado");
        window.location.href = "index.html";
    }

    if (resposta.status === 401) {
        sessionStorage.removeItem("autenticado");
        window.location.href = "index.html";
    }
}

montarMenu();
carregarNoticias();
