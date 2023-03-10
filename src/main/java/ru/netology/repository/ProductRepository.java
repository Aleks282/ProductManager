package ru.netology.repository;

import ru.netology.domain.Product;

public class ProductRepository {
    private Product[] products = new Product[0];


    public void addProduct(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[products.length] = product;
        products = tmp;
    }

    public Product[] getAll() {
        return products;
    }

    public void deleteID(int id) {
        int i = 0;
        Product[] tmp = new Product[products.length - 1];
        for (Product prod : products) {
            if (prod.getId() != id) {
                tmp[i] = prod;
                i++;
            }
        }
        products = tmp;
    }

}
