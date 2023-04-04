package br.com.fatecmogidascruzes.topicos.domain.product.usecase;

import br.com.fatecmogidascruzes.topicos.domain.product.entity.Product;
import br.com.fatecmogidascruzes.topicos.infrastructure.persistence.jpa.product.ProductRepository;

public class SaveProduct {
    private ProductRepository productRepository;

    public SaveProduct(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public void execute(Product product){
        productRepository.save(product);
    }
}
