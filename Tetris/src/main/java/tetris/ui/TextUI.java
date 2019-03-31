
package tetris.ui;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TextUI implements Userinterface {
  
  private Scanner scanner;
  private Map<String, String> commands;

  public TextUI(Scanner scanner) {
    this.scanner = scanner;
    
    this.commands = new TreeMap<>();
    
    commands.put("1", "Play");
    commands.put("2", "Set Player name");
    commands.put("3", "High Scores");    
    commands.put("q", "Quit");
  }
  
  @Override
  public void start() {
    this.printUnderlinedString("Welcome to Tetris v.0.02 BETA");
    
    while (true) {
      System.out.println("");
      this.printMainMenu();
      
      String command = this.askUser("> ");
      
      System.out.println("got: " + command);
      if (command.equals("q")) {
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
  
  private void printUnderlinedString(String str) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      sb.append("-");
    }
    System.out.println(str);
    System.out.println(sb.toString());
  }
  /**
   * Prints the string given as parameter and then
   * waits for the user input, which is then returned
   * @param question
   * @return 
   */
  private String askUser(String question) {
    System.out.print(question);
    String input = this.scanner.nextLine();
    return input;
  }
  
}
