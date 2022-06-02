package files;

import java.util.ArrayList;

public class Objects {
    ArrayList <Field> fields;
    Objects(){
        this.fields = new ArrayList<>();
    }
    public ArrayList<Field> getFields() {
        return fields;
    }
    public void setFields(ArrayList<Field> fields) {
        this.fields = fields;
    }
    public void addField(Field field){
        fields.add(field);
    }
    


}
