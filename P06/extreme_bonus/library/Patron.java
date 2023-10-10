package library;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

/** 
 * Creates object to store library patron information.
 * 
 * @author                  Diego Olmos
 * @version                 1.0
 * @since                   1.0
 */
public class Patron
{
    private String name;
    private String email;

    /**
     * Creates an instance of Patron.
     * 
     * @param name          name of the patron
     * @param email         email of the patron
     * @since               1.0
     */
    public Patron(String name, String email)
    {
        this.name = name;
        this.email = email;
    }

    public Patron(BufferedReader br) throws IOException
    {
        this.name = br.readLine();
        this.email = br.readLine();
    }

    public void save(BufferedWriter bw) throws IOException 
    {
        bw.write(name + '\n');
        bw.write(email + '\n');
    }

    /**
     * Returns the patron's information.
     * 
     * @return              String name and email of the patron
     * @since               1.0
     */
    @Override
    public String toString()
    {
        return String.format("%s\t%s", name, email);
    }
}