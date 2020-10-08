import javax.swing.*;
import java.util.Random;

/**
 * Uruchamiana z klasy CreateMoles
 * Tutaj generowane sa w watku postaci - krety, krety krole, bomby
 */

public class Gameplay extends Thread {

    /**
     * random - zmienna wykorzystywana do generowania 1...9 kretowki
     */

    private Random random = new Random();
    private JFrame frame;
    private JTextArea timeArea, scoreArea;
    private JLabel timeLabel, scoreLabel;
    private JLabel[] mole;

    /**
     *
     * @param frame przekazana ramka
     * @param scoreLabel napis "Wynik" w celu pozniejszego ustawienia widocznosci na false
     * @param mole przekazana tablica kretow
     * @param timeLabel napis "Pozostalo czasu:" w celu pozniejszego ustawienia widocznosci na false
     * @param timeArea obszar timeArea w celu pozniejszego ustawienia widocznosci na false
     * @param scoreArea obszar scoreArea w celu pozniejszego ustawienia widocznosci na false
     */
    public Gameplay(JFrame frame, JLabel scoreLabel, JLabel[] mole, JLabel timeLabel, JTextArea timeArea, JTextArea scoreArea){
        this.frame = frame;
        this.mole = mole;
        this.timeLabel = timeLabel;
        this.timeArea = timeArea;
        this.scoreLabel = scoreLabel;
        this.scoreArea = scoreArea;

        //Ustawienie widocznosci Labelow na true
        scoreLabel.setVisible(true);
        timeLabel.setVisible(true);

        //Ustawienie widocznosci kretowek na true
        for(int i=0;i<mole.length;i++){
            mole[i].setVisible(true);
        }

        //Uruchomienie zegara odliczajacego czas
        Thread timerThread = new GameTimerThread(frame, timeArea, scoreArea, timeLabel, scoreLabel);
        timerThread.start();
    }

    /**
     * Tworzenie oddzielnych watkow postaci na oddzielnych pozycjach
     */
    @Override
    public void run() {
        Thread[] moleThread = new Thread[100];
        for (int i = 0; i < moleThread.length; i++) {
            //Sprzatanie
            if(GameTimerThread.thisIsTheEnd == true){
                for (int x = 0; x < moleThread.length; x++) {
                    for(int j=0;j<9;j++){
                        mole[j]=null;
                    }
                }
                break;
            }
            int randomMoleNum = (random.nextInt(mole.length))%9;
            JLabel temp = mole[randomMoleNum];  //Wybiera kreta z wybranym numerem kopca
            moleThread[i] = new MoleThread(frame, temp, randomMoleNum);
            moleThread[i].start();
            try{
                Thread.sleep(1000*Game.mnoznik);
            } catch (InterruptedException e) {e.printStackTrace();}
        }

    }
}
