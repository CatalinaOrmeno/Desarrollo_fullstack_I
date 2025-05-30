API_URL = "http://localhost:8080/api/v2/usuarios/login";

function login(){
    fetch(API_URL, {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({
            email: document.getElementById("email").value,
            password: document.getElementById("password").value
        })
    })  .then(response => response.json())
        .then(data => {
            if(data.result === "OK"){
                sessionStorage.setItem("nombreUsuario",data.nombre);
                window.location.href = "/index.html";
            }else{
                alert("Acceso ha sido denegado");
            }
        })
}