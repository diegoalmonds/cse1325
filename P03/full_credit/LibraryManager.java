import java.time.LocalDate;
import java.lang.String;
import java.util.Scanner;

public class LibraryManager
{
    public static void main(String[] args)
    {
        String name, email;
        int index;
        Scanner in = new Scanner(System.in);
        Library lib1 = new Library("South Irving Library");
        lib1.addPublication(new Publication("The Martian", "Andy Weir", 2015));
        lib1.addPublication(new Publication("Atomic Habits", "James Clear", 2019));
        lib1.addPublication(new Publication("1987", "George Orwell", 1970));
        System.out.println(lib1);
        
        System.out.println("Which book would you like to check out?");
        index = in.nextInt();
        in.nextLine();
        System.out.println("What is your name?");
        name = in.nextLine();
        System.out.println("What is your email?");
        email = in.nextLine();
        Patron person1 = new Patron(name, email);
        lib1.checkOut(index, person1);

        System.out.println(lib1);
    }
}