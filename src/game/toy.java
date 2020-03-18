package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

class toy {
    private String mysteryWord = "";
    private StringBuilder currentGuess;
    private ArrayList<Character> previousGuesses = new ArrayList<>();

    private int maxTries = 6;
    private int currentTries = 0;

    private ArrayList<String> dictionary = new ArrayList<>();
    private static FileReader reader;
    private static BufferedReader buffreader;

    private void readtheword() throws IOException {
        try {
            File inFile = new File("C:\\Users\\Hello\\Desktop\\dictionary.txt");
            reader = new FileReader(inFile);
            buffreader = new BufferedReader(reader);
            String currentLine = buffreader.readLine();

            while(currentLine != null) {
                dictionary.add(currentLine);
                currentLine = buffreader.readLine();
            }
            buffreader.close();
            reader.close();
        } catch (IOException e) {
            System.out.println("cannot load file.");
        }
    }

    public String pickaWord() {
        Random rand = new Random();
        int wordIndex = Math.abs(rand.nextInt()) % dictionary.size();
        return dictionary.get(wordIndex);
    }

    public StringBuilder InitializeCurrentGuess() {
        StringBuilder current = new StringBuilder();
        for (int i = 0; i < mysteryWord.length() * 2; i++) {
            if (i % 2 == 0) {
                current.append("_");
            } else {
                current.append(" ");
            }
        }
        return current;
    }

    public toy() throws IOException {
        readtheword();
        mysteryWord = pickaWord();
        currentGuess = InitializeCurrentGuess();
    }

    public String getFormalCurrentGuess() {
        return "Current Guess: " + currentGuess.toString();
    }

    public String getCondensedCurrentGuess() {
        String guess = currentGuess.toString();
        return guess.replace(" ", "");
    }

    public boolean didwewin() {
        String guess = getCondensedCurrentGuess();
        return guess.equals(mysteryWord);
    }

    public boolean didwelost() {
        return currentTries >= maxTries;
    }

    public boolean GameOver() {
        if (didwewin()) {
            System.out.println("You won the game.");
        } else if (didwelost()) {
            System.out.println("Sorry, you lost the game.");
            System.out.println("The mystery word was: " + mysteryWord);
        }
        return didwewin() || didwelost();
    }

    public boolean isgueesedAlready(char guess) {
        return previousGuesses.contains(guess);
    }

    public boolean playGame(char guess) {
        boolean isitaGoodGuess = false;
        previousGuesses.add(guess);
        for (int i = 0; i < mysteryWord.length(); i++) {
            if (mysteryWord.charAt(i) == guess) {
                currentGuess.setCharAt(i * 2, guess);
                isitaGoodGuess = true;
            }
        }

        if (!isitaGoodGuess) {
            currentTries++;
        }

        return isitaGoodGuess;
    }

    public String drawtoy() {
        switch (currentTries) {
            case 0: return noPersonDraw();
            case 1: return addHeadDraw();
            case 2: return addBodyDraw();
            case 3: return addOneArmDraw();
            case 4: return addSecondArmDraw();
            case 5: return addFirstLegDraw();
            default: return fullPersonDraw();
        }
    }

    private String noPersonDraw() {
        return " - - - - -\n"+
                "|        |\n"+
                "|        \n" +
                "|       \n"+
                "|        \n" +
                "|       \n" +
                "|\n" +
                "|\n";
    }

    private String addHeadDraw() {
        return " - - - - -\n"+
                "|        |\n"+
                "|        O\n" +
                "|       \n"+
                "|        \n" +
                "|       \n" +
                "|\n" +
                "|\n";
    }

    private String addBodyDraw() {
        return " - - - - -\n"+
                "|        |\n"+
                "|        O\n" +
                "|        | \n"+
                "|        |\n" +
                "|        \n" +
                "|\n" +
                "|\n";
    }

    private String addOneArmDraw() {
        return   " - - - - -\n"+
                "|        |\n"+
                "|        O\n" +
                "|      / |  \n"+
                "|        |\n" +
                "|        \n" +
                "|\n" +
                "|\n";
    }

    private String addSecondArmDraw() {
        return  " - - - - -\n"+
                "|        |\n"+
                "|        O\n" +
                "|      / | \\ \n"+
                "|        |\n" +
                "|        \n" +
                "|\n" +
                "|\n";
    }

    private String addFirstLegDraw() {
        return   " - - - - -\n"+
                "|        |\n"+
                "|        O\n" +
                "|      / | \\ \n"+
                "|        |\n" +
                "|       / \n" +
                "|\n" +
                "|\n";
    }

    private String fullPersonDraw() {
        return   " - - - - -\n"+
                "|        |\n"+
                "|        O\n" +
                "|      / | \\ \n"+
                "|        |\n" +
                "|       / \\ \n" +
                "|\n" +
                "|\n";
    }
}