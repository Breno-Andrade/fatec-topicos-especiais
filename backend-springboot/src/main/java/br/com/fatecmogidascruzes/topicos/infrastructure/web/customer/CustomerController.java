package br.com.fatecmogidascruzes.topicos.infrastructure.web.customer;

import br.com.fatecmogidascruzes.topicos.infrastructure.persistence.jpa.customer.CustomerRepository;
import br.com.fatecmogidascruzes.topicos.domain.customer.entity.Customer;
import br.com.fatecmogidascruzes.topicos.domain.customer.usecase.DeleteCustomer;
import br.com.fatecmogidascruzes.topicos.domain.customer.usecase.ListCustomer;
import br.com.fatecmogidascruzes.topicos.domain.customer.usecase.SaveCustomer;
import br.com.fatecmogidascruzes.topicos.domain.customer.usecase.UpdateCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "*")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    @PostMapping
    public void create(@RequestBody @Valid CustomerCreationRequest customerCreationRequest,
                       BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        new SaveCustomer(customerRepository).execute(customerCreationRequest.toDomain());
    }
    @GetMapping
    public List<CustomerPM> getAll() {
        return new ListCustomer(customerRepository)
                .execute()
                .stream()
                .map(CustomerPM::new)
                .collect(Collectors.toList());
    }
    @GetMapping("/{itin}")
    public Optional<CustomerPM> getByItin(@PathVariable String itin) {
        Optional<Customer> opCustomer = customerRepository.findByItin(itin);
        if(opCustomer.isPresent()) {
            return Optional.of(new CustomerPM(opCustomer.get()));
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{itin}")
    public void deleteByItin(@PathVariable String itin) {
        boolean found = new DeleteCustomer(customerRepository).execute(itin);
        if(!found) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{itin}")
    public void updateByItin(@PathVariable String itin,
                             @RequestBody Customer customer) {
        boolean found = new UpdateCustomer(customerRepository).execute(customer);
        if(!found) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
