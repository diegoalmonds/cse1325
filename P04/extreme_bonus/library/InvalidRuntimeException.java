package library;

/** 
 * Custom exception for runtime below 0 seconds.
 * 
 * @author              Diego Olmos
 * @version             1.0
 * @since               1.0
 */
public class InvalidRuntimeException extends ArithmeticException
{

    /**
     * Constructs an InvalidRuntimeExpression with no detailed message.
     * 
     * @since           1.0
     */
    public InvalidRuntimeException()
    {
        super();
    }
    /**
     * Constructs an InvalidRuntimeExpression with a message
     * 
     * @param message           the detail message
     * @since                   1.0
     */
    public InvalidRuntimeException(String message)
    {
        super(message);
    }

    /**
     * Constructs an InvalidRuntimeExpression with a video title and runtime
     * 
     * @param title             title of the video
     * @param runtime           runtime of the video
     * @since                   1.0
     */
    public InvalidRuntimeException(String title, int runtime)
    {
        System.err.println(title + " has invalid runtime " + runtime);
    }

}