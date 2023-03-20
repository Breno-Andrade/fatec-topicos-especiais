const itin = document.getElementById("itin")
const deleteButton = document.getElementById("delete")

deleteButton.addEventListener("click", deleteCustomer)

async function deleteCustomer() {
    try{
        const response = await fetch(`http://localhost:8080/customers/byItin/${itin.value}`, {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json",
            },
        })
        alert("Customer deleted successfully!")
        window.location = "index.html"
    } catch (error){
        console.error(error)
        alert("Failed to delete customer!")
    }
}