package tetris.domain;

public class Statistics {
    
    private String playerName;
    private int clearedLinesNum;
    private int totalScore;
    private int lastClearedLinesAmount;

    public Statistics(String playerName, int clearedLinesNum,
            int score, int lastClearedLinesAmount) {
        this.playerName = playerName;
        this.clearedLinesNum = clearedLinesNum;
        this.totalScore = score;
        this.lastClearedLinesAmount = lastClearedLinesAmount;
    }
    
    public Statistics() {
        this("anonymous", 0, 0, 1);
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setClearedLinesNum(int clearedLinesNum) {
        this.clearedLinesNum = clearedLinesNum;
    }
    
    public void incrementClearedLines(int clearedLinesAmount) {
        if (clearedLinesAmount <= 0) {
            return;
        } else if (clearedLinesAmount > 4) {
            throw new Error("over 4 rows cleared, should never be possible");
        }
        this.clearedLinesNum += clearedLinesAmount;
        totalScore += 100 * clearedLinesAmount * lastClearedLinesAmount;
        lastClearedLinesAmount = clearedLinesAmount;
    }
    
    public String getPlayerName() {
        return playerName;
    }

    public int getClearedLinesNum() {
        return clearedLinesNum;
    }
    
    public String getClearedLinesAsString() {
        return Integer.toString(clearedLinesNum);
    }
    
    public int getTotalScore() {
        return totalScore;
    }
    
    public String getTotalScoreAsString() {
        return Integer.toString(totalScore);
    }
    
}
