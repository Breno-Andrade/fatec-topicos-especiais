const backendBaseURL = "http://localhost:8080/customers"
const name = document.getElementById("name")
const itin = document.getElementById("itin")
const phone = document.getElementById("phone")
const email = document.getElementById("email")

const save = document.getElementById("save")
save.addEventListener('click', postCustomers)

async function postCustomers() {
    try {
        const response = await fetch(backendBaseURL, {
            method: "post",
            headers: {
                "Content-type": "application/json"
            },
            body: JSON.stringify({
                itin: itin.value,
                name: name.value,
                phone: phone.value,
                email: email.value
            })
        })
        alert("Customer registered successfully!")
        window.location = "index.html"
    } catch(error) {
        console.error(error)
        alert("Failed to register customer!")
    }
}