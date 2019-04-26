package tetris.domain;

import tetris.Constants;

public class User {
    
    private String name;
    private boolean isAnonymous;
    
    public User(String name) {
        this.name = name;
        this.isAnonymous = name == null || name.equals(Constants.DEFAULT_ANON_PLAYER_NAME);
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
    
    public boolean getIsAnonymous() {
        return this.isAnonymous;
    }
}
