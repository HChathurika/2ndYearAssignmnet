package Task2;


import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();


    public void addBook(Book book) {
        books.add(book);
    }


    public void displayBooks() {
        System.out.println("Library Catalog:");
        int index = 1;
        for (Book book : books) {
            String status = book.isBorrowed() ? " (Borrowed)" : " (Available)";
            System.out.println(index + ". Title: \"" + book.getTitle()
                    + "\", Author: \"" + book.getAuthor()
                    + "\", Year: " + book.getPublicationYear() + status);
            index++;
        }
    }


    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!book.isBorrowed()) {
                    book.borrowBook();
                    System.out.println("You borrowed: " + book.getTitle());
                } else {
                    System.out.println("Sorry, this book is already borrowed.");
                }
                return; // stop after finding
            }
        }
        System.out.println("Book not found in library.");
    }


    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isBorrowed()) {
                    book.returnBook();
                    System.out.println("You returned: " + book.getTitle());
                } else {
                    System.out.println("This book was not borrowed.");
                }
                return;
            }
        }
        System.out.println("Book not found in library.");
    }
}

