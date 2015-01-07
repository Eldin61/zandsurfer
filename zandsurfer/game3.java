import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class game3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class game3 extends World
{
    private int spawnX = 0;
    private int spawnX2 = 0;
    private int spawnX3 = 0;
    private int spawnCounter = 0;
    private int spawnTreasure = 0;
    private static final String bgImageName = "watergoed.jpg";
    private static final int scrollSpeed = 2;
    private static final int picHeight = (new GreenfootImage(bgImageName)).getHeight();
    private GreenfootImage bgImage, bgBase;
    private int scrollPosition = 0;
    private Counter theCounter;
    private int timer = 3600;
    public game3()
    {    
        super(900, 900, 1); 
        setBackground(bgImageName);
        bgImage = new GreenfootImage(getBackground());
        bgBase = new GreenfootImage(getWidth(), picHeight);
        bgBase.drawImage(bgImage, 0, 0);
        prepare();
        TimerText timerText = new TimerText();
        addObject(timerText, 20, 20);
        timerText.setText("Time left: " + (timer/60));
    }

    public Counter getCounter()
    {
        return theCounter;
    }

    public void act()
    {
        addObjects();
        scrollPosition += scrollSpeed;
        while(scrollSpeed > 0 && scrollPosition > picHeight) scrollPosition -= picHeight;
        while(scrollSpeed < 0 && scrollPosition < 0) scrollPosition += picHeight;
        paint(scrollPosition);
        timerFunc();
    }

    private void paint(int position)
    {
        GreenfootImage bg = getBackground();
        bg.drawImage(bgBase,0, position);
        bg.drawImage(bgImage,0 , position - picHeight);
    }

    private void prepare()
    {
        Boat boat = new Boat();
        addObject(boat, 409, 797);
        boat.setLocation(464, 791);
        boat.setLocation(453, 765);
        theCounter = new Counter();
        addObject(theCounter, 810, 20);

    }
    public void timerFunc()
    {
       if (timer>0)
        {
            timer--;
            if(timer == 0) Greenfoot.stop();
        } 
        
    }

    public void addObjects()
    {
        spawnCounter++;
        spawnTreasure++;
        spawnX = Greenfoot.getRandomNumber(850)+20;
        spawnX2 = Greenfoot.getRandomNumber(850)+20;
        spawnX3 = Greenfoot.getRandomNumber(150)+50;
        if (spawnCounter == spawnX3 || spawnCounter > 150)
        {
            Rock rock = new Rock();
            Rock rock2 = new Rock();
            addObject(rock, spawnX, 0);
            addObject(rock2, spawnX2, 0);
            spawnCounter = 0;
            spawnX = 0;
            spawnX2 = 0;
            spawnX3 = 0;
        }   
        if(spawnTreasure == 310)
        {
            Schat schat = new Schat();
            addObject(schat, spawnX, 0);
            Eiland eiland = new Eiland();
            addObject(eiland, spawnX2, 0);
            spawnX = 0;
            spawnX2 = 0;
            spawnTreasure = 0;
        }
    }

}
