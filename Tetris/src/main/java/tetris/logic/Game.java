package tetris.logic;

import tetris.domain.Board;
import tetris.domain.User;
import tetris.domain.piece.Piece;

/**
 * Main game logic class. This class holds all the objects that are needed
 * during one game. Main classes are the following:
 *  -boardState of type Board, that holds he current values for all the cells.
 *  -scoreCounter of type ScoreCounter, counts the current score.
 *  -user of type User, holds the name of the current player
 *  -highScores, All highscores reside inside this class.
 *  -currentPiece, nextPiece which are the two tetrispieces used during the game.
 
 * Provides methods for starting, pausing and stopping the game and handles
 * all the checking and updating of these objects.
 */
public class Game {

    private int height; 
    private int width;
    
    private Board boardState;
    
    private ScoreCounter scoreCounter;
    private User user;
    private Highscores highscores;
    
    private int[][] boardInPlay;
    
    private Piece currentPiece;
    private Piece nextPiece;
    
    private boolean isStarted;
    private boolean isActive;
    private boolean isOver;
    
    public Game(int height, int width, User user, Highscores highscores) {
        this.height = height;
        this.width = width;
        
        this.scoreCounter = new ScoreCounter();
        this.user = user;
        this.highscores = highscores;

        this.boardState = new Board(height, width);
        this.boardInPlay = this.boardState.getBoardCopy();
        
        this.isStarted = false;
        this.isActive = false;
        this.isOver = false;
        
        
    }
    
    /**
     * Method for starting a new game.
     */
    public void startGame() {
        initializeGame();
        isStarted = true;
        isActive = true;
    }
    
    /**
     * Method for finishing one game.
     */
    public void finishGame() {
        isOver = true;
        stopGame();
        addScoreToHighScores();
    }
    
    /**
     * Pauses the game, switches isActive boolean if the game is started
     * and returns true. Otherwise only returns false.
     * @return - false if this isActive didn't change, true otherwise
     */
    public boolean pauseGame() {
        if (!isStarted) {
            return false;
        }
        isActive = !isActive;
        return true;
    }
    
    /**
     * Helper method for stopping a game.
     */
    private void stopGame() {
        isActive = false;
        isStarted = false;
    }
    
    /**
     * Handles adding the current score to the highscores object.
     */
    public void addScoreToHighScores() {
        if (user.isAnonymous() || !scoreCounter.shouldBeSaved()) {
            return;
        }
        
        highscores.newScore(user.getName(), scoreCounter.getTotalScore());
        scoreCounter.setIsSaved(true);
    }
    
    public boolean getIsActive() {
        return isActive;
    }
    
    public boolean getIsOver() {
        return isOver;
    }
    
    public int[][] getBoardInPlay() {
        return boardInPlay;
    }
    
    public int[][] getNextPieceCoords() {
        return nextPiece.getPieceCoordinates();
    }
    
    public ScoreCounter getScoreCounter() {
        return this.scoreCounter;
    }

    /**
     * Resets the state of the game, or in other words
     * simply initializes a new game.
     */
    private void initializeGame() {
        addScoreToHighScores();
        scoreCounter.reset();
        boardState.reset();
        boardInPlay = this.boardState.getBoardCopy();
        isOver = false;
        isStarted = false;
        isActive = false;
        setNewPiece();
    }
    
    
    /**
     * Helper method that handles the shifting of pieces. Always moves
     * the next piece in turn to the playable piece. Initially all pieces
     * are null, so this method keeps on spawning new pieces until there
     * actually is one piece in turn.
     * 
     * The design of this method is like this to allow for further
     * development of this class.
     */
    private void setNewPiece() {
        currentPiece = nextPiece;
        nextPiece = Piece.createNewRandomTetrisPiece((width / 2) - 1);
        
        while (currentPiece == null) {
            currentPiece = nextPiece;
            nextPiece = Piece.createNewRandomTetrisPiece((width / 2) - 1);
        }
    }
    
    /**
     * Rotates the current piece if the board allows it to be rotated.
     * In other words, checks that nothing is blocking the piece from
     * beeing rotated and proceeds accordingly.
     */
    public void rotatePiece() {
        if (this.currentPiece == null
                || !this.boardState.pieceCanBeRotated(this.currentPiece)) {
            return;
        }

        this.currentPiece.rotateRight();
        refreshBoardInPlay();
    }

