/**
 * Interface that expresses the property of an object to be downloaded by a page.
 * Classes that implement this interface should define the method: public String download();
 * **/
public interface Downloadable {
     /**
      * Returns a String containing the URL from which the object will be downloaded.
      * **/
     String download();
}
