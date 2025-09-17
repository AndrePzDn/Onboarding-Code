package movies.domain.valueobjects;

public class RentalLineItem {
    private String movieTitle;
    private double amount;

    public RentalLineItem(String movieTitle, double amount) {
        if (movieTitle == null) {
            throw new IllegalArgumentException("Invalid Movie Title");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid Amount");
        }
        this.movieTitle = movieTitle; 
        this.amount = amount;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public double getAmount() {
        return amount;
    }
}
