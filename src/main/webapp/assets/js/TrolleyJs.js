class Trolley {


    add(_id) {
        let data = JSON.stringify({
            "_id": _id            
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
                    toastr.success("Añadido con exito", data.message);  
                    var span = document.getElementById('countTrolley');
                    span.innerText = data.count;                    
                } else {
                    toastr.error(data.fallos,"Error al añadir al carrito");
                }
            }).catch((error) => {
                toastr.error("Error", "Error");
            });
    }
   
}

const trolley = new Trolley();