package tetris.domain;

public abstract class Piece {

    private final String TYPE;
    private final int MAX_ORIENTATIONS;
    private final int SIZE;
    
    private int orientation;
    protected int[][][] pieceCoordinates;

    private int y;
    private int x;

    public Piece(String name, int size, int maxOrientations, int initialX) {
        this.orientation = 0;

        this.TYPE = name;
        this.MAX_ORIENTATIONS = maxOrientations;
        this.SIZE = size;
        this.pieceCoordinates = new int[maxOrientations][size][size];

        this.y = size;
        this.x = initialX;
    }
    
    public int[][] getCoords() {
        return this.pieceCoordinates[this.orientation];
    }

    public void moveDown() {
        this.y++;
    }
    
    public void moveLeft() {
        this.x--;
    }

    public void moveRight() {
        this.x++;
    }
    
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getSize() {
        return this.SIZE;
    }

    public void rotateLeft() {
        if (this.orientation != 0) {
            this.orientation--;
        } else {
            this.orientation = this.MAX_ORIENTATIONS - 1;
        }
    }

    public void rotateRight() {
        this.orientation = (this.orientation + 1) % this.MAX_ORIENTATIONS;
    }
    
}
