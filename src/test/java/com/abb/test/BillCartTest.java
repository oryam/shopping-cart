package com.abb.test;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BillCartTest {

    private final ShopCart emptyCart = new ShopCart();

    @Test
    public void show_content_of_empty_cart() {
        BillCart bill = new BillCart(emptyCart);

        String billDetailExpected = generateEmptyCartDetail();
        assertThat(bill.getCartDetail()).isEqualTo(billDetailExpected);
    }

    @Test
    public void show_content_of_cart_by_products() {
        ShopCart cartWithProducts = generateCartWithMultipleProducts();

        BillCart bill = new BillCart(cartWithProducts);

        String billDetailExpected = generateCartDetailOfTwoProducts();
        assertThat(bill.getCartDetail()).isEqualTo(billDetailExpected);
    }

    private ShopCart generateCartWithMultipleProducts() {
        ShopCart cartWithProducts = emptyCart;
        for (int i = 0; i < 3; i++) {
            cartWithProducts.addProduct(1, new Product("prod1", 10.));
        }
        for (int i = 0; i < 8; i++) {
            cartWithProducts.addProduct(1, new Product("prod2", 98.76));
        }
        return cartWithProducts;
    }

    private String generateEmptyCartDetail() {
        String header = String.join("\t", "name", "qu", "price", "total");
        String footer = String.join("\t", "TOTAL", "0", "----", "0.00");

        return String.join("\n", header, "", footer);
    }

    private String generateCartDetailOfTwoProducts() {
        String header = String.join("\t", "name", "qu", "price", "total");
        String product1detail = String.join("\t", "prod1", "3", "10.00", "30.00");
        String product2detail = String.join("\t", "prod2", "8", "98.76", "790.08");
        String footer = String.join("\t", "TOTAL", "11", "----", "820.08");

        return String.join("\n", header, product1detail, product2detail, footer);
    }

}
