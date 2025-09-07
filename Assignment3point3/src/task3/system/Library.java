package task3.system;


import task3.model.Book;
import task3.model.LibraryMember;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<LibraryMember> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) { books.add(book); }
    public void addMember(LibraryMember member) { members.add(member); }


    public void reserveBook(LibraryMember member, Book book) {
        if (!book.isReserved()) {
            book.setReserved(true);
            member.reserveBook(book);
            System.out.println(member.getName() + " reserved \"" + book.getTitle() + "\"");
        } else {
            System.out.println("Book \"" + book.getTitle() + "\" is already reserved.");
        }
    }


    public void cancelReservation(LibraryMember member, Book book) {
        if (book.isReserved() && member.hasReservedBook(book)) {
            book.setReserved(false);
            member.cancelReservation(book);
            System.out.println(member.getName() + " canceled reservation of \"" + book.getTitle() + "\"");
        } else {
            System.out.println("No reservation found for \"" + book.getTitle() + "\" by " + member.getName());
        }
    }


    public void displayReservedBooks(LibraryMember member) {
        System.out.println("Reserved books for " + member.getName() + ":");
        if (member.getReservedBooks().isEmpty()) {
            System.out.println("No reserved books.");
        } else {
            for (Book book : member.getReservedBooks()) {
                System.out.println("- " + book.getTitle());
            }
        }
    }
}

