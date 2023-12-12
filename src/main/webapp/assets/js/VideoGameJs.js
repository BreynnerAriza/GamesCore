class VideoGame{

    buscar() {
        // Obtener el valor del campo de entrada
        var dato = document.getElementById('name').value;
        // Construir la cadena de parámetros para agregar al final de la URL
        var parametros = 'name=' + encodeURIComponent(dato);
        // Obtener la URL actual de la acción del formulario
        var urlActual = document.getElementById('searchV').action;
        urlActual += '&' + parametros;
        window.location.href = urlActual;
    }


}
const videoGame = new VideoGame();