package domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.Constants;
import tetris.domain.User;

public class UserTest {
    
    User user;
    
    public UserTest() {
    }
    
    @Before
    public void setUp() {
        user = new User();
    }
    
    @Test
    public void constructedUserHasDefaultAnonymousName() {
        assertEquals(Constants.DEFAULT_ANON_PLAYER_NAME, user.getName());
    }
    
    @Test
    public void constructedUserIsAnonymous() {
        assertTrue(user.isAnonymous());
    }
    
    @Test
    public void constructedWithNameAsNullIsAnonymous() {
        User userobject = new User(null);
        assertTrue(userobject.isAnonymous());
    }
    
    @Test
    public void userNameCanBeChanged() {
        String name = "NotDefault";
        user.setName(name);
        assertEquals(name, user.getName());
    }
    
    @Test
    public void userIsNotAnonymousWhenNameIsSet() {
        user.setName("Realname");
        assertFalse(user.isAnonymous());
    }
    
    @Test
    public void userCanBeConstructedWithAnName() {
        String name = "Playah";
        User namedUser = new User(name);
        assertEquals(name, namedUser.getName());
    }
    
    @Test
    public void whenConstructedWithNameIsNotAnonymous() {
        String name = "Playah";
        User namedUser = new User(name);
        assertFalse(namedUser.isAnonymous());
    }
    
    @Test
    public void ifNameIsSetToDefaultUserIsAnonymous() {
        User userobject = new User("Playah");
        userobject.setName(Constants.DEFAULT_ANON_PLAYER_NAME);
        assertTrue(userobject.isAnonymous());
    }
    
}
