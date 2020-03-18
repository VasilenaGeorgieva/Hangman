package game;

import java.io.IOException;
import java.util.Scanner;

public class app {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, u ready?");
        boolean douwanttoPlay = true;

        while (douwanttoPlay) {
            toy Hangman = new toy();
            do {
                System.out.println();
                System.out.println(Hangman.drawtoy());
                System.out.println();
                System.out.println(Hangman.getFormalCurrentGuess());
                System.out.println();

                System.out.println("Enter a char: ");
                char guess = scanner.next().toLowerCase().charAt(0);
                System.out.println();

                if (Hangman.isgueesedAlready(guess)) {
                    System.out.println("try again, you've checked this char before");
                    guess = scanner.next().toLowerCase().charAt(0);
                }

                if (Hangman.playGame(guess)) {
                    System.out.println("great guess maaaan");
                } else {
                    System.out.println("not a good guess");
                }
            }
            while (!Hangman.GameOver());

            System.out.println();
            System.out.println("do u want to play again? Press Y if u want.");
            Character wantDONTwant = scanner.next().toUpperCase().charAt(0);
            if (wantDONTwant == 'Y') {
                douwanttoPlay = true;
            } else {
                douwanttoPlay = false;
            }
        }
    }
}