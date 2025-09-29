import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Game extends JPanel implements Runnable{

    KeyController keyController = new KeyController();
    AppleMover mover = new AppleMover(this);
    Snakegenearator addSnake = new Snakegenearator(this);


    int AppleCount;

    int positionX = 50;
    int positionY = 50;

    boolean appleEaten;

    int HeadX = 50;
    int HeadY = 50;

    int lastBodyX;
    int lastBodyY;
    private int frames = 0;
    private long lastCheck = 0;

    int positionPartX = 0;
    int positionPartY = 0;
    int FPS = 5;

//    private int appleX = -1; // Ustawiamy domyślne wartości na -1 (lub inną wartość, której nie używasz)
//    private int appleY = -1;

    boolean lastS;
    boolean lastD;
    boolean lastA;
    boolean lastW;

//    public int[] appleCoords = appleGenerator();
    public int appleFinalX = 250;
    public int appleFinalY = 250;

    volatile boolean running = true;

    public Game() {
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(500, 500));
        this.setBackground(Color.black);
        this.addKeyListener(keyController);
        Thread tread = new Thread(this);
        tread.start();

    }
    public void run(){
        double timeperframe = 1000000000/FPS;
        long lastFrameTime = System.nanoTime();
        long now;
        while(running == true){



            now = System.nanoTime();
            if(now - lastFrameTime>=timeperframe){
                if (running == false) {
                    break;
                }
                checkkey();

                positionY = HeadY;
                positionX = HeadX;

                update();
                checkCollsion();
//                System.out.println("update");
                keyController.resetPreset();
                mover.moveApple();
                addSnake.CheckifEaten();
                resetlast();
                repaint();
                //stan();
                //fpscount();


                lastFrameTime=now;


            }






        }
    }

    private void checkCollsion() {
        if (HeadX == 500) {
            running = false;
            javax.swing.JOptionPane.showMessageDialog(null, "koniec");
            System.exit(0);
        }
        if (HeadY == -50) {
            running = false;
            javax.swing.JOptionPane.showMessageDialog(null, "koniec");
            System.exit(0);
        }
        if (HeadY == 500) {
            javax.swing.JOptionPane.showMessageDialog(null, "koniec");
            System.exit(0);
        }
        if (HeadX == -50) {
            javax.swing.JOptionPane.showMessageDialog(null, "koniec");
            System.exit(0);
        }

    }


    int w,s,a,d;
    String lastKey;

    public void fpscount(){
        frames++;
        if(System.currentTimeMillis() - lastCheck >= 1000){
            lastCheck = System.currentTimeMillis();
            System.out.println(frames);
            frames = 0;
        }
    }
    public void checkkey(){
        if (keyController.Spersistent || keyController.Wpersistent || keyController.Apersistent || keyController.Dpersistent) {
            if (keyController.Spersistent) {
                lastS = true;

            }
            if (keyController.Wpersistent) {
                lastW = true;


            }
            if (keyController.Apersistent) {
                lastA = true;


            }
            if (keyController.Dpersistent) {
                lastD = true;

            }
        }
    }
    public void stan(){
        System.out.println("a " + lastA);
        System.out.println("w " + lastW);
        System.out.println("s " + lastS);
        System.out.println("d " + lastD);




    }
    public void resetlast(){
        lastD = false;
        lastS = false;
        lastW = false;
        lastA = false;
    }
    public void update() {


        int speed = 50;
        if (lastS == true) {

            w = 0;
            s = 1;
            a = 0;
            d = 0;
        }
        if (lastD == true) {

            w = 0;
            s = 0;
            a = 0;
            d = 1;
        }
        if (lastA == true) {

            w = 0;
            s = 0;
            a = 1;
            d = 0;

        }
        if (lastW == true) {

            w = 1;
            s = 0;
            a = 0;
            d = 0;

        }

            if (d == 1) {
                if (lastKey != "a") {
                    HeadX = HeadX + speed;
                    //System.out.println("d");
                    lastKey = ("d");
                } else if (HeadX == 0) {
                    HeadX = 0;
                } else {
                    HeadX = HeadX - speed;
                    //System.out.println("a");
                    lastKey = ("a");
                }
            }


            if (w == 1) {
                if (lastKey != "s") {
                    HeadY = HeadY - speed;
                    //System.out.println("w");
                    lastKey = ("w");
                } else if(HeadY == 450){
                    HeadY = 450;
                }else {
                    HeadY = HeadY + speed;
                    //System.out.println("s");
                    lastKey = ("s");
                }

            }


            if (a == 1) {
                if (lastKey != "d") {
                    HeadX = HeadX - speed;
                    //System.out.println("a");
                    lastKey = ("a");
                } else if(HeadX == 450){
                    HeadX = 450;
                }else {
                    HeadX = HeadX + speed;
                    //System.out.println("d");
                    lastKey = ("d");
                }
            }


            if (s == 1) {
                if (lastKey != "w") {
                    HeadY = HeadY + speed;
                    //System.out.println("s");
                    lastKey = ("s");
                } else if(HeadY == 0){
                    HeadY = 0;
                }else{
                    HeadY = HeadY - speed;
                    //System.out.println("w");
                    lastKey = ("w");
                }
            }

        appleEaten = false;

    }
