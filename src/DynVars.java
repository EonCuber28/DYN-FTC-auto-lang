//import android.annotation.SuppressLint;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class DynVars {
    public List<String> usedVariableNames = new ArrayList<>();
    // field cords
    public List<DynVarFieldCords> fieldCords = new ArrayList<>();
    // field positions
    public List<DynVarFieldPos> fieldPoses = new ArrayList<>();
    // numbers
    public List<DynVarNumber> numbers = new ArrayList<>();
    // booleans
    public List<DynVarBoolean> booleans = new ArrayList<>();
    // strings
    public List<DynVarString> strings = new ArrayList<>();
    // lists
    public List<DynVarList> lists = new ArrayList<>();
    // json
    public List<DynVarJson> jsons = new ArrayList<>();

    public void init(){
        simpleSubsystem Subsystem = new simpleSubsystem();
        Consumer<String[]> func1 = args -> Subsystem.start(args);
    }
}

// field cords
class DynVarFieldCords{
    public String name = "";
    public DynVarNumber PosX;
    public DynVarNumber PosY;
    // to string
    // to prdro position
    // to dyn field position
    // equals
}
// field position
class DynVarFieldPos{
    public String name = "";
    public DynVarNumber PosX;
    public DynVarNumber PosY;
    public DynVarNumber Heading;
    // to dyn field cord
    // to string
    // pedro position
}
// number
class DynVarNumber{
    public String name  = "";
    public double value = 0;
    // to dyn string
    // to java number
    // to java string
    // set to add
}
// boolean
class DynVarBoolean{
    public String name  = "";
    public boolean value = true;
    // to dyn string
    // to java string
    // to java bool
    // equals
    // 2 variables equal
    // and
    // or
    // set to add
}
// string
class DynVarString{
    public String name  = "";
    public String value = "";
    // set to add
}
// list
class DynVarList{
    public String name  = "";

    private final AdaptiveList indexLookup = new AdaptiveList();

    public <T> T get(int index){return (T) indexLookup.get(index);}

    public void append(DynVarFieldCords value){indexLookup.append(value);}
    public void append(DynVarFieldPos value){indexLookup.append(value);}
    public void append(DynVarNumber value){indexLookup.append(value);}
    public void append(DynVarBoolean value){indexLookup.append(value);}
    public void append(DynVarString value){indexLookup.append(value);}
    public void append(DynVarList value){indexLookup.append(value);}

    public void set(int index, DynVarFieldCords value){indexLookup.set(index, value);}
    public void set(int index, DynVarFieldPos value){indexLookup.set(index, value);}
    public void set(int index, DynVarNumber value){indexLookup.set(index, value);}
    public void set(int index, DynVarBoolean value){indexLookup.set(index, value);}
    public void set(int index, DynVarString value){indexLookup.set(index, value);}
    public void set(int index, DynVarList value){indexLookup.set(index, value);}
    public void set(int index, DynVarJson value){indexLookup.set(index, value);}

    public void rm(int index){indexLookup.remove(index);}
}
// json
class DynVarJson{
    public String name  = "";
    // the json object
    private final Map<String, Object> data = new HashMap<>();
    // add key with value to object
    public void add(String key, DynVarFieldCords value){data.put(key, value);}
    public void add(String key, DynVarFieldPos value){data.put(key, value);}
    public void add(String key, DynVarNumber value){data.put(key, value);}
    public void add(String key, DynVarBoolean value){data.put(key, value);}
    public void add(String key, DynVarString value){data.put(key, value);}
    public void add(String key, DynVarList value){data.put(key, value);}
    public void add(String key, DynVarJson value){data.put(key, value);}
    // set key to value in json
    public void set(String key, DynVarFieldCords value){data.put(key, value);}
    public void set(String key, DynVarFieldPos value){data.put(key, value);}
    public void set(String key, DynVarNumber value){data.put(key, value);}
    public void set(String key, DynVarBoolean value){data.put(key, value);}
    public void set(String key, DynVarString value){data.put(key, value);}
    public void set(String key, DynVarList value){data.put(key, value);}
    public void set(String key, DynVarJson value){data.put(key, value);}
    // get object of key
    public <T> T get(String key){return (T) data.get(key);}
    // remove key and its object
    public void remove(String key){data.remove(key);}
}

// to be used here for now for list thingy of dyn variables
class AdaptiveList<T> {
    private ArrayList<T> list = new ArrayList<>();
    public void append(T item) {list.add(item);}
    public void remove(int index) {list.remove(index);}
    public void set(int index, T item) {list.set(index, item);}
    public T get(int index) {return list.get(index);}
}