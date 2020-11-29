package cz.muni.fi.pb162.project.exception;

/**
 * Exception for drawing same color as background
 * @author Petr Smejkal
 */
public class TransparentColorException extends Exception {
    /**
     * Constructor of class TransparentColorException
     * @param message String reason of exception
     */
    public TransparentColorException(String message) {
        super(message);
    }

    /**
     * Constructor of class TransparentColorException
     * @param message String reason of exception
     * @param cause Exception
     */
    public TransparentColorException(String message, Throwable cause) {
        super(message, cause);
    }
}
