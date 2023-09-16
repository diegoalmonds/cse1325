import java.util.ArrayList;

public class Library
{
    private String name;
    private ArrayList<Publication> publications;
    private ArrayList<Patron> patrons;


    public Library(String name)
    {
        this.name = name;
        this.publications = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }

    public void addPublication(Publication publication)
    {
        publications.add(publication);
    }

    public void addPatron(Patron patron)
    {
        patrons.add(patron);
    }

    public String patronMenu()
    {
        StringBuilder patronMenu = new StringBuilder("Patrons\n\n");
        for (int i = 0; i < patrons.size(); i++)
            patronMenu.append("" + i + ") " + patrons.get(i).toString() + "\n");
        return patronMenu.toString();
    }

    public void checkOut(int publicationIndex, int patronIndex)
    {
        publications.get(publicationIndex).checkOut(patrons.get(patronIndex));
    }

    @Override
    public String toString()
    {
        StringBuilder library = new StringBuilder(name + "\n\n");
        for (int i = 0; i < publications.size(); i++)
            library.append("" + i + ") " + publications.get(i).toString() + "\n");
        return library.toString();
    }
}