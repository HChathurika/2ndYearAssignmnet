package Library.system;

import Library.model.Book;
import Library.model.LibraryMember;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<LibraryMember> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }


    public void addBook(Book book) {
        books.add(book);
    }


    public void addMember(LibraryMember member) {
        members.add(member);
    }


    public void borrowBook(LibraryMember member, Book book) {
        if (!book.isBorrowed()) {
            book.setBorrowed(true);
            member.borrowBook(book);
            System.out.println(member.getName() + " borrowed \"" + book.getTitle() + "\"");
        } else {
            System.out.println("Book \"" + book.getTitle() + "\" is already borrowed.");
        }
    }


    public void returnBook(LibraryMember member, Book book) {
        if (book.isBorrowed()) {
            book.setBorrowed(false);
            member.returnBook(book);
            System.out.println(member.getName() + " returned \"" + book.getTitle() + "\"");
        }
    }


    public void listBooks() {
        System.out.println("Library Books:");
        for (Book book : books) {
            System.out.println("- " + book.getTitle() + " (Borrowed: " + book.isBorrowed() + ")");
        }
    }

    
    public void listMembers() {
        System.out.println("Library Members:");
        for (LibraryMember member : members) {
            System.out.println("- " + member.getName());
        }
    }
}
