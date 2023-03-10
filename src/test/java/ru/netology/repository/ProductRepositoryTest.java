package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class ProductRepositoryTest {
    @Test
    public void addFile() {
        Book book1 = new Book(1, "Книга", 500, "Как закалялась сталь", "Николай Островский");
        Smartphone smartphone1 = new Smartphone(2, "Смартфон", 40_400, "Xiaomi 13 12/256 GB", "Xiaomi");
        ProductRepository repo = new ProductRepository();
        repo.addProduct(book1);
        repo.addProduct(smartphone1);

        Product[] expected = {book1, smartphone1};
        Product[] actual = repo.getAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void deleteId() {
        Book book1 = new Book(1, "Книга", 500, "Как закалялась сталь", "Николай Островский");
        Smartphone smartphone1 = new Smartphone(2, "Смартфон", 40_000, "Xiaomi 13 12/256 GB", "Xiaomi");
        ProductRepository repo = new ProductRepository();
        repo.addProduct(book1);
        repo.addProduct(smartphone1);
        repo.deleteID(1);

        Product[] expected = {smartphone1};
        Product[] actual = repo.getAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}
