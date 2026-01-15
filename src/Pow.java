import java.util.function.BiConsumer;
import java.util.function.Function;

public class Pow {
    private String Value1ID;
    private String Value2ID;
    private String outID;

    private BiConsumer<String, DynVar> setVar;
    private Function<String, DynVar> getVar;

    public Pow(String InID1, String InID2, String OutID){
        Value1ID = InID1;
        Value2ID = InID2;
        outID = OutID;
    }
    public Pow(String IOID, String InID){
        Value1ID = IOID;
        Value2ID = InID;
        outID = IOID;
    }
    public void init(BiConsumer<String, DynVar> SetVarFunc, Function<String, DynVar> GetVarFunc){
        getVar = GetVarFunc;
        setVar = SetVarFunc;
    }

    public void run(){
        getVar.apply(outID).setToPow(getVar.apply(Value1ID), getVar.apply(Value2ID));
        setVar.accept(outID, getVar.apply(Value1ID));
    }
}
