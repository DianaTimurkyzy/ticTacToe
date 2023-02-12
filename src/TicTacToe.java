import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    final static char SIGN_X = 'x';
    final static char SIGN_O = 'o';
    final static char SIGN_CELL = '_';
    static char[][] table = new char[3][3];


    public static void main(String[] args) {
        play();
    }


    static void play() {
        initTable();
        showMap();
        while (true) {
            humanMove();
            showMap();
            if (checkWin(SIGN_X)) {
                System.out.println("U won!");
                break;
            }
            if (isTableFull()) {
                System.out.println("Table is full. Try again");
                break;
            }

            AIMove();
            showMap();
            if (checkWin(SIGN_O)) {
                System.out.println("U won");
                break;
            }
            if (isTableFull()) {
                System.out.println("Table is full. Try again");
                break;
            }
        }
    }

    static void humanMove() {
        int x, y;

        do {
            System.out.println("Enter X and Y(1...3):");
            x = new Scanner(System.in).nextInt() - 1;
            y = new Scanner(System.in).nextInt() - 1;
        } while (!isCellValid(x, y));
        table[y][x] = SIGN_X;
    }


    static boolean isCellValid(int x, int y) {
        if (x < 0 || x > 2 || y < 0 || y > 2) {
            System.out.println("Number is not from range (1...3)");
            return false;
        }
        if (table[y][x] != SIGN_CELL) {
            System.out.println("Cell is unavailable");
            return false;
        }
        return true;
    }

    static void initTable() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                table[row][col] = SIGN_CELL;
            }
        }
    }

    static void showMap() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print("[" + table[row][col] + "]");
            }
            System.out.println();
        }

    }

    static boolean checkWin(char symbol) {
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

    static boolean isTableFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (table[row][col] == SIGN_CELL)
                    return false;
            }
        }
        return true;
    }

    static void AIMove() {
        int x, y;

        System.out.println("IA move");
        do {
            x = new Random().nextInt(2);
            y = new Random().nextInt(2);
        } while (!isCellValid(x, y));
        table[y][x] = SIGN_O;
    }
}