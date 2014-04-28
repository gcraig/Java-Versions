import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

// Java 7
public class NewFeatures {
    
    // underscore commana
    static int millions = 1_000_000;
    
    // diamond operator
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        
        list.add("Michael");
        list.add("Jordan");
        System.out.println(list);
        
        System.out.println(millions);
        
        try {
            System.out.println("Going to throw an NPE. Don't ya love those?");
            
            if (1==1)
                throw new NullPointerException();
            else {
                throw new IOException();
            }
                    
        // single handler for multiple exceptions
        } catch (IOException | NullPointerException e) {
            System.out.println("Caught exception:");
            System.out.println(e);
        }
    }   
    
}