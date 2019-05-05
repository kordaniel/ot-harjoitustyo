package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.database.Database;
public class DatabaseTest {
    
    Database database;
    String dbAddress;
    
    public DatabaseTest() {
        dbAddress = "jdbc:sqlite::memory:";
    }
    
    @Before
    public void setUp() {
        database = new Database(dbAddress);
    }
    
    @Test
    public void databaseProvidesConnection() {
        Connection conn = null;
        try {
            conn = database.getConnection();
        } catch (SQLException e) {
            System.err.println("TEST ERROR CONNECTING TO DB: " + e.getMessage());
        }
        
        assertNotNull(conn);
    }
    
    @Test
    public void databaseCanBeReached() throws SQLException {
        ResultSet rs = null;
        int result = -99;
        
        try (Connection conn = database.getConnection()){
            rs = conn.prepareStatement("SELECT 1").executeQuery();
            rs.next();
            result = rs.getInt(1);
        } catch (SQLException e) {
            System.err.println("TEST ERROR CONNECTING TO DB: " + e.getMessage());
        }
        
        assertEquals(1, result);
    }
}
