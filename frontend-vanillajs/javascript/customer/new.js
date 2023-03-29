const name = document.getElementById("name")
const itin = document.getElementById("itin")
const phone = document.getElementById("phone")
const email = document.getElementById("email")
const backendBaseURL = "http://localhost:8080/customers"

const save = document.getElementById("save")
save.addEventListener('click', (event) => {
    event.preventDefault()

    if (checkInputsIsNotEmpty()){
        checkItin()
    }

})

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

function errorValidation(input, message){
    const formControl = input.parentElement
    const small = formControl.querySelector("small")

    small.innerText = message
    formControl.className = "form-control error"
}

function sucessValidation (input) {
    const formControl = input.parentElement

    formControl.className =  "form-control success"
}

function checkInputsIsNotEmpty() {
    const nameValue = name.value.trim()
    const itinValue = itin.value.trim()
    const phoneValue = phone.value.trim()
    const emailValue = email.value.trim()
    let numberOfErrors = 0

    if (nameValue === ''){
        errorValidation(name, "Fill in this field!")
        numberOfErrors += 1
    } else {
        sucessValidation(name)
    }

    if (itinValue === ''){
        errorValidation(itin, "Fill in this field!")
        numberOfErrors += 1
    } else {
        sucessValidation(itin)
    }

    if (phoneValue === ''){
        errorValidation(phone, "Fill in this field!")
        numberOfErrors += 1
    } else {
        sucessValidation(phone)
    }

    if (emailValue === ''){
        errorValidation(email, "Fill in this field!")
        numberOfErrors += 1
    }  else {
        sucessValidation(email)
    }

    return numberOfErrors === 0;
}

async function checkItin() {
    try {
        const response = await fetch(`${backendBaseURL}/${itin.value}`);
        if (response.ok) {
            const data = await response.json();
            if (data != null) {
                errorValidation(itin, "ITIN number already exists.")
            } else {
                postCustomers();
            }
        } else {
            alert("Error checking ITIN number");
        }
    } catch (error) {
        console.error(error)
    }
}
