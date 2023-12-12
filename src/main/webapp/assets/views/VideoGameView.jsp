<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html lang="es">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Tienda gamescore">
    <meta name="author" content="Breynner, Emanuel, Laura">
    <title>Gamescore ${videoGame.name}</title>
    <!-- Bootstrap core CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/IndexStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/toastr/toastr.min.css">
</head>

<body style="padding: 0;background-color: #dee2e6;" class="container-fluid">

<!-- Menu -->
<jsp:include page="/WEB-INF/components/MenuView.jsp"/>

<!--Encabezado tienda-->
<div class="position-relative overflow-hidden p-3 p-md-5 text-center background__videogame">
    <div class="col-md-5 p-lg-5 mx-auto my-5">
        <h1 class="display-4 fw-normal text-light">${videoGame.name}</h1>
        <p class="lead fw-normal text-light">${videoGame.description[0]}</p>
        <button type="button" class="btn btn-outline-success" onclick="trolley.agregar('${videoGame._id}')">Agregar <i
                class="bi bi-basket2 ms-2"></i></button>
    </div>
    <div class="product-device shadow-sm d-none d-md-block"></div>
    <div class="product-device product-device-2 shadow-sm d-none d-md-block"></div>
</div>

<div class="container m-auto mt-4">
    <div class="ratio ratio-16x9">
        <iframe width="560" height="315" src="${videoGame.video}"
                title="YouTube video player"
                allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                allowfullscreen></iframe>
    </div>
</div>

<div class="row align-items-md-stretch m-4">
    <div class="col-md-6">
        <div class="h-100 p-5 text-white bg-dark rounded-3">
            <h2>${videoGame.name}</h2>
            <p>${videoGame.description[1]}</p>
        </div>
    </div>
    <div class="col-md-6 background__card">
    </div>
</div>

<!--Footer-->
<jsp:include page="/WEB-INF/components/FooterView.jsp"/>

<script>
    const miElemento = document.querySelector('.background__videogame');
    document.documentElement.style.setProperty('--background_presentation', 'url(${pageContext.request.contextPath}/assets/img/Img-tienda/${videoGame.images[1]})');

    const miElemento2 = document.querySelector('.background__card');
    document.documentElement.style.setProperty('--background_card-p', 'url(${pageContext.request.contextPath}/assets/img/Img-tienda/${videoGame.images[2]})');
</script>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/TrolleyJs.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/UtilsJs.js"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/jquery/jquery-3.7.1.js"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/toastr/toastr.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/toastr/toastr.js"></script>

</html>