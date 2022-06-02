package files;

import java.util.ArrayList;

public class API {
    private String URL;
    private String operation;
    private String name ;
    private ArrayList<Objects> objects;
    
    API(){
        this.name = "default";
       // this.objects = new ArrayList<>();
    }

    API(String name){
        this.name = name; 
        this.objects = new ArrayList<>();
    }
    public void addObject(Objects obj){
        this.objects.add(obj);
    }
    public ArrayList<Objects> showObjects(){
        return this.objects;
    }
    public void setURL(String uRL) {
        URL = uRL;
    }
    public void setOperation(String operation) {
        this.operation = operation;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setObjects(ArrayList<Objects> objects) {
        this.objects = objects;
    }
    public String getURL() {
        return URL;
    }
    public String getOperation() {
        return operation;
    }
    public String getName() {
        return name;
    }
    public ArrayList<Objects> getObjects() {
        return objects;
    }

    public void print(){
        System.out.println(this.getName());
        for(Objects obj:this.objects){
            System.out.println(obj.toString());
            for(Field field:obj.getFields()){
                System.out.print(field.toString()+ "\t");
                System.out.print(field.input()+ "\t");
                System.out.print(field.getallowedValues()+ "\t");
                System.out.print(field.isMandatory()+ "\t");
                System.out.println();
            }
            System.out.println("-".repeat(40));
            
            
        }
        //System.out.println(this.objects.get(0));  // made by Zeyad 


    }


}
