package br.com.fatecmogidascruzes.topicos.product;

import br.com.fatecmogidascruzes.topicos.customer.FindCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public void create(@RequestBody Product product){
        new SaveProduct(productRepository).execute(product);
    }

    @GetMapping
    public List<Product> getAll(){
        return new ListProduct(productRepository).execute();
    }

    @GetMapping("/{id}")
    public Optional<Product> getById(@PathVariable Long id){
        return new FindProduct(productRepository).execute(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        new DeleteProduct(productRepository).execute(id);
    }

    @PutMapping("/{id}")
    public void updateByName(@PathVariable Long id,
                             @RequestBody Product product) {
        new UpdateProduct(productRepository).execute(id, product);
    }
}
