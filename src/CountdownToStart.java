import javax.swing.*;
import java.awt.*;

/**
 * Klasa odliczajaca 3 sekundy do rozpoczecia gry
 */

public class CountdownToStart extends Thread {

    /**
     * ImageIcon i JLabel:
     * odliczanie3 - wyswietlenie grafiki z liczba 3 na ekranie
     * odliczanie2 - wyswietlenie grafiki z liczba 2 na ekranie
     * odliczanie1 - wyswietlenie grafiki z liczba 3 na ekranie
     * start - wyswietlenie grafiki z napisem START na ekranie
     * GRASS_COLOR - nadanie koloru do zmiennej z hex
     */

    private JFrame frame;
    private ImageIcon odliczanie3Icon, odliczanie2Icon, odliczanie1Icon, startIcon;
    private JLabel odliczanie3Label, odliczanie2Label, odliczanie1Label, startLabel;
    private static final Color GRASS_COLOR = Color.decode("#9BE751");

    /**
     * Funkcja tworzaca obrazek, wyswietlajaca oraz ustawiajaca go na konkretnych parametrach
     * @param icon zmienna ikony
     * @param label zmienna label
     * @param filename nazwa pliku
     * @param visible czy obrazek ma byc od razu widoczny w ramce
     * @param x parametr ulozenia x
     * @param y parametr ulozenia y
     * @param width dlugosc obrazka
     * @param height wysokosc obrazka
     * @return zwraca label w celu dalszego wykorzystania
     */

    public JLabel viewImage(ImageIcon icon, JLabel label, String filename, boolean visible, int x, int y, int width, int height){
        icon = new ImageIcon(filename);
        label = new JLabel("", icon, JLabel.CENTER);
        label.setVisible(visible);
        label.setBounds(x,y,width,height);
        frame.add(label);
        return label;
    }

    /**
     * @param frame przekazana ramka przez konstruktor
     */
    public CountdownToStart(JFrame frame){
        this.frame = frame;
    }

    /**
     * Pierwszy watek w programie
     * Dzialanie funkcji polega na wyswietlaniu grafik z liczbami 3, 2, 1, START co sekunde
     * A nastepnie wywolanie konstruktora bezargumentowego klasy Game
     */

    @Override
    public void run() {
        frame.getContentPane().setBackground( GRASS_COLOR );
        try{
            GameTimerThread.thisIsTheEnd = false;
            odliczanie3Label = viewImage(odliczanie3Icon, odliczanie3Label, "images/odliczanie3.png", false, 220, 30, 500, 500);
            odliczanie2Label = viewImage(odliczanie2Icon, odliczanie2Label, "images/odliczanie2.png", false, 220, 30, 500, 500);
            odliczanie1Label = viewImage(odliczanie1Icon, odliczanie1Label, "images/odliczanie1.png", false, 220, 30, 500, 500);
            startLabel = viewImage(startIcon, startLabel, "images/start.png", false, 0, 30, 1000, 500);
            odliczanie3Label.setVisible(true);
            Thread.sleep(1000);
            odliczanie3Label.setVisible(false);
            odliczanie2Label.setVisible(true);
            Thread.sleep(1000);
            odliczanie2Label.setVisible(false);
            odliczanie1Label.setVisible(true);
            Thread.sleep(1000);
            odliczanie1Label.setVisible(false);
            startLabel.setVisible(true);
            Thread.sleep(1000);
            startLabel.setVisible(false);
            new Game();

        } catch (InterruptedException e){e.printStackTrace();}
    }
}
