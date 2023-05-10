package br.com.fatecmogidascruzes.topicos.infrastructure.web.product;

import br.com.fatecmogidascruzes.topicos.domain.product.entity.Product;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class ProductCreationRequest {
    @NotEmpty
    @Size(max = Product.MAX_NAME_LENGTH)
    private String name;
    @NotEmpty
    @Size(min = Product.MIN_DESCRIPTION_LENGTH, max = Product.MAX_DESCRIPTION_LENGTH)
    private String description;
    @NotEmpty
    @Positive
    private String quantityStock;
    @NotEmpty
    @Positive
    private String unitPrice;
    private String perishable;

    ProductCreationRequest(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuantityStock() {
        return quantityStock;
    }

    public void setQuantityStock(String quantityStock) {
        this.quantityStock = quantityStock;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getPerishable() {
        return perishable;
    }

    public void setPerishable(String perishable) {
        this.perishable = perishable;
    }

    public Product toDomain(){
        return new Product(name, description,
                Float.parseFloat(unitPrice),
                Integer.parseInt(quantityStock),
                Boolean.parseBoolean(perishable));
    }
}
