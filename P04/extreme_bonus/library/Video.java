/** 
 * Creates object to store library patron information.
 * 
 * @author Diego Olmos
 * @version 1.0
 * @since 1.0
 */
package library;

import java.time.Duration;
import java.lang.String;

public class Video extends Publication
{
    private Duration runtime;

    public Video(String title, String author, int copyright, minutes runtime)
    {   
        super(title, author, copyright);
        if (runtime.getSign() != 1)
            throw new InvalidRuntimeException(title, runtime.toString());
        this.runtime = runtime.toMinutes();
    }

    @Override
    public String toString()
    {
        super.toString();
        publication = publication.substring(0, publication.lastIndexOf("copyright") + 6) + "runtime " + runtime + " minutes" + publication.substring(publication.lastIndexOf("copyright") + 6);
    }
}