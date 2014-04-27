
public class Assert {

    // http://stackoverflow.com/questions/2758224/assertion-in-java
    // Calculates the sum of a (int) + b (int) and returns the result (int).
    int sum(int a, int b) {
        assert (a < 50) : "a = " + a + " is too large";
        final int result = a + b;
        return result;
    }    
    
    public static void main(String[] args) {
        
        Assert a = new Assert();
        System.out.println(a.sum(40, 2));
        System.out.println(a.sum(Integer.MAX_VALUE, 1));
    }   
}