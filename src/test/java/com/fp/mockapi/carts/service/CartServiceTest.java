package com.fp.mockapi.carts.service;

import com.fp.mockapi.carts.model.Product;
import com.fp.mockapi.carts.repository.impl.CartMemoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fp.mockapi.carts.model.Cart;
import com.fp.mockapi.carts.model.CartPage;
import com.fp.mockapi.carts.repository.CartRepository;
import com.fp.mockapi.carts.service.CartService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CartServiceTest {

    @Autowired
    private CartRepository cartRepository;

    private CartService cartService;

    @Before
    public void setup() {
        cartRepository = new CartMemoryRepository();
        cartService = new CartService(cartRepository);
    }

    @Test
    public void testGetAll() {
        CartPage cartPage = cartService.getAll();
        assertNotNull(cartPage);
        assertNotNull(cartPage.getCarts());

        assertEquals(30, cartPage.getCarts().size());
        assertEquals(30, cartPage.getLimit());
        assertEquals(50, cartPage.getTotal());

        // Valida que el primer carrito sea el esperado
        assertEquals(getExpectedCartGetAll(), cartPage.getCarts().get(0));
    }

    @Test
    public void testGetByUserId() {
        CartPage cartPage = cartService.getByUserId(6);
        assertNotNull(cartPage.getCarts());
        // Valida que devuelva 1 carro
        assertEquals(1, cartPage.getCarts().size());
        // Valida que el primer elemento sea el esperado
        assertEquals(getExpectedCartByUser(), cartPage.getCarts().get(0));
    }

    @Test
    public void testGetAddHarcodedResponse() {


        Cart expectedCart = new Cart();
        expectedCart.setId(51);
        expectedCart.setUserId(1);
        expectedCart.setTotal(56044.95);
        expectedCart.setDiscountedTotal(55581);
        expectedCart.setTotalProducts(2);
        expectedCart.setTotalQuantity(5);

        List<Product> expectedProducts = new ArrayList<>();

        Product expectedProduct1 = new Product();
        expectedProduct1.setId(98);
        expectedProduct1.setTitle("Rolex Submariner Watch");
        expectedProduct1.setPrice(13999.99);
        expectedProduct1.setQuantity(4);
        expectedProduct1.setTotal(55999.96);
        expectedProduct1.setDiscountPercentage(0.82);
        expectedProduct1.setDiscountedPrice(55541);
        expectedProduct1.setThumbnail("https://cdn.dummyjson.com/products/images/mens-watches/Rolex%20Submariner%20Watch/thumbnail.png");
        expectedProducts.add(expectedProduct1);

        Product expectedProduct2 = new Product();
        expectedProduct2.setId(144);
        expectedProduct2.setTitle("Cricket Helmet");
        expectedProduct2.setPrice(44.99);
        expectedProduct2.setQuantity(1);
        expectedProduct2.setTotal(44.99);
        expectedProduct2.setDiscountPercentage(10.75);
        expectedProduct2.setDiscountedPrice(40);
        expectedProduct2.setThumbnail("https://cdn.dummyjson.com/products/images/sports-accessories/Cricket%20Helmet/thumbnail.png");
        expectedProducts.add(expectedProduct2);

        expectedCart.setProducts(expectedProducts);

        Cart cart = cartService.getAddHarcodedResponse();
        assertNotNull(cart);
        assertEquals(expectedCart, cart);
    }

    private Cart getExpectedCartByUser() {
        Cart cart = new Cart();
        cart.setId(24);
        cart.setUserId(6);
        cart.setTotalProducts(3);
        cart.setTotalQuantity(10);
        cart.setTotal(1749.9);
        cart.setDiscountedTotal(1594.33);

        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setId(108);
        product1.setTitle("iPhone 12 Silicone Case with MagSafe Plum");
        product1.setPrice(29.99);
        product1.setQuantity(5);
        product1.setTotal(149.95);
        product1.setDiscountPercentage(14.68);
        product1.setDiscountedTotal(127.94);
        product1.setDiscountedPrice(0.0);
        product1.setThumbnail("https://cdn.dummyjson.com/products/images/mobile-accessories/iPhone%2012%20Silicone%20Case%20with%20MagSafe%20Plum/thumbnail.png");
        products.add(product1);

        Product product2 = new Product();
        product2.setId(134);
        product2.setTitle("Vivo S1");
        product2.setPrice(249.99);
        product2.setQuantity(4);
        product2.setTotal(999.96);
        product2.setDiscountPercentage(5.64);
        product2.setDiscountedTotal(943.56);
        product2.setDiscountedPrice(0.0);
        product2.setThumbnail("https://cdn.dummyjson.com/products/images/smartphones/Vivo%20S1/thumbnail.png");
        products.add(product2);

        Product product3 = new Product();
        product3.setId(174);
        product3.setTitle("Prada Women Bag");
        product3.setPrice(599.99);
        product3.setQuantity(1);
        product3.setTotal(599.99);
        product3.setDiscountPercentage(12.86);
        product3.setDiscountedTotal(522.83);
        product3.setDiscountedPrice(0.0);
        product3.setThumbnail("https://cdn.dummyjson.com/products/images/womens-bags/Prada%20Women%20Bag/thumbnail.png");
        products.add(product3);

        cart.setProducts(products);

        return cart;
    }

    private Cart getExpectedCartGetAll() {
        Cart cart = new Cart();
        cart.setUserId(33);
        cart.setId(1);

        List<Product> products = new ArrayList<>();

        Product product1 = new Product();
        product1.setId(168);
        product1.setTitle("Charger SXT RWD");
        product1.setPrice(32999.99);
        product1.setQuantity(3);
        product1.setTotal(98999.97);
        product1.setDiscountPercentage(13.39);
        product1.setDiscountedTotal(85743.87);
        product1.setDiscountedPrice(0);
        product1.setThumbnail("https://cdn.dummyjson.com/products/images/vehicle/Charger%20SXT%20RWD/thumbnail.png");
        products.add(product1);

        Product product2 = new Product();
        product2.setId(78);
        product2.setTitle("Apple MacBook Pro 14 Inch Space Grey");
        product2.setPrice(1999.99);
        product2.setQuantity(2);
        product2.setTotal(3999.98);
        product2.setDiscountPercentage(18.52);
        product2.setDiscountedTotal(3259.18);
        product2.setDiscountedPrice(0);
        product2.setThumbnail("https://cdn.dummyjson.com/products/images/laptops/Apple%20MacBook%20Pro%2014%20Inch%20Space%20Grey/thumbnail.png");
        products.add(product2);

        Product product3 = new Product();
        product3.setId(183);
        product3.setTitle("Green Oval Earring");
        product3.setPrice(24.99);
        product3.setQuantity(5);
        product3.setTotal(124.94999999999999);
        product3.setDiscountPercentage(6.28);
        product3.setDiscountedTotal(117.1);
        product3.setDiscountedPrice(0);
        product3.setThumbnail("https://cdn.dummyjson.com/products/images/womens-jewellery/Green%20Oval%20Earring/thumbnail.png");
        products.add(product3);

        Product product4 = new Product();
        product4.setId(100);
        product4.setTitle("Apple Airpods");
        product4.setPrice(129.99);
        product4.setQuantity(5);
        product4.setTotal(649.95);
        product4.setDiscountPercentage(12.84);
        product4.setDiscountedTotal(566.5);
        product4.setDiscountedPrice(0);
        product4.setThumbnail("https://cdn.dummyjson.com/products/images/mobile-accessories/Apple%20Airpods/thumbnail.png");
        products.add(product4);

        cart.setProducts(products);
        cart.setTotal(103774.85);
        cart.setDiscountedTotal(89686.65);
        cart.setUserId(33);
        cart.setTotalProducts(4);
        cart.setTotalQuantity(15);

        return cart;

    }
}