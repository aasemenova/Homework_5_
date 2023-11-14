package Lesson_4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryCatalog library = new LibraryCatalog();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nВведите число в соответствии с нужным вам действием:");
            System.out.println("1. Добавить книгу");
            System.out.println("2. Удалить книгу");
            System.out.println("3. Найти книгу");
            System.out.println("4. Выйти");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Введите ID книги: ");
                    String bookId = scanner.nextLine();
                    System.out.println("Введите название книги: ");
                    String title = scanner.nextLine();
                    System.out.println("Введите жанр книги: ");
                    String genre = scanner.nextLine();
                    System.out.println("Введите имя и фамилию автора: ");
                    String author = scanner.nextLine();
                    System.out.println("Введите год издания: ");
                    int year = Integer.parseInt(scanner.nextLine());
                    System.out.println("Введите краткое описание книги: ");
                    String description = scanner.nextLine();
                    Book newBook = new Book(bookId, title, genre, author, year, description);
                    library.addBook(newBook);
                    break;
                case "2":
                    System.out.println("Введите ID книги, которую хотите удалить: ");
                    String bookIdToRemove = scanner.nextLine();
                    library.removeBook(bookIdToRemove);
                    break;
                case "3":
                    System.out.println("Выберите критерий поиска (название, жанр, автор): ");
                    String searchBy = scanner.nextLine();
                    System.out.println("Введите ключевовое слово для поиска: ");
                    String keyword = scanner.nextLine();
                    library.searchBooks(keyword, searchBy);
                    break;
                case "4":
                    System.out.println("Работа с книжной картотекой завершена.");
                    System.exit(0);
                default:
                    System.out.println("Некорректный выбор. Пожалуйста, выберите существующий номер действия.");
            }
        }
    }
}