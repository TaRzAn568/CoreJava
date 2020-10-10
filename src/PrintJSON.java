import java.util.*;
/*


  {
    "id": 1,
    "name": "Leanne Graham",
    "username": "Bret",
    "email": "Sincere@april.biz",
    "address": {
      "street": "Kulas Light",
      "suite": "Apt. 556",
      "city": "Gwenborough",
      "zipcode": "92998-3874",
      "geo": {
        "lat": "-37.3159",
        "lng": "81.1496"
      }
    },
    "phone": "1-770-736-8031 x56442",
    "website": "hildegard.org",
    "company": {
      "name": "Romaguera-Crona",
      "catchPhrase": "Multi-layered client-server neural-net",
      "bs": "harness real-time e-markets"
    }
  }
*/


public class PrintJSON {

    public static void main(String [] arsg){
       Map m = buildMap();
    }

    public  static Map<String,String> buildMap(){
        Map<String, String> m = new HashMap<>();
        m.put("id","1");
        m.put("name","Ved");
        m.put("email","ved@gmail.com");
        Map<String, String> address = new HashMap<>();
        address.put("street","112");
        address.put("city","Bangalore");
        Map<String, String> geo = new HashMap<>();

        m.put("id","1");
        m.put("id","1");
        m.put("id","1");
        m.put("id","1");
        m.put("id","1");
        m.put("id","1");
        m.put("id","1");

        return m;
    }




}
