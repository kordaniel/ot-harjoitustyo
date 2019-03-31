package tetris.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Board board;
    private Piece currentPiece;

    public Game(int height, int width) {
        this.board = new Board(height, width);
    }

    public void addPiece() {

    }

}
