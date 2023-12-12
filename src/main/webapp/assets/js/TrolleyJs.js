class Trolley {
    agregar(id) {
        let data = JSON.stringify({
            "_id": id
        });
        fetch("http://localhost:8080/GamesCore/FrontController?path=Trolley&action=Add", {
            method: "POST",
            body: data,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then((response) => response.json()).
            then((data) => {
                if (data.message) {
                    toastr.success(data.message, "Anadido con exito");
                } else {
                    toastr.error(data.fallos,"Error al anadir al carrito");
                }
            }).catch((error) => {
                toastr.error("Error", "Error");
            });
    }


    eliminar(id) {
        fetch("http://localhost:8080/GamesCore/FrontController?path=Trolley&action=Eliminar&VideoGameReq="+id, {
            method: "DELETE",
        }).then((response) => response.json()).
        then((data) => {
            if (data.message) {
                toastr.success(data.message, "Eliminado con exito");
                Utils.redirect(data.url);
            } else {
                toastr.error(data.fallos,"Error al eliminar del carrito");
            }
        }).catch((error) => {
            toastr.error("Error", "Error");
        });
    }

}

const trolley = new Trolley();