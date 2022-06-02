package files;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.compress.utils.Iterators;
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

            // this loop will iterate over the rows in the sheet
            while(rows.hasNext()){    
                while(!nextRow){
                    Row row = rows.next();

                    Iterator <Cell> cells = row.cellIterator();    // making a cell   
                    
                    if(row.getCell(0) == null){
                        break;
                    }

                    if(row.getCell(0).getStringCellValue().contains("REST Operation Mapping")){

                        row = rows.next();   // to get the next row 
                        API api = new API(row.getCell(0).getStringCellValue(),row.getCell(1).getStringCellValue());
                        app.addApi(api);
                        System.out.println("mans");
                    }
                    else if(row.getCell(0).getStringCellValue().equals("I/o"))
                        nextRow = true;
                }


                //     while(cells.hasNext()){                       //check if it has a next cells 
                //         Cell cell = cells.next();
                        
                // }

                // this while loop will iterate over the wanted rows which is selected from the previous while loop
                
                //Objects obj = new Objects();
                while(nextRow && rows.hasNext()){                   // the second condition is just to remove a bug and check again if has anoter item
                    Row row = rows.next();
                    Iterator <Cell> cells = row.cellIterator();    // making a cell 
                    //Boolean cellCheck = false;
                    int i = 0;
                    while(cells.hasNext()) {
                        i++;
                        cells.next();
                    }
                    System.out.println(i);
                    //Field field = new Field();      

                    if(row.getCell(0) == null) 
                        break;                                      // this will break if it null so it skip the spaces rows 

                    Cell firstCell = row.getCell(0);
                    if(firstCell.getStringCellValue().isEmpty() && firstCell.getColumnIndex() == 0){
                        nextRow = false;
                        break;  
                    }
                    if(row.getCell(3).getStringCellValue().contains("object")){ 
                        Objects obj = new Objects();
                        row = rows.next();



                    }
                    
                    
                    // while(cells.hasNext()){                       // this just to get the number of columns in the wannted row.
                    //     Cell cell = cells.next();                 // making a cell 
                    //     //cellCheck = cell.getStringCellValue().isEmpty();
                        
                        
                    //         switch (cell.getColumnIndex()) {
                    //         case 0:
                    //             field.setInput(cell.getStringCellValue());
                    //             if(cell.getStringCellValue().isEmpty()){
                    //                 nextRow = false;
                    //             }
                    //             break;
                    //         case 1 : 
                    //             field.setName(cell.getStringCellValue());
                    //         break;

                    //         case 2 : 
                    //         break;
                    //         case 3 : 
                    //             if(cell.getStringCellValue().isEmpty())
                    //                 field.setAloowedValues("");
                    //             else{
                    //                 field.setAloowedValues(cell.getStringCellValue());
                    //             }
                    //         break;
                    //         case 4 : 
                    //             if(cell.getStringCellValue().equals("Y"))
                    //                 field.setMandatory(true);
                    //             else{
                    //                 field.setMandatory(false);
                    //             }      
                    //         break;

                    //         default:
                    //         break;
                    //     }

                    // }  
                    //obj.addField(field);

                }
                
                //ArrayList <Field> arr = obj.getFields();
    
                // for(Field item:arr){
                //     System.out.print(item.isMandatory() + "\t" + item.getName() + "\t" + item.getAloowedValues()); 
                //     System.out.println("");
                // }
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

