const save = document.getElementById("save")
save.addEventListener('click', postCustomers)

async function postCustomers() {
    const form = document.getElementById("form")
    const name = document.getElementById("name")
    const itin = document.getElementById("itin")
    const phone = document.getElementById("phone")
    const email = document.getElementById("email")

    try {
        const response = await fetch(form.action, {
            method: form.method,
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
        alert("Failed to register client!")
    }
}