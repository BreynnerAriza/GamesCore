<header class="p-1 bg-dark text-white">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a href="#">
                <img src="${pageContext.request.contextPath}/assets/img/logo.png" alt="Logo gamescore" width="65"
                     height="auto"
                     class="d-inline-block align-text-top navbar-brand">
            </a>
            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="${pageContext.request.contextPath}/FrontController?path=Home" class="nav-link px-2 text-white active">Inicio</a></li>
                <li><a href="${pageContext.request.contextPath}/FrontController?path=VideoGame&action=Listar" class="nav-link px-2 text-white">Tienda</a></li>
                <li><a href="${pageContext.request.contextPath}/FrontController?path=User&action=Profile" class="nav-link px-2 text-white">Perfil</a></li>
                <li><a href="${pageContext.request.contextPath}/FrontController?path=Trolley&action=Listar" class="nav-link px-2 text-white">Carrito (<span class="text-danger">${countTrolley}</span>) </a></li>
            </ul>
            <%if (session.getAttribute("user") == null) { %>
            <div class=" ml-2 text-end">
                <a type="button" href="${pageContext.request.contextPath}/FrontController?path=Auth&action=Login"
                   class="btn btn-outline-light me-2">Login</a>
                <a type="button" href="${pageContext.request.contextPath}/FrontController?path=Auth&action=Register"
                   class="btn btn-warning">Registro</a>
            </div>
            <% } else { %>
            <li class="nav nav-item">
                <a class="nav-link dropdown-toggle show" href="#" data-bs-toggle="dropdown"
                   aria-expanded="true"> ${user.nick} </a>
                <ul class="dropdown-menu show" data-bs-popper="static">
                    <li><a class="dropdown-item" href="#"> Perfil </a></li>
                    <li><a class="dropdown-item"
                           href="${pageContext.request.contextPath}/FrontController?path=Auth&action=CerrarSesion">
                        Cerrar sesion </a></li>
                </ul>
            </li>
            <%
                }%>
        </div>
    </div>
</header>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>