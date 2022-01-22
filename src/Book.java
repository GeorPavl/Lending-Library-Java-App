import java.util.ArrayList;
import  java.util.LinkedList;
import java.util.List;

public class Book extends LibraryItem {

    private ArrayList<String> writers;


    public Book (ArrayList<String> authors, String serialNo, String title) {
        super(serialNo,title);
        this.writers = new ArrayList<>();
        for(String tempAuthor : authors){
           writers.add(tempAuthor);
        }
    }

    @Override
    public String toString(){
        String myWriters = "";
        for(int i=0; i<writers.size(); i++){

                myWriters += writers.get(i).toUpperCase() + ", ";

        }
        return super.toString() + " by " + myWriters + "-";
    }

    @Override
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
