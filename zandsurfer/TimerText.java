import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class TimerText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TimerText extends Actor
{
    private int tijdslimiet;
    /**
     * Act - do whatever the TimerText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public TimerText()
    {
        this("");
    }
        public TimerText(String text)
    {
        setText(text);
    }
        public void setText(String text)
    {
        setImage(new GreenfootImage(text, 24, Color.black, new Color(0, 0, 0, 0)));
    } 
}

