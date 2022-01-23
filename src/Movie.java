/**
 * Represents a movie and inherits from LibraryItem.
 * A movie is additionally characterized by the year of its release.
 **/
public class Movie extends LibraryItem implements Downloadable{

    private int releaseYear;

    // Constructor
    public Movie(int releaseYear, String serialNumber, String title) {
        super(serialNumber,title);
        this.releaseYear = releaseYear;
    }

    // Overridden methods
    @Override
    public String toString(){
        return super.toString() + " (" + releaseYear + ")";
    }

    /**
     * Overridden method of interface.
     * Returns a string which represents item's download url.
     **/
    @Override
    public String download(){
        String result = "https://projectlibrary.net/movie?serial=" + getSerialNumber() + "&year=" + releaseYear ;
        return result;
    }
}
