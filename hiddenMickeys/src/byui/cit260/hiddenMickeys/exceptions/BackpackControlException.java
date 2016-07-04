/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.exceptions;

/**
 *
 * @author Hannah Mars
 */
    
public class BackpackControlException extends Exception {

    public BackpackControlException() {
    }

    public BackpackControlException(String message) {
        super(message);
    }

    public BackpackControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public BackpackControlException(Throwable cause) {
        super(cause);
    }

    public BackpackControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}


