const customerBody = document.getElementById('tableBody')

async function getCustomers() {
    try {
        const response = await fetch(`http://localhost:8080/customers`)
        const customers = await response.json()
        
        if(customers.length === 0) {
            customerBody.innerHTML = `<tr><td colspan="4">No customers found</td></tr>`
        } else {
            for(const customer of customers) {
                customerBody.innerHTML = customerBody.innerHTML + `<tr>
                    <td>${customer.name}</td>
                    <td>${customer.itin}</td>
                    <td>${customer.phone}</td>
                    <td>${customer.email}</td>
                </tr>`
            }
            customerBody.innerHTML =
                customerBody.innerHTML + `<tr><td colspan="4">${customers.length} customer(s) found.</td></tr>`
        }
        
    } catch(error) {
        console.error(error)
    }
}

getCustomers()