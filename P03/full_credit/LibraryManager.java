import java.time.LocalDate;
import java.lang.String;
import java.util.Scanner;

public class LibraryManager
{
    public static void main(String[] args)
    {
        String name;
        int index;
        Scanner in = new Scanner(System.in);
        Library lib1 = new Library("South Irving Library");
        lib1.addPublication(new Publication("The Martian", "Andy Weir", 2015));
        lib1.addPublication(new Publication("Fahrenheit 451", "Ray Bradbury", 1953));
        lib1.addPublication(new Publication("1984", "George Orwell", 1961));
        System.out.println(lib1);
        
        System.out.println("Which book would you like to check out?");
        index = in.nextInt();
        in.nextLine();
        System.out.println("What is your name?");
        name = in.nextLine();
        lib1.checkOut(index, name);

        System.out.println(lib1);
    }
}