const productBody = document.getElementById('tableBody')
const backendBaseURL = 'http://localhost:8080/products'

async function deleteProduct(id) {
    try {
        await fetch(`${backendBaseURL}/${id}`, {
            method: 'delete'
        })
        window.location = "index.html"
    } catch(error) {
        console.error(error)
    }
}

async function getProducts() {
    try {
        const response = await fetch(`${backendBaseURL}`)
        const products = await response.json()
        
        if(products.length === 0) {
            productBody.innerHTML = `<tr><td colspan="7">No products found</td></tr>`
        } else {
            for(const product of products) {
                productBody.innerHTML = productBody.innerHTML + `<tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.description}</td>
                    <td>${product.unitPrice}</td>
                    <td>${product.quantityStock}</td>
                    <td>${product.perishable}</td>
                    <td>
                    <a href="update.html?id=${product.id}">Update</a>
                    <a href="javascript:void(0)" onclick="deleteProduct('${product.id}')">Delete</a>
                    </td>
                </tr>`
            }
            productBody.innerHTML =
                productBody.innerHTML + `<tr><td colspan="7">${products.length} product(s) found.</td></tr>`
        }
        
    } catch(error) {
        console.error(error)
    }
}

getProducts()