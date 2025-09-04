package Task5;


public class LibraryMain {
    public static void main(String[] args) {
        Book book1 = new Book("Introduction to Java Programming", "John Smith", 2020);
        Book book2 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);


        book1.setRating(4.5);
        book1.addReview("Very helpful for beginners!");
        book1.addReview("Detailed and well-structured.");

        book2.setRating(3.8);
        book2.addReview("Good explanations but a bit outdated.");

        Library myLibrary = new Library();
        myLibrary.addBook(book1);
        myLibrary.addBook(book2);

        myLibrary.displayBooks();
    }
}

