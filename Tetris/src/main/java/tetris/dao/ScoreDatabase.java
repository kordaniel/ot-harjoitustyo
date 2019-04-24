package tetris.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ScoreDatabase {
    
    private String databaseAddress;
    
    public ScoreDatabase(String databaseAddress) {
        
        this.databaseAddress = "jdbc:sqlite:" + databaseAddress;
        createTable();
    }
    
    private void createTable() {
        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS Score"
                    + " (id integer PRIMARY KEY, name varchar(16), score integer)"
            );
            stmt.executeUpdate();
            System.out.println("db+table created");
        } catch (SQLException e) {
            System.out.println("ERROR initializing score db: " + e.getMessage());
        }
    }
    
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(databaseAddress);
    }
    
}
