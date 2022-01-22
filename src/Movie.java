public class Movie extends LibraryItem implements Downloadable{

    private int year;

    public Movie(int year, String serialNo, String title) {
        super(serialNo,title);
        this.year = year;
    }

    @Override
    public String toString(){
        return super.toString() + " (" + year + ")";
    }

    @Override
    public String download(){
        String result = "https://projectlibrary.net/movie?serial=" + getSerialNo() + "&year=" + year ;
        return result;
    }
}
