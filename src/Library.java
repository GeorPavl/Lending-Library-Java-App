import java.util.ArrayList;

/**
 * The Library class represents a lending library and is characterized by a collection
 * of LibraryItem type objects.
 **/
public class Library {

    ArrayList<LibraryItem> items;

    // Constructor
    public Library() {
        items = new ArrayList<>();
    }

    // Overridden methods
    @Override
    public String toString() {
        return "Library{" +
                "items=" + items.toString() +
                '}';
    }

    // Other methods

    /**
     * If the item is already in the library, then a new copy is added to it,
     * otherwise the new item is added to the library. You can assume that
     * when an attempt is made to import an item that is already in the library, then it will
     * all his details have been given correctly
     **/
    public void addItem(LibraryItem item)  {
        boolean isFound = false;
        for(LibraryItem tempItem : items){
            if(tempItem.equals(item)){
                tempItem.plusCopy();
                isFound = true;
            }
        }
        if(!isFound){
            items.add(item);
        }
    }

    /**
     * Looks for the object with the specific serial number and after finding it manages it
     * lending it by reducing the number of copies available, if possible. Returns
     * true if the loan is completed successfully, false has no object with this
     * serial number or no copies available.
     * **/
    public boolean loanOut(String serialNumber) {
        LibraryItem tempItem = null;
        for(LibraryItem listItem : items){
            if(listItem.getSerialNumber().equals(serialNumber)){
                tempItem = listItem;
            }
        }
        if(tempItem != null && tempItem.borrow()){
            return true;
        }
        return false;
    }

    /**
     * Looks for the object with the specific serial number and after finding it manages
     * its return by increasing the number of copies available, if possible.
     * Returns true if the return is successful, false no object with
     * this serial number or there were no borrowed copies.
     * **/
    public boolean putBack(String serialNumber) {
        LibraryItem tempItem =null;
        for(LibraryItem listItem : items){
            if(listItem.getSerialNumber().equals(serialNumber)){
                tempItem = listItem;
            }
        }
        if(tempItem != null && tempItem.returnCopy()){
            return true;
        }
        return false;
    }

    /**
     * Overridden method of superclass.
     * Returns true if item's title or publisher, contains the searching term
     **/
    public ArrayList<String> search(String term) {
        ArrayList<String> list = new ArrayList<>();
        for(LibraryItem tempItem :items){
            if(term.equals("*")){
                list.add(tempItem.toString());
            }else{
                boolean searchResult = tempItem.search(term);
                if(searchResult){
                    list.add(tempItem.toString());
                }
            }
        }
        return list;
    }

    /**
     * Provided the library contains an object with the given serial number and title and this can be
     * download, returns its url, otherwise returns "https://projectlibrary.net/404.html"
     **/
    public String download(String serialNumber) {
        LibraryItem tempItem = null;
        for(LibraryItem listItem : items){
            if(listItem.getSerialNumber().equals(serialNumber)){
                tempItem = listItem;
            }
        }
        if(tempItem !=null){
            if(tempItem instanceof Downloadable){
                return ((Downloadable) tempItem).download();
            }else{
                return "https://projectlibrary.net/noDL.html";
            }

        }
        return "https://projectlibrary.net/404.html";
    }
}
