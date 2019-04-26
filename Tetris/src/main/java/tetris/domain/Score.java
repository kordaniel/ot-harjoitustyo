package tetris.domain;

public class Score extends AbstractIdObject implements Comparable<Score> {
    
    private String name;
    private int score;

    public Score(Integer id, String name, int score) {
        super(id);
        this.name = name;
        this.score = score;
    }

    public Score() {
        this(null, "anonymous", 0);
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
    
    @Override
    public int compareTo(Score o) {
        return o.score - this.score;
    }

    @Override
    public String toString() {
        return this.name + ", score: " + this.score;
    }
    
}
