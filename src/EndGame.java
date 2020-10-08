import javax.swing.*;
import java.awt.*;

/**
 * Klasa wyswietlajaca obrazek Koniec Gry
 * oraz podsumowanie
 * Takze w oddzielnym watku
 */

public class EndGame extends Thread{

    private JFrame frame;
    private ImageIcon koniecGryIcon, podsumowanieGryIcon, powrotDoMenuTwoIcon;
    private JLabel koniecGryLabel, podsumowanieGryLabel, zagrajPonownieOneLabel, powrotDoMenuOneLabel, zagrajPonownieTwoLabel, powrotDoMenuTwoLabel;
    private JTextArea MoleTextArea, KingTextArea, BombTextArea;
    private static final Color GRASS_COLOR = Color.decode("#9BE751");
    Font font = new Font(Font.MONOSPACED, Font.BOLD,50);

    /**
     * @param frame przekazanie ramki
     */

    public EndGame(JFrame frame){
        this.frame = frame;
    }
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
     *
     * @param TextArea obszar TextArea
     * @param x parametr ulozenia x
     * @param y parametr ulozenia y
     * @param width dlugosc obrazka
     * @param heigh wysokosc obrazka
     * @param howMuch zmienna wstawiajaca wyniki
     * @return zwraca obiekt w celu jego pozniejszego wykorzystania
     */
    public JTextArea viewTextArea(JTextArea TextArea, int x, int y, int width, int heigh, int howMuch){
        TextArea = new JTextArea(1,5);
        TextArea.setEditable(false);
        TextArea.setBounds(x,y,width,heigh);
        TextArea.setFont(font);
        TextArea.setBackground(GRASS_COLOR);
        frame.add(TextArea);
        TextArea.setVisible(true);
        TextArea.setText("" + howMuch);
        return TextArea;
    }

    /**
     * Tutaj nastepuje wywolanie funkcji oraz zmiana widocznosci obrazkow
     */
    public void run(){
        try{
            powrotDoMenuTwoLabel = viewImage(powrotDoMenuTwoIcon, powrotDoMenuTwoLabel, "images/returnToMenuTwo.png", false, 550, 450, 280, 150);
            koniecGryLabel = viewImage(koniecGryIcon, koniecGryLabel, "images/gameOverBackground.png", false, 0, 0, 1000, 600);

            //JTextAreas
            MoleTextArea = viewTextArea(MoleTextArea, 615, 175, 120, 60, Game.howMuchMole);
            KingTextArea = viewTextArea(KingTextArea, 615, 240, 120, 60, Game.howMuchMoleKings);
            BombTextArea = viewTextArea(BombTextArea, 615, 305, 120, 60, Game.howMuchMoleBombs);

            podsumowanieGryLabel = viewImage(podsumowanieGryIcon, podsumowanieGryLabel, "images/summaryBackground.png", false, 0, 0, 1000, 600);

            koniecGryLabel.setVisible(true);
            Thread.sleep(3000); //Wyswietlaj background koniec gry przez 3 sekundy
            koniecGryLabel.setVisible(false);
            podsumowanieGryLabel.setVisible(true);

        } catch (InterruptedException e) {e.printStackTrace();}
    }

}
