package com.fp.mockapi.product.repository;

import com.fp.mockapi.product.model.Product;
import com.fp.mockapi.product.model.ProductPage;
import com.fp.mockapi.utils.exceptions.JsonUtils;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class ProductMemoryRepository implements ProductRepository {

    private final ProductPage productPage;

    public ProductMemoryRepository() {
        JsonUtils jsonUtils = new JsonUtils();
        productPage = jsonUtils.getProductPage();
    }

    @Override
    public ProductPage getAll() {
        return productPage;
    }

    @Override
    public Optional<Product> getById(int id) {
        return productPage.getProducts().stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }
}
