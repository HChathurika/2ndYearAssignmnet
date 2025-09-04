
import java.util.ArrayList;

public class LibBook {
    private String title;
    private String author;
    private int publicationYear;

    // Ratings and reviews
    private double rating;
    private ArrayList<String> reviews;

    public LibBook(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.rating = 0.0;
        this.reviews = new ArrayList<>();
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPublicationYear() { return publicationYear; }
    public double getRating() { return rating; }
    public ArrayList<String> getReviews() { return reviews; }

    public void setRating(double rating) {
        if (rating >= 0 && rating <= 5) {
            this.rating = rating;
        } else {
            System.out.println("Rating must be between 0 and 5.");
        }
    }

    public void addReview(String review) {
        reviews.add(review);
    }

    @Override
    public String toString() {
        return title + " by " + author + " (" + publicationYear + ")" +
                " | Rating: " + rating + " | Reviews: " + reviews.size();
    }
}

