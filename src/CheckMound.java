import javax.swing.*;

/**
 * Watek pomocniczy ustawiajacy puste kretowki jak watek postaci skonczy swoja prace
 */

public class CheckMound extends Thread {

    /**
     * mound[] - tablica pomocnicza
     * mole[] - przekazana tablica kretow w konstruktorze
     * flag - pomocnicza do przerwania petli
     */

    volatile static boolean[] mound;
    public JLabel[] mole;
    boolean flag = false;

    /**
     * @param mole tablica kretow
     */
    public CheckMound(JLabel[] mole){
        this.mole = mole;
    }

    /**
     * Nastepuje przejscie po kretach, jesli kretowka nie jest uzywana przez watek tworzacy postaci
     * to nastepuje zastapienie grafika kretowki
     */

    @Override
    public void run(){
        mound = new boolean[9];
        for(int i=0;i<9;i++){
            mound[i] = false;
        }

        while(true){
            for(int i=0;i<9;i++){
                if(GameTimerThread.thisIsTheEnd == true){
                    for(int x=0;x<9;x++){
                        mole[x].setVisible(false);
                    }
                    flag = true;
                    break;
                }
                if(mound[i] == true){
                    mole[i].setVisible(true);
                    mound[i] = false;
                }
            }
            if(flag == true)
                break;
        }
        flag = false;
        for(int i=0;i<9;i++){
            mound[i] = false;
        }
    }
}
