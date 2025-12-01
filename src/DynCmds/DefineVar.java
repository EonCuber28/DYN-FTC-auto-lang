package DynCmds;

import DynVars.*;

import java.util.HashMap;

public class DefineVar {
    // class variables
    private int linePosition;
    private String varType;
    private Object variable;
    private String varName;
    // instantiators
    public DefineVar(int lineNumber, String type, String name, Object state){
        linePosition = lineNumber;
        switch (type){
            case "FieldCoord": {
                varType = type;
                varName = name;
                variable = new DynVarFieldCords((double[])state, name);
            }
            case "FieldPos": {
                varType = type;
                varName = name;
                variable = new DynVarFieldPos((double[])state, name);
            }
            case "String": {
                varType = type;
                varName = name;
                variable = new DynVarString((String)state, name);
            }
            case "Bool": {
                varType = type;
                varName = name;
                variable = new DynVarBoolean((boolean)state, name);
            }
            case "List": {
                varType = type;
                varName = name;
                Object[] items = (Object[]) state;
                DynVarList barryable = new DynVarList(name);
                for (int x = 0; x < items.length; x++){
                    switch (items[x]){
                        case DynVarBoolean a -> barryable.append(a);
                        case DynVarFieldCords a -> barryable.append(a);
                        case DynVarFieldPos a -> barryable.append(a);
                        case DynVarJson a -> barryable.append(a);
                        case DynVarList a -> barryable.append(a);
                        case DynVarNumber a -> barryable.append(a);
                        case DynVarString a -> barryable.append(a);
                        default -> {}
                    }
                }
                variable = barryable;
            }
            case "Json": {
                varType = type;
                varName = name;
                variable = new DynVarJson((HashMap<String,Object>)state, name);
            }
            case "Num": {
                varType = type;
                varName = name;
                switch (state){
                    case int a -> variable = new DynVarNumber(a, name);
                    case float a -> variable = new DynVarNumber(a, name);
                    case double a -> variable = new DynVarNumber(a, name);
                    default -> {}
                }
            }
        }
    }
}
