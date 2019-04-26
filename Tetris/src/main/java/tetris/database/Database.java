package tetris.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class that holds one database address and provides and Connection
 * to it, currently only sqlite3 databases.
 * @author DanielKor
 */
public class Database {
    
    private String databaseAddress;
    
    /**
     * Constructs an new instance of this class.
     * @param databaseAddress name of used database file.
     */
    public Database(String databaseAddress) {
        this.databaseAddress = "jdbc:sqlite:" + databaseAddress;
    }

    /**
     * Method that provides the connection to the used database.
     * @return Connection to sqlite3 database.
     * @throws SQLException 
     */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(databaseAddress);
    }
    
}
