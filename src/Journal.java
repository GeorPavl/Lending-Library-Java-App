/**
 * Represents a magazine and is inherited from LibraryItem.
 * A magazine is also characterized by its publisher, volume and issue.
 **/
public class Journal extends LibraryItem{

    /** fields **/
    private String publisher;

    private int volume;

    private int issue;


    /** constructor **/
    public Journal(String publisher, int volume, int issue, String serialNumber, String title) {
        super(serialNumber, title);
        this.publisher = publisher;
        this.volume = volume;
        this.issue = issue;
    }

    /** methods **/
    @Override
    public String toString() {
        return super.toString() + " " + this.publisher.toUpperCase() + ", " + this.volume + ", #" + this.issue;
    }
}
