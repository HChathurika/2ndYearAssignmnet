package task3;


import task3.model.Book;
import task3.model.LibraryMember;
import task3.system.Library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Create books
        Book book1 = new Book("Java Basics", "John Doe", "12345");
        Book book2 = new Book("Advanced Java", "Jane Smith", "67890");

        library.addBook(book1);
        library.addBook(book2);

        // Create members
        LibraryMember member1 = new LibraryMember("Alice", 1);
        LibraryMember member2 = new LibraryMember("Bob", 2);

        library.addMember(member1);
        library.addMember(member2);


        library.reserveBook(member1, book1);         // Alice reserves book1
        library.reserveBook(member2, book1);         // Bob tries to reserve book1 (already reserved)
        library.displayReservedBooks(member1);       // Display Alice's reserved books
        library.cancelReservation(member1, book1);   // Alice cancels reservation
        library.reserveBook(member2, book1);         // Bob reserves successfully
        library.displayReservedBooks(member2);       // Display Bob's reserved books
    }
}

