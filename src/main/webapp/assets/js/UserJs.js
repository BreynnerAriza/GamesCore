class User {

    comprarCarrito() {
        alert("comprando")
        fetch("http://localhost:8080/GamesCore/FrontController?path=User&action=TerminarCompra", {
            method: "PUT",
        }).then((response) => response.json()).
        then((data) => {
            if (data.message) {
                toastr.success(data.message, "Comprado con exito");
                Utils.redirect(data.url);
            } else {
                toastr.error(data.fallos,"Error al comprar");
            }
        }).catch((error) => {
            toastr.error("Error", "Error");
        });
    }

}

const user = new User();