package br.com.fatecmogidascruzes.topicos.domain.customer.usecase;

import br.com.fatecmogidascruzes.topicos.domain.customer.entity.Customer;
import br.com.fatecmogidascruzes.topicos.infrastructure.persistence.jpa.customer.CustomerRepository;

import java.util.Optional;

public class DeleteCustomer {

    private CustomerRepository customers;

    public DeleteCustomer(CustomerRepository customers) {
        this.customers = customers;
    }

    public boolean execute(String itin) {
        Optional<Customer> customer = customers.findByItin(itin);
        if(customer.isPresent()) {
            customers.delete(customer.get());
            return true;
        }
        return false;
    }

}