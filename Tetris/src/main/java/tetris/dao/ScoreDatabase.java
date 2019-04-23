package tetris.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ScoreDatabase {
    
    private String databaseAddress;

    public ScoreDatabase(String databaseAddress) {
        this.databaseAddress = databaseAddress;
    }
    
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:" + databaseAddress);
    }
    
}
