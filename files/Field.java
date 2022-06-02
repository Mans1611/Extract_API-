package files;

public class Field  {
    String name,aloowedValues,input,mandatory;

    Field(){}
    Field(String input,String name,String aloowedValues , String mandatory){
        this.name = name;
        this.mandatory = mandatory;
        this.aloowedValues = aloowedValues;
        this.input = input;
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
    public String isMandatory() {
        return mandatory;
    }
    public void setMandatory(String mandatory) {
        this.mandatory = mandatory;
    }

}
