package br.com.fatecmogidascruzes.topicos.domain.customer.usecase;

import br.com.fatecmogidascruzes.topicos.domain.customer.entity.Customer;
import br.com.fatecmogidascruzes.topicos.infrastructure.persistence.jpa.customer.CustomerRepository;

public class SaveCustomer {
    private CustomerRepository customers;
    public SaveCustomer(CustomerRepository customers) {
        this.customers = customers;
    }
    public void execute(Customer customer) {
        customers.save(customer);
    }
}