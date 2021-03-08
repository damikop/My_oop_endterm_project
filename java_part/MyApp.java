package com.company;
import com.company.BookRepository;
import com.company.BookController;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApp {
    private final BookController controller2;
    private final Scanner scanner;

    public MyApp(BookController controller2) {
        this.controller2 = controller2;
        scanner = new Scanner(System.in);
    }
    public void start2() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to Our Library");
            System.out.println("Select option:");
            System.out.println("1. Get all books");
            System.out.println("2. Get book by title");
            System.out.println("3. Add book");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-3): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllBooksMenu();
                } else if (option == 2) {
                    getBookByTitleMenu();}
                 else if (option == 3) {
                    addBookMenu();
                }
                else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                scanner.nextLine(); // to ignore incorrect input
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("*************************");

        }
    }
    public void getAllBooksMenu() {
        String response2 = controller2.getAllBooks();
        System.out.println(response2);
    }

    public void getBookByTitleMenu() {
        System.out.println("Please enter ISBN of the book");

        int ISBN = scanner.nextInt();
        String response2 = controller2.getBook(ISBN);
        System.out.println(response2);
    }

    public void addBookMenu() {
        System.out.println("Please enter ISBN");
        int ISBN = scanner.nextInt();
        System.out.println("Please enter title");
        String title = scanner.next();
        System.out.println("Please enter author");
        String author = scanner.next();
        System.out.println("Please enter category");
        String category = scanner.next();

        String response2 = controller2.addBook(ISBN, title, author, category);
        System.out.println(response2);
    }
}
