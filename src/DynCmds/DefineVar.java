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
                    Object a = items[x];
                    if (a instanceof DynVarBoolean) {}
                    else if (a instanceof DynVarFieldCords) {}
                    else if (a instanceof DynVarFieldPos) {}
                    else if (a instanceof DynVarJson) {}
                    else if (a instanceof DynVarList) {}
                    else if (a instanceof DynVarNumber) {}
                    else if (a instanceof DynVarString) {}
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
                if (state instanceof Integer) {variable = new DynVarNumber((double)state, name);}
                else if (state instanceof Double) {variable = new DynVarNumber((double)state, name);}
                else if (state instanceof Float) {variable = new DynVarNumber((double)state, name);}
            }
        }
    }
}
