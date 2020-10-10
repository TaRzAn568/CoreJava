import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
public class JSON {
    public static void main(String[] args)throws Exception {
        String response = getRequest();
        List responseList = getResponseMap(response);
        printAddress(responseList);
    }

    public static String getRequest() throws Exception {

        URL url = new URL("https://jsonplaceholder.typicode.com/users");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();

        String readLine = null;
        StringBuffer response = new StringBuffer();

        if(responseCode == HttpURLConnection.HTTP_OK){
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            readLine = br.readLine();
            while(readLine != null){
            response.append(readLine);
            readLine = br.readLine();
            }
            br.close();
            //System.out.println("GET result = "+response);
        }
        else{
            System.out.println("Get not worked ");
        }
    return response.toString();
    }

    public static List getResponseMap(String res)throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        List map = mapper.readValue(res, new TypeReference<List>() {
        });
        //System.out.println("map = "+map);
        return map;
    }

    public static void printAddress(List<LinkedHashMap> al){
        for(LinkedHashMap  m : al){
            //Map m = new HashMap();
            int c =10;
            System.out.println("Company Name : "+((Map)m.get("company")).get("name") + ", lat : "+((Map)(((Map)m.get("address")).get("geo"))).get("lat")+ " and lng : "+((Map)(((Map)m.get("address")).get("geo"))).get("lng"));
        }
    }


}
/*class LinkedHashMap{
    public LinkedHashMap get(String s){
        Object o = super
    }
}*/

