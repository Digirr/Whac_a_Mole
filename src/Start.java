import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Whac a mole
 * @author Kamil Tyszkiewicz
 * @version 1.0
 */

public class Start extends JFrame{

    /**
     * frame - nowa ramka
     * ImageIcon i JLabele:
     * backgroundIcon- ikony i labele odpowiedzialne za tla
     * newGame- ikony i labele zawierajace obrazki Nowa Gra oraz Instrukcja
     * latwy/sredni/trudny Przed - ikony i labele zawierajace obrazki Latwy, Sredni, Trudny przed najechaniem kursorem
     * latwy/sredni/trudny Po - ikony i labele zawierajace obrazki Latwy, Sredni, Trudny po najechaniem kursorem
     * powrot1, powrot2 Przed - ikony i labele powrotu do poprzedniego menu przed najechaniem kursorem
     * powrot2, powrot2 Po - ikony i labele powrotu do poprzedniego menu po najechaniem kursorem
     */
    private JFrame frame;
    public ImageIcon backgroundIcon1, backgroundIcon2, backgroundIcon3, newGameIcon1, newGameIcon2, newGameIcon3, newGameIcon4,
            latwyPrzedIcon, latwyPoIcon, sredniPrzedIcon, sredniPoIcon, trudnyPrzedIcon, trudnyPoIcon, powrot1PrzedIcon, powrot1PoIcon, powrot2PrzedIcon, powrot2PoIcon;
    public JLabel backgroundIconLabel1, backgroundIconLabel2, backgroundIconLabel3, newGameLabel1, newGameLabel2, newGameLabel3,
    newGameLabel4, latwyPrzedLabel, latwyPoLabel, sredniPrzedLabel, sredniPoLabel, trudnyPrzedLabel, trudnyPoLabel, powrot1PrzedLabel, powrot1PoLabel, powrot2PrzedLabel, powrot2PoLabel;


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


