package tetris.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tetris.database.Database;
import tetris.domain.Score;

public class ScoreDao extends AbstractIdObjectDao<Score>{

    public ScoreDao(Database database, String tableName) {
        super(database, tableName);
        createTableIfNeeded();
    }

    @Override
    public Score createFromRow(ResultSet resultSet) {
        try {
            return new Score(resultSet.getInt("id"),
                    resultSet.getString("name"), resultSet.getInt("score"));
        } catch (SQLException e) {
            System.err.println("Error trying to create a new score "
                    + "with data from db. Exception: " + e.getMessage());
            return null;
        }
    }
    
    private void createTableIfNeeded() {
        try (Connection conn = database.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS " + tableName
                    + " (id integer PRIMARY KEY, name varchar(16), score integer)"
            );
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error when trying to create table: "
                    + tableName + ". Exception: " + e.getMessage());
        }
    }
    
}
