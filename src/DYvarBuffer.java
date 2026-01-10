import java.util.HashMap;
import java.util.Map;

public class DYvarBuffer {
    
}

class DYNutilVar{
    // handles variable operaitons

    //buffer
    private Map<String, DynVar> VarMap = new HashMap<>();

    //funcs
    public void addVar(String ID, DynVar var){VarMap.put(ID, var);}
    public DynVar getVar(String ID){return VarMap.get(ID);}
    // math ops
    // logic ops
    public boolean equals(String ID1, String ID2){return VarMap.get(ID1).equals(VarMap.get(ID2));}
    public boolean notEquals(String ID1, String ID2){return !equals(ID1, ID2);}
    public boolean isMore(String ID1, String ID2){return true;}
    public boolean isLess(String ID1, String ID2){return false;}
}