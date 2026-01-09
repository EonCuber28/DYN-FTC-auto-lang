import Telemetry.Telemetry;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static DynProcessor parser = new DynProcessor();
    private static Telemetry telem = new Telemetry();
    public static void main(String[] args){
        // test custom func IDs
        String[] funcIDs = new String[]{"Fire0","Fire1","Fire2","startIntake","stopIntake"};
        // load file
        File file = new File("/home/eoncuber/IdeaProjects/DYN-FTC-auto-lang/DYN/Test.dyn");
        String fileText = "";
        try {
            Scanner fileScan = new Scanner(file);
            while (fileScan.hasNextLine()){
                fileText += fileScan.nextLine() + "\n";
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        // load dyn
        parser.init(telem, fileText, funcIDs);
        // print ending

    }
}