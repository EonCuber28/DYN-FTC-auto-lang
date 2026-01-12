package DYNtokenizer;

import java.util.List;

/**
 * Example usage of the DYN Tokenizer for FTC autonomous programs.
 * This class demonstrates how to integrate the tokenizer with your FTC OpMode.
 */
public class DynTokenizerExample {

    public static void main(String[] args) {
        // Example DYN script
        String dynScript = """
            // Sample FTC auto script
            def_path main start
                PathStartPosition = startPos
                FieldPos startPos (0, 0, 90)
                FieldCoord waypoint1 (24, 24)
                
                Num speed 0.8
                Bool isBlueAlliance true
                
                goTo(waypoint1)
                turnTo(180, 45)
                
                if (isBlueAlliance == true) start
                    output2telem "Running blue auto"
                end
                
                ADD speed 0.1 to speed
                
                cmd grabSample from samplePos to armPos
            end
            
            autoPath main
            """;

        // Create tokenizer
        DynTokenizer tokenizer = new DynTokenizer(dynScript);

        // Register custom commands (these would be your robot subsystem functions)
        tokenizer.registerCustomCommand("grabSample");
        tokenizer.registerCustomCommand("releaseSample");
        tokenizer.registerCustomCommand("extendArm");
        tokenizer.registerCustomCommand("retractArm");

        try {
            // Tokenize the script
            List<Token> tokens = tokenizer.tokenize();

            // Print all tokens
            System.out.println("=== DYN Tokenizer Output ===\n");
            for (Token token : tokens) {
                System.out.println(token);
            }

            System.out.println("\n=== Tokenization Complete ===");
            System.out.println("Total tokens: " + tokens.size());

        } catch (DYNtokenizer.TokenizerException e) {
            System.err.println("Tokenization failed: " + e.getMessage());
        }
    }

    /**
     * Example of how to use in an FTC OpMode:
     *
     * @LinearOpMode
     * public class DynAutoOpMode extends LinearOpMode {
     *     @Override
     *     public void runOpMode() {
     *         String script = readDynScript(); // Load your .dyn file
     *
     *         DynTokenizer tokenizer = new DynTokenizer(script);
     *
     *         // Register your robot's custom commands
     *         tokenizer.registerCustomCommand("intake");
     *         tokenizer.registerCustomCommand("outtake");
     *         tokenizer.registerCustomCommand("liftUp");
     *         tokenizer.registerCustomCommand("liftDown");
     *
     *         List<Token> tokens = tokenizer.tokenize();
     *
     *         // Pass tokens to your parser/interpreter
     *         DynParser parser = new DynParser(tokens);
     *         DynProgram program = parser.parse();
     *
     *         waitForStart();
     *
     *         // Execute the program
     *         program.execute(this);
     *     }
     * }
     */
}
