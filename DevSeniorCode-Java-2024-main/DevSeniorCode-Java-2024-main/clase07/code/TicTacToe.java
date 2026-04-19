package clase07.code;

import java.util.Scanner;

public class TicTacToe {

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

    private static char changePlayer(char player) {
        return player == 'X' ? 'O' : 'X';
    }

    private static void playGame(Scanner scanner, char player) {
        var board = initializeBoard();
        var isFinished = false;
        var turnCount = 0;

        do {
            showBoard(board);

            System.out.printf("Jugador '%c' ingresa tu movimiento: %n", player);
            System.out.print("fila (1-3): ");
            var row = Integer.parseInt(scanner.nextLine()) - 1;
            System.out.print("columna (1-3): ");
            var column = Integer.parseInt(scanner.nextLine()) - 1;

            if (makeMove(board, row, column, player)) {
                turnCount++;
                if (checkWinner(board, player)) {
                    showBoard(board);
                    System.out.println("El jugador " + player + " ha ganado!");
                    isFinished = true;
                } else {
                    player = changePlayer(player);
                }
            } else {
                System.err.println("Movimiento inválido. Intenta de nuevo.");
            }

            if (turnCount == board.length * board[0].length) {
                System.out.println("Han quedado empatados!");
                break;
            }
        } while (!isFinished);
    }

    private static char[][] initializeBoard() {
        var board = new char[3][3];

        for (int i = 0; i < board.length; i++) {
            var fila = board[i];
            for (int j = 0; j < fila.length; j++) {
                fila[j] = ' ';
            }
        }

        return board;
    }

    private static void showBoard(char[][] board) {
        System.out.println("  1   2   3");
        for (int i = 0; i < board.length; i++) {
            System.out.printf("%d ", i + 1);
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println(" ---+---+---");
            }
        }
    }

    private static boolean makeMove(char[][] board, int row, int column, char player) {
        if (board[row][column] != ' ') {
            return false;
        }
        board[row][column] = player;
        return true;
    }

    private static boolean checkWinner(char[][] board, char player) {
        // Verificar filas y columnas
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player)
                    || (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        // Verificar diagonales
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player)
                || (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }
        return false;

    }

}
