import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame okno = new JFrame();


        okno.setTitle("Gra");
        okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        okno.getContentPane().setBackground(Color.BLACK);

        Game panel = new Game();
        okno.add(panel);

        okno.pack();
        okno.setVisible(true);

        okno.setResizable(false);
        okno.setLocationRelativeTo(null);





    }
}