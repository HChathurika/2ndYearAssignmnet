package Library.model;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean borrowed;
    private boolean reserved;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.borrowed = false;
        this.reserved = false;
    }

    public String getTitle() { return title; }
    public boolean isBorrowed() { return borrowed; }
    public boolean isReserved() { return reserved; }

    public void setBorrowed(boolean borrowed) { this.borrowed = borrowed; }
    public void setReserved(boolean reserved) { this.reserved = reserved; }

    @Override
    public String toString() {
        return title + (reserved ? " [Reserved]" : "") + (borrowed ? " [Borrowed]" : "");
    }
}

