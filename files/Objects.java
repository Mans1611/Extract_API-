package files;

import java.util.ArrayList;

public class Objects {
    ArrayList <Field> fields;
    private String input;
    private String name;
    private String alowedValues;
    private String mandotroy;
    Objects(){
        this.fields = new ArrayList<>();
    }

    public ArrayList<Field> getFields() {
        return this.fields;
    }
    public void setFields(ArrayList<Field> fields) {
        this.fields = fields;
    }
    public void addField(Field field){
        fields.add(field);
    }
}
