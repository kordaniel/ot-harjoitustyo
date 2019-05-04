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
    private final int maxOrientations;
    private final int SIZE;

    private int orientation;
    protected int[][][] pieceCoordinates;

    private int y;
    private int x;

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
     * Constructs a new Piece with the properties of values passed.
     * as parameters
     * @param size size of the 2d coordinate grid
     * @param maxOrientations amount of orientations the piece has
     * @param initialY the initial Y-coordinate for the constructed piece
     * @param initialX the initial X-coordinate for the constructed piece
     */
    public Piece(int size, int maxOrientations,
            int initialY, int initialX) {
        this.orientation = 0;

        this.maxOrientations = maxOrientations;
        this.SIZE = size;
        this.pieceCoordinates = new int[maxOrientations][size][size];

        this.y = initialY;
        this.x = initialX;
    }
    
    private void setCoordinates(int orientation, int[][] coordinates) {
        //initialize coordinates trough this from extending classes!
    }
    
    final public int[][] getPieceCoordinates() {
        return this.pieceCoordinates[this.orientation];
    }

    final public int[][] getCoordinatesForNextOrientation() {
        return this.pieceCoordinates[getNextOrientation()];
    }

    /**
     * Moves the piece down. In other words increments the y-coordinate
     * of this piece by one.
     */
    final public void moveDown() {
        this.y++;
    }
    
    /**
     * Moves the piece to the left.
     */
    final public void moveLeft() {
        this.x--;
    }

    /**
     * Moves the piece to the right.
     */
    final public void moveRight() {
        this.x++;
    }

    final public int getX() {
        return this.x;
    }

    final public int getY() {
        return this.y;
    }

    /**
     * Returns the size of the 2 dimensional array holding
     * the coordinates for this piece.
     * @return integer value representing the size.
     */
    final public int getSize() {
        return this.SIZE;
    }
    
    /**
     * Calculates the next orientation for the piece. The orientation
     * of this piece is an integer value, representing the first dimension
     * of the coordinates 3 dimensional array. That is this value is always
     * [0, (max_orientations-1)].
     * @return 
     */
    final public int getNextOrientation() {
        return (this.orientation + 1) % this.maxOrientations;
    }
    
    /**
     * Sets the orientation integer to represent
     * the next orientation (position).
     */
    final public void rotateRight() {
        this.orientation = getNextOrientation();
    }

}
