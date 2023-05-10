package br.com.fatecmogidascruzes.topicos.domain.product.entity;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.util.Objects;

@Entity
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public static final int MAX_NAME_LENGTH = 100;
    @Column(length = MAX_NAME_LENGTH, nullable = false)
    private String name;

    public static final int MIN_DESCRIPTION_LENGTH = 10;
    public static final int MAX_DESCRIPTION_LENGTH = 200;
    @Column(length = MAX_DESCRIPTION_LENGTH)
    private String description;

    @Positive
    private float unitPrice;
    @Positive
    private int quantityStock;
    private boolean perishable;

    Product() {}

    public Product(String name, String description, float unitPrice, int quantityStock, boolean perishable) {
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.quantityStock = quantityStock;
        this.perishable = perishable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String tempName = Objects.requireNonNull(Strings.trimToNull(name),
                "The name is required");
        if(tempName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("The name cannot have more than " + MAX_NAME_LENGTH + " chars.");
        }
        this.name = tempName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = Objects.requireNonNull(description, "The Description is required");
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = Objects.requireNonNull(unitPrice, "The Price is required");
    }

    public int getQuantityStock() {
        return quantityStock;
    }

    public void setQuantityStock(int quantityStock) {
        this.quantityStock = Objects.requireNonNull(quantityStock, "The Quantity Stock is required");
    }

    public boolean isPerishable() {
        return perishable;
    }

    public void setPerishable(boolean perishable) {
        this.perishable = perishable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

