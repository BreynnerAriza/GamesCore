class Utils {

    static redirect(url){
        setTimeout(function() {
            window.location.href = url;
        }, 1000);
    }

    static showPassword(id) {
        const inputPassword = document.querySelector(id);
        if(inputPassword.type === "password"){
            inputPassword.type = "text";
        }else{
            inputPassword.type = "password";
        }     
    }


}