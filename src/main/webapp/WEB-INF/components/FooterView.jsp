<div class="container-fluid bg-dark  position-absolute">
    <div class="container">
        <footer class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
            <p class="col-md-4 mb-0 text-muted">&copy; 2023 GamesCore</p>
            <a href="#"
               class="col-md-4 d-flex align-items-center justify-content-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none">
                <img src="${pageContext.request.contextPath}/assets/img/logo.png" width="100px" alt="">
            </a>

            <ul class="nav col-md-4 justify-content-end">
                <li class="nav-item"><a href="${pageContext.request.contextPath}/FrontController?path=Home" class="nav-link px-2 text-muted">Inicio</a></li>
                <li class="nav-item"><a href="${pageContext.request.contextPath}/FrontController?path=VideoGame&action=Listar" class="nav-link px-2 text-muted">Tienda</a></li>
                <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">Perfil</a></li>
                <li class="nav-item"><a href="${pageContext.request.contextPath}/FrontController?path=Trolley&action=Listar" class="nav-link px-2 text-muted">Carrito</a></li>
            </ul>
        </footer>
    </div>
</div>