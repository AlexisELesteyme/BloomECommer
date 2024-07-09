const invocarApi=async()=>{
    const mostrarProducto=(pProducto)=>{
        console.log(pProducto)
        let urlImagen=""
        
        nodoContenido=document.getElementById("container")
        
        nodoCard=document.createElement("div")
        nodoCardHeader=document.createElement("div")
        nodoTitulo=document.createElement("h6")
        nodoTitulo.textContent=pProducto.title
        nodoCardHeader.className="card-header"
        nodoCardHeader.appendChild(nodoTitulo)

        nodoCardBody=document.createElement("div")
        nodoImg=document.createElement("img")
        urlImagen=pProducto.image
        nodoImg.setAttribute("src",urlImagen)
        nodoImg.className="card_img"
        nodoCardBody.className="card-body"
        nodoCardBody.appendChild(nodoImg)

        nodoCardFooter=document.createElement("div")
        nodoSpan=document.createElement("span")
        nodoSpan.textContent=pProducto.price
        nodoCardFooter.appendChild(nodoSpan)

        nodoCard.appendChild(nodoCardHeader)
        nodoCard.appendChild(nodoCardBody)
        nodoCard.appendChild(nodoCardFooter)
        nodoCardFooter.className="card-footer"
        
        nodoCard.className="card"
        nodoContenido.appendChild(nodoCard)
    }


    console.log("pagina cargada")
    let url="https://fakestoreapi.com/products/category/women's clothing"
    try {
        const res=await fetch(url)
        console.log(res.status)
        if (res.status==200) {
            const results=await res.json()
            console.log("cantidad de productos :"+results.length)
            console.log(results)
            contador=1
            results.map((producto)=>{
                console.log("Producto: "+contador)
                mostrarProducto(producto)
                contador+=1
        })  
        } else {
            console.log("no se obtuvo datos de los productos")
        }  
    } catch (error) {
        console.log(error)
    }
}