package tetris.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tetris.domain.Score;

public class SqlScoreDao implements ScoreDao {
    
    private ScoreDatabase db;

    public SqlScoreDao(ScoreDatabase db) {
        this.db = db;
    }
    
    @Override
    public List<Score> getAll() {
        List<Score> allScores = new ArrayList<>();
        
        try (Connection conn = db.getConnection()) {
            
            PreparedStatement stmt =
                    conn.prepareStatement("SELECT * FROM Score");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                allScores.add(
                        new Score(rs.getString("name"), rs.getInt("score"))
                );
            }
        } catch (SQLException e) {
            System.out.println("SQL exception occured while fetching scores: "
                + e.getMessage());
        }
        
        return allScores;
    }

    @Override
    public void saveAll(List<Score> scores) {
        if (scores == null) {
            return;
        }
        deleteScores();
        
        try (Connection conn = db.getConnection()) {
            PreparedStatement stmt = null;
            for (Score score : scores) {
                stmt = conn.prepareStatement(
                        "INSERT INTO Score (name, score)"
                        + " values (?, ?)");
                stmt.setString(1, score.getUsername());
                stmt.setInt(2, score.getScore());
                stmt.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println("Error saving scores: " + e.getMessage());
        }
    }
    
    public void deleteScores() {
        try (Connection conn = db.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM Score");
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL Exception when deleting scores: " + e.getMessage());
        }
    }
    
}
