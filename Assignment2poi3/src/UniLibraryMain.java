public class UniLibraryMain {
    public static void main(String[] args) {
        // Create books
        LibBook book1 = new LibBook("Java Programming", "John Smith", 2020);
        LibBook book2 = new LibBook("Data Structures", "Jane Doe", 2018);
        LibBook book3 = new LibBook("Fiction Art", "Alice Johnson", 2019);

        // Add ratings & reviews
        book1.setRating(4.5);
        book1.addReview("Great for beginners.");
        book2.setRating(4.0);
        book2.addReview("Informative.");
        book2.addReview("Well explained.");
        book3.setRating(3.8);

        // Library
        UniLibrary myLibrary = new UniLibrary();
        myLibrary.addBook(book1);
        myLibrary.addBook(book2);
        myLibrary.addBook(book3);

        // Users
        LibUser user1 = new LibUser("Alice", 25);
        LibUser user2 = new LibUser("Bob", 30);
        myLibrary.addUser(user1);
        myLibrary.addUser(user2);

        // Display books
        System.out.println("Books in library:");
        myLibrary.displayBooks();
        System.out.println();

        // Borrow & return
        myLibrary.borrowBook("Data Structures", user1);
        System.out.println("Is 'Data Structures' available? " +
                myLibrary.isBookAvailable("Data Structures"));
        myLibrary.returnBook(book2, user1);
        System.out.println();

        // Statistics
        System.out.println("Average book rating: " + myLibrary.getAverageBookRating());
        System.out.println("Most reviewed book: " + myLibrary.getMostReviewedBook());
        System.out.println();

        // Display users
        System.out.println("Library users:");
        myLibrary.displayUsers();
    }
}


