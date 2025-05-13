function registrar(){
    fetch("http://localhost:8080/api/v2/usuarios/registrar", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({
            nombre: document.getElementById("nombre").value,
            email: document.getElementById("email").value,
            password: document.getElementById("password").value

        })
    })  .then(response => response.json())
        .then(data => {
            alert("Usuario se creo con el id: " + data.id);
            window.location.href = "/login.html"
        });
}