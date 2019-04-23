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
            //try with resources, not needed?
            //stmt.close();
            //rs.close();
            
        } catch (SQLException e) {
            System.out.println("SQL exception occured while fetching scores: "
                + e.getMessage());
        }
        return allScores;
    }
    
}
