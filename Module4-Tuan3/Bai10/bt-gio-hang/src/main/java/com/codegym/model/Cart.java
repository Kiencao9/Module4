package com.codegym.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Long> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Long> products) {
        this.products = products;
    }
    public Map<Product, Long> getProducts() {
        return products;
    }

    private boolean checkItemInCart(Product product) {
        for (Map.Entry<Product, Long> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return true;
            }
        }
        return false;
    }

    public Integer countItemQuantity(){
        return products.size();
    }

    public Map.Entry<Product, Long> selectItemCart(Product product) {
        for (Map.Entry<Product, Long> entry: products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        if (!checkItemInCart(product)) {
            products.put(product, 1L);
        } else {
            Map.Entry<Product, Long> itemEntry = selectItemCart(product);
            Long newQuantity = itemEntry.getValue() + 1L;
            products.replace(itemEntry.getKey(),newQuantity);
        }
    }

    public Long countProductQuantity() {
        Long productQuantity = 0L;
        for (Map.Entry<Product, Long> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

}

