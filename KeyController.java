import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyController implements KeyListener{

    public boolean W,S,A,D;

    public volatile boolean Wpersistent;
    public volatile boolean Apersistent;
    public volatile boolean Spersistent;
    public volatile boolean Dpersistent;


    public void keyPressed(KeyEvent e) {
        int Key = e.getKeyCode();
        if(Key == KeyEvent.VK_UP){
            W = true;
            Wpersistent = true;
        }
        if(Key == KeyEvent.VK_DOWN){
            S = true;
            Spersistent = true;
        }
        if(Key == KeyEvent.VK_LEFT){
            A = true;
            Apersistent = true;
        }
        if(Key == KeyEvent.VK_RIGHT){
            D = true;
            Dpersistent = true;
        }
    }


    public void keyReleased(KeyEvent e) {
        int Key = e.getKeyCode();
        if(Key == KeyEvent.VK_W){
            W = false;
        }
        if(Key == KeyEvent.VK_S){
            S = false;
        }
        if(Key == KeyEvent.VK_A){
            A = false;
       }
       if(Key == KeyEvent.VK_D){
            D = false;
        }
    }


    public void keyTyped(KeyEvent e) {

    }
    public void resetPreset(){
        Wpersistent = false;
        Spersistent = false;
        Apersistent = false;
        Dpersistent = false;
    }
}
