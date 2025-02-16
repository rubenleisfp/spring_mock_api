package com.fp.mockapi.carts.service;

import com.fp.mockapi.carts.model.Cart;
import com.fp.mockapi.carts.model.CartPage;
import com.fp.mockapi.carts.model.Product;
import com.fp.mockapi.carts.repository.CartRepository;
import com.fp.mockapi.products.service.ProductService;
import com.fp.mockapi.utils.exceptions.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CartService {

    private static Logger LOG = LoggerFactory.getLogger(CartService.class);

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductService productService;

    private CartPage cartPage;


    public CartService(CartRepository cartRepository){
        this();
        this.cartRepository = cartRepository;
    }

    public CartService() {
        JsonUtils jsonUtils = new JsonUtils();
        cartPage = jsonUtils.getCartPage();
    }


    public CartPage getAll() {
        return cartRepository.getAll();
    }

    public CartPage getByUserId(int id) {
        return cartRepository.getByUserId(id);
    }

    /**
     * Respuesta hardcoded para devolver un producto de Carts
     * Es compleja la devolución de este elemento, ya que el API utiliza
     * productos que no expone en getAll, sale de productos ocultos
     *
     * @return
     */
    public Cart getAddHarcodedResponse() {
        Cart expectedCart = new Cart();
        expectedCart.setId(51);
        expectedCart.setUserId(1);
        expectedCart.setTotal(56044.95);
        expectedCart.setDiscountedTotal(55581.0);
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
        return expectedCart;
    }
}