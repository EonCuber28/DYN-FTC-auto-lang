import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DynVar {
    private enum VarType{
        NUMBER,
        BOOLEAN,
        STRING,
        LIST,
        JSON,
        FIELD_CORD,
        FIELD_POS
    }
    public VarType type;
    private Object value;

    public DynVar(String setType) throws Exception {
        switch (setType){
            case "Number" -> {type = VarType.NUMBER;}
            case "Boolean" -> {type = VarType.BOOLEAN;}
            case "String" -> {type = VarType.STRING;}
            case "List" -> {type = VarType.LIST;}
            case "Json" -> {type = VarType.JSON;}
            case "Field coordinates" -> {type = VarType.FIELD_CORD;}
            case "Field cords" -> {type = VarType.FIELD_CORD;}
            case "Field position" -> {type = VarType.FIELD_POS;}
            case "Field pos" -> {type = VarType.FIELD_POS;}
            default -> {throw new Exception("cannot create DYN variable type: "+setType);}
        }
    }
    public Object getValue(){return value;}

    // logical ops
    public boolean equals(DynVar IN){return (IN == value);}
    public boolean isMore(DynVar IN){
        if (IN.type == VarType.NUMBER && type == VarType.NUMBER){
            // dyn numbers are always doubles in java land.
            return ((double)IN.getValue() > (double)value);
        } else {
            return false;
        }
    }
    public boolean isLess(DynVar IN){
        if (IN.type == VarType.NUMBER && type == VarType.NUMBER){
            // dyn numbers are always doubles in java land.
            return ((double)IN.getValue() < (double)value);
        } else {
            return false;
        }
    }
    public boolean isMoreEq(DynVar IN){
        if (IN.type == VarType.NUMBER && type == VarType.NUMBER){
            // dyn numbers are always doubles in java land.
            return ((double)IN.getValue() >= (double)value);
        } else {
            return false;
        }
    }
    public boolean isLessEq(DynVar IN){
        if (IN.type == VarType.NUMBER && type == VarType.NUMBER){
            // dyn numbers are always doubles in java land.
            return ((double)IN.getValue() <= (double)value);
        } else {
            return false;
        }
    }
    // math ops
    public DynVar add(DynVar IN){return null;}

    // general
    public String toString(){
        switch (type){
            case NUMBER -> {return Double.toString((double)value);}
            case BOOLEAN -> {return Boolean.toString((boolean)value);}
            case STRING -> {return (String)value;}
            case LIST -> {return ((ArrayList)value).toString();}
            case JSON -> {return}
        }
    }
}
