package tetris.domain;

import tetris.Constants;

/**
 * Class that holds the current users details.
 * @author DanielKor
 */
public class User {
    
    private String name;
    
    /**
     * Creates a new instance of this class.
     * @param name String name of user(player).
     */
    public User(String name) {
        this.name = name;
    }
    
    /**
     * Creates a new instance of this class with the default.
     * playername (which is considered as an anonymous player).
     */
    public User() {
        this(Constants.DEFAULT_ANON_PLAYER_NAME);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Helper method to check if player is anonymous or using a set name.
     * @return true, if username is default, false otherwise.
     */
    public boolean isAnonymous() {
        return name == null || name.equals(Constants.DEFAULT_ANON_PLAYER_NAME);
    }
}
