function login(){
    fetch("http://localhost:8080/api/v2/usuarios/login", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({
            email: document.getElementById("email").value,
            password: document.getElementById("password").value
        })
    })  .then(response => response.json())
        .then(data => alert("Usuario accedio correctamente"))
}