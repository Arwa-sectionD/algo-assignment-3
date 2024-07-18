public class Main {
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

            // Validate input to ensure it's an integer
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // consume the invalid input
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ISBN to add: ");
                    while (!scanner.hasNextLong()) {
                        System.out.println("Invalid ISBN format. Please enter a valid 10-digit number.");
                        scanner.next(); // consume the invalid input
                    }
                    long isbnToAdd = scanner.nextLong();
                    db.addBook(isbnToAdd);
                    break;
                case 2:
                    System.out.print("Enter ISBN to search: ");
                    while (!scanner.hasNextLong()) {
                        System.out.println("Invalid ISBN format. Please enter a valid 10-digit number.");
                        scanner.next(); // consume the invalid input
                    }
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