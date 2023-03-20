async function updateProduct() {
    const name = document.getElementById("name").value;
    const description = document.getElementById("description").value;
    const unitPrice = document.getElementById("unitPrice").value;
    const quantityStock = document.getElementById("quantityStock").value;
    const perishable = document.getElementById("perishable").value;

    const url = `http://localhost:8080/products/${name}`;

    const response = await fetch(url, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            name: name,
            description: description,
            unitPrice: unitPrice,
            quantityStock: quantityStock,
            perishable: perishable
        })
    });

    if (response.ok) {
        alert('Product updated successfully');
        window.location = "index.html";
    } else {
        alert('Failed to update product');
    }
}

const button = document.getElementById("update");
button.addEventListener("click", updateProduct);