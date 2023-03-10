package ru.netology.domain;

public class Book extends Product {
    private String title;
    private String author;

    public Book(int id, String name, int price, String title, String author) {
        super(id, name, price);
        this.author = author;
        this.title = title;
    }

}
