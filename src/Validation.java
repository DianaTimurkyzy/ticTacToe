public class Validation {

    static boolean checkWin(char symbol, char[][] table) {
        for (int i = 0; i < 3; i++) {
            if ((table[i][0] == symbol && table[i][1] == symbol && table[i][2] == symbol) ||
                    (table[0][i] == symbol && table[1][0] == symbol && table[2][i] == symbol))
                return true;
        }
        if ((table[0][0] == symbol && table[1][1] == symbol && table[2][2] == symbol) ||
                (table[2][0] == symbol && table[1][1] == symbol && table[0][2] == symbol))
            return true;

        return false;
    }

    static boolean isTableFull(char[][] table) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (table[row][col] == TicTacToe.SIGN_CELL)
                    return false;
            }
        }
        return true;
    }
}
