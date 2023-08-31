public enum Color 
{
    MAGENTA(0x800080), CYAN(0x00FFFF), PINK(0xFFC0CB), ORANGE(0xFFA500);

    private final int rgb;
    
    private Color(int rgb)
    {
        this.rgb = rgb;
    }

    @Override
    public String toString()
    {
        return String.format("%s (0x%06x)", name(), rgb);
    }
}
