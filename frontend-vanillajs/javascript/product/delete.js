const deleteButton = document.getElementById('delete');

deleteButton.addEventListener("click", () => {
    const name = document.getElementById('name').value;
    deleteProductByName(name);
});

async function deleteProductByName(name) {
    const response = await fetch(`http://localhost:8080/products/byName/${name}`, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
        },
    });

    if (response.ok) {
        alert("Product deleted successfully");
        window.location.href = "index.html";
    } else {
        alert("Failed to delete customer.");
    }
}