    public Start(){

         /**
         * Utworzenie ramki i nadanie podstawowych parametrow
         */
         frame = new JFrame("Whack a mole");
         frame.setSize(1000, 600);
         frame.setLayout(null);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setResizable(false);

        /**
         * Wyswietlanie potrzebnych grafik w ramce:
         */

        //Wyswietlanie grafiki: Nowa gra - PRZED najechaniem kursorem
        newGameLabel1 = viewImage(newGameIcon1, newGameLabel1, "menuImages/newGameOne.png", true, 261, 145, 481, 134);
        //Wyswietlanie grafiki: Nowa gra - PO najechaniem kursorem
        newGameLabel2 = viewImage(newGameIcon2, newGameLabel2, "menuImages/newGameTwo.png", true, 261, 145, 481, 134);
        //Wyswietlanie grafiki: Instrukcja - PRZED najechaniem kursorem
        newGameLabel3 = viewImage(newGameIcon3, newGameLabel3, "menuImages/instrukcjaOne.png", true, 241, 275, 519, 146);
        //Wyswietlanie grafiki: Instrukcja - PO najechaniem kursorem
        newGameLabel4 = viewImage(newGameIcon4, newGameLabel4, "menuImages/instrukcjaTwo.png", true, 241, 275, 519, 146);
        //Wyswietlanie grafiki: Latwy - PRZED najechaniem kursorem
        latwyPrzedLabel = viewImage(latwyPrzedIcon, latwyPrzedLabel, "menuImages/latwyOne.png", false, 390, 150, 223, 105);
        //Wyswietlanie grafiki: Latwy - PO najechaniem kursorem
        latwyPoLabel = viewImage(latwyPoIcon, latwyPoLabel, "menuImages/latwyTwo.png", false, 390, 150, 223, 105);
        //Wyswietlanie grafiki: Sredni - PRZED najechaniem kursorem
        sredniPrzedLabel = viewImage(sredniPrzedIcon, sredniPrzedLabel, "menuImages/sredniOne.png", false, 390, 235, 223, 105);
        //Wyswietlanie grafiki: Sredni - PO najechaniem kursorem
        sredniPoLabel = viewImage(sredniPoIcon, sredniPoLabel, "menuImages/sredniTwo.png", false, 390, 235, 223, 105);
        //Wyswietlanie grafiki: Trudny - PRZED najechaniem kursorem
        trudnyPrzedLabel = viewImage(trudnyPrzedIcon, trudnyPrzedLabel, "menuImages/trudnyOne.png", false, 375, 335, 253, 105);
        //Wyswietlanie grafiki: Trudny - PO najechaniem kursorem
        trudnyPoLabel = viewImage(trudnyPoIcon, trudnyPoLabel, "menuImages/trudnyTwo.png", false, 375, 335, 253, 105);
        //Wyswietlanie grafiki: Powrot1 - PRZED najechaniem kursorem
        powrot1PrzedLabel = viewImage(powrot1PrzedIcon, powrot1PrzedLabel, "menuImages/powrotOne.png", false, 15, 430, 270, 105);
        //Wyswietlanie grafiki: Powrot1 - PO najechaniem kursorem
        powrot1PoLabel = viewImage(powrot1PoIcon, powrot1PoLabel, "menuImages/powrotTwo.png", false, 15, 430, 270, 105);
        //Wyswietlanie grafiki: Powrot2 - PRZED najechaniem kursorem
        powrot2PrzedLabel = viewImage(powrot2PrzedIcon, powrot2PrzedLabel, "menuImages/powrotOne.png", false, 15, 430, 270, 105);
        //Wyswietlanie grafiki: Powrot2 - PO najechaniem kursorem
        powrot2PoLabel = viewImage(powrot2PoIcon, powrot2PoLabel, "menuImages/powrotTwo.png", false, 15, 430, 270, 105);
        //Wyswietlenie tla 1
        backgroundIconLabel1 = viewImage(backgroundIcon1, backgroundIconLabel1, "menuImages/tloStart.png", true, -1, 0, 1000, 600);
        //Wyswietlenie tla 2
        backgroundIconLabel2 = viewImage(backgroundIcon2, backgroundIconLabel2, "menuImages/tloStart2.png", false, 0, 0, 1000, 600);
        //Wyswietlenie tla 3
        backgroundIconLabel3 = viewImage(backgroundIcon3, backgroundIconLabel3, "menuImages/tloInstrukcja.png", false, 0, 0, 1000, 600);

        /**
         * MouseListenery nalozone na Labele, ktore sa przyciskami w programie
         *
         */

        //Nowa gra
        newGameLabel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                newGameLabel1.setVisible(false);
                newGameLabel2.setVisible(true);

            }
            @Override
            public void mouseExited(MouseEvent e){
                try{
                    Thread.sleep(100);
                } catch (InterruptedException f) {f.printStackTrace();}
                newGameLabel1.setVisible(true);
                newGameLabel2.setVisible(false);

            }
        });
        newGameLabel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                //Wylaczam napisy nowa gra i instrukcja
                newGameLabel1.setVisible(false);
                newGameLabel2.setVisible(false);
                newGameLabel3.setVisible(false);
                newGameLabel4.setVisible(false);
                //Wylaczam tlo
                backgroundIconLabel1.setVisible(false);

                //Wlaczam nowe tlo
                backgroundIconLabel2.setVisible(true);
                //Wlaczam napis latwy, sredni, trudny
                latwyPrzedLabel.setVisible(true);
                sredniPrzedLabel.setVisible(true);
                trudnyPrzedLabel.setVisible(true);

                //Wlaczam napis powrot
                powrot1PrzedLabel.setVisible(true);
            }
        });
        //Instrukcja
        newGameLabel3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                newGameLabel3.setVisible(false);
                newGameLabel4.setVisible(true);
            }
            @Override
            public void mouseExited(MouseEvent e){
                try{
                    Thread.sleep(100);
                } catch (InterruptedException f) {f.printStackTrace();}
                newGameLabel3.setVisible(true);
                newGameLabel4.setVisible(false);

            }
            @Override
            public void mousePressed(MouseEvent e){
                newGameLabel3.setVisible(false);
                newGameLabel4.setVisible(false);
            }
        });
        newGameLabel4.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                newGameLabel1.setVisible(false);
                newGameLabel2.setVisible(false);
                newGameLabel3.setVisible(false);
                newGameLabel4.setVisible(false);
                backgroundIconLabel1.setVisible(false);
                backgroundIconLabel3.setVisible(true);

                powrot2PrzedLabel.setVisible(true);
            }
        });
        //Latwy
        latwyPrzedLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                latwyPrzedLabel.setVisible(false);
                latwyPoLabel.setVisible(true);
            }
            @Override
            public void mouseExited(MouseEvent e){
                    try{
                        Thread.sleep(100);
                    } catch (InterruptedException f) {f.printStackTrace();}
                    latwyPrzedLabel.setVisible(true);
                    latwyPoLabel.setVisible(false);
                }
             });
        latwyPoLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent x){
                //Co sie stanie po kliknieciu latwy
                powrot1PrzedLabel.setVisible(false);
                latwyPrzedLabel.setVisible(false);
                latwyPoLabel.setVisible(false);
                sredniPrzedLabel.setVisible(false);
                sredniPoLabel.setVisible(false);
                trudnyPrzedLabel.setVisible(false);
                trudnyPoLabel.setVisible(false);
                backgroundIconLabel2.setVisible(false);
                Game game = new Game(frame, 3);
            }
        });
        //Sredni
        sredniPrzedLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                sredniPrzedLabel.setVisible(false);
                sredniPoLabel.setVisible(true);
            }
            @Override
            public void mouseExited(MouseEvent e){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException f) {
                        f.printStackTrace();
                    }
                    sredniPrzedLabel.setVisible(true);
                    sredniPoLabel.setVisible(false);
                }
        });
        sredniPoLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                //Co sie stanie po kliknieciu sredni
                powrot1PrzedLabel.setVisible(false);
                latwyPrzedLabel.setVisible(false);
                latwyPoLabel.setVisible(false);
                sredniPrzedLabel.setVisible(false);
                sredniPoLabel.setVisible(false);
                trudnyPrzedLabel.setVisible(false);
                trudnyPoLabel.setVisible(false);
                backgroundIconLabel2.setVisible(false);
                Game game = new Game(frame, 2);
            }
        });
        //Trudny
        trudnyPrzedLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                trudnyPrzedLabel.setVisible(false);
                trudnyPoLabel.setVisible(true);
            }
            @Override
            public void mouseExited(MouseEvent e){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException f) {
                        f.printStackTrace();
                    }
                    trudnyPrzedLabel.setVisible(true);
                    trudnyPoLabel.setVisible(false);
                }
        });
        trudnyPoLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                //Co sie stanie po kliknieciu trudny
                powrot1PrzedLabel.setVisible(false);
                latwyPrzedLabel.setVisible(false);
                latwyPoLabel.setVisible(false);
                sredniPrzedLabel.setVisible(false);
                sredniPoLabel.setVisible(false);
                trudnyPrzedLabel.setVisible(false);
                trudnyPoLabel.setVisible(false);
                backgroundIconLabel2.setVisible(false);
                Game game = new Game(frame, 1);
            }
        });
        //Powrot po wcisnieciu Nowa gra
        powrot1PrzedLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                powrot1PrzedLabel.setVisible(false);
                powrot1PoLabel.setVisible(true);
            }
            @Override
            public void mouseExited(MouseEvent e){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException f) {
                        f.printStackTrace();
                    }
                    powrot1PrzedLabel.setVisible(true);
                    powrot1PoLabel.setVisible(false);
            }});
        powrot1PoLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                //Wlaczam napisy nowa gra i instrukcja
                newGameLabel1.setVisible(true);
                newGameLabel2.setVisible(true);
                newGameLabel3.setVisible(true);
                newGameLabel4.setVisible(true);

                //Wlaczam tlo
                backgroundIconLabel1.setVisible(true);

                //Wylaczam poprzednie tlo
                backgroundIconLabel2.setVisible(false);

                //Wylaczam napisy latwy, sredni, trudny
                latwyPrzedLabel.setVisible(false);
                sredniPrzedLabel.setVisible(false);
                trudnyPrzedLabel.setVisible(false);

                //Wylaczam napis powrot
                powrot1PrzedLabel.setVisible(false);
                powrot1PoLabel.setVisible(false);
            }
        });
        //Powrot po wcisnieciu Instrukcji
        powrot2PrzedLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                powrot2PrzedLabel.setVisible(false);
                powrot2PoLabel.setVisible(true);
            }
            @Override
            public void mouseExited(MouseEvent e){
                try{
                    Thread.sleep(100);
                } catch (InterruptedException f) {f.printStackTrace();}
                powrot2PrzedLabel.setVisible(true);
                powrot2PoLabel.setVisible(false);

            }
        });
        powrot2PoLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                //Wlaczam napisy nowa gra i instrukcja
                newGameLabel1.setVisible(true);
                newGameLabel2.setVisible(true);
                newGameLabel3.setVisible(true);
                newGameLabel4.setVisible(true);
                //Wlaczam tlo
                backgroundIconLabel1.setVisible(true);

                //Wylaczam poprzednie tlo
                backgroundIconLabel2.setVisible(false);
                //Wylaczam napisy latwy, sredni, trudny
                latwyPrzedLabel.setVisible(false);
                sredniPrzedLabel.setVisible(false);
                trudnyPrzedLabel.setVisible(false);

                //Wylaczam napis powrot
                powrot2PrzedLabel.setVisible(false);
                powrot2PoLabel.setVisible(false);

                backgroundIconLabel3.setVisible(false);
            }
        });

        /**
         * Zmiana kursora myszy na customowy
         */

         Toolkit toolkit = Toolkit.getDefaultToolkit();
         Image image = toolkit.getImage("menuImages/cursor.gif");
         Cursor c = toolkit.createCustomCursor(image , new Point(frame.getX(), frame.getY()), "img");
         frame.setCursor (c);


        /**
         * Obszar ustalania kolejnosci dodawania obiektow do ramki
         */
         frame.add(newGameLabel1);
         frame.add(newGameLabel2);
         frame.add(newGameLabel3);
         frame.add(newGameLabel4);
         frame.add(backgroundIconLabel1);
         frame.setVisible(true);

    }

    /**
     * Uruchomienie konstruktora klasy
     * @param args args
     */
    public static void main(String[] args) {
        new Start();
    }
}
