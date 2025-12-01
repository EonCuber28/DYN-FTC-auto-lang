import DynCmds.*;

import java.util.function.Consumer;

public class DynCmdBuffer {
    // final movemet ops

    // instantiators
    public DynCmdBuffer(){}
    public void addCustomCommand(String command, Consumer<String[]> funcIn){
        //
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