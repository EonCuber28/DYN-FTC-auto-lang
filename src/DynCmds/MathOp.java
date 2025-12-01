package DynCmds;

import DynVars.DynVarNumber;

public class MathOp {
    String MathOp;
    String VarIn1;
    String VarIn2;
    String VarOut;
    public <DynVarBuffer> DynVarNumber process(DynVarBuffer in){
        DynVarNumber out = new DynVarNumber(VarOut);
        switch (MathOp){
            case "ADD" -> {}
            case "SUB" -> {}
            case "MUX" -> {}
            case "DIV" -> {}
            case "POW" -> {}
            case "SQR" -> {}
            case "SIN" -> {}
            case "invSIN" -> {}
            case "COS" -> {}
            case "invCOS" -> {}
            case "TAN" -> {}
            case "invTAN" -> {}
            default -> {}
        }
        return null; // TEMP
    }
}
