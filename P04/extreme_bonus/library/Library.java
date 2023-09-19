package library;

import java.util.ArrayList;

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
     * Creates a library instance
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

    /**
     * Adds a publicaation to the end of the publications ArrayList
     * 
     * @param publication       Publication to be added to the ArrayList
     * @since                   1.0
     */
    public void addPublication(Publication publication)
    {
        publications.add(publication);
    }

    /**
     * Adds a patron to the end of the patrons ArrayList
     * 
     * @param patron            Patron to be added to the ArrayList
     * @since                   1.0
     */
    public void addPatron(Patron patron)
    {
        patrons.add(patron);
    }

    /**
     * Prints a menu showing each patron in the patron ArrayList
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
     * Calls the chosen publication's checkOut method with a patron parameter passed in
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
     * Prints a menu showing the library name and all the publications
     * 
     * @return                  String with all the publications listed
     * @since                   1.0
     */
    @Override
    public String toString()
    {
        StringBuilder library = new StringBuilder(name + "\n\n");
        for (int i = 0; i < publications.size(); i++)
            library.append("" + i + ") " + publications.get(i).toString() + "\n");
        return library.toString();
    }
}