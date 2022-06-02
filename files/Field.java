package files;

public class Field  {
    String name,aloowedValues,input;
    
    boolean mandatory;
    Field(){}
    Field(String name,boolean mandatory){
        this.name = name;
        this.mandatory = mandatory;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getAloowedValues() {
        return aloowedValues;
    }
    public void setAloowedValues(String aloowedValues) {
        this.aloowedValues = aloowedValues;
    }
    public String input() {
        return this.input;
    }
    public void setInput(String input) {
        this.input = input;
    }
    public boolean isMandatory() {
        return mandatory;
    }
    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }

}
