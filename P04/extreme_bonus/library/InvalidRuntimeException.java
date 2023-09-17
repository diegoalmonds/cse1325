/** 
 * Custom exception for runtime below 0 seconds
 * 
 * @author Diego Olmos
 * @version 1.0
 * @since 1.0
 */
package library;

public class InvalidRuntimeException extends ArithmeticException
{
    public InvalidRuntimeException()
    {
        super();
    }
    public InvalidRuntimeException(String message)
    {
        super(message);
    }
    public InvalidRuntimeException(String title, int runtime)
    {
        System.err.println(title + "has invalid runtime " + runtime);
    }

}