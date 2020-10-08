import javax.swing.*;
import java.util.Random;

/**
 * Watek uruchamiany w Gamplay
 * Klasa odpowiedzialna za animacje postaci - wyjscie i powrot do kretowki
 */

public class MoleThread extends Thread {

    /**
     * random - wykorzystywane do losowania kreta, krola kreta, badz bomby
     */

    private Random random = new Random();
    private volatile JLabel mole;
    private volatile ImageIcon moleIcon;
    private volatile int i;
    private JFrame frame;

    /**
     *
     * @param frame przekazywana ramka
     * @param mole przekazany pojedynczy obiekt kreta
     * @param i przekazany numer wylosowanej kretowki
     */

    public MoleThread(JFrame frame, JLabel mole, int i){
        this.frame = frame;
        this.mole = mole;
        this.i=i;
        Game.whichMole = i;
    }

    /**
     * Tutaj powstaja animacje i losowanie postaci
     * Synchronizowane - jednoczesnie moze pojawiac sie tylko jedna postac
     */
    @Override
    public void run(){
        synchronized (this) {
                int whichObjectRandom = random.nextInt(10);
                //KRET
                if (whichObjectRandom < 6) {
                    try {
                        for (int x = 1; x <= 7; x++) {
                            String name = new String();
                            String temp = Integer.toString(x);
                            name = "images/animacja" + temp + ".png";
                            mole.setVisible(false);
                            moleIcon = new ImageIcon(name);
                            mole = new JLabel("", moleIcon, JLabel.CENTER);
                            mole.setVisible(true);
                            frame.repaint();
                            switchBounds(i);
                            frame.add(mole);
                            Thread.sleep(30);
                            if (x >= 5) {
                                Game.readyforclick = true;
                                Game.moleFlag = true;
                                Game.clickedFlag = true;
                            }
                        }
                        Thread.sleep(150*Game.mnoznik);
                        for (int x = 7; x >= 1; x--) {
                            String name = new String();
                            String temp = Integer.toString(x);
                            name = "images/animacja" + temp + ".png";
                            mole.setVisible(false);
                            moleIcon = new ImageIcon(name);
                            mole = new JLabel("", moleIcon, JLabel.CENTER);
                            mole.setVisible(true);
                            frame.repaint();
                            switchBounds(i);
                            frame.add(mole);
                            Thread.sleep(30);
                            if (x < 5) {
                                Game.readyforclick = false;
                                Game.moleFlag = false;
                            }
                        }
                        CheckMound.mound[i] = true;
                        mole.setVisible(false);


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                //BOMBA
                if (whichObjectRandom >= 6 && whichObjectRandom < 8) {
                    try {
                        for (int x = 1; x <= 7; x++) {
                            String name = new String();
                            String temp = Integer.toString(x);
                            name = "images/animacjabomb" + temp + ".png";
                            mole.setVisible(false);
                            moleIcon = new ImageIcon(name);
                            mole = new JLabel("", moleIcon, JLabel.CENTER);
                            mole.setVisible(true);
                            frame.repaint();
                            switchBounds(i);
                            frame.add(mole);
                            Thread.sleep(30);
                            if (x >= 5) {
                                Game.readyforclick = true;
                                Game.bombFlag = true;
                                Game.clickedFlag = true;
                            }
                        }
                        Thread.sleep(150*Game.mnoznik);
                        for (int x = 7; x >= 1; x--) {
                            String name = new String();
                            String temp = Integer.toString(x);
                            name = "images/animacjabomb" + temp + ".png";
                            mole.setVisible(false);
                            moleIcon = new ImageIcon(name);
                            mole = new JLabel("", moleIcon, JLabel.CENTER);
                            mole.setVisible(true);
                            frame.repaint();
                            switchBounds(i);
                            frame.add(mole);
                            Thread.sleep(30);
                            if (x < 5) {
                                Game.readyforclick = false;
                                Game.bombFlag = false;
                                Game.clickedFlag = false;
                            }
                        }
                        CheckMound.mound[i] = true;
                        mole.setVisible(false);


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                //KROL
                else {
                    try {
                        for (int x = 1; x <= 7; x++) {
                            String name = new String();
                            String temp = Integer.toString(x);
                            name = "images/animacjaKrol" + temp + ".png";
                            mole.setVisible(false);
                            moleIcon = new ImageIcon(name);
                            mole = new JLabel("", moleIcon, JLabel.CENTER);
                            mole.setVisible(true);
                            frame.repaint();
                            switchBounds(i);
                            frame.add(mole);
                            Thread.sleep(30);
                            if (x >= 5) {
                                Game.readyforclick = true;
                                Game.moleKingFlag = true;
                                Game.clickedFlag = true;
                            }
                        }
                        Thread.sleep(150*Game.mnoznik);
                        for (int x = 7; x >= 1; x--) {
                            String name = new String();
                            String temp = Integer.toString(x);
                            name = "images/animacjaKrol" + temp + ".png";
                            mole.setVisible(false);
                            moleIcon = new ImageIcon(name);
                            mole = new JLabel("", moleIcon, JLabel.CENTER);
                            mole.setVisible(true);
                            frame.repaint();
                            switchBounds(i);
                            frame.add(mole);
                            Thread.sleep(30);
                            if (x < 5) {
                                Game.readyforclick = false;
                                Game.moleKingFlag = false;
                                Game.clickedFlag = false;
                            }
                        }
                        CheckMound.mound[i] = true;
                        mole.setVisible(false);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


        }
    }

    /**
     * Pomocnicza, do ustawiania pozycji danej postaci
     * @param x - numer kretowiska
     */
    private void switchBounds(int x){
        switch(x){
            case 0:
                mole.setBounds(50,15,202,154);
                break;
            case 1:
                mole.setBounds(370,15,202,154);
                break;
            case 2:
                mole.setBounds(690,15,202,154);
                break;
            case 3:
                mole.setBounds(50,200,202,154);
                break;
            case 4:
                mole.setBounds(370,200,202,154);
                break;
            case 5:
                mole.setBounds(690,200,202,154);
                break;
            case 6:
                mole.setBounds(50,385,202,154);
                break;
            case 7:
                mole.setBounds(370,385,202,154);
                break;
            case 8:
                mole.setBounds(690,385,202,154);
                break;
            default:
        }
    }

}
