import java.util.ArrayList;

public class Library
{
    private String name;
    private ArrayList<Publication> publications;


    public Library(String name)
    {
        this.name = name;
        this.publications = new ArrayList<>();
    }

    public void addPublication(Publication publication)
    {
        publications.add(publication);
    }

    public void checkOut(int publicationIndex, String patron)
    {
        try
        {
            publications.get(publicationIndex).checkOut(patron);
        }
        catch(IndexOutOfBoundsException ioe)
        {
            System.err.println("\nIndex " + publicationIndex + " does not exist in publications.\n");
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