import Telemetry.Telemetry;

public class Main {
    private static DynParser parser = new DynParser();
    private static Telemetry telem = new Telemetry();
    public static void main(String[] args){
        // load dyn
        parser.init(telem, "Docs");
        // print ending
    }
}