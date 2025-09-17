package movies.domain.models;

import jakarta.xml.bind.annotation.XmlElement;

public class Movie {
    @XmlElement
    private String title;
    @XmlElement
    private MovieType priceCode;

    public Movie() { }

    public Movie(String title, int priceCode) {
        if (title == null) {
            throw new IllegalArgumentException("Invalid Movie Name");
        }
        this.title = title;
        this.priceCode = MovieType.fromCode(priceCode);
    }

    public MovieType getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int movieCode) {
        priceCode = MovieType.fromCode(movieCode);
    }

    public String getTitle() {
        return title;
    }
}
