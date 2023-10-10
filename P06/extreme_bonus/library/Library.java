package library;

import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

/** 
 * Models a Library.
 * 
 * @author                       Diego Olmos
 * @version                      1.0
 * @since                        1.0
 */
public class Library
{
    private String name;
    private ArrayList<Publication> publications;
    private ArrayList<Patron> patrons;

    /**
     * Creates a library instance.
     * 
     * @param name              name of the library
     * @since                   1.0
     * 
     */
    public Library(String name)
    {
        this.name = name;
        this.publications = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }

    public Library(BufferedReader br) throws IOException
    {
        this(br.readLine());
        int size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++)
        {
            if (br.readLine().equals("VIDEO"))
                publications.add(new Video(br));
            else
                publications.add(new Publication(br));
        }
        size = Integer.parseInt(br.readLine());
        for(int i = 0; i < size; i++)
        {
            patrons.add(new Patron(br));
        }
    }

    public void save(BufferedWriter bw) throws IOException
    {
        bw.write(name + '\n');
        bw.write("" + publications.size() + '\n');
        for (int i = 0; i < publications.size(); i++)
        {
            if (publications.get(i) instanceof Video)
                bw.write("VIDEO" + '\n');
            else
                bw.write("PUBLICATION" + '\n');
            publications.get(i).save(bw);
        }
        bw.write("" + patrons.size() + '\n');
        for (int i = 0; i < patrons.size(); i++)
        {
            patrons.get(i).save(bw);
        }
    }

    /**
     * Adds a publicaation to the end of the publications ArrayList.
     * 
     * @param publication       Publication to be added to the ArrayList
     * @since                   1.0
     */
    public void addPublication(Publication publication)
    {
        publications.add(publication);
    }

    /**
     * Adds a patron to the end of the patrons ArrayList.
     * 
     * @param patron            Patron to be added to the ArrayList
     * @since                   1.0
     */
    public void addPatron(Patron patron)
    {
        patrons.add(patron);
    }

    /**
     * Prints a menu showing each patron in the patron ArrayList.
     * 
     * @return                  String showing each patron's information on seperate lines
     * @since                   1.0
     */
    public String patronMenu()
    {
        StringBuilder patronMenu = new StringBuilder("Patrons\n\n");
        for (int i = 0; i < patrons.size(); i++)
            patronMenu.append("" + i + ") " + patrons.get(i).toString() + "\n");
        return patronMenu.toString();
    }

    /**
     * Calls the chosen publication's checkOut method with a Patron parameter passed in.
     * 
     * @param publicationIndex  Index of the publication shown when printing library
     * @param patronIndex       Index of the patron shown in patronMenu
     * @since                   1.0
     */
    public void checkOut(int publicationIndex, int patronIndex)
    {
        publications.get(publicationIndex).checkOut(patrons.get(patronIndex));
    }
    /**
     * Calls the checkIn method of the chosen publication
     * 
     * @param publicationIndex  Index of the publication being checked in
     * @since                   1.0
     */
    public void checkIn(int publicationIndex)
    {
        publications.get(publicationIndex).checkIn();
    }

    /**
     * Prints a menu showing the library name and all the publications.
     * 
     * @return                  String with all the publications listed
     * @since                   1.0
     */
    @Override
    public String toString()
    {
        StringBuilder library = new StringBuilder("\n" + name + "\n\n");
        for (int i = 0; i < publications.size(); i++)
            library.append("" + i + ") " + publications.get(i).toString() + "\n");
        return library.toString();
    }
}