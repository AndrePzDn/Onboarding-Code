package movies.domain.models;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"movie", "daysRented"})
public class Rental {
    @XmlElement
    private Movie movie;

    @XmlElement
    private int daysRented;

    public Rental() {}

    public Rental(Movie movie, int daysRented) throws IllegalArgumentException {
        if (movie == null) {
            throw new IllegalArgumentException("Invalid Movie");
        }
        if (daysRented < 1) {
            throw new IllegalArgumentException("Invalid rented days");
        }
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }
}
