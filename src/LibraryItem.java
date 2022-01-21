/**
 * Represents an item available from the library for borrowing.
 * The class is defined as abstract.
**/
public abstract class LibraryItem {

    /** fields **/
    private String serialNumber;

    private String title;

    private int totalCopies;

    private int availableCopies;

    /** constructor **/
    public LibraryItem(String serialNumber, String title) {
        this.serialNumber = serialNumber;
        this.title = title;
        this.totalCopies = 1;
        this.availableCopies = 1;
    }

    /** methods **/
    public String getSerialNumber() {
        return this.serialNumber;
    }

    public void addCopy() {
        this.totalCopies++;
        this.availableCopies++;
    }

    public boolean borrowCopy() {
        if (this.availableCopies > 0) {
            this.availableCopies--;
            return true;
        }
        return false;
    }

    public boolean returnCopy() {
        if (this.totalCopies > this.availableCopies) {
            this.availableCopies++;
            return true;
        }
        return false;
    }

    /** overridden methods **/
    @Override
    public String toString() {
        return "[" + this.availableCopies + "/" + this.totalCopies + "] "
                + this.serialNumber.toUpperCase() + ", \"" + this.title.toUpperCase() + "\"";
    }

    @Override
    public boolean equals(Object obj) {
        if ((obj instanceof LibraryItem) && ((LibraryItem) obj).serialNumber == this.serialNumber) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
