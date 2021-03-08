package com.company;

public class Book {
    private int ISBN;
    private String title;
    private String author;
    private String category;

    //constructor
    public Book() {

    }

    public Book(String title, String author, String category) {
        setTitle(title);
        setAuthor(author);
        setCategory(category);
    }

    public Book(int ISBN, String title, String author, String category) {
        setISBN(ISBN);
        setTitle(title);
        setAuthor(author);
        setCategory(category);
    }

    //setters and getters for all filed of Book
    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    //toString method for fields
    @Override
    public String toString() {
        return "Book{" +
                "ISBN=" + ISBN +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category=" + category +
                '}';
    }
}
