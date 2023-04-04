package br.com.fatecmogidascruzes.topicos.domain.product.usecase;

import br.com.fatecmogidascruzes.topicos.domain.product.entity.Product;
import br.com.fatecmogidascruzes.topicos.infrastructure.persistence.jpa.product.ProductRepository;

import java.util.Optional;

public class FindProduct {
    private ProductRepository productRepository;

    public FindProduct(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Optional<Product> execute(Long id){
        return productRepository.findById(id);
    }
}
