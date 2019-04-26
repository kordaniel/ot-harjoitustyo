package tetris.logic;

public class Statistics {
    
    private final int basepoints;
    private int totalClearedLinesNum;
    private int totalScore;
    private int lastClearedLinesAmount;
    private boolean isSaved;

    public Statistics(int clearedLinesNum, int score,
            int lastClearedLinesAmount) {
        this.basepoints = 100;
        this.totalClearedLinesNum = clearedLinesNum;
        this.totalScore = score;
        this.lastClearedLinesAmount = lastClearedLinesAmount;
        this.isSaved = false;
    }
    
    public Statistics() {
        this(0, 0, 1);
    }
    
    public void incrementClearedLines(int clearedLinesAmount) {
        this.totalClearedLinesNum += clearedLinesAmount;
        totalScore += basepoints * clearedLinesAmount * lastClearedLinesAmount;
        lastClearedLinesAmount = clearedLinesAmount;
    }

    public int getTotalClearedLinesNum() {
        return totalClearedLinesNum;
    }
    
    public String getClearedLinesAsString() {
        return Integer.toString(totalClearedLinesNum);
    }
    
    public int getTotalScore() {
        return totalScore;
    }
    
    public String getTotalScoreAsString() {
        return Integer.toString(totalScore);
    }

    public boolean getIsSaved() {
        return isSaved;
    }

    public void setIsSaved(boolean isSaved) {
        this.isSaved = isSaved;
    }

    public void reset() {
        totalClearedLinesNum = 0;
        totalScore = 0;
        lastClearedLinesAmount = 1;
        isSaved = false;
    }
}
