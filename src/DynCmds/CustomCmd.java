package DynCmds;

import java.util.function.Consumer;

public class CustomCmd {
    public String Cmd;
    public Consumer<String[]> func;
    private String[] args;
    public CustomCmd(String command, Consumer<String[]> function){
        this.Cmd = command;
        this.func = function;
    }
    public CustomCmd(String command, Consumer<String[]> function, String[] args){
        this.Cmd = command;
        this.func = function;
        this.args = args;
    }
    public void callFunc(String[] in){
        func.accept(in);
    }
    public void process(String[] in){
        callFunc(in);
    }
    public void callFunc(){
        func.accept(args);
    }
    public void process(){}
    public void setArgs(String[] in){
        args = in;
    }
    public void run(){}
}
