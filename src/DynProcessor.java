//import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import DYNtokenizer.DynTokenizer;
import DYNtokenizer.Token;
import Telemetry.Telemetry;

public class DynProcessor {
    private DynTokenizer tokeniser;

    private Token[] tokens;

    public DynProcessor(){
        // idk            nothing?
    }
    public void init(Telemetry telemetry, String scriptData, String[] funcIDs){
        // start tokeniser
        tokeniser = new DynTokenizer(scriptData);
        // register function ids
        for (int i = 0; i < funcIDs.length; i++){tokeniser.registerCustomCommand(funcIDs[i]);}
        // tokenise script
        tokens = tokeniser.tokenize().toArray(new Token[0]);
        for (int i = 0; i < tokens.length; i++){System.out.println(tokens[i].toString());}
        // process tokens
        // set variables
    }
    public void processScriptTokens(){
        //
    }
}