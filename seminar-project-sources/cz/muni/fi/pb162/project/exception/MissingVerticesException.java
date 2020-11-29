package cz.muni.fi.pb162.project.exception;

/**
 * Exception when not enough vertex2D object in collection
 * @author Petr Smejkal
 */
public class MissingVerticesException extends RuntimeException {

    /**
     * Constructor of class MissingVerticesException
     * @param message String reason of exception
     */
    public MissingVerticesException(String message) {
        super(message);
    }

    /**
     * Constructor of class MissingVerticesException
     * @param message String reason of exception
     * @param cause Exception
     */
    public MissingVerticesException(String message, Throwable cause) {
        super(message, cause);
    }
}
