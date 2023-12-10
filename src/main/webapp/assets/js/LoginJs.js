class Login{


    login(){
        const validate = this.validateCamp();
        if (validate) {
            let data = JSON.stringify({
                "email": document.querySelector("#email").value.trim(),
                "password":document.querySelector("#password").value.trim()
            });
            fetch("http://localhost:8080/GamesCore/FrontController?path=Auth&action=Login",{
                method: "POST",
                body: data,
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then((response) => response.json()).
            then((data) =>{
                if(data.message){
                    toastr.success(data.message,"Bienvenido");
                    Utils.redirect(data.url);
                }else{
                    toastr.error("Error al ingresar",data.fallos);
                }
            }).catch((error) =>{
                toastr.error("Error","Error");
            });
        }
    }

    //Mostrar u ocultar contraseña
    showPassword() {
        Utils.showPassword("#password");
    }

    validateCamp(){
        const regexEmail = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;
        const emailInput = document.querySelector("#email");
        const passwordInput = document.querySelector("#password");
        const email = emailInput.value.trim();
        const password = passwordInput.value.trim();
        if(email === ""){
            toastr.error("Por favor ingrese un Email", "Email vacio");
            return false;
        }else if(password === ""){
            toastr.error("Por favor ingrese una contraseña", "Contraseña vacia");
            return false;
        }else if(!regexEmail.test(email)){
            toastr.error("El email no es valido", "Email invalido");
            return false;
        }
        return true;

    }
}

const login = new Login();