    /**
     * Moves the current piece one coordinate to the right if the
     * board allows it.
     * In other words, checks that nothing is blocking the piece from
     * beeing moved and proceeds accordingly.
     */    
    public void moveRight() {
        if (this.currentPiece == null
                || !this.boardState.pieceCanMoveRight(this.currentPiece)) {
            return;
        }
        
        this.currentPiece.moveRight();
        refreshBoardInPlay();
    }
    
    /**
     * Moves the current piece one coordinate to the left if the
     * board allows it.
     * In other words, checks that nothing is blocking the piece from
     * beeing moved and proceeds accordingly.
     */
    public void moveLeft() {
        if (this.currentPiece == null
                || !this.boardState.pieceCanMoveLeft(this.currentPiece)) {
            return;
        }
        
        this.currentPiece.moveLeft();
        refreshBoardInPlay();
    }
    
    /**
     * Moves the current piece one coordinate down if the board allows it.
     * In other words, checks that nothing is blocking the piece from
     * beeing moved and proceeds accordingly.
     */
    public void moveDown() {
        if (this.currentPiece == null
                || !this.boardState.pieceCanMoveDown(this.currentPiece)) {
            return;
        }
        
        this.currentPiece.moveDown();
        refreshBoardInPlay();
    }
    
    /**
     * Moves the current piece as far down as the board will allow it to go.
     */
    public void dropPiece() {
        if (this.currentPiece == null) {
            return;
        }
        while (this.boardState.pieceCanMoveDown(this.currentPiece)) {
            moveDown();
        }
    }
    
    /**
     * Method that handles the progression of the game state. It moves down
     * the current piece by one step if it can be moved. Otherwise it appends
     * the coordinates of the stagnated piece to the boardState and updates
     * the score and finally checks if the game can continue. If the game can
     * continue it updates the pieces by spawning a new one, otherwise it
     * will finish the game.
     * 
     * Finally it will refresh the boardinplay status.
     */
    public void advanceGame() {
        if (this.currentPiece == null
                || this.nextPiece == null) {
            return;
        }
        
        if (this.boardState.pieceCanMoveDown(currentPiece)) {
            this.currentPiece.moveDown();
        } else {
            this.boardState.addPieceToBoard(this.currentPiece);
            
            int rowsCleared = this.boardState.dropRows();
            scoreCounter.incrementClearedLines(rowsCleared);
            
            if (this.boardState.pieceCanBeSpawned(nextPiece)) {
                setNewPiece();
            } else {
                finishGame();
            }
        }

        this.refreshBoardInPlay();        
    }
    
    /**
     * Helper method that handles the refreshing of this games current state.
     * It fetches the main boardstate and then appends the current pieces
     * coordinates to it and saves it to the variable boardInPlay, which
     * can be used to draw the game in the UI.
     * 
     * This method should always be called when any change to the current
     * status of this game is done.
     */
    private void refreshBoardInPlay() {
        this.boardInPlay = this.boardState.getBoardCopy();
        int[][] pieceCoords = this.currentPiece.getPieceCoordinates();
        int py = this.currentPiece.getY();
        int px = this.currentPiece.getX();
        int dim = this.currentPiece.getSize() - 1;
        
        for (int dy = 0; dy <= dim; dy++) {
            for (int dx = 0; dx <= dim; dx++) {
                if (pieceCoords[dy][dx] == 0) {
                    continue;
                }
                this.boardInPlay[py - dim + dy][px + dx] = pieceCoords[dy][dx];
            }
        }
    }
    
    private int currentLevel() {
        return scoreCounter.getLevel();
    }
    
    /**
     * Returns the amount of frames that should be rendered before the 
     * AnimationTimer should advance the game. That is, the lower this
     * integer is, the quicker the game progresses. This method assumes
     * that the AnimationTimer is called at a rate of 60 times / second.
     * @return int value of frames to skip between 6-17, inclusive.
     */
    public int refreshesToWait() {
        final int min = 5;
        final int max = 14;
        int skips = max - (currentLevel() - 1);
        return skips > min ? skips : min;
    }
    
}
