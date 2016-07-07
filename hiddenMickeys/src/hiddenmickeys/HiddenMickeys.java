
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiddenmickeys;

/**
 *
 * @author Hannah Mars
 */
import byui.cit260.hiddenMickeys.model.*;
        


import byui.cit260.hiddenMickeys.view.StartProgramView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HiddenMickeys {
    
    private static Game currentGame = null;
    private static Player player = null;

    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    
    private static PrintWriter logFile = null;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
     try {
        //open character stream files for end user input and output
        HiddenMickeys.inFile = 
                new BufferedReader(new InputStreamReader(System.in));
        
        HiddenMickeys.outFile = new PrintWriter(System.out, true);
        
        //open log file
        String filePath = "log.txt";
        HiddenMickeys.logFile = new PrintWriter(filePath);
        
        //create the start program view and display the start program view
        StartProgramView startProgramView = new StartProgramView();
        startProgramView.displayStartProgramView();
        return;
        
     } catch (Throwable e) {
         
         System.out.println("Exception: " + e.toString() +
                            "\nCause: " + e.getCause() +
                            "\nMessage: " + e.getMessage());
         
         e.printStackTrace();;
     }       

     finally {
         try {
             if (HiddenMickeys.inFile != null)
                 HiddenMickeys.inFile.close();
             
             if (HiddenMickeys.outFile !=null)
                 HiddenMickeys.outFile.close();
             
             if (HiddenMickeys.logFile !=null)
                 HiddenMickeys.logFile.close();
             
         } catch (IOException ex) {
             System.out.println("Error closing files");
             return;
         }
         
     }
}


    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        HiddenMickeys.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }
    

    public static void setPlayer(Player player) {
        HiddenMickeys.player = player;
    }
   public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        HiddenMickeys.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        HiddenMickeys.inFile = inFile;
    }

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        HiddenMickeys.logFile = logFile;
    }

 
   
     
}


