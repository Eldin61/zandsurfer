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
    private Counter theCounter;
    private static final String bgImageName = "watergoed.jpg";
    private static final int scrollSpeed = 3;
    private static final int picHeight = (new GreenfootImage(bgImageName)).getHeight();
    private GreenfootImage bgImage, bgBase;
    private int scrollPosition = 0;
    private int timer = 3600;
    TimerText timerText = new TimerText();
    /**
     * Dit is de constructor voor game3. 
     * We pakken ook de background image hier zodat we in een andere methode 
     * de background kunnen tekenen zodat het lijkt alsof die naar beneden scrolled.
     */

    public game3()
    {    
        super(700, 600, 1); 
        setBackground(bgImageName);
        bgImage = new GreenfootImage(getBackground());
        bgBase = new GreenfootImage(getWidth(), picHeight);
        bgBase.drawImage(bgImage, 0, 0);
        prepare();
        addObject(timerText, 100, 15); //wherever
        timerText.setText("Time left: " + (timer/60));
    }
    /**
     * We returnen de waarde van theCounter hier.
     */
    public Counter getCounter()
    {
        return theCounter;
    }
    /**
     * In de act methode tekenen we de background image voor de scroll effect. 
     * We hebben ook de methode addObjects gebruikt om random objecten te spawnen in de wereld.
     * Ook de werking van de timer staat erin.
     */
    public void act()
    {
        addObjects();
        if (timer%60==0) timerText.setText("Time left: " + (timer/60));
         timerFunc();
    }
       
        
    /**
     * Hier word de background image echt getekend.
     */
    private void paint(int position)
    {
        GreenfootImage bg = getBackground();
        bg.drawImage(bgBase,0, position);
        bg.drawImage(bgImage, 0, position-(int)Math.signum(scrollSpeed)*picHeight);
    }
    private void prepare()
    {
        Boat boat = new Boat();
<<<<<<< HEAD
        addObject(boat, getWidth()/2, 530);
=======
        addObject(boat, 409, 797);
        boat.setSpeed(6);
        boat.setLocation(464, 791);
        boat.setLocation(453, 765);
>>>>>>> 5c28c92dd9e5cb2fd78d995b40a9bb6f02d78734
        theCounter = new Counter();
        addObject(theCounter, 580, 20);
    }



    /**
     * Hier tellen we af voor de timer.
     */

    public void timerFunc()
    {
       timer--;
       if (timer<=0)
        {

            Greenfoot.stop();
        } 
                        scrollPosition += scrollSpeed;
        while(scrollSpeed > 0 && scrollPosition > picHeight) scrollPosition -= picHeight;
        while(scrollSpeed < 0 && scrollPosition < 0) scrollPosition += picHeight;
        paint(scrollPosition);
    }
      
  
        
    /**
     * Hier geven we de objecten een random X waarde tussen 20 en 870. Zo spawnt die op een random plaats
     * bovenaan de map. Ook de spawncounter staat erin en die is laten we ook random activeren. Door middel 
     * van een random getal tussen de 50 en 200. Als spawncounter boven de 150 komt willen we hem gelijk 
     * spawnen omdat de act steps anders veel te snel gaan.
     */

    public void addObjects()
    {
        spawnCounter++;
        spawnTreasure++;
        spawnX = Greenfoot.getRandomNumber(550)+20;
        spawnX2 = Greenfoot.getRandomNumber(550)+20;
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
            Rock eiland = new Rock("Eiland");
            addObject(eiland, spawnX2, 0);
            spawnX = 0;
            spawnX2 = 0;
            spawnTreasure = 0;
        }
    }
}


