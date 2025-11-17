package DynCmds;

public class DefineVar {
    // class variables
    private int linePosition;
    private String varType;
    // instantiators
    public DefineVar(int lineNumber, String type){
        linePosition = lineNumber;
        switch (type){
            case "FieldCoord": {}
            case "FieldPos": {}
            case "Num": {}
            case "Bool": {}
            case "String": {}
            case "List": {}
            case "Json": {}
        }
    }
}
