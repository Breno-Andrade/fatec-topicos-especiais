package br.com.fatecmogidascruzes.topicos.product;


public class ProductPM {
    private String id;
    private String name;
    private String description;
    private String quantityStock;
    private String unitPrice;
    private String perishable;

    public ProductPM(Product product){
        setId(product.getId().toString());
        setName(product.getName());
        setDescription(product.getDescription());
        setQuantityStock(Integer.toString(product.getQuantityStock()));
        setUnitPrice(Float.toString(product.getUnitPrice()));
        setPerishable(Boolean.toString(product.isPerishable()));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
