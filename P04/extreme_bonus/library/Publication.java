package library;

import java.time.LocalDate;

public class Publication
{
    private String title;
    private String author;
    private int copyright;
    private Patron loanedTo;
    private LocalDate dueDate;

    public Publication(String title, String author, int copyright)
    {
        if (copyright < 1900 || copyright > LocalDate.now().getYear())
            throw new IllegalArgumentException("Copyright must be after 1900 and before the current year");
        this.title = title;
        this.author = author;
        this.copyright = copyright;
    }

    
    public void checkOut(Patron patron)
    {
        this.loanedTo = patron;
        this.dueDate = LocalDate.now().plusDays(14);
    }
    /*
    public void checkIn()
    {

    }
    */
    @Override
    public String toString()
    {   
        if (this.loanedTo == null)
            return String.format("Title: %s    Author: %s    copyright %d\n", title, author, copyright);
        return String.format("Title: %s    Author: %s    copyright: %d\n    CHECKED OUT BY: %s\n    DUE BY: %s\n", title, author, copyright, loanedTo, dueDate.toString());
    }
    
}