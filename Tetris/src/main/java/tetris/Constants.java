package tetris;

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
}
