package IO;

import java.io.*;

public class WriteToFile {
    public static void main(String[] args){
        printInFile();
    }
    public static void printInFile(){
        try {
            String filePath = "C:\\saviynt\\Conf\\logs\\aToZVal.txt";
            File f = new File(filePath);
            PrintWriter pw = new PrintWriter(f);
            for(int i = 1; i<=26; i++)
            pw.println((char)(i-1+'a') +" = " +i);
            pw.close();
        }
        catch (Exception e){
            System.out.println("Exceptin here "+e.getMessage());
        }

    }
}
