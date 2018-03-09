package com.abb.test;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShopCartTest {

    private final ShopCart emptyCart = new ShopCart();

    @Test
    public void cart_has_no_product_when_empty() {
        int nbProduct = emptyCart.getNbProduct();

        int zeroProductExpected = 0;
        assertThat(nbProduct).isEqualTo(zeroProductExpected);
    }

    @Test
    public void cart_has_one_product_after_adding_one_product() {
        ShopCart cartWithOneProduct = emptyCart.addProduct(1, new Product("", 0));

        int nbProduct = cartWithOneProduct.getNbProduct();

        int oneProductExpected = 1;
        assertThat(nbProduct).isEqualTo(oneProductExpected);
    }

    @Test
    public void cart_has_two_product_after_adding_product_twice() {
        Product product = new Product("", 0);
        ShopCart cartWithOneProduct = emptyCart
                .addProduct(1, product)
                .addProduct(1, product);

        int nbProduct = cartWithOneProduct.getNbProduct();

        int oneProductExpected = 2;
        assertThat(nbProduct).isEqualTo(oneProductExpected);
    }

    @Test
    public void cart_has_N_products_after_adding_product_N_times() {
        int quantity = 2;
        ShopCart cartWithOneProduct = emptyCart.addProduct(quantity, new Product("", 0));

        int nbProduct = cartWithOneProduct.getNbProduct();

        assertThat(nbProduct).isEqualTo(quantity);
    }

    @Test
    public void total_price_with_one_product_is_product_price() {
        double priceOfOneProduct = 10.;
        ShopCart cartWithOneProductCosting10 = emptyCart.addProduct(1, new Product("", priceOfOneProduct));

        double totalPriceWithOneProductCost10 = cartWithOneProductCosting10.getTotalPrice();

        assertThat(totalPriceWithOneProductCost10).isEqualTo(priceOfOneProduct);
    }

    @Test
    public void total_price_is_sum_of_all_product_prices() {
        ShopCart cartWithSomeProductWithPrice = emptyCart
                .addProduct(1, new Product("p1", 3.4))
                .addProduct(1, new Product("p2", 120.056));

        double totalPriceOfCart = cartWithSomeProductWithPrice.getTotalPrice();

        double sumOfProductPricesExpected = 123.456;
        assertThat(totalPriceOfCart).isEqualTo(sumOfProductPricesExpected);
    }

    @Test
    public void remove_one_product() {
        Product product = new Product("p", 10.);
        ShopCart cartWithOneProduct = emptyCart.addProduct(1, product);

        ShopCart cartWithNoProduct = cartWithOneProduct.removeProduct(product.getName());
        int nbProduct = cartWithNoProduct.getNbProduct();

        int zeroProductExpected = 0;
        assertThat(nbProduct).isEqualTo(zeroProductExpected);
    }

}
