package tetris.domain;

import tetris.Constants;

public class User {
    
    private String name;
    
    public User(String name) {
        this.name = name;
    }
    
    public User() {
        this(Constants.DEFAULT_ANON_PLAYER_NAME);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public boolean isAnonymous() {
        return name == null || name.equals(Constants.DEFAULT_ANON_PLAYER_NAME);
    }
}
