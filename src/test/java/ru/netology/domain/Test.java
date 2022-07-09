package ru.netology.domain;

import org.junit.jupiter.api.Assertions;

public class Test {
    Product first = new Book(12, "ArchipelagoGulage", 680, "Solzhenitsyn");
    Product second = new Smartphone(45, "Samsung", 25000, "SouthKorea");
    Product third = new Book(78, "GriefFromTheMind", 530, "Griboedov");
    Product fourth = new Smartphone(29, "Apple", 180000, "USA");

    @org.junit.jupiter.api.Test
    public void myTest() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.save(fourth);
        Product[] actual = repo.findAll();
        Product[] expected = {first, second, third, fourth};
        Assertions.assertArrayEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void myTest2() {
        ProductRepository repo = new ProductRepository();
        repo.save(first);
        repo.save(second);
        repo.removeById(45);
        Product[] actual = repo.findAll();
        Product[] expected = {first};
        Assertions.assertArrayEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void myTest3() {
        ProductRepository repo = new ProductRepository();

        ProductManager manager = new ProductManager(repo);
        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.save(fourth);
        Product[] actual = manager.searchBy("App");
        Product[] expected = {fourth};
        Assertions.assertArrayEquals(expected, actual);


    }

    @org.junit.jupiter.api.Test
    public void myTest4() {
        ProductRepository repo = new ProductRepository();

        ProductManager manager = new ProductManager(repo);
        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.save(fourth);
        Product[] actual = manager.searchBy("g");
        Product[] expected = {first, second,};
        Assertions.assertArrayEquals(expected, actual);


    }

    @org.junit.jupiter.api.Test
    public void myTest5() {
        ProductRepository repo = new ProductRepository();

        ProductManager manager = new ProductManager(repo);
        repo.save(first);
        repo.save(second);
        Product[] actual = manager.searchBy("g");
        Product[] expected = {first, second};
        Assertions.assertArrayEquals(expected, actual);


    }

    @org.junit.jupiter.api.Test
    public void myTest6() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        repo.save(first);
        repo.save(second);
        repo.save(third);
        Product[] actual = manager.searchBy("App");
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, actual);


    }

    @org.junit.jupiter.api.Test
    public void myTest7() {
        ProductRepository repo = new ProductRepository();
        repo.save(first);
        repo.save(second);
        repo.removeById(12);
        Product[] actual = repo.findAll();
        Product[] expected = {second};
        Assertions.assertArrayEquals(expected, actual);
    }


    @org.junit.jupiter.api.Test
    public void myTest8() {
        ProductRepository repo = new ProductRepository();
        repo.save(first);
        repo.save(second);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(-12);
        });


    }

}




