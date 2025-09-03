public class Book {
    private String title;
    private String author;
    private int publicationYear;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }
    public String getTitle() {
        return title;

    }
    public String getAuthor(){
        return author;

    }
    public int PublicationYear(){
        return publicationYear;

    }
    Book book1 = new Book("Introduction to Java Programming", "John Smith", 2020);
    Book book2 = new Book("Data Structures and Algorithms",  "Jane Doe",  2018);
    Book book3 = new Book("The Art of Fiction", "Alice Johnson",  2019);



    }



