import java.util.ArrayList;

public class Library {

    ArrayList<LibraryItem> items;


    public Library() {
        items = new ArrayList<>();
    }

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


    public boolean loanOut(String serialNo) {
        LibraryItem tempItem = null;
        for(LibraryItem listItem : items){
            if(listItem.getSerialNo().equals(serialNo)){
                tempItem = listItem;
            }
        }
        if(tempItem != null && tempItem.borrow()){
            return true;
        }
        return false;
    }

    public boolean putBack(String serialNo) {
        LibraryItem tempItem =null;
        for(LibraryItem listItem : items){
            if(listItem.getSerialNo().equals(serialNo)){
                tempItem = listItem;
            }
        }
        if(tempItem != null && tempItem.returnCopy()){
            return true;
        }
        return false;
    }

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

    public String download(String serialNumber) {
        LibraryItem tempItem = null;
        for(LibraryItem listItem : items){
            if(listItem.getSerialNo().equals(serialNumber)){
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

    @Override
    public String toString() {
        return "Library{" +
                "items=" + items.toString() +
                '}';
    }
}
