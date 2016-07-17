
package byui.cit260.hiddenMickeys.view;

import hiddenmickeys.HiddenMickeys;
import java.io.PrintWriter;


public class ErrorView {
    private static final PrintWriter errorFile = HiddenMickeys.getOutFile();
    private static final PrintWriter logFile = HiddenMickeys.getLogFile();
    
    public static void display(String className, String errorMessage) {
        
        errorFile.println(
        "-----------------------------------------------"
                + "\n- ERROR - " + errorMessage
        + "\n-----------------------------------------------");
    
    //log error
    logFile.println(className + " - " + errorMessage);
    
    }
}
