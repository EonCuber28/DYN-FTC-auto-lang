import java.util.function.BiConsumer;
import java.util.function.Function;

public class Inv_Cos {
    private String Value1ID;
    private String outID;

    private BiConsumer<String, DynVar> setVar;
    private Function<String, DynVar> getVar;

    public Inv_Cos(String InID1, String OutID){
        Value1ID = InID1;
        outID = OutID;
    }
    public Inv_Cos(String IOID){
        Value1ID = IOID;
        outID = IOID;
    }
    public void init(BiConsumer<String, DynVar> SetVarFunc, Function<String, DynVar> GetVarFunc){
        getVar = GetVarFunc;
        setVar = SetVarFunc;
    }

    public void run(){
        getVar.apply(outID).setToIcs(getVar.apply(Value1ID));
        setVar.accept(outID, getVar.apply(Value1ID));
    }
}
