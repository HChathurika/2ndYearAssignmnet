import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<Book>();
    public void addBook(Book book) {
        books.add(book);

    }
    public void displayBooks() {
        System.out.println("Library index");
                int index =1;
        for (Book book : books) {
            System.out.println(index + ". Title: \"" + book.getTitle()
                    + "\", Author: \"" + book.getAuthor()
                    + "\", Year: " + book.getPublicationYear());
            index++;
        }
    }
    public void findBooksByAuthor(String author) {
        System.out.println("Books by " + author + ":");
        int index = 1;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(index + ". Title: \"" + book.getTitle()
                        + "\", Year: " + book.getPublicationYear());
                index++;
            }
        }
        if (index == 1) { // no books found
            System.out.println("No books found by this author.");
        }
    }
}





