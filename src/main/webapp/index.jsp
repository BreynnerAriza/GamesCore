<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Pagina gamescore para la venta de videojuegos">
    <meta name="author" content="Breynner Ariza, Laura Ibanez, Emanuel Higuera">
    <meta name="generator" content="Hugo 0.84.0">
    <title>GamesCore</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/IndexStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/toastr/toastr.min.css">
</head>
<body style="padding: 0;background-color: #dee2e6;" class="container-fluid">

<!-- Inclur menu -->
<jsp:include page="WEB-INF/components/MenuView.jsp"/>

<div id="carouselExampleCaptions" class="carousel slide">
    <div class="carousel-indicators">
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active"
                aria-current="true" aria-label="Slide 1"></button>
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1"
                aria-label="Slide 2"></button>
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2"
                aria-label="Slide 3"></button>
    </div>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="${pageContext.request.contextPath}/assets/img/Img-home/halo.jpg"
                 class="d-block w-100 img__carrusel" alt="...">
            <div class="carousel-caption d-none d-md-block">
                <h5>Halo Infinite</h5>
                <p>Jefe Maestro lucha para salvar el universo en aventura de mundo abierto</p>
            </div>
        </div>
        <div class="carousel-item">
            <img src="${pageContext.request.contextPath}/assets/img/Img-home/blackangel.jpg"
                 class="d-block w-100 img__carrusel" alt="...">
            <div class="carousel-caption d-none d-md-block">
                <h5>Call of Duty</h5>
                <p>Combate epico, gráficos impactantes y estrategias tacticas en escenarios globales</p>
            </div>
        </div>
        <div class="carousel-item">
            <img src="${pageContext.request.contextPath}/assets/img/Img-home/fallguys.jpg"
                 class="d-block w-100 img__carrusel" alt="...">
            <div class="carousel-caption d-none d-md-block">
                <h5>Fall Guys</h5>
                <p>Diviertete solo o con muchas personas en linea!!</p>
            </div>
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>
</div>

