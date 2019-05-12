public class Playboard {

    private Symbol[][] matrix;

    public Playboard() {

        matrix = new Symbol[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                matrix[row][col] = Symbol.SYMBOL_EMPTY;
            }
        }
    }

    public Symbol getWinner() {

        if ( matrix[0][0] != Symbol.SYMBOL_EMPTY && matrix[0][0].equals(matrix[0][1]) && matrix[0][0].equals(matrix[0][2])) {
            return matrix[0][0];
        }
        if ( matrix[1][0] != Symbol.SYMBOL_EMPTY && matrix[1][0].equals(matrix[1][1]) && matrix[1][0].equals(matrix[1][2])) {
            return matrix[1][0];
        }
        if ( matrix[2][0] != Symbol.SYMBOL_EMPTY && matrix[2][0].equals(matrix[2][1]) && matrix[2][0].equals(matrix[2][2])) {
            return matrix[2][0];
        }
        if ( matrix[0][0] != Symbol.SYMBOL_EMPTY && matrix[0][0].equals(matrix[1][0]) && matrix[0][0].equals(matrix[2][0])) {
            return matrix[0][0];
        }
        if ( matrix[0][1] != Symbol.SYMBOL_EMPTY && matrix[0][1].equals(matrix[1][1]) && matrix[0][1].equals(matrix[2][1])) {
            return matrix[0][1];
        }
        if ( matrix[0][2] != Symbol.SYMBOL_EMPTY && matrix[0][2].equals(matrix[1][2]) && matrix[0][2].equals(matrix[2][2])) {
            return matrix[0][2];
        }
        if ( matrix[0][0] != Symbol.SYMBOL_EMPTY && matrix[0][0].equals(matrix[1][1]) && matrix[0][0].equals(matrix[2][2])) {
            return matrix[0][0];
        }
        if ( matrix[0][2] != Symbol.SYMBOL_EMPTY && matrix[0][2].equals(matrix[1][1]) && matrix[0][2].equals(matrix[2][0])) {
            return matrix[0][2];
        }

        return Symbol.SYMBOL_EMPTY;
    }

    public boolean isEmpty(int[] coord) {

        return matrix[coord[0]][coord[1]] == Symbol.SYMBOL_EMPTY;
    }

    public void fill(int[] coord, Symbol symbol) {

        matrix[coord[0]][coord[1]] = symbol;
    }

    @Override
    public String toString() {
        StringBuilder txt = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                txt.append(matrix[i][j]).append("  ");
            }

            txt.append("\n\n");
        }
        return txt.toString();
    }
}
