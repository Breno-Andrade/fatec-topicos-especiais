
const deleteButton = document.getElementById('delete');
deleteButton.addEventListener("click", deleteProductByName)

async function deleteProductByName() {
    const form = document.getElementById("form")
    const name = document.getElementById('name');

    try {
        const response = await fetch(form.action + `/byName/${name.value}`, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
            },
        });
        alert("Product deleted successfully!");
        window.location.href = "index.html";

    } catch (error) {
        console.log(error)
        alert("Failed to delete product!");
    }
}