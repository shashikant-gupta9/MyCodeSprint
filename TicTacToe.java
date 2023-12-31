import java.util.Scanner;

public class TicTacToe {
    private static final int BOARD_SIZE = 3;
    private static final char EMPTY = ' ';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    private static char[][] board;
    private static char currentPlayer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        initializeGame();
        boolean gameEnded = false;

        while (!gameEnded) {
            displayBoard();
            int[] move = getPlayerMove(scanner);
            makeMove(move[0], move[1]);

            if (checkWinner()) {
                displayBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                gameEnded = true;
            } else if (isBoardFull()) {
                displayBoard();
                System.out.println("It's a draw!");
                gameEnded = true;
            } else {
                currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
            }
        }

        scanner.close();
    }

    private static void initializeGame() {
        board = new char[BOARD_SIZE][BOARD_SIZE];
        currentPlayer = PLAYER_X;

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    private static void displayBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j]);
                if (j < BOARD_SIZE - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < BOARD_SIZE - 1) {
                System.out.println("---------");
            }
        }
    }

    private static int[] getPlayerMove(Scanner scanner) {
        int[] move = new int[2];
        boolean validMove = false;

        while (!validMove) {
            System.out.print("Player " + currentPlayer + ", enter row (0-2): ");
            move[0] = scanner.nextInt();
            System.out.print("Player " + currentPlayer + ", enter column (0-2): ");
            move[1] = scanner.nextInt();

            if (isValidMove(move[0], move[1])) {
                validMove = true;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        return move;
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE && board[row][col] == EMPTY;
    }

    private static void makeMove(int row, int col) {
        board[row][col] = currentPlayer;
    }

    private static boolean checkWinner() {
        return checkRows() || checkCols() || checkDiagonals();
    }

    private static boolean checkRows() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][0] != EMPTY && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkCols() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[0][i] != EMPTY && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkDiagonals() {
        return (board[0][0] != EMPTY && board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
               (board[0][2] != EMPTY && board[0][2] == board[1][1] && board[1][1] == board[2][0]);
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
