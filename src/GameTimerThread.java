import javax.swing.*;

/**
 * Watek uruchamiany w Gameplay
 * Klasa odpowiedzialna za odliczanie czasu gry
 * oraz za wydarzenia po zakonczeniu odliczania
 */

public class GameTimerThread extends Thread {

    private JLabel timeLabel, scoreLabel;
    private JTextArea timeArea, scoreArea;
    private JFrame frame;
    volatile static boolean thisIsTheEnd = false;

    /**
     *
     * @param frame przekazywana ramka
     * @param timeArea przekazywane w celu zmiany stanu obiektu co sekunde
     * @param scoreArea potrzebne do ustawienia widocznosci na false
     * @param timeLabel w celu ustawienia widocznosci na false
     * @param scoreLabel w celu ustawienia widocznosci na false
     */
    public GameTimerThread(JFrame frame, JTextArea timeArea, JTextArea scoreArea, JLabel timeLabel, JLabel scoreLabel){
        this.frame = frame;
        this.timeArea = timeArea;
        this.scoreArea = scoreArea;
        this.timeLabel = timeLabel;
        this.scoreLabel = scoreLabel;
    }

    /**
     * Watek odliczajacy czas
     */

    @Override
    public void run() {

        //Utworzenie watku odpowiedzialnego za klikanie mysza w postaci
        Thread mouseListener = new MouseListenerForGame(frame, scoreArea);
        mouseListener.start();

        //Odliczanie w petli
        while(MouseListenerForGame.time > -1){
            try{
                timeArea.setText("" + MouseListenerForGame.time); //Wrzucanie tekstu do obiektu JTextArea
                MouseListenerForGame.time--;
                Thread.sleep(1000); //Uspienie watku na 1 sekunde
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        //Co sie dzieje po zakonczeniu odliczania
        thisIsTheEnd = true;
        timeArea.setVisible(false);
        scoreArea.setVisible(false);
        timeLabel.setVisible(false);
        scoreLabel.setVisible(false);

        //Uruchomienie ostatniego watku wyswietlajacego podsumowanie po zakonczeniu gry
        Thread endgame = new EndGame(frame);
        endgame.start();
    }


}
