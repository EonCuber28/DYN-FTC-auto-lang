import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class WhileLoop {
     // https://youtu.be/KOaeDHeJ80I?si=z-WXQa0aNsOZWFnq

    private enum whileTypes{C1,C2}
    private whileTypes whileType;

    private String ConditionID;
    private String ConditionID2;

    private int index;

    private Function<String,DynVar> getVarFunc;
    private BiConsumer<String,DynVar> setVarFunc;

    public WhileLoop(String condition_ID, int index){
        whileType = whileTypes.C1;
        ConditionID = condition_ID;
        this.index = index;
    }
    public WhileLoop(String condition_ID_pt1, String condition_ID_pt2, int index){
        whileType = whileTypes.C2;
        ConditionID = condition_ID_pt1;
        ConditionID2 = condition_ID_pt2;
        this.index = index;
    }

    public void init(Function<String,DynVar> getVarFuncIN, BiConsumer<String,DynVar> setVarFuncIN){
        getVarFunc = getVarFuncIN;
        setVarFunc = setVarFuncIN;
    }

    private DynVar getVar(String ID){
        return getVarFunc.apply(ID);
    }
    private void setVar(String ID, DynVar Value){
        setVarFunc.accept(ID, Value);
    }

    public boolean isLooping(){
        return switch (whileType) {
            case C1 -> getVar(ConditionID).isTrue();
            case C2 -> getVar(ConditionID).equals(getVar(ConditionID2));
        }; // intelliJ told me to
    }

    public int getIndex(){
        return index;
    }
}
