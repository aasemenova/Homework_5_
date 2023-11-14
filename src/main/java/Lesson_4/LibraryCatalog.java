package Lesson_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryCatalog {
    Map<String, Book> catalog;

    public LibraryCatalog() {
        this.catalog = new HashMap<>();
    }

    public void addBook(Book book) {
        if (!catalog.containsKey(book.bookId)) {
            catalog.put(book.bookId, book);
            System.out.println("Книга '" + book.title + "' была успешно добавлена в картотеку.");
        } else {
            System.out.println("Книга с таким ID уже существует в картотеке.");
        }
    }

    public void removeBook(String bookId) {
        if (catalog.containsKey(bookId)) {
            catalog.remove(bookId);
            System.out.println("Книга с ID " + bookId + " была успешно удалена из картотеки.");
        } else {
            System.out.println("Книги с таким ID не существует в картотеке.");
        }
    }

    public void searchBooks(String keyword, String searchBy) {
        List<Book> results = new ArrayList<>();
        if (searchBy.equals("название")) {
            catalog.forEach((id, book) -> {
                if (book.title.toLowerCase().contains(keyword.toLowerCase())) {
                    results.add(book);
                }
            });
        } else if (searchBy.equals("жанр")) {
            catalog.forEach((id, book) -> {
                if (book.genre.toLowerCase().contains(keyword.toLowerCase())) {
                    results.add(book);
                }
            });
        } else if (searchBy.equals("автор")) {
            catalog.forEach((id, book) -> {
                if (book.author.toLowerCase().contains(keyword.toLowerCase())) {
                    results.add(book);
                }
            });
        } else {
            System.out.println("Некорректный критерий поиска.");
            return;
        }

        if (!results.isEmpty()) {
            System.out.println("\nРезультаты поиска:");
            for (Book book : results) {
                System.out.println("ID: " + book.bookId + ", Название: " + book.title + ", Жанр: " + book.genre +
                        ", Автор: " + book.author + ", Год издания: " + book.year + ", Описание: " + book.description);
            }
        } else {
            System.out.println("По вашему запросу ничего не найдено.");
        }
    }
}