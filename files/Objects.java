package files;

import java.util.ArrayList;

public class Objects {
    ArrayList <Field> fields;
    private String input;
    private String name;
    private String mandotroy;
    Objects(){
        //this.fields = new ArrayList<>();
    }

    public Objects(String input, String name, String mandotroy) {
        this.input = input;
        this.name = name;
        this.mandotroy = mandotroy;
        this.fields = new ArrayList<>();
    }


    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMandotroy() {
        return mandotroy;
    }

    public void setMandotroy(String mandotroy) {
        this.mandotroy = mandotroy;
    }

    public ArrayList<Field> getFields() {
        return this.fields;
    }
    public void setFields(ArrayList<Field> fields) {
        this.fields = fields;
    }
    public void addField(Field field){
        this.fields.add(field);
    }
    @Override 
    public String toString(){
        String[] arr = this.getName().split("/"); // object1/feilds
        String varr = arr[arr.length-1];
        return varr;
    } 
}
