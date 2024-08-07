package  demo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LibrarySystem {
    private ArrayList<String> books;

    public LibrarySystem() {
        books = new ArrayList<>();
    }
    // Add a new book title to the list
    public void addBook(String title) {
        if (title != null && !title.trim().isEmpty()) {
            books.add(title);
            System.out.println("Book \"" + title + "\" added.");
        } else {
            System.out.println("Invalid book title.");
        }
    }
    // Remove a specific book title from the list
    public void removeBook(String title) {
        if (books.remove(title)) {
            System.out.println("Book \"" + title + "\" removed.");
        } else {
            System.out.println("Book \"" + title + "\" not found.");
        }
    }

    // Search for a book title and return its index if found
    public void searchBook(String title) {
        int index = books.indexOf(title);
        if (index >= 0) {
            System.out.println("Book \"" + title + "\" found at index " + index + ".");
        } else {
            System.out.println("Book \"" + title + "\" not found.");
        }
    }

    // Display all the book titles in the list
    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the list.");
        } else {
            System.out.println("List of books:");
            for (int i = 0; i < books.size(); i++) {
                System.out.println(i + ". " + books.get(i));
            }
        }
    }

    // Sort the book titles alphabetically
    public void sortBooks() {
        Collections.sort(books);
        System.out.println("Books sorted alphabetically.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibrarySystem library = new LibrarySystem();

        while (true) {
            System.out.println("\nLibrary System Menu:");
            System.out.println("1. Add a Book Title");
            System.out.println("2. Remove a Book Title");
            System.out.println("3. Search for a Book Title");
            System.out.println("4. List All Book Titles");
            System.out.println("5. Sort Book Titles");
            System.out.println("6. Exit");

            System.out.print("Enter your choice (1-6): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the book title to add: ");
                    String addTitle = scanner.nextLine();
                    library.addBook(addTitle);
                    break;
                case 2:
                    System.out.print("Enter the book title to remove: ");
                    String removeTitle = scanner.nextLine();
                    library.removeBook(removeTitle);
                    break;
                case 3:
                    System.out.print("Enter the book title to search for: ");
                    String searchTitle = scanner.nextLine();
                    library.searchBook(searchTitle);
                    break;
                case 4:
                    library.listBooks();
                    break;
                case 5:
                    library.sortBooks();
                    break;
                case 6:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }
}
