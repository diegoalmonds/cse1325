public class LibraryManager
{
    public static void main(String[] args)
    {
        try
        {        
            Library lib1 = new Library("South Irving Library");
            lib1.addPublication(new Publication("The Martian", "Andy Weir", 2015));
            lib1.addPublication(new Publication("Fahrenheit 451", "Ray Bradbury", 1953));
            lib1.addPublication(new Publication("1984", "George Orwell", 1961));
            lib1.addPatron(new Patron("Diego Olmos", "dxo5722@mavs.uta.edu"));
            System.out.println(lib1);
            int publicationIndex = Integer.parseInt(System.console().readLine("\nWhat book would you like to check out? "));
            System.out.println(lib1.patronMenu());
            int patronIndex = Integer.parseInt(System.console().readLine("\nWhat patron are you? "));
            lib1.checkOut(publicationIndex, patronIndex);
            System.out.println(lib1);
        }
        catch (Exception e)
        {
            System.err.println("\nThe index entered does not exist in publications." + e);
        }   
    }
}