package br.com.fatecmogidascruzes.topicos.infrastructure.web.product;

import br.com.fatecmogidascruzes.topicos.domain.product.entity.Product;
import br.com.fatecmogidascruzes.topicos.domain.product.usecase.*;
import br.com.fatecmogidascruzes.topicos.infrastructure.persistence.jpa.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<ProductPM> getAll(){
        return new ListProduct(productRepository)
                .execute()
                .stream()
                .map(ProductPM::new)
                .collect(Collectors.toList());
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
