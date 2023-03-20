const deleteButton = document.getElementById("delete")

deleteButton.addEventListener("click", () => {
    const itin = document.getElementById("itin").value
    deleteCustomer(itin)
})

async function deleteCustomer(itin) {

    try{
        const response = await fetch(`http://localhost:8080/customers/byItin/${itin}`, {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json",
            },
        })
        alert("Customer deleted successfully!")
        window.location.href = "index.html"
    } catch (error){
        alert("Failed to delete customer!")
        console.error(error)
    }
}