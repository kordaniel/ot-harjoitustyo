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
    
    /**
     * All classes that extend this class must implement this method.
     * 
     * The methods in this abstract class that fetches data from the
     * database uses this method to create objects of the correct type
     * from the rows in the database.
     * @param resultSet containing the rows data.
     * @return Object of type T, decided by the extending class.
     */
    public abstract T createFromRow(ResultSet resultSet);
    
    /**
     * All classes that extend this class must implement this method.
     * 
     * This method is used by all the methods in this abstract class that
     * inserts data into the database. They use this abstract method to
     * create PreparedStatement objects based on the objects of type T,
     * decided by the extending class.
     * @param object of type T that is to be saved.
     * @param conn Connection to database.
     * @return PreparedStatement containing the fields to be saved.
     * @throws SQLException when error in DB-connection.
     */
    public abstract PreparedStatement createInsertStatement(T object,
            Connection conn) throws SQLException;
    
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
            System.err.println("Error when trying to delete all rows from "
                    + tableName + ". Exception: " + e.getMessage());
        }
    }
    
    @Override
    public void saveAll(List<T> scores) {
        deleteAll();
        
        try (Connection connection = database.getConnection()) {
            PreparedStatement stmt = null;
            for (T score : scores) {
                stmt = createInsertStatement(score, connection);

                if (stmt != null) {
                    stmt.executeUpdate();
                }
            }
        } catch (SQLException e) {
            System.err.println("Error when trying to save scores to table: "
                    + tableName + ". Exception: " + e.getMessage());
        }
    }

}
