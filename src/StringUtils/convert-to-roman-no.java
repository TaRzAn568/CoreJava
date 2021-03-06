import java.util.Scanner;
import java.util.*;


class NoToRoman
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int N = sc.nextInt();
			
			NoToRomanSol g = new NoToRomanSol();
			System.out.println (g.convertToRoman(N));
			t--;
		}
	}
}// } Driver Code Ends


/*you are required to complete this function*/
class NoToRomanSol
{
    String convertToRoman(int n)
    {
 Map<Integer, String> map = new HashMap<>();
    map.put(1,"I");
    map.put(5,"V");
    map.put(10,"X");
    map.put(50,"L");
    map.put(100,"C");
    map.put(500,"D");
    map.put(1000,"M");
    
    
    int num = n;
    int c = -1;
    while(num > 0){
        num = num /10;
        c++;
    }
    StringBuffer sb = new StringBuffer();
    while(n > 0){
        int divider = (int) Math.pow(10,c);
        int div = n / divider;
        n = n % divider;
        c--;
    
    
    if(div <= 3){
        for(int i=0; i<div; i++){
            sb.append(map.get(divider));
        }
    }
    else if(div == 4){
        sb.append(map.get(divider)).append(map.get(5*divider));
    }
    else if(div == 5){
        sb.append(map.get(5*divider));
    }
    else if(div >5 && div <9) {
        sb.append(map.get(5*divider));
        for(int i=6; i<=div; i++){
            sb.append(map.get(divider));
        }
    }
    else{
        sb.append(map.get(divider)).append(map.get(10*divider));
    }
    
    
    }
    return sb.toString();
        }
}
