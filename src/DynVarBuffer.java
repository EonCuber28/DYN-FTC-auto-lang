import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DynVarBuffer {
    private Map<String, DynVar> varBuffer = new HashMap<>();

    public DynVarBuffer(Map<String, DynVar> varBuffer){
        this.varBuffer = varBuffer;
    }
    public DynVarBuffer(String[] IDs){}
    public DynVarBuffer(ArrayList<String> IDs){}
}
