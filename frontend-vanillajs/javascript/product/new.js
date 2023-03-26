const name = document.getElementById("name")
const description = document.getElementById("description")
const unitPrice = document.getElementById("unitPrice")
const quantityStock = document.getElementById("quantityStock")
const perishable = document.getElementById("perishable")
const backendBaseURL = "http://localhost:8080/products"

const save = document.getElementById("save")
save.addEventListener('click', postProducts)

async function postProducts() {
    try {
        const response = await fetch(`${backendBaseURL}`, {
            method: "post",
            headers: {
                "Content-type": "application/json"
            },
            body: JSON.stringify({
                name: name.value,
                description: description.value,
                unitPrice: unitPrice.value,
                quantityStock: quantityStock.value,
                perishable: perishable.value
            })
        })
        alert("Product successfully created!")
        window.location = "index.html"
    } catch(error) {
        console.error(error)
        alert("Failed to register product")
    }
}