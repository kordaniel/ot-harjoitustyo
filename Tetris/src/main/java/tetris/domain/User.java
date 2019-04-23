package tetris.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    
    private String name;
    private List<Score> scores;
    private boolean isAnonymous;
    
    public User(String name) {
        this.name = name;
        this.scores = new ArrayList<>();
        if (name != null && !name.equals("anonymous")) {
            this.isAnonymous = false;
        } else {
            this.isAnonymous = true;
        }
    }
    
    public User() {
        this("anonymous");
    }
}
