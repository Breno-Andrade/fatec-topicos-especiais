
const button = document.getElementById("update")
button.addEventListener("click", updateProduct)

async function updateProduct() {
    const form = document.getElementById("form")
    const name = document.getElementById("name")
    const description = document.getElementById("description")
    const unitPrice = document.getElementById("unitPrice")
    const quantityStock = document.getElementById("quantityStock")
    const perishable = document.getElementById("perishable")

    try{
        const response = await fetch(form.action + `/${name.value}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                name: name.value,
                description: description.value,
                unitPrice: unitPrice.value,
                quantityStock: quantityStock.value,
                perishable: perishable.value
            })
        })
        alert('Product updated successfully')
        window.location = "index.html"

    } catch (error) {
        console.log(error)
        alert('Failed to update product')
    }
}