import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private double price;
    private int quantity;

    public Book(String title, String author, double price, int quantity) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class Bookstore {
    private Map<String, Book> books;

    public Bookstore() {
        books = new HashMap<>();
    }

    public void addBook(String title, String author, double price, int quantity) {
        Book book = new Book(title, author, price, quantity);
        books.put(title, book);
        System.out.println("Book added successfully: " + title);
    }

    public void sellBook(String title, int quantity) {
        if (books.containsKey(title)) {
            Book book = books.get(title);
            int availableQuantity = book.getQuantity();
            if (availableQuantity >= quantity) {
                book.setQuantity(availableQuantity - quantity);
                System.out.println("Sold " + quantity + " copies of " + title + ". Remaining quantity: " + book.getQuantity());
            } else {
                System.out.println("Insufficient quantity of " + title + " available.");
            }
        } else {
            System.out.println("Book not found: " + title);
        }
    }

    public void displayInventory() {
        System.out.println("Current Book Inventory:");
        for (Map.Entry<String, Book> entry : books.entrySet()) {
            Book book = entry.getValue();
            System.out.println("Title: " + book.getTitle() + " | Author: " + book.getAuthor() +
                    " | Price: $" + book.getPrice() + " | Quantity: " + book.getQuantity());
        }
    }
}

public class BookstoreManagement {
    public static void main(String[] args) {
        Bookstore bookstore = new Bookstore();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("Welcome to the Bookstore Management System!");
            System.out.println("1. Add Book");
            System.out.println("2. Sell Book");
            System.out.println("3. Display Inventory");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter price: $");
                    double price = scanner.nextDouble();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    bookstore.addBook(title, author, price, quantity);
                    break;
                case 2:
                    System.out.print("Enter title to sell: ");
                    String sellTitle = scanner.nextLine();
                    System.out.print("Enter quantity to sell: ");
                    int sellQuantity = scanner.nextInt();
                    bookstore.sellBook(sellTitle, sellQuantity);
                    break;
                case 3:
                    bookstore.displayInventory();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting the Bookstore Management System. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
