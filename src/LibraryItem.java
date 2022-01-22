import java.util.ArrayList;
import java.util.Objects;

public abstract class LibraryItem {

    private String serialNo;
    private String title;
    private int copies;
    private int availableCopies;

    public LibraryItem(String serialNo, String title){
        this.serialNo = serialNo;
        this.title = title;
        this.copies = 1;
        this.availableCopies = 1;
    }

    public String getSerialNo() {
        return this.serialNo;
    }


    public void plusCopy(){
        this.copies++;
        this.availableCopies++;
    }

    public boolean borrow(){
        if(availableCopies > 0){
            availableCopies--;
            return true;
        }
        return false;
    }

    public boolean returnCopy(){
        if(availableCopies<copies){
            availableCopies++;
            return true;
        }
        return false;
    }

    public boolean search(String term){
        if(title.toLowerCase().contains(term.toLowerCase())){
            return true;
        }
        return false;
    }


    @Override
    public String toString(){
        return "(" + availableCopies + "/" + copies + ") " + serialNo.toUpperCase() + ", \"" + title.toUpperCase() + "\"";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LibraryItem)) return false;
        LibraryItem item = (LibraryItem) o;
        return Objects.equals(getSerialNo(), item.getSerialNo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSerialNo());
    }


}
