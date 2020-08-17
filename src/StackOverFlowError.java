import nl.flotsam.xeger.Xeger;

public class StackOverFlowError {
    public static void main(String[] args) {
        //String pattern = "[\\w\\-.]+(\\@[a-zA-Z0-9.\\-]+\\.[a-zA-Z0-9]{2,})?";
        String pattern = "(?=^.[a-zA-Z0-9!@#$&*.,?\\\\\\/<>|]{11,14}$)[a-zA-Z]{1}(?=(.*?[0-9]){3})(?=(.*?[!@#$&*.,?\\\\\\/<>|]){3})";
        Xeger generator = new Xeger(pattern);
        for (int i = 0; i < 1000; i++) {
            System.out.println("iteration " + i);
            generator.generate();
        }
    }
}
