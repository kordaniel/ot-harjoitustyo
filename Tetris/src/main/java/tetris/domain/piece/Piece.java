package tetris.domain.piece;

import java.util.Random;

/**
 * Abstract class that provides all the fields and methods for all the 
 * different Pieces. Classes that extends this class, should set the
 * field SYMBOL and then initialize the coordinates.
 * @author DanielKor
 */
public abstract class Piece {

    private static final Random RANDOM = new Random();
    private final String TYPE;
    private final int MAX_ORIENTATIONS;
    private final int SIZE;

    private int orientation;
    protected int[][][] pieceCoordinates;

    private int y;
    private int x;

    //NEED TO ADD TESTS FOR THIS METHOD. how to test random though?
    //loop n times and check distribution of classes and that no nulls
    //are returned..?
    /**
     * Factory method that returns an randomly chosen tetris Piece of
     * type I,J,L,O,S,Z,T that extends this abstract class of type Piece.
     * @param initialX position
     * @return new Piece
     */
    public static Piece createNewRandomTetrisPiece(int initialX) {
        switch (RANDOM.nextInt(7)) {
            case 0:
                return new PieceT(initialX);
            case 1:
                return new PieceO(initialX);
            case 2:
                return new PieceI(initialX);
            case 3:
                return new PieceJ(initialX);
            case 4:
                return new PieceL(initialX);
            case 5:
                return new PieceZ(initialX);
            case 6:
                return new PieceS(initialX);
            default:
                return null;
        }
    }

    /**
     * Constructs a new Piece with the properties of values passed
     * as parameters
     * @param name name of the constructed piece, for example I,O,Z...
     * @param size size of the 2d coordinate grid
     * @param maxOrientations amount of orientations the piece has
     * @param initialY the initial Y-coordinate for the constructed piece
     * @param initialX the initial X-coordinate for the constructed piece
     */
    public Piece(String name, int size, int maxOrientations,
            int initialY, int initialX) {
        this.orientation = 0;

        this.TYPE = name;
        this.MAX_ORIENTATIONS = maxOrientations;
        this.SIZE = size;
        this.pieceCoordinates = new int[maxOrientations][size][size];

        this.y = initialY;
        this.x = initialX;
    }

    final public int[][] getCoords() {
        return this.pieceCoordinates[this.orientation];
    }

    final public int[][] getCoordsForNextOrientation() {
        return this.pieceCoordinates[getNextOrientation()];
    }

    final public void moveDown() {
        this.y++;
    }

    final public void moveLeft() {
        this.x--;
    }

    final public void moveRight() {
        this.x++;
    }

    final public int getX() {
        return this.x;
    }

    final public int getY() {
        return this.y;
    }

    final public int getSize() {
        return this.SIZE;
    }

    final public void rotateRight() {
        this.orientation = getNextOrientation();
    }

    final public int getNextOrientation() {
        return (this.orientation + 1) % this.MAX_ORIENTATIONS;
    }

}
