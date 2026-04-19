package clase07.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        var words = List.of("elefante", "computadora", "biblioteca", "helicoptero", "mariposa", "television",
                "cangrejo", "montana", "universo", "cascada", "guitarra", "espejo", "reloj", "ventana", "puerta",
                "lampara", "silla", "mesa", "cuaderno", "lapiz");
        var scanner = new Scanner(System.in);
        var random = new Random();

        var playAgain = false;
        do {
            var word = words.get(random.nextInt(words.size())).toUpperCase();
            playGame(scanner, word);

            System.out.print("Desea jugar de nuevo? (S/n): ");
            var option = scanner.nextLine();
            playAgain = !option.equalsIgnoreCase("N");
        } while (playAgain);
        System.out.println("Hasta luego!");

        scanner.close();
    }

    private static void playGame(Scanner scanner, String word) {
        var guessed = new ArrayList<Character>();
        var letters = new ArrayList<Character>();
        for (int i = 0; i < word.length(); i++) {
            guessed.add('_');
        }

        var errors = 0;
        var endGame = false;
        while (!endGame) {
            showBoard(guessed, letters, errors);

            System.out.print("Prueba una nueva letra: ");
            var letter = scanner.nextLine().toUpperCase().charAt(0);

            if (!Character.isLetter(letter)) {
                System.out.println("Carácter inválido. Solo ingresa de la 'A' a la 'Z'");
            } else if (letters.contains(letter)) {
                System.out.println("Esa letra ya ha sido intentada");
            } else {
                letters.add(letter);
                if (!word.contains(String.valueOf(letter))) {
                    errors++;
                } else {
                    for (int i = 0; i < word.length(); i++) {
                        if (word.charAt(i) == letter) {
                            guessed.set(i, letter);
                        }
                    }

                }
                if (!guessed.contains('_')) {
                    showBoard(guessed, letters, errors);
                    System.out.println("Felicitaciones, has adivinado la palabra " + word);
                    endGame = true;
                } else if (errors == 6) {
                    showBoard(guessed, letters, errors);
                    System.out.println("Perdiste!, la palabra era " + word);
                    endGame = true;
                }
            }
        }

    }

    private static void showBoard(List<Character> guessed, List<Character> letters, int errors) {
        System.out.print("Palabra a adivinar: ");
        for (var letter : guessed) {
            System.out.printf("%c ", letter);
        }
        System.out.println();

        System.out.print("Letras intentadas: ");
        for (var letter : letters) {
            System.out.printf("%c ", letter);
        }
        System.out.println();

        var hangman = switch (errors) {
            case 6 -> """
                       +------+
                       |      |
                       |      O
                       |     \\|/
                       |      |
                       |     / \\
                       |
                    +--+--+
                    |     |
                    """;
            case 5 -> """
                       +------+
                       |      |
                       |      O
                       |     \\|/
                       |      |
                       |     /
                       |
                    +--+--+
                    |     |
                    """;
            case 4 -> """
                       +------+
                       |      |
                       |      O
                       |     \\|/
                       |      |
                       |
                       |
                    +--+--+
                    |     |
                    """;
            case 3 -> """
                       +------+
                       |      |
                       |      O
                       |     \\|
                       |      |
                       |
                       |
                    +--+--+
                    |     |
                    """;
            case 2 -> """
                       +------+
                       |      |
                       |      O
                       |      |
                       |      |
                       |
                       |
                    +--+--+
                    |     |
                    """;
            case 1 -> """
                       +------+
                       |      |
                       |      O
                       |
                       |
                       |
                       |
                    +--+--+
                    |     |
                    """;
            default -> """
                       +------+
                       |      |
                       |
                       |
                       |
                       |
                       |
                    +--+--+
                    |     |
                    """;
        };
        System.out.println(hangman);
    }
}
