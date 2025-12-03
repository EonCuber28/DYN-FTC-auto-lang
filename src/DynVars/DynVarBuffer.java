package DynVars;//import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DynVarBuffer {
    // I, Isaac Clark, programmer for FTC team 17153 and 32165, hereby call this the "yes" list
    public List<Object> yesList = new ArrayList<>();

    public void init(){

    }
    public void addCustomCmd(String ID, Consumer func){}
    // getters
    public <T> T get(String ID){
        for (int x = 0; x < yesList.toArray().length; x++){
            switch (yesList.get(x)){
                case null -> {return null;}
                default -> {return null;}
            }
        }
        return null;
    }
    // setters
}