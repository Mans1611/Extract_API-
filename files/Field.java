package files;

public class Field  {
    String name,allowedValues,input,mandatory;

    Field(){}
    Field(String input,String name,String allowedValues , String mandatory){
        this.name = name;
        this.mandatory = mandatory;
        this.allowedValues = allowedValues;
        this.input = input;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getallowedValues() {
        return allowedValues;
    }
    public void setallowedValues(String allowedValues) {
        this.allowedValues = allowedValues;
    }
    public String input() {
        return this.input;
    }
    public void setInput(String input) {
        this.input = input;
    }
    public String isMandatory() {
        return mandatory;
    }
    public void setMandatory(String mandatory) {
        this.mandatory = mandatory;
    }
    @Override 
    public String toString(){
        String[] arr = this.getName().split("/"); // object1/feilds
        String varr = arr[arr.length-1];                // to return the last elements before dash "/".
        return varr;
    } 

}
