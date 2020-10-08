import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Klasa z MouseListenerem
 * Nastepuje tu sprawdzanie czy postac zostala kliknieta w odpowiednim czasie i miejscu
 */

public class MouseListenerForGame extends Thread{

    private JFrame frame;
    //Ustawienie wyniku poczatkowego oraz czasu gry
    volatile static int score = 0;
    volatile static int time = 60;
    private JTextArea scoreArea;
    private Point mousePoint;   //Wbrew podswietleniu na szaro- potrzebne

    /**
     *
     * @param frame przekazywana ramka
     * @param scoreArea do zmiany wartosci wyniku
     */
    public MouseListenerForGame(JFrame frame, JTextArea scoreArea){
        this.frame = frame;
        this.scoreArea = scoreArea;
    }

    /**
     * Watek sprawdzajacy klikniecia
     */

    @Override
    public void run(){
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mousePoint = e.getPoint();
                double dx = e.getX();
                double dy = e.getY();

                if (dx > 103 && dx < 199 && dy > 48 && dy < 132 && Game.whichMole == 0 || dx > 423 && dx < 517 && dy > 47 && dy < 134 && Game.whichMole == 1 ||
                        dx > 744 && dx < 831 && dy > 47 && dy < 134 && Game.whichMole == 2 || dx > 106 && dx < 193 && dy > 234 && dy < 321 && Game.whichMole == 3||
                        dx > 427 && dx < 512 && dy > 233 && dy < 319 && Game.whichMole == 4 || dx > 744 && dx < 831 && dy > 233 && dy < 318 && Game.whichMole == 5 ||
                        dx > 105 && dx < 195 && dy > 417 && dy < 502 && Game.whichMole == 6 || dx > 425 && dx < 512 && dy > 233 && dy < 504 && Game.whichMole == 7 ||
                        dx > 744 && dx < 831 && dy > 420 && dy < 504 && Game.whichMole == 8) {
                    if(Game.clickedFlag) {
                        if (Game.readyforclick) {
                            if (Game.moleKingFlag) {
                                if (score == 0) score++;
                                else score *= 2;
                                scoreArea.setText("" + score);
                                Game.howMuchMoleKings++;
                            }
                            if (Game.moleFlag) {
                                score++;
                                scoreArea.setText("" + score);
                                Game.howMuchMole++;
                            }

                            if (Game.bombFlag) {
                                if (score < 5) {
                                    score = 0;
                                } else {
                                    score -= 5;
                                }
                                Game.howMuchMoleBombs++;
                                scoreArea.setText("" + score);
                            }
                            Game.clickedFlag = false;
                        }

                    }
                }
            }
        });
    }

}
