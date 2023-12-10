class Register {

    register() {
        const validate = this.validateCamp();
        if (validate) {
            let data = JSON.stringify({
                "nick":document.querySelector("#nick").value.trim(),
                "email": document.querySelector("#email").value.trim(),
                "password":document.querySelector("#password").value.trim()
            });
            fetch("http://localhost:8080/GamesCore/FrontController?path=Auth&action=Register",{
                method: "POST",
                body: data,
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then((response) => response.json()).
            then((data) =>{
                if(data.message){
                    toastr.success(data.message,"Felicidades");
                    Utils.redirect(data.url);
                }else{
                    toastr.error("Error al registrar",data.fallos);
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

    showConfirmPassword() {
        Utils.showPassword("#confirmPassword");
    }

    validateCamp() {
        const regexEmail = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;
        const nickInput = document.querySelector("#nick");
        const emailInput = document.querySelector("#email");
        const passwordInput = document.querySelector("#password");
        const confirmPasswordInput = document.querySelector("#confirmPassword");

        if (nickInput.value.trim() === "") {
            toastr.error("Por favor ingrese un Apodo, sera divertido", "Apodo vacio");
            return false;
        } else if (emailInput.value.trim() === "") {
            toastr.error("Por favor ingrese un Email", "Email vacio");
            return false;
        } else if (password === "") {
            toastr.error("Por favor ingrese una contraseña", "Contraseña vacia");
            return false;
        } else if (!regexEmail.test(emailInput.value.trim())) {
            toastr.error("El email no es valido", "Email invalido");
            return false;
        } else if (passwordInput.value.trim() !== confirmPasswordInput.value.trim()) {
            toastr.warning("Las contraseñas no coindiden", "Contraseñas diferentes");
            return false;
        }

        return true;

    }
}

const register = new Register();