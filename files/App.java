package files;

import java.util.ArrayList;

public class App {
    private ArrayList <API> apis;
    private String name;
    App(){
        this.name = "Api Application"; // default constructor;
        this.apis = new ArrayList<>();
    }

    public ArrayList<API> getApis() {
        return this.apis;
    }

    public void setApis(ArrayList<API> apis) {
        this.apis = apis;
    }
    public void addApi(API api){
        this.apis.add(api);
    }
    
}
