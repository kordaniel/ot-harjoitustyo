package tetris;

import javafx.scene.paint.Color;

public class Constants {
    
    public static final double VERSION = 0.5;
    
    // GAME
    public static final int BOARD_DEFAULT_HEIGHT = 18;
    public static final int BOARD_DEFAULT_WIDTH = 10;
    
    //UI
    public static final int RECTANGLE_DEFAULT_SIZE = 30;
    public static final int WINDOW_DEFAULT_WIDTH =
            (BOARD_DEFAULT_WIDTH + 4) * (RECTANGLE_DEFAULT_SIZE + 2);
    public static final int WINDOWS_DEFAULT_HEIGHT =
            BOARD_DEFAULT_HEIGHT * (RECTANGLE_DEFAULT_SIZE + 2);
    //COLORS
    public static final Color[] GAME_DEFAULT_COLORS = new Color[] {
        Color.rgb(45, 63, 81), // Background color 1
        Color.rgb(36, 51, 65), // Background color 2
        Color.rgb(172, 77, 155).brighter(), // T
        Color.rgb(247, 211, 25).brighter(), // O
        Color.rgb(55, 199, 239).brighter(), // I
        Color.rgb(90, 101, 172).brighter(), // J
        Color.rgb(238, 121, 35).brighter(), // L
        Color.rgb(238, 31, 41).brighter(),  // Z
        Color.rgb(70, 182, 69).brighter()   // S
    };
}
