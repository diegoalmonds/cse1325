public class Hello
{
    public static void main(String args[])
    {
        String name = System.getProperty("user.home");
        System.out.println("hello, " + name.substring(name.lastIndexOf("/")+1));
    }
}