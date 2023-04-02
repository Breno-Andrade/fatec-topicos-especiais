package br.com.fatecmogidascruzes.topicos.domain.customer.usecase;

import br.com.fatecmogidascruzes.topicos.common.domain.humanresources.Email;
import br.com.fatecmogidascruzes.topicos.common.domain.humanresources.Phone;
import br.com.fatecmogidascruzes.topicos.domain.customer.entity.Customer;
import br.com.fatecmogidascruzes.topicos.infrastructure.persistence.jpa.customer.CustomerRepository;

import java.util.Optional;

public class UpdateCustomer {
    private CustomerRepository customers;
    public UpdateCustomer(CustomerRepository customers) {
        this.customers = customers;
    }
    public boolean execute(Customer customer) {
        Optional<Customer> opDatabaseCustomer = customers.findByItin(customer.getItin());
        if(opDatabaseCustomer.isPresent()) {
            Customer databaseCustomer = opDatabaseCustomer.get();
            databaseCustomer.setName(customer.getName());
            databaseCustomer.setEmail(new Email(customer.getEmail()));
            databaseCustomer.setPhone(new Phone(customer.getPhone()));
            customers.save(databaseCustomer);
            return true;
        }
        return false;
    }
}