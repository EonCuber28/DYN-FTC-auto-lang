package DynCmds;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DynCmdBuffer {
    // final movemet ops
    private List<MovementOp> finalMovement = new ArrayList<>();
    //  json/hashmap fro custom commands
    // instantiators
    public DynCmdBuffer(){
        // add basic instantiation
    }
    public void addCustomCommand(String command, Consumer<String[]> funcIn){
        // add command to special json that aligns the ID's with the wanted function
    }
    // command add functions
    public void addCommand(MovementOp in){}
    public void addCommand(DefineVar in){}
    public void addCommand(WhileLoop in){}
    public void addCommand(PathFunc in){}
    public void addCommand(ForLoop in){}
    public void addCommand(MathOp in){}
    // runner
    public void process(){
        // go though all commands in the buffer and process them using the Var Buffer
        // depending on the command, we give it a different input
    }
}