<main>
    <div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-body-tertiary">
        <div class="col-md-6 p-lg-5 mx-auto my-5">
            <h1 class="display-3 fw-bold">Descubre nuevos juegos</h1>
            <h3 class="fw-normal text-muted mb-3"> Bienvenido a la emocionante aventura de descubrir tu nuevo juego
                favorito</h3>
            <div class="d-flex gap-3 justify-content-center lead fw-normal">

            </div>
        </div>
        <div class="product-device shadow-sm d-none d-md-block"></div>
        <div class="product-device product-device-2 shadow-sm d-none d-md-block"></div>
    </div>

    <div class="d-md-flex flex-md-equal w-100 my-md-3 ps-md-3 justify-content-center"
         style="background: linear-gradient(to right, rgb(0, 149, 163), #3e8f49);">
        <div class="text-bg-dark me-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center overflow-hidden w-50">
            <div class="my-3 py-3">
                <h2 class="display-5" style="color: aliceblue; margin-top: 50px;">Entérate</h2>
                <p></p>
                <p class="lead" style="color: aliceblue; margin-top: 50px;">Embárcate en una extraordinaria odisea en el
                    inmenso universo de Minecraft. Forja tu camino a través de paisajes pixelados llenos de creatividad
                    y desafíos. Construye tu propio reino, explora vastos biomas y enfrenta criaturas misteriosas. Con
                    infinitas posibilidades a tu alcance, Minecraft te invita a tejer la narrativa de tu propia aventura
                    única. ¡Sumérgete en este fenómeno global, donde la imaginación no tiene límites y cada bloque
                    cuenta una historia emocionante!</p>
            </div>
            <div class="bg-body-tertiary shadow-sm mx-auto"
                 style="width: 90%; height: 300px; border-radius: 21px 21px 0 0; "></div>
        </div>
        <div class="bg-body-tertiary me-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center overflow-hidden w-50">
            <div class="my-3 p-3">
                <h2 class="display-5" style="color: aliceblue; margin-top: 50px;">Minecraft</h2>
                <p></p>
                <p></p>
                <iframe width="550" height="350" style="margin-top: 50px;"
                        src="https://www.youtube.com/embed/8OQSupo-0V0?si=u5Z-WgOodD3DOTAR" title="YouTube video player"
                        frameborder="0"
                        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                        allowfullscreen></iframe>
            </div>
        </div>
    </div>


    <div class="d-md-flex flex-md-equal w-100 my-md-3 ps-md-3"
         style="background: linear-gradient(to right, rgb(54, 138, 138), #4e4e80);">
        <div class="bg-body-tertiary me-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center overflow-hidden w-50">
            <div class="my-3 p-3">
                <h2 class="display-5" style="color: aliceblue; margin-top: 50px;">Sons of The Forest</h2>
                <iframe width="550" height="350" style="margin-top: 50px;"
                        src="https://www.youtube.com/embed/8sghWJKPWno?si=eClf1ebAdZYvpTqr" title="YouTube video player"
                        frameborder="0"
                        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                        allowfullscreen></iframe>
            </div>
        </div>
        <div class="text-bg-primary me-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center overflow-hidden w-50">
            <div class="my-3 py-3">
                <h2 class="display-5" style="color: aliceblue; margin-top: 50px;">Entérate</h2>
                <p></p>
                <p class="lead" style="color: aliceblue; margin-top: 50px;">
                    "Sons of The Forest" es un juego de supervivencia en una isla misteriosa tras un accidente de avión.
                    Enfrenta a criaturas, construye refugios y explora para descubrir secretos. La narrativa se revela
                    con la exploración y tus elecciones influyen en tu destino. Además de la supervivencia, incorpora
                    elementos de construcción para defenderte. Con atmósfera tensa y gráficos inmersivos, ofrece una
                    experiencia cautivadora. Sumérgete en este desafío donde cada decisión cuenta. El juego es un viaje
                    intrigante lleno de peligros y maravillas, invitándote a descubrir la verdad detrás de la isla
                    enigmática.</p>
            </div>
            <div class="bg-body-tertiary shadow-sm mx-auto"
                 style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;"></div>
        </div>
    </div>


    <div class="d-md-flex flex-md-equal w-100 my-md-3 ps-md-3 justify-content-center"
         style="background: linear-gradient(to right, rgb(0, 149, 163), #3e8f49);">
        <div class="text-bg-dark me-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center overflow-hidden w-50">
            <div class="my-3 py-3">
                <h2 class="display-5" style="color: aliceblue; margin-top: 50px;">Entérate</h2>
                <p></p>
                <p class="lead" style="color: aliceblue; margin-top: 50px;">
                    "Raft" te lanza a una aventura única de supervivencia en un océano vasto e implacable. Enfrenta la
                    soledad y los peligros del mar flotando en una pequeña balsa. Tu misión es recolectar escombros y
                    mejorar tu plataforma flotante mientras te enfrentas a amenazas como tiburones y escasez de
                    recursos. La colaboración es clave, ya que puedes jugar con amigos para construir y expandir tu
                    balsa.

                    Con gráficos coloridos y un enfoque en la creatividad, "Raft" combina la gestión de recursos con la
                    exploración marina. A medida que navegas, descubres islas, ruinas y secretos ocultos, haciendo de
                    cada viaje una experiencia única. Sumérgete en la emoción de la supervivencia marítima y descubre
                    hasta dónde puedes llegar en este vasto océano virtual.</p>
            </div>
            <div class="bg-body-tertiary shadow-sm mx-auto"
                 style="width: 90%; height: 300px; border-radius: 21px 21px 0 0; "></div>
        </div>
        <div class="bg-body-tertiary me-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center overflow-hidden w-50">
            <div class="my-3 p-3">
                <h2 class="display-5" style="color: aliceblue; margin-top: 50px;">Raft</h2>
                <p></p>
                <p></p>
                <iframe width="550" height="350" style="margin-top: 50px;"
                        src="https://www.youtube.com/embed/__w615A5lC4?si=R8yJnIc1RIbNzup3" title="YouTube video player"
                        frameborder="0"
                        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                        allowfullscreen></iframe>
            </div>
        </div>
    </div>

    <div class="d-md-flex flex-md-equal w-100 my-md-3 ps-md-3"
         style="background: linear-gradient(to right, rgb(54, 138, 138), #4e4e80);">
        <div class="bg-body-tertiary me-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center overflow-hidden w-50">
            <div class="my-3 p-3">
                <h2 class="display-5" style="color: aliceblue; margin-top: 50px;">Fortnite</h2>
                <iframe width="550" height="350" style="margin-top: 50px;"
                        src="https://www.youtube.com/embed/1XcgbOAkRIQ?si=a5uQVDZbt8cJjljZ" title="YouTube video player"
                        frameborder="0"
                        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                        allowfullscreen></iframe>
            </div>
        </div>
        <div class="text-bg-primary me-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center overflow-hidden w-50">
            <div class="my-3 py-3">
                <h2 class="display-5" style="color: aliceblue; margin-top: 50px;">Entérate</h2>
                <p></p>
                <p class="lead" style="color: aliceblue; margin-top: 50px;">

                    "Fortnite" es un popular juego de batalla real que ha conquistado la escena del gaming. Ambientado
                    en un mundo vibrante y lleno de acción, enfrenta a 100 jugadores en un enfrentamiento a vida o
                    muerte, donde solo el último jugador o equipo en pie obtiene la victoria. Con un estilo de
                    construcción único, los jugadores pueden levantar estructuras para protegerse y ganar ventaja
                    táctica.

                    El juego es conocido por sus constantes actualizaciones, eventos en tiempo real y colaboraciones con
                    franquicias populares, lo que mantiene la experiencia fresca y emocionante. La diversidad de modos
                    de juego, desde el clásico Battle Royale hasta modos creativos, permite a los jugadores explorar
                    distintas dimensiones del juego.

            </div>
            <div class="bg-body-tertiary shadow-sm mx-auto"
                 style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;"></div>
        </div>
    </div>


    <!-- Inclur footer -->
    <jsp:include page="WEB-INF/components/FooterView.jsp"/>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>