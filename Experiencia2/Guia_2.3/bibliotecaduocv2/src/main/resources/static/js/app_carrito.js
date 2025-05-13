const carrito = (() => {
    const API = "/api/v2/carrito";

    //Función para listar los libros en el carrito:
    async function listarCarrito(){
        try{
            const response = await fetch(API);
            const libros = await response.json();

            const tbody = document.querySelector("#tablaCarrito tbody");
            const totalItems = document.getElementById("totalCarrito");

            tbody.innerHTML = "";
            totalItems.textContent = libros.length;

            libros.forEach(libro => {
                const fila = `
                    <tr>
                        <td>${libro.id}</td>
                        <td>${libro.titulo}</td>
                        <td>${libro.autor}</td>
                        <td>
                            <button class="btn btn-sm btn-danger" onclick="carrito.eliminarLibro(${libro.id})">Eliminar</button>
                        </td>
                    </tr>
                `;
                tbody.innerHTML += fila;
            });
        }catch(err){
            console.error("Error al cargar el carrito: ", err);
        }
    }

    //Función para agregar un libro al carrito:
    async function agregarLibro(id){
        try{
            await fetch(`${API}/agregar/${id}`, {method: "POST"});
            alert("El libro ha sido agregado");
            listarCarrito();
        }catch(err){
            console.error("Error al agregar el libro al carrito: ", err);
        }
    }
    
    //Función para eliminar un libro del carrito:
    async function eliminarLibro(id){
        try{
            await fetch(`${API}/eliminar/${id}`, {method: "DELETE"});
            alert("El libro ha sido eliminado");
            listarCarrito();
        }catch(err){
            console.error("Error al eliminar el libro del carrito: ", err);
        }
    }

    //Función para vaciar el carrito:
    async function vaciarCarrito(){
        if(confirm("¿Está seguro de vaciar el carrito?")){
            await fetch(`${API}/vaciar`, {method: "DELETE"});
            alert("Carrito vaciado");
            listarCarrito();
        }
    }

    //Función para confirmar la compra:
    async function confirmarCompra(){
        const total = document.getElementById("totalCarrito").textContent;
        if(parseInt(total) === 0){
            alert("El carrito está vacío");
            return;
        }else if(confirm(`"¿Desea confirmar tu compra por ${total}?"`)){
            await fetch(`${API}/vaciar`, {method: "DELETE"});
            alert("Compra realizada éxitosamente");
            listarCarrito();
        }
    }
    return { listarCarrito, agregarLibro, eliminarLibro, vaciarCarrito, confirmarCompra};
}) ();