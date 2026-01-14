//import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import DYNtokenizer.DynTokenizer;
import DYNtokenizer.Token;
import Telemetry.Telemetry;

import java.util.ArrayList;

public class DynProcessor {
    private DynTokenizer tokeniser;

    private Token[] tokens;

    private DynVarBuffer varBuffer;

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
        // process tokens
        processScriptTokens();
        // set variables
    }
    public void processScriptTokens(){
        ArrayList<DynVar> scriptVars = new ArrayList<>();
        // cycle through all tokens, take note of variables, and format into
        for (int i = 0; i < tokens.length; i++){
            Token currentToken = tokens[i];
            switch (currentToken.getType()){
                case JSON -> {}
                case FIELD_POS -> {}
                case AS -> {}
                case IF -> {}
                case OR -> {}
                case TO -> {}
                case ADD -> {}
                case AND -> {}
                case CMD -> {}
                case COS -> {}
                case DIV -> {}
                case DOT -> {}
                case END -> {}
                case EOF -> {}
                case FOR -> {}
                case MOD -> {}
                case MUX -> {}
                case NOT -> {}
                case NUM -> {}
                case POW -> {}
                case RUN -> {}
                case SIN -> {}
                case SQR -> {}
                case SUB -> {}
                case TAN -> {}
                case BOOL -> {}
                case FROM -> {}
                case LIST -> {}
                case PLUS -> {}
                case STAR -> {}
                case WEND -> {}
                case COLON -> {}
                case COMMA -> {}
                case GO_TO -> {}
                case MINUS -> {}
                case SLASH -> {}
                case START -> {}
                case WHILE -> {}
                case EQUALS -> {}
                case LBRACE -> {}
                case LPAREN -> {}
                case RBRACE -> {}
                case RPAREN -> {}
                case STRING -> {}
                case TO_DEG -> {}
                case TO_RAD -> {}
                case WSTART -> {}
                case COMMENT -> {}
                case INV_COS -> {}
                case INV_SIN -> {}
                case INV_TAN -> {}
                case NEWLINE -> {}
                case PERCENT -> {}
                case TURN_TO -> {}
                case DEF_PATH -> {}
                case LBRACKET -> {}
                case RBRACKET -> {}
                case AUTO_PATH -> {}
                case LESS_THAN -> {}
                case NOT_EQUAL -> {}
                case IDENTIFIER -> {}
                case LESS_EQUAL -> {}
                case EQUAL_EQUAL -> {}
                case FIELD_COORD -> {}
                case GREATER_THAN -> {}
                case FOLLOW_BEZIER -> {}
                case GREATER_EQUAL -> {}
                case NUMBER_LITERAL -> {}
                case OUTPUT_2_TELEM -> {}
                case STRING_LITERAL -> {}
                case BOOLEAN_LITERAL -> {}
                case PATH_START_POSITION -> {}
                default -> {}
            }
        }

    }
}