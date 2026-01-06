package DynVars;//import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DynVarBuffer {
    // I, Isaac Clark, programmer for FTC team 17153 and 32165, hereby call this the "yes" list
    // later now i wonder what the heck i was thinking this was gonna do
    // whilst writing the last comment, i now realise that its just the container for all of the variables
    public List<Object> yesList = new ArrayList<>();

    public void init(){

    }
    public void addCustomCmd(String ID, Consumer func){}
    // getters
    public <T> T get(String ID){
        for (int x = 0; x < yesList.toArray().length; x++){
            Object current = yesList.get(x);
            if (current instanceof DynVarBoolean){
                return (T) current;
            }
            else if (current instanceof DynVarFieldCords) {}
            else if (current instanceof DynVarFieldPos) {}
            else if (current instanceof DynVarJson) {}
            else if (current instanceof DynVarList) {}
            else if (current instanceof DynVarNumber) {}
            else if (current instanceof DynVarString) {}
            else {}
        }
        return null;
    }
    // setters
}