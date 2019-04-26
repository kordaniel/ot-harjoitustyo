package tetris.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    
    private String databaseAddress;
    
    public Database(String databaseAddress) {
        this.databaseAddress = "jdbc:sqlite:" + databaseAddress;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(databaseAddress);
    }
    
}
