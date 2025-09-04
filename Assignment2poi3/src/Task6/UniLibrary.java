package Task6;

import java.util.ArrayList;

public class UniLibrary {
    private ArrayList<LibBook> books;
    private ArrayList<LibUser> users;

    public UniLibrary() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    // Add book
    public void addBook(LibBook book) { books.add(book); }

    // Display books
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("Library is empty.");
            return;
        }
        for (LibBook book : books) System.out.println(book);
    }

    // Find books by author
    public void findBooksByAuthor(String author) {
        boolean found = false;
        for (LibBook book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) System.out.println("No books found by " + author);
    }

    // Borrow book
    public void borrowBook(String title, LibUser user) {
        for (LibBook book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                books.remove(book);
                user.borrowBook(book);
                System.out.println(user.getName() + " borrowed: " + book);
                return;
            }
        }
        System.out.println("Book not available: " + title);
    }

    // Return book
    public void returnBook(LibBook book, LibUser user) {
        books.add(book);
        user.returnBook(book);
        System.out.println(user.getName() + " returned: " + book);
    }

    // Check availability
    public boolean isBookAvailable(String title) {
        for (LibBook book : books)
            if (book.getTitle().equalsIgnoreCase(title)) return true;
        return false;
    }

    // Average rating
    public double getAverageBookRating() {
        if (books.isEmpty()) return 0.0;
        double total = 0;
        for (LibBook book : books) total += book.getRating();
        return total / books.size();
    }

    // Most reviewed book
    public LibBook getMostReviewedBook() {
        if (books.isEmpty()) return null;
        LibBook mostReviewed = books.get(0);
        for (LibBook book : books) {
            if (book.getReviews().size() > mostReviewed.getReviews().size())
                mostReviewed = book;
        }
        return mostReviewed;
    }

    // User management
    public void addUser(LibUser user) { users.add(user); }
    public void displayUsers() {
        if (users.isEmpty()) {
            System.out.println("No users in the library.");
            return;
        }
        for (LibUser user : users) System.out.println(user);
    }
}


