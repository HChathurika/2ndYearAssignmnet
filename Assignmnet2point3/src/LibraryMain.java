public class LibraryMain {
    public static void main(String[] args) {

        Book book1 = new Book("Introduction to Java Programming", "John Smith", 2020);
        Book book2 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);
        Book book3 = new Book("The Art of Fiction", "Alice Johnson", 2019);

        Library myLibrary = new Library();

        myLibrary.addBook(book1);
        myLibrary.addBook(book2);
        myLibrary.addBook(book3);

        myLibrary.displayBooks();

        System.out.println();

        myLibrary.findBooksByAuthor("Jane Doe");
    }




}
