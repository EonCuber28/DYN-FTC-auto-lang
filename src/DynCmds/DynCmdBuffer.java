package DynCmds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class DynCmdBuffer {
    // final movemet ops
    private List<MovementOp> finalMovement = new ArrayList<>();
    // custom command stuff
    private Map<String, CustomCmd> customCmds = new HashMap<>();
    // the command buffer
    private List<Object> commandList = new ArrayList<>();
    private List<String> commadnTypeList = new ArrayList<>();
    // instantiators
    public DynCmdBuffer(){
        // add basic instantiation (if needed)
    }
    public void addCustomCommand(String command, Consumer<String[]> funcIn){
        // add command to special json that aligns the ID's with the wanted function
        CustomCmd cmd = new CustomCmd(command, funcIn);
        customCmds.put(command, cmd);
    }
    // command add functions
    public void addCommand(MovementOp in){
        commandList.add(in);
        commadnTypeList.add("MoveOp");
    }
    public void addCommand(DefineVar in){
        commandList.add(in);
        commadnTypeList.add("VarDefine");
    }
    public void addCommand(WhileLoop in){
        commandList.add(in);
        commadnTypeList.add("LoopW");
    }
    public void addCommand(PathFunc in){
        commandList.add(in);
        commadnTypeList.add("PathFunc");
    }
    public void addCommand(ForLoop in){
        commandList.add(in);
        commadnTypeList.add("LoopF");
    }
    public void addCommand(MathOp in){
        commandList.add(in);
        commadnTypeList.add("MathOp");
    }
    public void addUnknown(String ukID){
        CustomCmd func = customCmds.get(ukID);
        commandList.add(func);
        commadnTypeList.add(func.Cmd);
    }
    // runner
    public void process(){
        // go though all commands in the buffer and process them using the Var Buffer
        for (int cmdIndex = 0; cmdIndex < commandList.toArray().length; cmdIndex++) {
            // depending on the command, we give it a different input
            String type = commadnTypeList.get(cmdIndex);
            switch (type){
                case "VarDefine" -> {}
                case "PathFunc" -> {}
                case "MathOp" -> {}
                case "MoveOp" -> {}
                case "LoopW" -> {}
                case "LoopF" -> {}
                default -> {
                    customCmds.get(type).process();
                }
            }
        }
    }
}