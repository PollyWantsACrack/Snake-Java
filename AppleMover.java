import java.util.Random;

public class AppleMover {

    Game gra;

    AppleMover(Game gra){
        this.gra = gra;
    }
//    public void moveApple(){
//        Random genrator = new Random();
//        if(gra.positionY == gra.appleFinalY && gra.positionX == gra.appleFinalX){
//
//            gra.appleFinalY = genrator.nextInt(10)*50;
//            gra.appleFinalX = genrator.nextInt(10)*50;
//            gra.appleEaten = true;
//        }
//    }
public void moveApple(){
    Random genrator = new Random();
    if(gra.HeadY == gra.appleFinalY && gra.HeadX == gra.appleFinalX){

        gra.appleFinalY = genrator.nextInt(10)*50;
        gra.appleFinalX = genrator.nextInt(10)*50;
        gra.appleEaten = true;
    }
}
}