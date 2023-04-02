package br.com.fatecmogidascruzes.topicos.domain.customer.usecase;

import br.com.fatecmogidascruzes.topicos.domain.customer.entity.Customer;
import br.com.fatecmogidascruzes.topicos.infrastructure.persistence.jpa.customer.CustomerRepository;

import java.util.Optional;

public class FindCustomer {
    private CustomerRepository customers;
    public FindCustomer(CustomerRepository customers) {
        this.customers = customers;
    }
    public Optional<Customer> execute(String itin) {
        return customers.findByItin(itin);
    }
}