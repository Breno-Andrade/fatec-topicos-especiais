const customerBody = document.getElementById('tableBody')
const backendBaseURL = 'http://localhost:8080/customers'

async function deleteCustomer(itin) {
    try {
        await fetch(`${backendBaseURL}/${itin}`, {
            method: 'delete'
        })
        window.location = "index.html"
    } catch(error) {
        console.error(error)
    }
}

async function getCustomers() {
    try {
        const response = await fetch(backendBaseURL)
        const customers = await response.json()
        
        if(customers.length === 0) {
            customerBody.innerHTML = `<tr><td colspan="5">No customers found</td></tr>`
        } else {
            for(const customer of customers) {
                customerBody.innerHTML = customerBody.innerHTML + `<tr>
                    <td>${customer.name}</td>
                    <td>${customer.itin}</td>
                    <td>${customer.phone}</td>
                    <td>${customer.email}</td>
                    <td>
                    <a href="update.html?itin=${customer.itin}">Update</a>
                    <a href="javascript:void(0)" onclick="deleteCustomer('${customer.itin}')">Delete</a>
                    </td>
                </tr>`
            }
            customerBody.innerHTML =
                customerBody.innerHTML + `<tr><td colspan="5">${customers.length} customer(s) found.</td></tr>`
        }
        
    } catch(error) {
        console.error(error)
    }
}

getCustomers()