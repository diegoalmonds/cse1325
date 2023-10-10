package mdi;

import library.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class LibraryManager
{
    private Library library;

    public void saveLibrary()
    {
        String filename = System.console().readLine("Enter the name of the file to save your library information: ");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filename))))
        {
            library.save(bw);
        }
        catch (IOException ioe)
        {
            System.err.println("The file could not be written to - " + ioe);
        }
    }

    public void openLibrary()
    {
        String filename = System.console().readLine("Enter the name of the library file to open: ");
        try (BufferedReader br = new BufferedReader(new FileReader(new File(filename))))
        {
            library = new Library(br);
        }
        catch (IOException ioe)
        {
            System.err.println("The file could not be read - " + ioe);
        }
    }

    public String listPublications()
    {
        return library.toString();
    }

    public void addPublication()
    {
        String input = System.console().readLine("Enter the information of the publication in the following format\n[TITLE],[AUTHOR],[COPYRIGHT YEAR]\n");
        String[] publicationInfo = input.split(",");
        library.addPublication(new Publication(publicationInfo[0], publicationInfo[1], Integer.parseInt(publicationInfo[2])));
    }
    

    public void addVideo()
    {
        String input = System.console().readLine("Enter the information of the video in the following format\n[TITLE],[AUTHOR],[COPYRIGHT YEAR],[RUNTIME IN MINUTES]\n");
        String[] videoInfo = input.split(",");
        Publication video = new Video(videoInfo[0], videoInfo[1], Integer.parseInt(videoInfo[2]), Integer.parseInt(videoInfo[3]));
        library.addPublication(video);
    }

    public void addPatron()
    {
        String input = System.console().readLine("Enter the information of the patron in the following format\n[NAME],[EMAIL]\n");
        String[] patronInfo = input.split(",");
        Patron patron = new Patron(patronInfo[0], patronInfo[1]);
        library.addPatron(patron);
    }

    public String listPatrons()
    {
        return library.patronMenu();
    }
    
    public void checkOut()
    {
        System.out.println(library);
        int publicationIndex = Integer.parseInt(System.console().readLine("\nWhat book would you like to check out? "));
        System.out.println(library.patronMenu());
        int patronIndex = Integer.parseInt(System.console().readLine("\nWhat patron are you? "));
        library.checkOut(publicationIndex, patronIndex);
    }

    public void checkIn()
    {
        System.out.println(library);
        int publicationIndex = Integer.parseInt(System.console().readLine("Which publication would you like to check in? "));
        library.checkIn(publicationIndex);
    }
    
    public static void main(String[] args)
    {
        LibraryManager menu = new LibraryManager();
        int command;
        menu.openLibrary();
        while (true)
        {
            try
            {
                System.out.println("\nLibrary Menu:\n");
                System.out.println("1) Open a library file\n");
                System.out.println("2) List all publications\n");
                System.out.println("3) Add a new publication\n");
                System.out.println("4) Add a new video\n");
                System.out.println("5) Add a new patron to the library\n");
                System.out.println("6) List all patrons\n");
                System.out.println("7) Check out a publication\n");
                System.out.println("8) Check in a publication\n");
                System.out.println("9) Save library information\n");
                System.out.println("0) Exit\n");
                command = Integer.parseInt(System.console().readLine("Enter your selection: "));
                if (command == 0) break;
                if (command == 1) menu.openLibrary();
                if (command == 2) System.out.println(menu.listPublications());
                if (command == 3) menu.addPublication();
                if (command == 4) menu.addVideo();
                if (command == 5) menu.addPatron();
                if (command == 6) System.out.println(menu.listPatrons());
                if (command == 7) menu.checkOut();
                if (command == 8) menu.checkIn();
                if (command == 9) menu.saveLibrary();
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
                System.err.println("One or more indexes entered do not exist\n" + e);
            }
        }
    }
}