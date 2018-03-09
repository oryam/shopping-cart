package com.abb.test;

import java.util.stream.Collectors;

public class BillCart {

    private static final String COLUMN_SEPARATOR = "\t";
    private static final String EOF = "\n";
    private static final String PRICE_FORMAT = "%.2f";

    private final ShopCart cart;

    public BillCart(ShopCart cart) {
        this.cart = cart;
    }

    public String getCartDetail() {
        String header = String.join(COLUMN_SEPARATOR, "name", "qu", "price", "total");

        String allProductDetail = this.cart
                .getProductCarts()
                .stream()
                .map(this::getProductDetail)
                .collect(Collectors.joining(EOF));

        String footer = String.join(COLUMN_SEPARATOR,
                "TOTAL",
                String.format("%d", this.cart.getNbProduct()),
                "----",
                String.format(PRICE_FORMAT, this.cart.getTotalPrice()));

        return String.join(EOF, header, allProductDetail, footer);
    }

    private String getProductDetail(ProductCart productCart) {
        return String.join(COLUMN_SEPARATOR,
                productCart.getProduct().getName(),
                String.valueOf(productCart.getQuantity()),
                String.format(PRICE_FORMAT, productCart.getProduct().getPrice()),
                String.format(PRICE_FORMAT, productCart.getTotalPrice())
        );
    }

}
