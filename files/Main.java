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

public class Main{
    public static int counter = 0;
    public void creating(int number ){
        if(number == 2)
        {
            System.out.println("object");
        }else{
            System.out.println("field");
        }
    }
    
    public API readExcelFile(String path,String apiName) throws IOException{   
        API api = new API();
        try{
            App app = new App();                                            // makin a whole single app
            FileInputStream file = new FileInputStream(new File(path));     // creating an input strem file
            XSSFWorkbook workbook = new XSSFWorkbook(file);                // creating an workbok
            XSSFSheet sheet = workbook.getSheetAt(0);               // picking the first sheet in excel file  
            Iterator <Row> rows = sheet.iterator();
            boolean nextRow = false;
            
            // this loop will iterate over the rows in the sheet
            // ArrayList <API> apis = new ArrayList<>();
            
            while(rows.hasNext()){
                
                while(!nextRow){
                    Row row = rows.next();

                    //Iterator <Cell> cells = row.cellIterator();    // making a cell   
                    
                    if(row.getCell(0) == null){
                        break;
                    }
                    
                    if(row.getCell(0).getStringCellValue().contains(apiName)){
                        
                        //row = rows.next();   // to get the next row 
                        api = new API(apiName);
                        while(rows.hasNext()){
                            row = rows.next();
                            
                            if(row.getCell(0) != null){
                                if(row.getCell(0).getStringCellValue().contains("I/o")){
                                    nextRow = true;
                                    break;
                                }
                            }
                            
                            // break;
                        }
                    }


                }

                Row row = rows.next();
                while(nextRow && rows.hasNext()){                   // the second condition is just to remove a bug and check again if has anoter item
                    Iterator <Cell> cells = row.cellIterator();    // making a cell 
                    
                    
                    Field field;

                    if(row.getCell(0) == null) 
                        break;                                      // this will break if it null so it skip the spaces rows 

                    Cell firstCell = row.getCell(0);
                   
                    if(firstCell.getStringCellValue().isEmpty() && firstCell.getColumnIndex() == 0){
                        nextRow = false;
                        break;  
                    }
                    if(row.getCell(2) !=null){

                    
                    if(!(row.getCell(2).getStringCellValue().contains("string"))){  //
                        
                        Objects obj = new Objects(row.getCell(0).getStringCellValue(),row.getCell(1).getStringCellValue(),row.getCell(4).getStringCellValue()); 
                        row = rows.next();
                       
                            while(row.getCell(2).getStringCellValue().contains("string")){
                                // System.out.println(row.getCell(3).getStringCellValue());
    
                                String allowedValues;
                                if(row.getCell(3).getStringCellValue().isEmpty()){
                                    allowedValues = "Any value";
                                }
                                else{
                                    allowedValues = row.getCell(3).getStringCellValue();
                                }
    
                                field = new Field(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue(), allowedValues, row.getCell(4).getStringCellValue());
                                obj.addField(field);
                                if(rows.hasNext()){
                                    row = rows.next();
                                }
                            }
                        

                        api.addObject(obj);

                    }
                }
                }

            }
                


                //     while(cells.hasNext()){                       //check if it has a next cells 
                //         Cell cell = cells.next();
                        
                // }

                // this while loop will iterate over the wanted rows which is selected from the previous while loop
                
                //Objects obj = new Objects();
                

                
            
            
                    
                    
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

                
                
                //ArrayList <Field> arr = obj.getFields();
    
                // for(Field item:arr){
                //     System.out.print(item.isMandatory() + "\t" + item.getName() + "\t" + item.getAloowedValues()); 
                //     System.out.println("");
                // }
            //}
            return api;
        }
        
        catch(FileNotFoundException err){
            System.out.println(err);
        }
        return api;
        
        //return api;
    }
    
}




