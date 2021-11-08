package ru.netology.domain;

import java.util.Objects;

public class Book extends Product {
    private String author;

    public Book(String author) {
        this.author = author;
    }

    public Book(int id, String name, int price, String author) {
        super(id, name, price); // super - это и есть вызов ролительского класса и его конструктора
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    /* Переопределение метода Equals в дочернем классе необходимо для "расширение" его диапазона сравнений, т.е. будет
    сравниваться поля не только из родителького класса Product но и поля дочернего класса.
    -
    if (!super.equals(o)) return false;     - вызов метода Equals в родительском классе для сравнения полей описанных
    в родительском классе.
    Если super.equals(o) вернет false оператор ! инвертирует результат, это упирается в "механику" работы условного
    оператора if: if (условие) {если условие выполняется}
    */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author);
    }
}