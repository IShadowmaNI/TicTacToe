
/*
 * IsA relationship:
 *  inseamna ca o clasa mostenste/implementeaza o alta clasa/interfata; Exemple: ArrayList este o Lista;
 *  HashSet este un Set; Cainele este un Animal; CoffeMachine este un AutomaticCoffeMachine
 *
 * HasA relationship:
 *  inseamna ca o clasa are ca mebru (variabile) alte clase; Exemple: ArrayList are un storage; HashSet are un storage
 *  in forma de matrice; Cainele are dinti; CoffeMachine are stock (adica 3 numere intregi)
 *
 */

import java.util.Random;

public class Referee {

    private Playable pX;
    private Playable p0;
    private Playboard board;

    public Referee(Playboard board, Playable a, Playable b) {
        this.board = board;
        Random r = new Random();
        if (r.nextBoolean()) {
            this.pX = a;
            a.setSymbol(Symbol.SYMBOL_X);
            this.p0 = b;
            b.setSymbol(Symbol.SYMBOL_0);
        } else {
            this.pX = b;
            b.setSymbol(Symbol.SYMBOL_X);
            this.p0 = a;
            a.setSymbol(Symbol.SYMBOL_0);
        }
    }


    public Symbol start() {

        Playable currentPlayer = pX;
        System.out.println(board);
        int moves = 0;

        while (true) {
            System.out.println(currentPlayer + " este la rand");
            int[] coord = currentPlayer.getCoord();

            // Arbitrul valideaza mutarea cu respect fata de incapsulare (adica in loc sa se uite abuziv in matrice,
            // acesta intreaba matricea daca este libera casuta)
            if (board.isEmpty(coord)) {
                board.fill(coord, currentPlayer.getSymbol());
                System.out.println("\n Current state of the game: \n");
                System.out.println(board);
                moves++;

                if (currentPlayer == pX) {
                    currentPlayer = p0;
                } else {
                    currentPlayer = pX;
                }

                if (board.getWinner().equals(Symbol.SYMBOL_X)) {
                    System.out.println("Castigatorul este " + this.pX);
                    return this.pX.getSymbol();
                } else if (board.getWinner().equals(Symbol.SYMBOL_0)) {
                    System.out.println("Castigatorul este " + this.p0);
                    return this.p0.getSymbol();
                } else if (moves == 9) {
                    System.out.println("Remiza!");
                    return Symbol.SYMBOL_EMPTY;
                }
            } else {
                System.out.println("Mutare incorecta!");
            }
        }
    }
}
