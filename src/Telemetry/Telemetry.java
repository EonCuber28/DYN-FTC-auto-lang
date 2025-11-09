package Telemetry;

public class Telemetry {
    private String terminalOutput = "";
    public void addData(Object Header, Object Message){
        terminalOutput += String.valueOf(Header)+": "+String.valueOf(Message)+"\n";
    }
    public void update(){
        System.out.println(terminalOutput);
        terminalOutput = "";
    }
}
