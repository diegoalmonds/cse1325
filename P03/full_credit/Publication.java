import java.time.LocalDate;

public class Publication
{
    private String title;
    private String author;
    private int copyright;
    private String loanedTo;
    private LocalDate dueDate;

    public Publication(String title, String author, int copyright)
    {
        int currentYear = Integer.parseInt((LocalDate.now()).toString().substring(0, 4));
        this.title = title;
        this.author = author;
        if (copyright < 1900 || copyright > currentYear)
            throw new IllegalArgumentException("Copyright must be after 1900 and before the current year");
        this.copyright = copyright;
    }

    
    public void checkOut(String patron)
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
            return String.format("Title: %s     Author: %s     copyright %d\n", title, author, copyright);
        return String.format("Title: %s     Author: %s     copyright: %d\n     CHECKED OUT BY: %s     DUE BY: %s\n", title, author, copyright, loanedTo, dueDate.toString());
    }
    
}