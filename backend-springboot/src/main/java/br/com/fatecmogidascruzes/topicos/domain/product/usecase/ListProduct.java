package br.com.fatecmogidascruzes.topicos.domain.product.usecase;

import br.com.fatecmogidascruzes.topicos.domain.product.entity.Product;
import br.com.fatecmogidascruzes.topicos.infrastructure.persistence.jpa.product.ProductRepository;

import java.util.List;

public class ListProduct {
    private ProductRepository productRepository;

    public ListProduct(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> execute(){
        return productRepository.findAll();
    }
}
