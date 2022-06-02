package files;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.logging.log4j.core.tools.picocli.CommandLine.Help.Column;
import org.apache.poi.ss.formula.atp.Switch;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.xml.transform.Source;

import java.nio.file.FileSystemNotFoundException;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect.Type;
import java.net.SocketTimeoutException;
import java.io.FileNotFoundException;

public class Main {
    public static int counter = 0;
    public void creating(int number ){
        if(number == 2)
        {
            System.out.println("object");
        }else{
            System.out.println("field");
        }
    }
    public void readExcelFile(String path) throws IOException{   




        try{
            App app = new App();                                            // makin a whole single app
            FileInputStream file = new FileInputStream(new File(path));     // creating an input strem file
            XSSFWorkbook workbook = new XSSFWorkbook(file);                // creating an workbok
            XSSFSheet sheet = workbook.getSheetAt(0);               // picking the first sheet in excel file  
            Iterator <Row> rows = sheet.iterator();
            boolean nextRow = false;
            



            while(rows.hasNext()){
                
                
                while(!nextRow){
                    Row row = rows.next();
                    Iterator <Cell> cells = row.cellIterator();    // making a cell   
                    while(cells.hasNext()){                       //check if it has a next cells 
                        Cell cell = cells.next();
                        if(cell.getStringCellValue().equals("HTTP Operation"))
                            nextRow = true;
                        else if(cell.getStringCellValue().equals("I/o"))
                            nextRow = true;
                        
                    }
                }

                // this while loop will iterate over the wanted rows which is selected from the previous while loop
                Objects obj = new Objects();
                while(nextRow && rows.hasNext()){                   // the second condition is just to remove a bug and check again if has anoter item
                    Row row = rows.next();
                    Iterator <Cell> cells = row.cellIterator();    // making a cell 
                    Boolean cellCheck = false;
                    

                    Field field = new Field();
                    while(cells.hasNext()){                  // this just to get the number of columns in the wannted row.
                        Cell cell = cells.next();            // making a cell 
                        
                        //cellCheck = cell.getStringCellValue().isEmpty();
                            switch (cell.getColumnIndex()) {
                            case 0:
                                field.setInput(cell.getStringCellValue());
                                if(cell.getStringCellValue().isEmpty()){
                                    nextRow = false;
                                }
                                break;
                            case 1 : 
                                field.setName(cell.getStringCellValue());
                            break;

                            case 2 : 
                               // System.out.println("passed");
                            break;

                            case 3 : 
                                if(cell.getStringCellValue().isEmpty()){
                                    field.setAloowedValues("");
                                }
                                else{
                                    field.setAloowedValues(cell.getStringCellValue());
                                }
                            break;

                            case 4 : 
                                
                                if(cell.getStringCellValue().equals("Y"))
                                    field.setMandatory(true);
                                else{
                                    field.setMandatory(false);
                                }
                                
                            break;
                            

                            default:
                                break;
                        }
                    }  

                    obj.addField(field);
                    
                    
                    ArrayList <Field> arr = obj.getFields();
                    for(Field item:arr){

                    System.out.print(item.isMandatory() + " " + item.getName() + " " + ++counter); 
                    System.out.println("");
                    }   
                    
                    
                    

                }
            }
        }

        catch(FileNotFoundException err){
            System.out.println(err);
        }

    }
    
}










class test{
    public static void  main(String[] args){
        try{
            Main read = new Main();
            read.readExcelFile("C:\\Users\\hp\\Desktop\\Mans1611\\University\\Advanced Computer Programming\\Project\\data\\api.xlsx");
            
        }
        catch(IOException err){
            System.out.println(err);}

        catch(Error err){
            System.out.println(err);
        }

        
    }
}

