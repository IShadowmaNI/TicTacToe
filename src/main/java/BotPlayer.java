import java.util.Random;

public class BotPlayer implements Playable {

    private String name;
    private Symbol sb;

    public BotPlayer(String name) {
        this.name = name;
    }

    public int[] getCoord() {
        Random r = new Random();
        return new int[] {r.nextInt(3), r.nextInt(3)};
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
