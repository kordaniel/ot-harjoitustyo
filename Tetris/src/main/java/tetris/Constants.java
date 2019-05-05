package tetris;

//import java.io.File;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Constants {
    
    public static final double VERSION = 0.9;
    
    // DATABASE URI
    public static final String DATABASE_URI = "scores.db";
    
    // DATABASE TABLES
    public static final String HIGHSCORE_TABLE_NAME = "Score";
    
    // GAME
    public static final int BOARD_DEFAULT_HEIGHT = 18;
    public static final int BOARD_DEFAULT_WIDTH = 10;
    
    //UI
    public static final int RECTANGLE_DEFAULT_SIZE = 35;
    public static final int WINDOW_DEFAULT_WIDTH =
            (BOARD_DEFAULT_WIDTH + 4) * (RECTANGLE_DEFAULT_SIZE + 2);
    public static final int WINDOWS_DEFAULT_HEIGHT =
            BOARD_DEFAULT_HEIGHT * (RECTANGLE_DEFAULT_SIZE + 2);
    
    public static final Font DEFAULT_FONT = Font.font("Monospaced", 32);
    public static final Font DEFAULT_FONT_BOLD =
            Font.font("Monospaced", FontWeight.BOLD, 32);
    
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
    public static final String DEFAULT_BG_COLOR_CSS = "rgb(210, 192, 174)";
    
    // SOUNDS
    // all sounds downloaded from https://freesound.org
    public static final double DEFAULT_BG_MUSIC_VOLUME = 0.15;
    //public static final File FILE_BG_MUSIC =
    //        new File("src/main/resources/sounds/bg_music.wav");
    
    
    // USER
    public static final String DEFAULT_ANON_PLAYER_NAME = "Noname";
}
