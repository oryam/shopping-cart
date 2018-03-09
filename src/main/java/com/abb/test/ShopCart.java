package com.abb.test;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class ShopCart {

    private final Map<String, ProductCart> products = new TreeMap<>();

    public ShopCart addProduct(int quantity, Product product) {
        String productKey = product.getName();
        if (!this.products.containsKey(productKey)) {
            this.products.put(productKey, new ProductCart(product));
        }

        this.products.get(product.getName()).add(quantity);
        return this;
    }

    public ShopCart removeProduct(String productKey) {
        this.products.remove(productKey);
        return this;
    }

    public int getNbProduct() {
        return this.products.values().stream().mapToInt(ProductCart::getQuantity).sum();
    }

    public double getTotalPrice() {
        return this.products.values().stream().mapToDouble(ProductCart::getTotalPrice).sum();
    }

    public Collection<ProductCart> getProductCarts() {
        return products.values();
    }

}
