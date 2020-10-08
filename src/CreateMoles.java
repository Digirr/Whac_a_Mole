import javax.swing.*;
import java.awt.*;

/**
 * Wywolywana z klasy Game
 * Klasa ustawiajaca parametry kretow oraz komponenty wyswietlajace napisy i odliczajace czas
 * Na koncu uruchomienie watku odpowiedzialnego za sama rozgrywke
 */

public class CreateMoles extends Thread {

    /**
     * Icon i Label:
     * mole - ustawienie grafiki pustej kretowki oraz rozstawienie na mapie
     * timeLabel - napis wyswietlajacy "Pozostalo czasu:"
     * scoreLabel - napis wyswietlajacy "Wynik:"
     * timeArea - obszar na wyswietlanie czasu
     * scoreArea - obszar na wyswietlanie wyniku
     * GRASS_COLOR - wykorzystywany tutaj do zapelnienia tla TextArea
     */

    private JFrame frame;
    private ImageIcon moleIcon;
    public JLabel[] mole;
    private JLabel timeLabel, scoreLabel;
    private JTextArea timeArea, scoreArea;

    private static final Color GRASS_COLOR = Color.decode("#9BE751");

    /**
     * @param frame ramka przekazana przez konstruktor
     */
    public CreateMoles(JFrame frame){
        this.frame = frame;
    }
    public void run(){
        //Czcionka monospaced, pogrubiona, rozmiar 14
        Font font = new Font(Font.MONOSPACED, Font.BOLD, 18);

        //Nadanie grafiki pustych kretowek
        moleIcon = new ImageIcon("images/nieobecnosckret.png");
        mole = new JLabel[9];
        for(int i=0;i<mole.length;i++){
            mole[i] = new JLabel("", moleIcon, JLabel.CENTER);
            //Tymczasowo widocznosc kretowek ustawiona na false
            mole[i].setVisible(false);
        }

        //Rozstawienie kretow na mapie

        //1 rzad
        mole[0].setBounds(50,15,202,154);
        mole[1].setBounds(370,15,202,154);
        mole[2].setBounds(690,15,202,154);
        //2 rzad
        mole[3].setBounds(50,200,202,154);
        mole[4].setBounds(370,200,202,154);
        mole[5].setBounds(690,200,202,154);
        //3 rzad
        mole[6].setBounds(50,385,202,154);
        mole[7].setBounds(370,385,202,154);
        mole[8].setBounds(690,385,202,154);


        //Utworzenie watku pomocniczego w celu ustawiania pustych kretowek jak watek postaci skonczy swoja prace

        Thread checkMound = new CheckMound(mole);
        checkMound.start();

        //Etykieta informujaca, ile pozostalo czasu
        timeLabel = new JLabel("Pozostalo czasu:");
        frame.add(timeLabel);   //Dodanie do panelu
        timeLabel.setBounds(220,-35,180,100);
        timeLabel.setFont(font);
        timeLabel.setVisible(false);

        //Stworzenie obszaru tekstowego dla czasu
        timeArea = new JTextArea(1, 5); //Wymiary TextArea
        timeArea.setEditable(false); //Zakaz edytowania
        timeArea.setBounds(400, 10, 15, 15);
        //timeArea.setFont(font);
        timeArea.setBackground(GRASS_COLOR);
        frame.add(timeArea);    //Dodanie do panelu
        timeArea.setVisible(true);  //Widocznosc true

        //Kolejna etykieta informujaca o wyniku
        scoreLabel = new JLabel("Wynik:");
        scoreLabel.setFont(font);
        scoreLabel.setBounds(630,-35,100,100);
        scoreLabel.setVisible(false);
        frame.add(scoreLabel);

        //Obszar tekstowy na wynik
        scoreArea = new JTextArea(1, 5); //Wymiary TextArea
        scoreArea.setEditable(false);
        scoreArea.setBounds(700, 10, 150, 15);
        scoreArea.setText(" ");
        scoreArea.setBackground(GRASS_COLOR);
        frame.add(scoreArea);
        scoreArea.setVisible(true);

        //Dodanie kretow do ramki

        for(int i=0;i<mole.length;i++){
            frame.add(mole[i]);
        }
        //Ostatecznie ustawienie widocznosci ramki na true
        frame.setVisible(true);

        //Na koncu uruchomienie oddzielnego watku odpowiedzialnego za sama rozgrywke
        Thread gameplay = new Gameplay(frame, scoreLabel, mole, timeLabel, timeArea, scoreArea);
        gameplay.start();
    }
}
