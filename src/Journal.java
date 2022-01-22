public class Journal extends LibraryItem implements Downloadable{

    private String editor;
    private int volume;
    private int issue;


    public Journal(String editor, int volume, int issue, String serialNo, String title) {
        super(serialNo,title);
        this.editor = editor;
        this.volume = volume;
        this.issue = issue;
    }

    @Override
    public String toString(){
        return super.toString() + " " + editor.toUpperCase() + ", " + volume + " #" + issue;
    }

    @Override
    public boolean search(String term) {
        if (super.search(term)) {
            return true;
        }
        if (editor.toLowerCase().contains(term.toLowerCase())) {
            return true;
        }
        return false;
    }

    @Override
    public String download(){
        String result = "https://projectlibrary.net/mag?serial=" + getSerialNo() + "&volume=" + volume + "&issue=" + issue;
        return result;
    }

}
