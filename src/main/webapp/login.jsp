<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<jsp:include page="/includes/header.jsp" />

<body class="bg-light">

<div class="d-flex justify-content-center align-items-center">
    <div class="card p-4 shadow" style="width: 600px" align-i>
        <h3 class="text-center">Login</h3>

        <form action="login" method="post">

            <div class="mb-3">
                <label>Email</label>
                <input type="email" name="email" class="form-control" required>
            </div>

            <div class="mb-3">
                <label>Senha</label>
                <input type="password" name="senha" class="form-control" required>
            </div>

            <button type="submit" class="btn btn-primary w-100">
                Entrar
            </button>
        </form>
        <a href="index.jsp" class="btn btn-secondary mt-3 w-100">Voltar</a>

    </div>
</div>

</body>
</html>