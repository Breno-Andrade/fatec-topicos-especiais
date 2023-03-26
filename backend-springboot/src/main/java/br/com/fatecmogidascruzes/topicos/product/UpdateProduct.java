package br.com.fatecmogidascruzes.topicos.product;

import java.util.Optional;

public class UpdateProduct {
    private ProductRepository productRepository;

    public UpdateProduct(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void execute(Long id, Product product){
        Optional<Product> opDatabaseProduct = productRepository.findById(id);
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
