package mdi;

import library.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Scanner;

public class LibraryManagerMenu
{
    public Library loadLibraryFile(String filename)
    {
        String type, name;
        File libraryText = new File(filename);
        Scanner fileInput = new Scanner(libraryText);
        Library library = new Library(fileInput.nextLine());
        while (fileInput.hasNextLine())
        {
            type = fileInput.nextLine();
            if (type.isEmpty())
                break;
            if (type.equals("Book"))
                library.addPublication(new Publication(fileInput.nextLine(), fileInput.nextLine(), Integer.parseInt(fileInput.nextLine())));
            if (type.equals("Video"))
                library.addPublication(new Video(fileInput.nextLine(), fileInput.nextLine(), Integer.parseInt(fileInput.nextLine()), Integer.parseInt(fileInput.nextLine())));
        }
        while (fileInput.hasNextLine())
        {
            name = fileInput.nextLine();
            if (name.isEmpty())
                break;
            library.addPatron(new Patron(name, fileInput.nextLine()));
        }
        return library;
    }

    public String listPublications(Library library)
    {
        return library.toString();
    }

    public void addPublication(Library library)
    {
        String input = System.console().readLine("Enter the information of the publication in the following format\n[TITLE],[AUTHOR],[COPYRIGHT YEAR]\n");
        String[] publicationInfo = input.split(",");
        Publication publication = new Publication(publicationInfo[0], publicationInfo[1], Integer.parseInt(publicationInfo[2]));
        library.addPublication(publication);
    }

    public void addVideo(Library library)
    {
        String input = System.console().readLine("Enter the information of the video in the following format\n[TITLE],[AUTHOR],[COPYRIGHT YEAR],[RUNTIME IN MINUTES]\n");
        String[] videoInfo = input.split(",");
        Publication video = new Video(videoInfo[0], videoInfo[1], Integer.parseInt(videoInfo[2]), Integer.parseInt(videoInfo[3]));
        library.addPublication(video);
    }

    public void addPatron(Library library)
    {
        String input = System.console().readLine("Enter the information of the patron in the following format\n[NAME],[EMAIL]");
        String[] patronInfo = input.split(",");
        Patron patron = new Patron(patronInfo[0], patronInfo[1]);
        library.addPatron(patron);
    }

    public String listPatrons(Library library)
    {
        return library.patronMenu();
    }
    /*
    public void checkOut()
    {

    }
    */
    public static void main(String[] args)
    {
        LibraryManagerMenu menu = new LibraryManagerMenu();
        String input;
        String file = "library.txt";
        int command;
        Library library = menu.loadLibraryFile(file);
        while (true)
        {
            try
            {
                System.out.println("Library Menu:\n");
                System.out.println("0) Load a library file\n");
                System.out.println("1) List all publications\n");
                System.out.println("2) Add a new publication\n");
                System.out.println("3) Add a new video\n");
                System.out.println("4) Add a new patron to the library\n");
                System.out.println("5) List all patron\n");
                System.out.println("6) Check out a publication\n");
                System.out.println("7) Check in a publication\n");
                input = System.console().readLine("Enter your selection ('x' to exit): ");
                if (input.charAt(0) == 'x') break;
                command = Integer.parseInt(input);
                if (command == 0)
                {
                    file = System.console().readLine("Enter the name of the library file: ");
                    library = menu.loadLibraryFile(file);
                }
                if (command == 1) menu.listPublications(library);
                if (command == 2) menu.addPublication(library);
                if (command == 3) menu.addVideo(library);
                if (command == 4) menu.addPatron(library);
                if (command == 5) menu.listPatrons(library);
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
            /*
            catch (FileNotFoundException fnfe)
            {
                System.err.println("Filename entered does not exist\n" + fnfe);
            }
            */
            catch (Exception e)
            {
                System.err.println("The index entered does not exist\n" + e);
            }
        }
    }
}

