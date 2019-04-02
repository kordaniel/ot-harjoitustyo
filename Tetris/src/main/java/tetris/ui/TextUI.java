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
        //NOT IMPLEMENTED
        //commands.put("2", "Set Player name");
        //commands.put("3", "High Scores");
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
            } else {
                System.out.println("unrecognized command!");
            }
        }
    }
    
    private void playGame() {
        this.game.addPiece();
        
        while (true) {
            this.game.advanceGame();
            System.out.println(this.game);
            
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println("virhe: " + e);
            }
            
            String input = this.askUser("[w||a|s|d|q(exit game)]> ");
            switch (input) {
                case "w":
                    this.game.rotatePiece();
                    break;
                case "a":
                    this.game.moveLeft();
                    break;
                case "s":
                    System.out.println("alas");
                    System.out.println("not implemented");
                    break;
                case "d":
                    this.game.moveRight();
                    break;
                case "q":
                    return;
                default:
                    System.out.println("unrecognized command!");
                    break;
            }
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
     * consisting of only the character '-' with matching length.
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
     * Prints the string given as parameter and then waits for 
     * input from user, which is then returned
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
