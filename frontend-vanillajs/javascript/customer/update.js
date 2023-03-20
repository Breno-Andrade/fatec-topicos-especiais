const form = document.getElementById("form")
const name = document.getElementById("name")
const itin = document.getElementById("itin")
const phone = document.getElementById("phone")
const email = document.getElementById("email")

const updateButton = document.getElementById("update")
updateButton.addEventListener("click", updateCustomer)

async function updateCustomer() {
    try {
        const response = await fetch(form.action + itin.value, {
            method: "put",
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
        console.log(error)
        alert("Failed updating customer!")
    }
}
