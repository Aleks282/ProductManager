package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.*;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product product1  = new Product(1, "Как закалялась сталь", 200);
    Product product2 = new Product(2, "Айвенго", 300);
    Product product3 = new Product(3, "Xiaomi", 6000);
    Product product4  = new Book(1, "Как закалялась сталь", 200,"Островский");
    Product product5  = new Smartphone(5, "Xiaomi", 2000,"China");
    @BeforeEach
    public void setup() {
        manager.save(product1);
        manager.save(product2);
        manager.save(product3);
        manager.save(product4);
        manager.save(product5);
    }

    @Test
    public void shouldFindByName() {
        String name = "Айвенго";
        Product[] expected = new Product[]{product2};
        Product[] actual = manager.searchBy(name);
        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void shouldProductDoesNotExit() {//Найти несуществующий продукт
        String nameToSearch = "ГОД";
        Product[] expected = {};
        Product[] actual = manager.searchBy( nameToSearch );
        Assertions.assertArrayEquals( expected, actual );
    }
    @Test
    public void shouldFindByAuthor() {
        String author = "Островский";
        Product[] expected = new Book[]{};
        Product[] actual = manager.searchBy(author);
        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void shouldFindByManufacturer() {
        String manufacturer = "China";
        Product[] expected = new Smartphone[]{};
        Product[] actual = manager.searchBy(manufacturer);
        Assertions.assertArrayEquals(expected, actual);

    }
}