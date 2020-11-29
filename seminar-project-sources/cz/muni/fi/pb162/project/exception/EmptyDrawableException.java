package cz.muni.fi.pb162.project.exception;

/**
 * Exception when canvas is empty
 * @author Petr Smejkal
 */
public class EmptyDrawableException extends Exception {
    /**
     * Constructor of class EmptyDrawableException
     * @param message String reason of exception
     */
    public EmptyDrawableException(String message) {
        super(message);
    }

    /**
     * Constructor of class EmptyDrawableException
     * @param message String reason of exception
     * @param cause Exception
     */
    public EmptyDrawableException(String message, Throwable cause) {
        super(message, cause);
    }
}
