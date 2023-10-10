package library;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDate;

/** 
 * Superclass for all types of publications (e.g videos, book, etc.).
 * 
 * @author          Diego Olmos
 * @version         1.0
 * @since           1.0
 */
public class Publication
{
    private String title;
    private String author;
    private int copyright;
    private Patron loanedTo;
    private LocalDate dueDate;

    /**
     * Creates an instance of publication.
     * 
     * @param title             the title of the publication 
     * @param author            the author of the publication 
     * @param copyright         the copyright year of the publication
     * @since                   1.0
     */
    public Publication(String title, String author, int copyright)
    {
        if (copyright < 1900 || copyright > LocalDate.now().getYear())
            throw new IllegalArgumentException("Copyright must be after 1900 and before the current year");
        this.title = title;
        this.author = author;
        this.copyright = copyright;
    }

    public Publication(BufferedReader br) throws IOException
    {
        this.title = br.readLine();
        this.author = br.readLine();
        this.copyright = Integer.parseInt(br.readLine());
        if (copyright < 1900 || copyright > LocalDate.now().getYear())
            throw new IllegalArgumentException("Copyright must be after 1900 and before the current year");
        if (br.readLine().equals("CHECKED IN"))
        {
            this.loanedTo = null;
            this.dueDate = null;
        }
        else
        {
            String patronInfo = br.readLine();
            this.loanedTo = new Patron(patronInfo.substring(0,patronInfo.indexOf("\t")), patronInfo.substring(patronInfo.indexOf("\t")+1));
            this.dueDate = LocalDate.of(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()));
        }
    }

    public void save(BufferedWriter bw) throws IOException
    {
        bw.write(title + '\n');
        bw.write(author + '\n');
        bw.write("" + copyright + '\n');
        if (loanedTo == null)
            bw.write("CHECKED IN" + '\n');
        else
        {
            bw.write("CHECKED OUT" + '\n');
            bw.write("" + loanedTo + '\n');
            bw.write("" + dueDate.getYear() + '\n');
            bw.write("" + dueDate.getMonthValue() + '\n');
            bw.write("" + dueDate.getDayOfMonth() + '\n');
        }
    }
            

    /**
     * Sets the publication's loanedTo field to the patron that was passed in and sets the due date 14 days after the current date.
     * 
     * @param patron            the patron object that will checkout the publication
     * @since                   1.0
     */
    public void checkOut(Patron patron)
    {
        this.loanedTo = patron;
        this.dueDate = LocalDate.now().plusDays(14);
    }
    /**
     * Sets the loanedTo and dueDate fields of the publication to null
     * 
     * @since 1.0
     * 
     */
    public void checkIn()
    {
        this.loanedTo = null;
        this.dueDate = null;
    }
    

    /**
     * Prints all the publication's information.
     * 
     * @return                  String the fields of the publication
     * @since                   1.0
     */
    @Override
    public String toString()
    {

        StringBuilder publication = new StringBuilder();
        if (this.loanedTo == null)
            publication.append(String.format("Book Title: \"%s\"    Author: %s    copyright %d    \n", title, author, copyright));
        else
            publication.append(String.format("Book Title: \"%s\"    Author: %s    copyright %d    \n    CHECKED OUT BY: %s\n    DUE BY: %s\n", title, author, copyright, loanedTo, dueDate.toString()));
        return publication.toString();
    }
    
}