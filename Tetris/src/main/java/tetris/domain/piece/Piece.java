package tetris.domain.piece;

public abstract class Piece {

    private final String TYPE;
    private final int MAX_ORIENTATIONS;
    private final int SIZE;
    
    private int orientation;
    protected int[][][] pieceCoordinates;

    private int y;
    private int x;
    
    /**
     * Piece is always constructed with Y-coord equal to the size
     * of the piece (piece is placed on top of the grid)
     * @param name name of the constructed piece, for example I,O,Z...
     * @param size size of the 2d coordinate grid
     * @param maxOrientations amount of orientations the piece has
     * @param initialX the initial X-coordinate for the constructed piece
     */
    public Piece(String name, int size, int maxOrientations, int initialX) {
        this.orientation = 0;

        this.TYPE = name;
        this.MAX_ORIENTATIONS = maxOrientations;
        this.SIZE = size;
        this.pieceCoordinates = new int[maxOrientations][size][size];

        this.y = size;
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
