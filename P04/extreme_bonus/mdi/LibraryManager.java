package mdi;

import library.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Scanner;

public class LibraryManager
{
    public static void main(String[] args)
    {
        try
        {
            String type, name;
            File libraryText = new File(args[0]);
            Scanner textInput = new Scanner(libraryText);
            Library lib1 = new Library(textInput.nextLine());
            while (textInput.hasNextLine())
            {
                type = textInput.nextLine();
                if (type.isEmpty())
                    break;
                if (type.equals("Book"))
                    lib1.addPublication(new Publication(textInput.nextLine(), textInput.nextLine(), Integer.parseInt(textInput.nextLine())));
                if (type.equals("Video"))
                    lib1.addPublication(new Video(textInput.nextLine(), textInput.nextLine(), Integer.parseInt(textInput.nextLine()), Integer.parseInt(textInput.nextLine())));
            }
            while (textInput.hasNextLine())
            {
                name = textInput.nextLine();
                if (name.isEmpty())
                    break;
                lib1.addPatron(new Patron(name, textInput.nextLine()));
            }
            System.out.println(lib1);
            int publicationIndex = Integer.parseInt(System.console().readLine("\nWhat book would you like to check out? "));
            System.out.println(lib1.patronMenu());
            int patronIndex = Integer.parseInt(System.console().readLine("\nWhat patron are you? "));
            lib1.checkOut(publicationIndex, patronIndex);
            System.out.println(lib1);
        }
        catch (IllegalArgumentException iae)
        {
            System.err.println("The copyright year is not valid\n" + iae);
        }
        catch (InvalidRuntimeException ire)
        {
            System.err.println(ire);
        }
        catch (ArrayIndexOutOfBoundsException aie)
        {
            System.err.println("Filename was not entered as an argument\n" + aie);
        }
        catch (Exception e)
        {
            System.err.println("The index entered does not exist\n" + e);
        }
    }
}