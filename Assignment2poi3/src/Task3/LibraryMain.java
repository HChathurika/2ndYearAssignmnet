package Task3;

public class LibraryMain {
    public static void main(String[] args) {
        Book book1 = new Book("Introduction to Java Programming", "John Smith", 2020);
        Book book2 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);

        Library myLibrary = new Library();
        myLibrary.addBook(book1);
        myLibrary.addBook(book2);

        myLibrary.displayBooks();
        System.out.println();


        System.out.println("Is 'Introduction to Java Programming' available? "
                + myLibrary.isBookAvailable("Introduction to Java Programming"));


        myLibrary.borrowBook("Introduction to Java Programming");


        System.out.println("Is 'Introduction to Java Programming' available? "
                + myLibrary.isBookAvailable("Introduction to Java Programming"));


        myLibrary.returnBook("Introduction to Java Programming");


        System.out.println("Is 'Introduction to Java Programming' available? "
                + myLibrary.isBookAvailable("Introduction to Java Programming"));
    }
}


