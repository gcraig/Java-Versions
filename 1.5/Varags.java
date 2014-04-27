
public class Varags {
 
    public void multipleArgs(String... arguments) {
        
        for (String arg : arguments) {
            System.out.println(arg);
        }
    }
    
    public static void main(String[] args) {
        
        Varags v = new Varags();
        v.multipleArgs("Hello", "World!");
        v.multipleArgs("Test", "Me", "All", "Day");
    }   
    
}