package com.abb.test;

public class ProductCart {

    private final Product product;
    private int quantity;

    public ProductCart(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void add(int quantityToAdd) {
        this.quantity += quantityToAdd;
    }

    public double getTotalPrice() {
        return quantity * product.getPrice();
    }

}
