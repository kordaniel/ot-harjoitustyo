package tetris.domain;

import tetris.Constants;

public class Score extends AbstractIdObject implements Comparable<Score> {
    
    private String name;
    private int score;

    public Score(Integer id, String name, int score) {
        super(id);
        this.name = name;
        this.score = score;
    }

    public Score() {
        this(null, Constants.DEFAULT_ANON_PLAYER_NAME, 0);
    }
    
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public boolean isHigher(Score other) {
        return compareTo(other) < 0;
    }
    
    @Override
    public int compareTo(Score other) {
        return other.score - this.score;
    }

    @Override
    public String toString() {
        return this.name + ", score: " + this.score;
    }
    
}
