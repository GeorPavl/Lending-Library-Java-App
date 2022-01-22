import java.util.ArrayList;

/**
 * Represents a book and inherits from LibraryItem.
 * A book is additionally characterized by its authors.
 **/
public class Book extends LibraryItem{

    /** fields **/
    private ArrayList<String> writers;

    /** constructor **/
    public Book(String serialNumber, String title, ArrayList<String> writers) {
        super(serialNumber, title);
        this.writers = new ArrayList<>();
        for (String writer : writers) {         // not just a reference to initial object
            this.writers.add(writer);
        }
    }

    /** methods **/
    @Override
    public String toString() {
        return super.toString() + " by " + this.writers.toString() + "-";
    }

    public boolean search(String term){
        boolean isOnTitle = super.search(term);
        boolean isOnWriters = false;
        for(String tempWriter : writers){
            if(tempWriter.toLowerCase().contains(term.toLowerCase())){
                isOnWriters = true;
            }
        }
        if(isOnTitle || isOnWriters){
            return true;
        }
        return false;
    }
}
