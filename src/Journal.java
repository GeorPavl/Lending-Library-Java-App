/**
 * Represents a magazine and is inherited from LibraryItem.
 * A magazine is featured in addition to the publisher, its volume and issue.
 **/
public class Journal extends LibraryItem implements Downloadable{

    private String publisher;

    private int volume;

    private int issue;

    // Constructor
    public Journal(String publisher, int volume, int issue, String serialNumber, String title) {
        super(serialNumber,title);
        this.publisher = publisher;
        this.volume = volume;
        this.issue = issue;
    }

    // Overridden methods
    @Override
    public String toString(){
        return super.toString() + " " + publisher.toUpperCase() + ", " + volume + " #" + issue;
    }

    /**
     * Overridden method of superclass.
     * Returns true if item's title or publisher, contains the searching term
     **/
    @Override
    public boolean search(String term) {
        if (super.search(term)) {
            return true;
        }
        if (publisher.toLowerCase().contains(term.toLowerCase())) {
            return true;
        }
        return false;
    }

    /**
     * Overridden method of interface.
     * Returns a string which represents item's download url.
     **/
    @Override
    public String download(){
        String result = "https://projectlibrary.net/mag?serial=" + getSerialNumber() + "&volume=" + volume + "&issue=" + issue;
        return result;
    }

}
