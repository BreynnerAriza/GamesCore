<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Tienda gamescore">
    <meta name="author" content="Breynner, Emanuel, Laura">
    <title>Gamescore trolley</title>
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

<div class="container-fluid" id="tienda">

    <div class="container bg-light mt-3 mb-3 p-5">
        <a href="" class="d-flex p-3 w-100 align-items-center justify-content-center">
            <img src="${pageContext.request.contextPath}/assets/img/logo.png" alt="Logo gamescore" width="100"
                 height="auto"
                 class="d-inline-block align-text-top navbar-brand">
        </a>
        <% if (Integer.parseInt(request.getSession().getAttribute("count").toString()) == 0) { %>
        <h2 class="text-center">El carrito se encuentra vacio</h2>
        <p class="text-center">Visita nuestra tienda para ver espectaculares juegos</p>
        <div class="text-center">
            <a href="${pageContext.request.contextPath}/FrontController?path=VideoGame&action=Listar" class="btn btn-outline-primary">Ir a tienda</a>
        </div>

        <%} else {%>
        <table class="table">
            <thead>
            <tr class="text-center">
                <th scope="col"></th>
                <th scope="col">Titulo</th>
                <th scope="col">Valor</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${trolley}" var="trolleyB">
                <tr class="text-center">
                    <td><img src="${pageContext.request.contextPath}/assets/img/Img-tienda/${trolleyB.images[0]}"
                             alt="Logo gamescore"
                             width="50"
                             height="auto"
                             class="d-inline-block align-text-top navbar-brand"></td>
                    <td>${trolleyB.name}</td>
                    <td>${trolleyB.price}</td>
                    <td class="text-center">
                        <button class="btn btn-outline-primary" onclick="trolley.eliminar('${trolleyB._id}')">Eliminar
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
            <tfoot>
            <tr>
                <td></td>
                <td class="text-center">Total</td>
                <td class="text-center">${total}</td>
                <td colspan="2" class="text-center">
                    <button type="button" class="btn btn-primary" onclick="user.comprarCarrito()">Terminar compra</button>
                </td>
            </tr>
            </tfoot>
        </table>
        <%}%>
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