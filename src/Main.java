import java.util.ArrayList;

public class Main {

    private static Library library = new Library();

    public static void main(String[] args) {

        ArrayList<String> writers = new ArrayList<>();
        writers.add("Savitch");
        Book book = new Book("1234", "Java", writers);

        System.out.println(book.toString());

        library.addItem(book);
        System.out.println(library.toString());

        ArrayList<String> writers1 = new ArrayList<>();
        writers1.add("Deitel J.");
        writers1.add("Deitel M.");
        Book book1 = new Book("5678", "C", writers1);

        System.out.println(book1);

        library.addItem(book1);
        System.out.println(library.toString());

        ArrayList<String> writers2 = new ArrayList<>();
        writers2.add("Savitch");
        Book book2 = new Book("1234", "Java", writers2);

        System.out.println(book2.toString());

        library.addItem(book2);
        System.out.println(library.toString());

        Movie movie = new Movie("45xy", "Get Out", 2017);

        System.out.println(movie.toString());

        library.addItem(movie);
        System.out.println(library.toString());

        System.out.println(library.loanOut("5678"));
        System.out.println(library.loanOut("5678"));
        System.out.println(library.loanOut("1234"));

        System.out.println(library.toString());

        ArrayList<String> writers3 = new ArrayList<>();
        writers3.add("Savitch");
        Book book3 = new Book("1234", "Java", writers3);

        System.out.println(book3.toString());

        library.addItem(book3);
        System.out.println(library.toString());

        library.putBack("5678");
        System.out.println(library.toString());

        Journal journal = new Journal("789ab", "NATIONAL GEOGRAPHIC", "K. Rowl", 14, 4);
        library.addItem(journal);
        System.out.println(library.toString());

        System.out.println("==================");
        for (String item : library.search("ro")) {
            System.out.println(item);
        }
        //implementation
    }
}
