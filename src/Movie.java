/**
 * Represents a movie and inherits from LibraryItem.
 * A movie is additionally characterized by the year of its release
 **/
public class Movie extends LibraryItem{

    /** fields **/
    private int releaseYear;

    /** constructor **/
    public Movie(String serialNumber, String title, int releaseYear) {
        super(serialNumber, title);
        this.releaseYear = releaseYear;
    }

    /** methods **/
    @Override
    public String toString() {
        return super.toString() + "(" + this.releaseYear + ")";
    }
}
