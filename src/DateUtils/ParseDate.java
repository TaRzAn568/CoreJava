package DateUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ParseDate {
    public static void main(String[] ajd)throws Exception {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
            String df3 = "M/d/yyyy h:mm:ss a";
            String df2 = "yyyy-MM-dd HH:mm:ss";
            String date2 = "2020-10-19 11:19:12";
            String date3 = "9/11/2020 11:19:12 PM";

            String s = "";
            Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(df2);
        SimpleDateFormat sdf3 = new SimpleDateFormat(df3);


            System.out.println(sdf.parse(date2));
            System.out.println(sdf.format(sdf3.parse(date3)));
        }
    }


