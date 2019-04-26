package tetris.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tetris.database.Database;
import tetris.domain.AbstractIdObject;

public abstract class AbstractIdObjectDao<T extends AbstractIdObject>
        implements Dao<T, Integer> {
    
    protected Database database;
    protected String tableName;
    
    public AbstractIdObjectDao(Database database, String tableName) {
        this.database = database;
        this.tableName = tableName;
    }
    
    public abstract T createFromRow(ResultSet resultSet);
    
    @Override
    public T findOne(Integer key) {
        try (Connection conn = database.getConnection()) {
            PreparedStatement stmt =
                    conn.prepareStatement("SELECT * FROM "
                            + tableName + " WHERE id = ?");
            stmt.setInt(1, key);
            ResultSet rs = stmt.executeQuery();
            return createFromRow(rs);
        } catch (SQLException e) {
            System.err.println("Error when looking for a row in "
                    + tableName + " with id " + key + ". Exception: "
                    + e.getMessage());
            return null;
        }
    }
    
    @Override
    public List<T> findAll() {
        List<T> scores = new ArrayList<>();
        
        try (Connection conn = database.getConnection()) {
            PreparedStatement stmt =
                    conn.prepareStatement("SELECT * FROM " + tableName);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                scores.add(createFromRow(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error when trying to get all rows from "
                    + tableName + ". Exception: " + e.getMessage());
        }
        
        return scores;
    }
    
    @Override
    public void deleteAll() {
        try (Connection conn = database.getConnection()) {
            PreparedStatement stmt =
                    conn.prepareStatement("DELETE FROM " + tableName);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error when trying to delete all rows from"
                    + tableName + ". Exception: " + e.getMessage());
        }
    }
    
    @Override
    public void delete(Integer key) {
        //
    }
    
    @Override
    public void saveAll(List<T> scores) {
        //
    }

}
