package clase07.code;

import java.util.Scanner;

public class Connect4 {
    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        var scanner = new Scanner(System.in);
        var playAgain = false;
        var player = 'O';

        do {
            player = changePlayer(player);
            playGame(scanner, player);

            System.out.print("Desea jugar de nuevo? (S/n): ");
            var option = scanner.nextLine();
            playAgain = !option.equalsIgnoreCase("N");
        } while (playAgain);
        System.out.println("Hasta luego!");

        scanner.close();
    }

    private static void playGame(Scanner scanner, char player) {
        var board = initializeBoard();
        var isFinished = false;
        var turnCount = 0;
        do {
            showBoard(board);

            System.out.printf("Jugador '%c' ingresa tu movimiento: %n", player);
            System.out.print("columna (1-7): ");
            var column = Integer.parseInt(scanner.nextLine()) - 1;

            if (makeMove(board, column, player)) {
                turnCount++;
                if(checkWinner(board, player)){
                    showBoard(board);
                    System.out.println("El jugador " + player + " ha ganado!");
                    isFinished = true;
                } else {
                    player = changePlayer(player);
                }

            } else {
                System.out.println("Movimiento inválido. Intenta de nuevo.");
            }

            if (turnCount == board.length * board[0].length) {
                System.out.println("Han quedado empatados!");
                break;
            }

        } while (!isFinished);
    }

    private static char[][] initializeBoard() {
        var board = new char[6][7];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
        return board;
    }

    private static void showBoard(char[][] board) {
        System.out.println(" 1   2   3   4   5   6   7");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.printf(" %c", board[i][j]);
                if (j < board[i].length - 1)
                    System.out.print(" |");
            }
            System.out.println();
            if (i < board.length - 1)
                System.out.println("---------------------------");
        }
    }

    private static boolean makeMove(char[][] board, int column, char player) {
        if (column < 0 || column >= board[0].length) {
            return false;
        }
        for (int i = board.length - 1; i >= 0; i--) {
            if (board[i][column] == ' ') {
                board[i][column] = player;
                return true;
            }
        }
        return false;
    }

    private static boolean checkWinner(char[][] board, char player) {
        // Check horizontal
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length - 3; j++) {
                if (board[i][j] == player && board[i][j + 1] == player && board[i][j + 2] == player
                        && board[i][j + 3] == player) {
                    return true;
                }
            }
        }
        // Check vertical
        for (int i = 0; i < board.length - 3; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == player && board[i + 1][j] == player && board[i + 2][j] == player
                        && board[i + 3][j] == player) {
                    return true;
                }
            }
        }
        // Check diagonal (bottom-left to top-right)
        for (int i = 3; i < board.length; i++) {
            for (int j = 0; j < board[i].length - 3; j++) {
                if (board[i][j] == player && board[i - 1][j + 1] == player && board[i - 2][j + 2] == player
                        && board[i - 3][j + 3] == player) {
                    return true;
                }
            }
        }
        // Check diagonal (top-left to bottom-right)
        for (int i = 0; i < board.length - 3; i++) {
            for (int j = 0; j < board[i].length - 3; j++) {
                if (board[i][j] == player && board[i + 1][j + 1] == player && board[i + 2][j + 2] == player
                        && board[i + 3][j + 3] == player) {
                    return true;
                }
            }
        }
        return false;
    }

    private static char changePlayer(char player) {
        return player == 'O' ? 'X' : 'O';
    }

}
