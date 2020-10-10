
public class PrintString {
    public static void main(String [] atd){
        String s = "1473636383.373";
        String out = getResult(s);
        System.out.println(out);
    }

    public  static String getResult(String s){
        String[] a = s.split("\\.");
        int sum1 = 0;
        int sum2 = 0;
        for(int i=0;i<a[0].length(); i++){
            sum1 += Integer.parseInt(Character.toString(a[0].charAt(i)));

        }
        for(int i=0;i<a[1].length(); i++){
            sum2 += Integer.parseInt(Character.toString(a[1].charAt(i)));

        }
        String res = s + "-" + sum1 + "-" + sum2;
        return res;
    }
}
