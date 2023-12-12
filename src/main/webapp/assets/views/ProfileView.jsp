<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Tienda gamescore">
    <meta name="author" content="Breynner, Emanuel, Laura">
    <title>Gamescore profile</title>
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

<section class="py-5 text-center container">
    <div class="row py-lg-5">
        <div class="col-lg-6 col-md-8 mx-auto">
            <h1 class="fw-light">!Bienvenido ${user.nick}!</h1>
            <p class="lead text-muted">¡Bienvenido a GamesCore! Tu destino para experiencias de juego únicas. Explora tu
                propia "Biblioteca Personal de Aventuras" con los juegos que has comprado. ¡Sumérgete en emocionantes
                mundos virtuales con un solo clic! ¡Que disfrutes cada momento en GamesCore!</p>
            <p>
                <a href="#juegos" class="btn btn-primary my-2">Comenzar </a>
            </p>
        </div>
    </div>
</section>

<div class="album py-5 bg-light" id="juegos">
    <div class="container">
        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
            <c:forEach var="acquired" items="${library}">
            <div class="col">
                <div class="card shadow-sm">
                    <img class="bd-placeholder-img card-img-top" width="360px"
                         src="${pageContext.request.contextPath}/assets/img/Img-tienda/${acquired.images[1]}">
                    <div class="card-body">
                        <p><strong>${acquired.name}</strong></p>
                        <p class="card-text">${acquired.description[0]}</p>
                        <div class="d-flex justify-content-between align-items-center">
                            <div class="btn-group">
                                <button type="button" class="btn btn-sm btn-danger">Devolver <i class="bi bi-trash"></i>
                                </button>
                                <button type="button" class="btn btn-sm btn-success">Jugar <i
                                        class="bi bi-controller"></i></button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
        <div class="container mt-3 pb-3">
            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-center">
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item"><a class="page-link" href="#">4</a></li>
                    <li class="page-item"><a class="page-link" href="#">5</a></li>
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</div>


<jsp:include page="/WEB-INF/components/FooterView.jsp"/>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/TrolleyJs.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/UserJs.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/UtilsJs.js"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/jquery/jquery-3.7.1.js"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/toastr/toastr.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/toastr/toastr.js"></script>
</body>
</html>