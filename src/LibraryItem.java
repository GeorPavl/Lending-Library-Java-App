import java.util.Objects;

/**
 * Represents an item available from the library for borrowing.
 * The class is defined as abstract.
 **/
public abstract class LibraryItem {

    private String serialNumber;

    private String title;

    private int totalCopies;

    private int availableCopies;

    // Constructor
    public LibraryItem(String serialNumber, String title){
        this.serialNumber = serialNumber;
        this.title = title;
        this.totalCopies = 1;
        this.availableCopies = 1;
    }


    // Getters & Setters
    public String getSerialNumber() {
        return this.serialNumber;
    }

    // Overridden methods
    @Override
    public String toString(){
        return "(" + availableCopies + "/" + totalCopies + ") " + serialNumber.toUpperCase() + ", \"" + title.toUpperCase() + "\"";
    }

    /**
     * Method that returns true if and only if the object to be compared is of type LibraryItem
     * with the same serial number as the current item.
     **/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LibraryItem)) return false;
        LibraryItem item = (LibraryItem) o;
        return Objects.equals(getSerialNumber(), item.getSerialNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSerialNumber());
    }

    // Other methods

    /**
     * Method that adds a new copy of the object to the library.
     * Does not take parameters and does not return anything.
     * After calling the method, the library has one additional copy of the specific item.
     **/
    public void plusCopy(){
        this.totalCopies++;
        this.availableCopies++;
    }

    /**
     * Method that manages the lending of the item by reducing it by one, if it is possible,
     * the number of available copies of the item.
     * It does not take parameters. Returns true if copies were available for loan, otherwise returns false.
     */
    public boolean borrow(){
        if(availableCopies > 0){
            availableCopies--;
            return true;
        }
        return false;
    }

    /**
     * Increases item's available copies, if there is a "missing" copy.
     * Returns true if return of copy is successful, false if there wasn't a "missing" copy of this item.
     **/
    public boolean returnCopy(){
        if(availableCopies<totalCopies){
            availableCopies++;
            return true;
        }
        return false;
    }

    /**
     * Returns true if item's title contains the searching term
     **/
    public boolean search(String term){
        if(title.toLowerCase().contains(term.toLowerCase())){
            return true;
        }
        return false;
    }

}
