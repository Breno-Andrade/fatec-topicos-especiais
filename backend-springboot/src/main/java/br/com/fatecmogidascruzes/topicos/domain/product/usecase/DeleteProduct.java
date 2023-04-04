package br.com.fatecmogidascruzes.topicos.domain.product.usecase;

import br.com.fatecmogidascruzes.topicos.domain.product.entity.Product;
import br.com.fatecmogidascruzes.topicos.infrastructure.persistence.jpa.product.ProductRepository;

import java.util.Optional;

public class DeleteProduct {
    private ProductRepository productRepository;

    public DeleteProduct(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void execute(Long id){
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()){
            productRepository.delete(product.get());
        }
    }
}
