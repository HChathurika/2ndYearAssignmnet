package Task6;

import java.util.ArrayList;

public class LibUser {
    private String name;
    private int age;
    private ArrayList<LibBook> borrowedBooks;

    public LibUser(String name, int age) {
        this.name = name;
        this.age = age;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public ArrayList<LibBook> getBorrowedBooks() { return borrowedBooks; }

    public void borrowBook(LibBook book) {
        borrowedBooks.add(book);
    }

    public void returnBook(LibBook book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return name + " (Age: " + age + ") | Borrowed Books: " + borrowedBooks.size();
    }
}


