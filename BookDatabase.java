import java.util.Scanner;

public class BookDatabase {
    private static final int MAX_BOOKS = 100; // Maximum number of books in the database
    private long[] isbnArray = new long[MAX_BOOKS];
    private int bookCount = 0;

    // Method to validate ISBN number
    private boolean validateISBN(long isbn) {
        // Example range for validation
        long lowerBound = 1000000000L; // 10-digit minimum
        long upperBound = 9999999999L; // 10-digit maximum
        return isbn >= lowerBound && isbn <= upperBound;
    }

    // Method to add a book to the database
    public void addBook(long isbn) {
        if (validateISBN(isbn)) {
            if (bookCount < MAX_BOOKS) {
                isbnArray[bookCount++] = isbn;
                System.out.println("Book with ISBN " + isbn + " added to the database.");
            } else {
                System.out.println("Database is full. Cannot add more books.");
            }
        } else {
            System.out.println("Invalid ISBN. Cannot add to the database.");
        }
    }

    // Method to search for an ISBN in the database
    public boolean searchISBN(long isbn) {
        for (int i = 0; i < bookCount; i++) {
            if (isbnArray[i] == isbn) {
                return true;
            }
        }
        return false;
    }

    // Method to print all ISBNs in the database
    public void printAllISBNs() {
        if (bookCount == 0) {
            System.out.println("No books in the database.");
        } else {
            System.out.println("Books in the database:");
            for (int i = 0; i < bookCount; i++) {
                System.out.println(isbnArray[i]);
            }
        }
    }

    // Main method for user interaction
    public static void main(String[] args) {
        BookDatabase db = new BookDatabase();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Add Book");
            System.out.println("2. Search Book");
            System.out.println("3. Print All Books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ISBN to add: ");
                    long isbnToAdd = scanner.nextLong();
                    db.addBook(isbnToAdd);
                    break;
                case 2:
                    System.out.print("Enter ISBN to search: ");
                    long isbnToSearch = scanner.nextLong();
                    boolean found = db.searchISBN(isbnToSearch);
                    if (found) {
                        System.out.println("Book with ISBN " + isbnToSearch + " is found in the database.");
                    } else {
                        System.out.println("Book with ISBN " + isbnToSearch + " is not found in the database.");
                    }
                    break;
                case 3:
                    db.printAllISBNs();
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
