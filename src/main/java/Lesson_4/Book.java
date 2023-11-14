package Lesson_4;

public class Book {
    String bookId;
    String title;
    String genre;
    String author;
    int year;
    String description;

    public Book(String bookId, String title, String genre, String author, int year, String description) {
        this.bookId = bookId;
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.year = year;
        this.description = description;
    }
}