//    public void update() {
//
//
//        int speed = 50;
//        if (lastS == true) {
//
//            w = 0;
//            s = 1;
//            a = 0;
//            d = 0;
//        }
//        if (lastD == true) {
//
//            w = 0;
//            s = 0;
//            a = 0;
//            d = 1;
//        }
//        if (lastA == true) {
//
//            w = 0;
//            s = 0;
//            a = 1;
//            d = 0;
//
//        }
//        if (lastW == true) {
//
//            w = 1;
//            s = 0;
//            a = 0;
//            d = 0;
//
//        }
//        if (positionX == 450) {
//            javax.swing.JOptionPane.showMessageDialog(null, "koniec");
//            System.exit(0);
//        } else {
//            if (d == 1) {
//                if (lastKey != "a") {
//                    positionX = positionX + speed;
//                    //System.out.println("d");
//                    lastKey = ("d");
//                } else if (positionX == 0) {
//                    positionX = 0;
//                } else {
//                    positionX = positionX - speed;
//                    //System.out.println("a");
//                    lastKey = ("a");
//                }
//            }
//        }
//        if (positionY == 0) {
//            javax.swing.JOptionPane.showMessageDialog(null, "koniec");
//            System.exit(0);
//        } else {
//            if (w == 1) {
//                if (lastKey != "s") {
//                    positionY = positionY - speed;
//                    //System.out.println("w");
//                    lastKey = ("w");
//                } else if(positionY == 450){
//                    positionY = 450;
//                }else {
//                    positionY = positionY + speed;
//                    //System.out.println("s");
//                    lastKey = ("s");
//                }
//
//            }
//        }
//        if (positionX == 0) {
//            javax.swing.JOptionPane.showMessageDialog(null, "koniec");
//            System.exit(0);
//        } else {
//            if (a == 1) {
//                if (lastKey != "d") {
//                    positionX = positionX - speed;
//                    //System.out.println("a");
//                    lastKey = ("a");
//                } else if(positionX == 450){
//                    positionX = 450;
//                }else {
//                    positionX = positionX + speed;
//                    //System.out.println("d");
//                    lastKey = ("d");
//                }
//            }
//        }
//        if (positionY == 450) {
//            javax.swing.JOptionPane.showMessageDialog(null, "koniec");
//            System.exit(0);
//        } else {
//            if (s == 1) {
//                if (lastKey != "w") {
//                    positionY = positionY + speed;
//                    //System.out.println("s");
//                    lastKey = ("s");
//                } else if(positionY == 0){
//                    positionY = 0;
//                }else{
//                    positionY = positionY - speed;
//                    //System.out.println("w");
//                    lastKey = ("w");
//                }
//            }
//        }
//        appleEaten = false;
//
//    }

//    public int[] appleGenerator() {
//        if (appleX == -1 && appleY == -1) { // Sprawdzamy, czy wartości zostały już wylosowane
//            Random rand = new Random();
//            appleX = rand.nextInt(9); // Zakres od 0 do 450 włącznie
//            appleY = rand.nextInt(9); // Zakres od 0 do 450 włącznie
//        }
//        return new int[] { appleX, appleY }; // Zwracamy wylosowane (lub już istniejące) wartości
//    }


//    public void bodyCollision(){
//        if (HeadX = ){
//
//        }
//    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        apple(g);
        snake(g);
        snakeHead(g);

    }
    public void snake(Graphics g){
        addSnake.addSnake(g);


    }
//    public void snakeHead(Graphics g){
//        g.setColor(Color.green);
//        g.fillRect(positionX,positionY,50,50);
//    }
public void snakeHead(Graphics g){
    g.setColor(Color.green);
    g.fillRect(HeadX,HeadY,50,50);
}
    public void apple(Graphics g){

        g.setColor(Color.red);
        g.fillRect(appleFinalX,appleFinalY,50,50);

    }

}
