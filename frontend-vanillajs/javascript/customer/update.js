const form = document.getElementById("form-update")
const name = document.getElementById("name")
const itin = document.getElementById("itin")
const phone = document.getElementById("phone")
const email = document.getElementById("email")
const updateButton = document.getElementById("update")


updateButton.addEventListener("click", () => {
    updateCustomer(itin)
})

async function updateCustomer(itin) {


    try {
        alert(itin.value)
        const response = await fetch(`http://localhost:8080/customers/${itin.value}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                itin: itin.value,
                name: name.value,
                email: email.value,
                phone: phone.value
            }),
        })
        alert("Customer updated successfully!")
        window.location = "index.html"
    } catch (error) {
        alert("Failed updating customer!")
        console.log(error)
    }
}