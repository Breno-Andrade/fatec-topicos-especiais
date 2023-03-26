const form = document.getElementById("form")
const name = document.getElementById("name")
const itin = document.getElementById("itin")
const phone = document.getElementById("phone")
const email = document.getElementById("email")
const backendBaseURL = 'http://localhost:8080/customers'

const updateButton = document.getElementById("update")
updateButton.addEventListener("click", updateCustomer)

const params = new URLSearchParams(window.location.search)
const itinNumber = params.get('itin')
getCustomer(itinNumber)

async function getCustomer(itinNumber) {
    try {
        const response = await fetch(`${backendBaseURL}/${itinNumber}`)
        const customer = await response.json()
        itin.value = customer.itin
        name.value = customer.name
        phone.value = customer.phone
        email.value = customer.email

    } catch(error) {
        console.error(error)
    }
}

async function updateCustomer() {
    try {
        const response = await fetch(`${backendBaseURL}/${itinNumber}`, {
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
