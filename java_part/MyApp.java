package com.company;

//importing created repository and contoller
import com.company.BookRepository;
import com.company.BookController;

//to indicate that the token retrieved does not match the pattern for the expected type, or that the token is out of range for the expected type.
import java.util.InputMismatchException;

//to get user input
import java.util.Scanner;

public class MyApp {
    private final BookController dinoController2;
    private final Scanner scanner;

    public MyApp(BookController dinoController2) {
        this.dinoController2 = dinoController2;
        scanner = new Scanner(System.in);
    }
    public void dinoStart2() {
        while (true) {
            //printing options for the user to do some book operations
            System.out.println();
            System.out.println("Welcome to Our Library");
            System.out.println("Select option:");
            System.out.println("1. Get all books");
            System.out.println("2. Get book by title");
            System.out.println("3. Add book");
            System.out.println("0. Exit");
            System.out.println();
            
            //"try" - to define a block of code to be tested for errors while it is being executed.
            try {
                System.out.print("Enter option (1-3): ");
                int dinoOption = scanner.nextInt();

                //using conditions executing operations according to user's input (0-3)                
                if (dinoOption == 1) {
                    getAllBooksMenu();
                } else if (dinoOption == 2) {
                    getBookByTitleMenu();}
                 else if (dinoOption == 3) {
                    addBookMenu();
                }
                
                else {
                    break;
                }
                
            } 
            
            //"catch" - to define a block of code to be executed, if an error occurs in the try block.
            catch (InputMismatchException dinoE) {
                // to ignore incorrect input
                System.out.println("Input must be integer");
                scanner.nextLine();                 
            }
            catch (Exception dinoE) {
                System.out.println(dinoE.getMessage());
            }

            System.out.println("*************************");

        }
    }
    
    //view all available books
    public void getAllBooksMenu() {
        String dinoResponse2 = dinoController2.getAllBooks();
        
        System.out.println(dinoResponse2);
    }

    //to fInd the book knwoing only its ID
    public void getBookByTitleMenu() {
        System.out.println("Please enter ISBN of the book");

        int ISBN = scanner.nextInt();
        String dinoResponse2 = dinoController2.getBook(ISBN);
        
        System.out.println(dinoResponse2);
    }

    //to add book
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
