import java.util.ArrayList;

/**
 * Represents a book and inherits from LibraryItem.
 * A book is additionally characterized by its authors.
 */
public class Book extends LibraryItem {

    private ArrayList<String> writers;

    // Constructor
    public Book (ArrayList<String> authors, String serialNo, String title) {
        super(serialNo,title);
        this.writers = new ArrayList<>();
        for(String tempAuthor : authors){
           writers.add(tempAuthor);
        }
    }

    // Overridden methods
    @Override
    public String toString(){
        String myWriters = "";
        for(int i=0; i<writers.size(); i++){
            myWriters += writers.get(i).toUpperCase() + ", ";
        }
        return super.toString() + " by " + myWriters + "-";
    }

    /**
     * Overridden method of superclass.
     * Returns true if item's title or writers, contains the searching term
     **/
    @Override
    public boolean search(String term){
        boolean isOnWriters = false;
        for(String tempWriter : writers){
            if(tempWriter.toLowerCase().contains(term.toLowerCase())){
                isOnWriters = true;
            }
        }
        if(super.search(term) || isOnWriters){
            return true;
        }
        return false;
    }
}
