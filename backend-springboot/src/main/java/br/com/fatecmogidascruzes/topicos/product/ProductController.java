package br.com.fatecmogidascruzes.topicos.product;

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
        productRepository.save(product);
    }

    @GetMapping
    public List<Product> getAll(){
        return productRepository.findAll();
    }

    @GetMapping("/byId/{id}")
    public Optional<Product> getById(@PathVariable Long id){
        return productRepository.findById(id);
    }

    @GetMapping("/byName/{name}")
    public Optional<Product> getById(@PathVariable String name){
        return productRepository.findByName(name);
    }

    @DeleteMapping("/byId/{id}")
    public void deleteById(@PathVariable Long id){
        Optional<Product> product = productRepository.findById(id);
        product.ifPresent(value -> productRepository.delete(value));
    }

    @DeleteMapping("/byName/{name}")
    public void deleteById(@PathVariable String name){
        Optional<Product> product = productRepository.findByName(name);
        product.ifPresent(value -> productRepository.delete(value));
    }

    @PutMapping("/{name}")
    public void updateByName(@PathVariable String name,
                             @RequestBody Product product) {
        Optional<Product> opDatabaseProduct = productRepository.findByName(name);
        if(opDatabaseProduct.isPresent()) {
            Product databaseProduct = opDatabaseProduct.get();
            databaseProduct.setName(product.getName());
            databaseProduct.setDescription(product.getDescription());
            databaseProduct.setUnitPrice(product.getUnitPrice());
            databaseProduct.setQuantityStock(product.getQuantityStock());
            databaseProduct.setPerishable(product.isPerishable());
            productRepository.save(databaseProduct);
        }
    }
}
