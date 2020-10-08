import javax.swing.*;

/**
 * Klasa zawierajaca wszystkie potrzebne zmienne statyczne do synchronizacji dzialania gry
 * Wywolywane sa stad tez odpowiednie klasy dziedziczace po Thread
 */


public class Game {
    /**
     *  whichMole - zmienna pomocnicza uzyta w if'ie chroniaca przed dodaniem punktow za klikniecie pustej kretowki
     *  mnoznik - uzyty w celu ustalenia poziomu trudnosci
     *  readyforclick - flaga ktora jest ustawiana na true, gdy postac wychodzi z dziury
     *  moleFlag - flaga do sprawdzenia, ktory rodzaj postaci (tutaj kret) zostal klikniety
     *  moleKingFlag -flaga do sprawdzenia, ktory rodzaj postaci (tutaj krol kret) zostal klikniety
     *  bombFlag - flaga do sprawdzenia, ktory rodzaj postaci (tutaj bomba) zostala kliknieta
     *  howMuchMole - sluzy do zliczania ilosci kliknietych kretow w klasie MouseListenerForGame
     *  howMuchKings - sluzy do zliczania ilosci kliknietych krolow kretow w klasie MouseListenerForGame
     *  howMuchMoleBombs - sluzy do zliczania ilosci kliknietych bomb w klasie MouseListenerForGame
     *  clickedFlag - flaga chroniaca przed kliknieciem wiecej niz raz w dana postac
     */

    public static int whichMole = 0;
    public static JFrame frame;
    public static int mnoznik;
    public static boolean readyforclick = false;
    public static boolean moleFlag = false;
    public static boolean moleKingFlag = false;
    public static boolean bombFlag = false;
    public static int howMuchMole = 0;
    public static int howMuchMoleKings = 0;
    public static int howMuchMoleBombs = 0;
    public static boolean clickedFlag = false;

    /**
     * Wywolany konstruktor bezargumentowy z watku klasy CountdownToStart
     */

    public Game(){
        Thread createMoles = new CreateMoles(frame);
        createMoles.start();
    }

    /**
     * Konstruktor uruchamiany z klasy Start, uruchamia odliczanie do rozpoczecia
     * nowej gry w nowym watku
     * @param frame - przekazanie ramki
     * @param mnoznik - przekazanie mnoznika ktory wplywa na poziom trudnosci
     */

    public Game(JFrame frame, int mnoznik){
        this.frame = frame;
        this.mnoznik = mnoznik;

        Thread startgame = new CountdownToStart(frame);
        startgame.start();
    }

}