package library;

import java.time.Duration;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.String;

/** 
 * Creates object to store library patron information.
 * 
 * @author                  Diego Olmos
 * @version                 1.0
 * @since                   1.0
 */
public class Video extends Publication
{
    private Duration runtime;

    /**
     * Creates an instance of video, using publication as a superclass.
     * 
     * @param title         title of the video
     * @param author        author of the video
     * @param copyright     copyright year of the video
     * @param runtime       runtime of the video in minutes
     * @since               1.0
     */
    public Video(String title, String author, int copyright, int runtime)
    {   
        super(title, author, copyright);
        Duration zeroRuntime = Duration.ofMinutes(0);
        Duration runtimeMins = Duration.ofMinutes(runtime);
        if (runtimeMins.compareTo(zeroRuntime) < 0)
            throw new InvalidRuntimeException(title, (int) runtimeMins.toMinutes());
        this.runtime = runtimeMins;
    }

    public Video(BufferedReader br) throws IOException
    {
        super(br);
        Duration zeroRuntime = Duration.ofMinutes(0);
        Duration runtimeMins = Duration.ofMinutes(Integer.parseInt(br.readLine()));
        if (runtimeMins.compareTo(zeroRuntime) < 0)
            throw new InvalidRuntimeException("One of the videos has an invalid runtime.");
        this.runtime = runtimeMins;

    }

    public void save(BufferedWriter bw) throws IOException
    {
        super.save(bw);
        bw.write("" + runtime.toMinutes() + '\n');
    }

    /**
     * Replaces publication toString method to fit Video fields.
     * 
     * @return             String fields of Video instance
     * @since               1.0
     */
    @Override
    public String toString()
    {
        StringBuilder video = new StringBuilder(super.toString());
        video.replace(0, 4, "Video");
        video.insert(video.lastIndexOf("copyright") + 18, "runtime " + (int) runtime.toMinutes() + " minutes");
        return video.toString();
    }
}