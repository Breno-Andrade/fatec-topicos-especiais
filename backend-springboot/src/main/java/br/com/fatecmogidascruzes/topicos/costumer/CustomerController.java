package br.com.fatecmogidascruzes.topicos.costumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping
    public void create(@RequestBody Customer customer) {
        customerRepository.save(customer);
    }

    @GetMapping
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @GetMapping("/byId/{id}")
    public Optional<Customer> getById(@PathVariable Long id) {
        return customerRepository.findById(id);
    }

    @GetMapping("/byItin/{itin}")
    public Optional<Customer> getByItin(@PathVariable String itin) {
        return customerRepository.findByItin(itin);
    }

    @DeleteMapping("/byId/{id}")
    public void deleteById(@PathVariable Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        customer.ifPresent(value -> customerRepository.delete(value));
    }

    @DeleteMapping("/byItin/{itin}")
    public void deleteByItin(@PathVariable String itin) {
        Optional<Customer> customer = customerRepository.findByItin(itin);
        customer.ifPresent(value -> customerRepository.delete(value));
    }

    @PutMapping("/{itin}")
    public void updateByItin(@PathVariable String itin,
                             @RequestBody Customer customer) {
        Optional<Customer> opDatabaseCustomer = customerRepository.findByItin(itin);
        if(opDatabaseCustomer.isPresent()) {
            Customer databaseCustomer = opDatabaseCustomer.get();
            databaseCustomer.setItin(customer.getItin());
            databaseCustomer.setName(customer.getName());
            databaseCustomer.setEmail(customer.getEmail());
            databaseCustomer.setPhone(customer.getPhone());
            customerRepository.save(databaseCustomer);
        }
    }

}
