package Java8;

public class Generics {


    // A Generic method example
    static <A> void genericDisplay (A element)
    {
        System.out.println(element.getClass().getName() +
                " = " + element);
    }

    // Driver method
    public static void main(String[] args)
    {
        // Calling generic method with Integer argument
        genericDisplay(11);

        // Calling generic method with String argument
        genericDisplay("GeeksForGeeks");

        // Calling generic method with double argument
        genericDisplay(1.0);
    }
}
