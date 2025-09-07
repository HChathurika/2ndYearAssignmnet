package task3.model;




import java.util.ArrayList;
import java.util.List;

public class LibraryMember {
    private String name;
    private int memberId;
    private List<Book> reservedBooks;

    public LibraryMember(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.reservedBooks = new ArrayList<>();
    }

    public String getName() { return name; }
    public int getMemberId() { return memberId; }
    public List<Book> getReservedBooks() { return reservedBooks; }

    public void reserveBook(Book book) { reservedBooks.add(book); }
    public void cancelReservation(Book book) { reservedBooks.remove(book); }
    public boolean hasReservedBook(Book book) { return reservedBooks.contains(book); }
}
