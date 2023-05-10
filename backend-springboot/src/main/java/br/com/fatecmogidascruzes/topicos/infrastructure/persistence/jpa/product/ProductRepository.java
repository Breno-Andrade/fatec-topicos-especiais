package br.com.fatecmogidascruzes.topicos.infrastructure.persistence.jpa.product;

import br.com.fatecmogidascruzes.topicos.domain.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
        Optional<Product> findById(Long id);

}
