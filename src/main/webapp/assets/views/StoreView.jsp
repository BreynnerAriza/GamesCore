<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Tienda gamescore">
    <meta name="author" content="Breynner, Emanuel, Laura">
    <title>Gamescore Store</title>
    <!-- Bootstrap core CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/IndexStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/toastr/toastr.min.css">
</head>

<body style="padding: 0;background-color: #dee2e6;" class="container-fluid">


<!-- Inclur menu -->
<jsp:include page="/WEB-INF/components/MenuView.jsp"/>

<!--Menu tienda-->
<div class="container-fluid" id="tienda">
    <div class="container bg-light mt-3 mb-3">
        <nav class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
            <a href="" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">
                <img src="${pageContext.request.contextPath}/assets/img/logo.png" alt="Logo gamescore" width="65"
                     height="auto" class="d-inline-block align-text-top navbar-brand">
            </a>
            <div class="col-md-3 text-end">
                <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
                    <input type="search" class="form-control" placeholder="Search..." aria-label="Search">
                </form>
            </div>
        </nav>
        <!--Tarjetas-->
        <div class="album py-3">
            <div class="container">
                <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">

                    <c:forEach var="videogameL" items="${videogames}">
                        <!--Primera ilera-->
                        <div class="col">
                            <div class="card shadow-sm">
                                <img class="bd-placeholder-img card-img-top  img__card" height="350px"
                                     src="${pageContext.request.contextPath}/assets/img/Img-tienda/${videogameL.images[0]}">
                                <div class="card-body">
                                    <p class="mb-0"><Strong>${videogameL.name}</Strong></p>
                                    <p class="mb-0">${videogameL.description[0]}</p>
                                    <p class="mb-0 text-success">$${videogameL.price}</p>
                                    <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                                        <a class="btn btn-info me-md-2" type="button" href="${pageContext.request.contextPath}/FrontController?path=VideoGame&action=Mostrar&VideoGameReq=${videogameL._id}">Ver mas <i class="bi bi-eye"></i></a>
                                        <button onclick="trolley.agregar('${videogameL._id}')" class="btn btn-warning"
                                                type="button">Añadir<i
                                                class="bi bi-basket2 ms-2"></i></button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
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

<!-- Inclur footer -->
<jsp:include page="/WEB-INF/components/FooterView.jsp"/>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/TrolleyJs.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/UtilsJs.js"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/jquery/jquery-3.7.1.js"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/toastr/toastr.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/toastr/toastr.js"></script>
</body>

</html>