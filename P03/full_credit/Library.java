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
        String patronMenu = "List of Patrons:\n\n";
        for (Patron p: patrons)
        {
            patronMenu += p + "\n\n"; 
        }
        return patronMenu;
    }

    public void checkOut(int publicationIndex, int patronIndex)
    {
        try
        {
            publications.get(publicationIndex).checkOut(patronIndex);
        }
        catch(IndexOutOfBoundsException ioe)
        {
            System.out.println("Index" + publicationIndex + "does not exist in publications.");
        }
    }

    @Override
    public String toString()
    {
        String library = "Welcome to " + this.name + "\n\n";
        int i = 0;
        for (Publication p: publications)
        {
            library += i + ") " + p + "\n";
            i++;
        }
        return library;
    }
}