package tetris.domain;

public class Score implements Comparable<Score> {
    
    private String username;
    private int score;

    public Score(String username, int score) {
        this.username = username;
        this.score = score;
    }

    public Score() {
        this("anonymous", 0);
    }
    
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
    
    @Override
    public int compareTo(Score o) {
        return o.score - this.score;
    }

    @Override
    public String toString() {
        return this.username + ", score: " + this.score;
    }
    
}
