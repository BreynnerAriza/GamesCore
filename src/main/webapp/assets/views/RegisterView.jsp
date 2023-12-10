<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Este es el registro de ListFull">
    <meta name="keywords" content="Lista, tareas, organizacion, listfull">
    <meta name="author" content="Breynner Ariza">
    <meta name="application-name">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/toastr/toastr.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/AuthStyle.css">
    <title>Registro</title>
</head>

<body class="auth__body register__background">


    <form action="" id="register" class="verification__form">
            
        <hgroup class="verification__tittles">
            <h1 class="verificatio__tittle">
                Registrate ahora
            </h1>
            <h2 class="verification__subtittle">
                Registrate para que formes parte de la familia LisftFull
            </h2>
        </hgroup>
        <figure class="figure__logo">
            <img src="${pageContext.request.contextPath}/assets/img/logo.png" alt="Logo gamescore" class="img__logo">
        </figure> 
        <div class="verification__inputs">
            <div class="input__group">
                <i class="fa-solid fa-user-secret verification__icon"></i>
                <input type="text" class="verification__input" id="nick" name="nick" placeholder="Usuario o apodo">
            </div>
            <div class="input__group">
                <i class="fa-solid fa-envelope verification__icon"></i>
                <input type="email" class="verification__input" id="email" name="email" placeholder="Correo@gmail.com">
            </div>
            <div class="input__group">
                <i class="fa-solid fa-lock verification__icon"></i>
                <input type="password" class="verification__input" id="password" name="password"
                    placeholder="Contraseña">
                <i class="fa-solid fa-eye-low-vision icon__vision" onclick="register.showPassword()"></i>
            </div>
            <div class="input__group">
                <i class="fa-solid fa-lock verification__icon"></i>
                <input type="password" class="verification__input" id="confirmPassword" name="confirmPassword"
                    placeholder="Confirmar contraseña">
                <i class="fa-solid fa-eye-low-vision icon__vision" onclick="register.showConfirmPassword()"></i>
            </div>
            <div class="input__group">
                <input type="button" class="verification__submit" value="Registrar" onclick="register.register()">
            </div>
        </div>
        <p class="verification__paragraph">
            Ya tienes cuenta? <a href="${pageContext.request.contextPath}/assets/views/LoginView.jsp" class="verification__cta">Inicia Sesion</a>
        </p>
    </form>

    <script src="https://kit.fontawesome.com/d2ec2ed15a.js" crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/assets/js/RegisterJs.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/UtilsJs.js"></script>
    <script src="${pageContext.request.contextPath}/assets/plugins/jquery/jquery-3.7.1.js"></script>
    <script src="${pageContext.request.contextPath}/assets/plugins/toastr/toastr.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/plugins/toastr/toastr.js"></script>

</html>