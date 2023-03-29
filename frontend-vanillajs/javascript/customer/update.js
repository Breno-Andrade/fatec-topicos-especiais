const form = document.getElementById("form")
const name = document.getElementById("name")
const itin = document.getElementById("itin")
const phone = document.getElementById("phone")
const email = document.getElementById("email")
const backendBaseURL = 'http://localhost:8080/customers'

const updateButton = document.getElementById("update")
updateButton.addEventListener("click", (event) => {
  if (checkInputsIsNotEmpty()) {
      updateCustomer()
  }
})

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