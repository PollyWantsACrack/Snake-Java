import java.awt.*;
import java.util.ArrayList;

public class Snakegenearator  {

    Game gra;

    ArrayList<Point> segmenty = new ArrayList<Point>();
    ArrayList<Integer> nrSegmentu = new ArrayList<>();

    


    Snakegenearator (Game gra){
        this.gra = gra;
    }

    public void CheckifEaten(){
        if (gra.appleEaten) {
            System.out.println("Jabłko zjedzone");
            gra.AppleCount++;
            //ta metoda wywołuje się przed metodą repaint dodje on  do losty segmenty element klasy Point kótra pozwala przechowywac
            //wspolrene ounktow, dodaje ona aktualna pozycję glowy weza z klasy Gamel'
            segmenty.add(new Point(gra.positionX, gra.positionY));

            //licznik segmentow

//            for (int i = 0; i < segmenty.size(); i++) {
//                System.out.println(segmenty.get(i));
//            }
            System.out.println(gra.AppleCount);
        }
    }

    public void addSnake(Graphics g) {
        g.setColor(Color.white);

        for(int i = segmenty.size()-1; i > 0; i = i -1){
            Point temp1 = segmenty.get(i);
            Point temp2 = segmenty.get(i - 1);
            temp1.setLocation(temp2.x,temp2.y);
        }
       if(segmenty.size()>0){
            segmenty.get(0).setLocation(gra.positionX,gra.positionY);
       }
        //ta metoda wywylana jest w repaint dizala ona tak ze kiedy zobaczy ze i jest mniejsze niz dlugosc tablicy segmenty tj. gdy
        //gdy zjemy jablko widzi ze zgadza sie zaleznosc i < segemnety.size i wykonuje sie petla ktora towrzy zmienna typu Point
        // o nazwie segment i ustawia do niej x i y o numerze w i w tablicy segmenty nastpenie rysuje kwadrat w miejscu pobrnaych
        //wczesniej sporedncyh czyli elemnetu tablicy [i] petla nie wykonuje sie koljeny ra zponiewaz i sie zwiksz ao 1 i
        // warubbke i < segemnty . size nie jesst spleniany bo segmenty size ma 1 i (i) ma 1 i tak az do kolejnego Check if eaten ktore
        // zmieni lenght tablicy segmenty o 1 wiecej
        for (int i = 0; i < segmenty.size(); i++) {
            Point segment = segmenty.get(i); // Pobieramy element z listy
            g.fillRect(segment.x, segment.y, 50, 50); // Rysujemy segment
        }
        for (int i = 0; i < segmenty.size(); i++) {
            Point segment = segmenty.get(i);
            if(gra.HeadX == segment.x && gra.HeadY == segment.y){
                gra.running = false;
                javax.swing.JOptionPane.showMessageDialog(null, "koniec");
                System.exit(0);

            }
        }


    }
}
