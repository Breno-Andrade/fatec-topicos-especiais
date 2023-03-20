const form = document.getElementById("form")
const name = document.getElementById("name")
const description = document.getElementById("description")
const unitPrice = document.getElementById("unitPrice")
const quantityStock = document.getElementById("quantityStock")
const perishable = document.getElementById("perishable")
const save = document.getElementById("save")

save.addEventListener('click', postProducts)

async function postProducts() {

    try {
        const response = await fetch(form.action, {
            method: form.method,
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
    }
}