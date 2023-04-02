package br.com.fatecmogidascruzes.topicos.domain.customer.usecase;

import br.com.fatecmogidascruzes.topicos.infrastructure.persistence.jpa.customer.CustomerRepository;
import br.com.fatecmogidascruzes.topicos.domain.customer.entity.Customer;

import java.util.List;

public class ListCustomer {
    private CustomerRepository customers;
    public ListCustomer(CustomerRepository customers) {
        this.customers = customers;
    }
    public List<Customer> execute() {
        return customers.findAll();
    }

}