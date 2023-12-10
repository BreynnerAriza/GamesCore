<!DOCTYPE html>
<html lang="es">

<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="Breynner Ariza, Laura Ibanez, Emanuel Hiuera">
    <meta name="application-name">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/toastr/toastr.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/AuthStyle.css">
    <title>GamesCore - Login</title>
</head>

<body class="auth__body login__background">


    <form action="" class="verification__form">
        <figure class="figure__logo">
            <img src="${pageContext.request.contextPath}/assets/img/logo.png" alt="Logo gamescore" class="img__logo">
        </figure>   
        <hgroup class="verification__tittles">
            <h1 class="verificatio__tittle">
                Inicia Sesion Ahora
            </h1>
            <h2 class="verification__subtittle">
                Unete a la batalla en diversos mundos con GamesCore
            </h2>
        </hgroup>
             
        <div class="verification__inputs">
            <div class="input__group">
                <i class="fa-solid fa-envelope verification__icon"></i>
                <input type="email" class="verification__input" id="email" name="email" placeholder="Correo@gmail.com">
            </div>
            <div class="input__group">
                <i class="fa-solid fa-lock verification__icon"></i>
                <input type="password" class="verification__input" id="password" name="password"
                    placeholder="Contraseña">
                <i class="fa-solid fa-eye-low-vision icon__vision" onclick="login.showPassword()"></i>
            </div>
            <div class="input__group">
                <input type="button" class="verification__submit" value="Iniciar sesion" onclick="login.login()">
            </div>
        </div>
        <p class="verification__paragraph">
            No tienes cuenta? <a href="${pageContext.request.contextPath}/assets/views/RegisterView.jsp" class="verification__cta">Registrate ahora</a>
        </p>
    </form>

    <script src="https://kit.fontawesome.com/d2ec2ed15a.js" crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/assets/js/LoginJs.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/UtilsJs.js"></script>
    <script src="${pageContext.request.contextPath}/assets/plugins/jquery/jquery-3.7.1.js"></script>
    <script src="${pageContext.request.contextPath}/assets/plugins/toastr/toastr.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/plugins/toastr/toastr.js"></script>
</body>

</html>