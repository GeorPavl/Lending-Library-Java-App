import java.util.ArrayList;

/**
 * The Library class represents a lending library and is characterized by a collection
 * of LibraryItem type objects.
 **/
public class Library {

    /** fields **/
    private ArrayList<LibraryItem> items;

    /** constructor **/
    public Library () {
        this.items = new ArrayList<>();
    }

    /** methods **/
    public void addItem(LibraryItem item) {
        boolean exists = false;
        for (LibraryItem libraryItem : this.items) {
            // if item already exists in the list -> add copy
            if (libraryItem.equals(item)) {
                libraryItem.addCopy();
                exists = true;
            }
        }
        // if item doesn't exist in the list -> add new item
        if (exists == false) {
            this.items.add(item);
        }
    }

    public boolean loanOut(String serialNumber) {
        for (LibraryItem libraryItem : this.items) {
            if (libraryItem.getSerialNumber() == serialNumber) {
                return libraryItem.borrowCopy();
            }
        }
        return false;
    }

    public boolean putBack(String serialNumber) {
        for (LibraryItem libraryItem : this.items) {
            if (libraryItem.getSerialNumber() == serialNumber) {
                return libraryItem.returnCopy();
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Library{" +
                "items=" + items +
                '}';
    }
}
