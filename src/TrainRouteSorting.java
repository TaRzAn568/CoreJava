/* IMPORTANT: Multiple classes and nested static classes are supported *//*


*/
/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*//*


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        */
/* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        *//*


        // Write your code here

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String da[] = br.readLine().split(" ");
        String departure = da[0];
        String arrival = da[1];
        List<String> input = new ArrayList<>();
        String line = br.readLine();
        while(line != null)
            input.add(line);

        List<String> res = getSortedTrains(departure, arrival, input);
        for(String x : res)
            System.out.println(x);


    }
    public static List<String> getSortedTrains(String departure, String arrival, List<String> inp){
        Map<String,List<List<String>>> input = new HashMap<>();
        for(String x: inp){
            String[] i = x.split(" ");
            List<String> x1 = new ArrayList<>();
            x1.add(i[1]);
            x1.add(i[2]);
            if(!input.containsKey(i[0])){
                List<List<String>> ll = new ArrayList<>();
                ll.add(x1);
                input.put(i[0],ll);
            }else{
                List<List<String>> ll  = input.get(i[0]);
                ll.add(x1);
                input.put(i[0], ll);
            }
        }
        List<List<String>> res = new ArrayList<>();
        res = getTrains(departure, arrival, input, res);

    }

    public static List<String> getTrains(String departure, String arrival, Map<String, List<List<String>>> input, List<List<String>> res){
        List<List<String>> val = input.get(departure);

        if(val == null || val.size() == 0)){
            8
        }

    }
}
*/
