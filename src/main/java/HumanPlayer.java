import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer implements Playable {

    private String name;
    private Scanner sc;
    private Symbol sb;

    public HumanPlayer(String name, Scanner sc) {
        this.name = name;
        this.sc = sc;
    }

    public int[] getCoord() {
        int[] coord = new int[2];
        try {
            coord[0] = sc.nextInt();
            coord[1] = sc.nextInt();
            if (coord[0] > 2 || coord[0] < 0 || coord[1] > 2 || coord[1] < 0) {
                System.out.println("Invalid input! Please input again: ");
                return getCoord();
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input! Please choose between 0-2!");
            // De retinut!!!
            sc.nextLine();
            return getCoord();
        };

        return coord;
    }

    public Symbol getSymbol() {
        return sb;
    }

    public void setSymbol(Symbol s) {
        this.sb = s;
    }

    @Override
    public String toString() {
        return name + " " + sb;
    }
}
