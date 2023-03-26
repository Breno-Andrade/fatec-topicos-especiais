const name = document.getElementById("name")
const description = document.getElementById("description")
const unitPrice = document.getElementById("unitPrice")
const quantityStock = document.getElementById("quantityStock")
const perishable = document.getElementById("perishable")
const backendBaseURL = "http://localhost:8080/products"

const button = document.getElementById("update")
button.addEventListener("click", updateProduct)

const params = new URLSearchParams(window.location.search)
const idNumber = params.get('id')
getProduct(idNumber)

async function getProduct(idNumber) {
    try {
        const response = await fetch(`${backendBaseURL}/${idNumber}`)
        const product = await response.json()
        name.value = product.name
        description.value = product.description
        unitPrice.value = product.unitPrice
        quantityStock.value = product.quantityStock
        perishable.value = product.perishable
    } catch (error) {
        console.log(error)
        alert('Failed to update product')
    }
}


async function updateProduct() {
    try{
        const response = await fetch( `${backendBaseURL}/${idNumber}`, {
            method: "put",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                name: name.value,
                description: description.value,
                unitPrice: unitPrice.value,
                quantityStock: quantityStock.value,
                perishable: perishable.value
            })
        })
        alert('Product updated successfully!')
        window.location = "index.html"

    } catch (error) {
        console.log(error)
        alert('Failed to update product!')
    }
}