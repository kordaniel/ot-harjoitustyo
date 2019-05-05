package tetris.logic;

/**
 * This class is used for counting the score during one game. Counting
 * scores for a single clearing depends on the last amount of cleared
 * lines. So the lastClearedLinesAmount should never be set to zero.
 * @author DanielKor
 */
public class ScoreCounter {
    
    /**
     * Basepoints to use when calculating scores.
     */
    private final int basepoints;
    private int totalScore;
    private int totalClearedLinesAmount;
    
    /**
     * Must never be set to zero. Currently should never be set
     * to under positive 1. Since the maximum amount of tetris
     * lines that can be cleared is 4 the effective value of this
     * variable should always be in [1,4].
     */
    private int lastClearedLinesAmount;
    private boolean isSaved;

    public ScoreCounter(int score, int clearedLinesAmount,
            int lastClearedLinesAmount) {
        this.basepoints = 100;
        
        this.totalScore = score;
        this.totalClearedLinesAmount = clearedLinesAmount;
        this.lastClearedLinesAmount = lastClearedLinesAmount;
        this.isSaved = false;
    }
    
    /**
     * Default constructor to use. Initializes the object with
     * a score and cleared lines set to zero.
     */
    public ScoreCounter() {
        this(0, 0, 1);
    }
    
    /**
     * This method should be called when there are cleared lines
     * in the game. It updated the score and total amount of cleared
     * lines. Also sets the lastClearedLinesAmount which is then
     * used during the next time there are cleared lines.
     * @param clearedLinesAmount Amount of cleared lines, should never be 0.
     */
    public void incrementClearedLines(int clearedLinesAmount) {
        if (clearedLinesAmount < 1) {
            return;
        }
        
        this.totalClearedLinesAmount += clearedLinesAmount;
        totalScore += basepoints * clearedLinesAmount * lastClearedLinesAmount;
        lastClearedLinesAmount = clearedLinesAmount;
    }

    public int getTotalClearedLinesAmount() {
        return totalClearedLinesAmount;
    }
    
    public int getTotalScore() {
        return totalScore;
    }

    /**
     * Returns the current level which is calculated based on how
     * many lines have been cleared. When 5 lines have been cleared,
     * the level is incremented. Integer division always rounds down,
     * so one must always be added to the calculated level.
     * @return current level.
     */
    public int getLevel() {
        return getTotalClearedLinesAmount() / 5 + 1;
    }
    
    /**
     * This method can be used to check if the score should be saved.
     * If the score is 0 or already saved it shouldn't be saved,
     * otherwise it should be.
     * @return true, if the score is not zero and not saved. false otherwise.
     */
    public boolean shouldBeSaved() {
        return totalScore == 0 ? false : !isSaved;
    }

    public void setIsSaved(boolean isSaved) {
        this.isSaved = isSaved;
    }

    public void reset() {
        totalClearedLinesAmount = 0;
        totalScore = 0;
        lastClearedLinesAmount = 1;
        isSaved = false;
    }
}
