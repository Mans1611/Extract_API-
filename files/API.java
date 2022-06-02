package files;

import java.util.ArrayList;

public class API {
    private String URL;
    private String operation;
    private ArrayList<Objects> objects;
    
    API(){}
    API(String URL , String operation){
        this.URL = URL ;
        this.operation = operation;
    }
    public void addObject(Objects obj){
        this.objects.add(obj);
    }
    public ArrayList<Objects> showObjects(){
        return this.objects;
    }


}
