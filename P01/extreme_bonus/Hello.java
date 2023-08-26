public class Hello
{
    public static void main(String args[])
    {
        String name = System.getProperty("user.home");
        String nameSubstring = name.substring(name.lastIndexOf("/")+1);
        System.out.println("hello, " + nameSubstring);
    }
}