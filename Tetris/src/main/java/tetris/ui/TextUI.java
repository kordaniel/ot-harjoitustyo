package tetris.ui;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import tetris.domain.Game;

public class TextUI implements Userinterface {

    private Scanner scanner;
    private Map<String, String> commands;
    private Game game;
    
    public TextUI(Scanner scanner, Game game) {
        this.scanner = scanner;

        this.commands = new TreeMap<>();

        commands.put("1", "Play");
        commands.put("2", "Set Player name");
        commands.put("3", "High Scores");
        commands.put("q", "Quit");
        
        this.game = game;
    }

    @Override
    public void start() {
        this.printUnderlinedString("Welcome to Tetris v.0.02 BETA");

        while (true) {
            System.out.println("");
            this.printMainMenu();

            String command = this.askUser("> ");
            
            if (command.equals("1")) {
                this.playGame();
            } else if (command.equals("q")) {
                break;
            }

        }
    }
    
    private void playGame() {
        while (true) {
            game.advanceGame();
            System.out.println(this.game);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println("virhe: " + e);
            }
            String input = this.askUser("> ");
            if (input.equals("w")) System.out.println("ylös");
            else if (input.equals("a")) System.out.println("vasen");
            else if (input.equals("d")) System.out.println("oikea");
            else if (input.equals("s")) System.out.println("alas");
            else return;
        }
    }

    private void printMainMenu() {
        System.out.println("Main menu");
        this.printUnderlinedString("Available commands:");

        this.commands.entrySet().forEach((command) -> {
            System.out.println(command.getKey() + ": " + command.getValue());
        });
    }

    /**
     * Prints the given string and prints an additional row with an string
     * consisting of only the character '-' of matching length.
     *
     * @param str String to be printed
     */
    private void printUnderlinedString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append("-");
        }

        System.out.println(str);
        System.out.println(sb.toString());
    }

    /**
     * Prints the string given as parameter and then waits for the user input,
     * which is then returned
     *
     * @param question
     * @return
     */
    private String askUser(String question) {
        System.out.print(question);
        String input = this.scanner.nextLine();
        return input;
    }

}
