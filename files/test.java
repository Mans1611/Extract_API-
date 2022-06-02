package files;

import java.io.IOException ;
import java.io.FileNotFoundException;


public class test{
    public static void  main(String[] args){
        try{
            Main read = new Main();
            API api = read.readExcelFile("C:\\Users\\hp\\Desktop\\Mans1611\\University\\Advanced Computer Programming\\Project\\data\\api.xlsx","API_NAME");    
            
            api.print();

        }
        catch(IOException err){
            System.out.println(err);}

        catch(Error err){
            System.out.println(err);
        }

        
    }
}