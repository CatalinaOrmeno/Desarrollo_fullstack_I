const API_URL = "http://localhost:8080/api/v1/libros";//Ruta de conexión de la API
//Funcion que nos permite mostrar los libros guardados
function listarLibros(){
    fetch(API_URL) //hacer una solicitud GET a la API_URL
        .then(Response = Response.json)//Convierte la respuesta de la API en un archivo.json
        .then(libros =>{//Usar el arreglo libros para procesar los libros guardados
            const tbody = document.querySelector("#tablaLibros tbody");//Obtener el cuerpo de la tabla Tbody
            tbody.innerHTML = "";//Limpia la tabla de cualquier contenido anterior
            libros.forEach(libro => {//Generar el recorrido del arreglo de libros
                const fila =//Cargar dinamicamente los elementos de la tabla
                <tr>
                    <td>${libro.id}</td>
                    <td>${libro.titulo}</td>
                    <td>${libro.autor}</td>
                    <td>${libro.editorial}</td>
                    <td>${libro.isbn}</td>
                    <td>${libro.fecha_publicacion}</td>
                    <td>
                        <button onclick="eliminarLibro(${libros.id})">Eliminar</button>
                        <button onclick="buscarLibro(${libros.id})">Editar</button>
                    </td>
                </tr>
                tbody.innerHTML+=fila;//Llenar las filas de la tabla
            });
        })
}
function agregarLibro(){//Sirve para que al tocar el botón de agregar libros se conecte con la API
    //Obtener los valores ingresados en los inputs del formulario.
    const titulo = document.getElementById("titulo").value;
    const autor = document.getElementById("autor").value;
    const editorial = document.getElementById("editorial").value;
    const isbn = document.getElementById("isbn").value;
    const fecha_publicacion = document.getElementById("fecha_publicacion").value;
    const nuevoLibro = {//Crear un objetp temporal con los datos ingresados por el usuario
        id: Date.now(),
        titulo: titulo,
        autor: autor,
        editorial: editorial,
        isbn: isbn,
        fecha_publicacion: parseInt(fecha_publicacion)
    };
    fetch(API_URL,{//Enviar una solicitud POST a la API y creara el registro de un nuevo libro
        method: "POST",
        headers: {"content-Type":"Application/json"},
        body: JSON.stringify(nuevoLibro)
    })
    //Muestra de mensajes de éxito al actualizar la tabla
    .then(Response => Response.json())
    .then(data =>{
        alert("Libro se agrego exitosamente.");
        listarLibros();
    });
}
//Funcion para eliminar libro
function eliminarLibro(id){
    fetch(`${API_URL}/${id}`,{method: "DELETE"})//Eliminara el libro por el id
        .then(Response =>{
            if(Response.ok){
                alert("El libro se elimino exitosamente.");
                listarLibros();
            }
        });
}

//Función para buscar libros
function buscarLibro(id){
    fetch(`${API_URL}/${id}`)//Buscara el libro por el id
        .then(Response => Response.json())
        .then(libro =>{
            document.getElementById("titulo").value = libro.titulo;
            document.getElementById("autor").value = libro.autor;
            document.getElementById("editorial").value = libro.editorial;
            document.getElementById("isbn").value = libro.isbn;
            document.getElementById("fecha_publicacion").value = libro.fecha_publicacion;
            
            //Botón para agregar los campos actualizados
            const boton = document.querySelector("button[onclick = 'agregarLibro()']");
            boton.innerHTML = "Actualizar libro";
            boton.setAttribute("onclick",`actualizarLibro(${libro.id})`);
        });
}

//Función actualizar Libros
function actualizarLibro(id){
    const titulo = document.getElementById("titulo").value;
    const autor = document.getElementById("autor").value;
    const editorial = document.getElementById("editorial").value;
    const isbn = document.getElementById("isbn").value;
    const fecha_publicacion = document.getElementById("fecha_publicacion").value;

    const libroActualizado = {
        id: id,
        titulo: titulo,
        autor: autor,
        editorial: editorial,
        isbn: isbn,
        fecha_publicacion: parseInt(fecha_publicacion)
    }
    fetch(`${API_URL}/${id}`,{
        method: "PUT",
        headers: {"content-Type":"Application/json"},
        body: JSON.stringify(libroActualizado)
    })
    .then(Response => Response.json())
    .then(data =>{
        alert("El libro se actualizo exitosamente.");
        listarLibros();
        limpiarFormulario();
    });
}

function limpiarFormulario(){//Limpiar los input
    document.getElementById("titulo").value = "";
    document.getElementById("autor").value = "";
    document.getElementById("editorial").value = "";
    document.getElementById("isbn").value = "";
    document.getElementById("fecha_publicacion").value = "";

    //Boton para restaurar
    const boton = document.querySelector("button[onclick^ = 'actualizarLibro']");
    boton.innerText= "Actualizar Libro";
    boton.setAttribute("onclick","agregarLibro()");
    listarLibros();
}