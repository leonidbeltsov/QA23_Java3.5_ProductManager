package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {
    Product product1 = new Book(1, "testBook", 150, "Petrov");
    Product product2 = new Book(2, "testBook", 50, "Petrov");
    Product product3 = new Smartphone(3, "TestPhone", 1000, "Samsung");
    Product product4 = new Smartphone(4, "TestPhone1", 1000, "LG");

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    @BeforeEach
    public void setUp() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
    }

    @Test
    public void shouldSearchByName() {
        Product[] actual = manager.searchBy("testBook");
        Product[] expected = new Product[]{product1, product2};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchByMaker() {
        Product[] actual = manager.searchBy("LG");
        Product[] expected = new Product[]{product4};
        assertArrayEquals(actual, expected);
    }


    @Test
    public void shouldSearchByAuthor() {
        Product[] actual = manager.searchBy("Petrov");
        Product[] expected = new Product[]{product1, product2};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchByAuthorFindNothing() {
        Product[] actual = manager.searchBy("Beltsov");
        Product[] expected = new Product[]{};
        assertArrayEquals(actual, expected);
    }
}