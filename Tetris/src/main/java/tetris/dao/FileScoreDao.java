package tetris.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileScoreDao implements ScoreDao {

    private String file;

    public FileScoreDao() throws IOException {
        this.file = "scores.txt";
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] lineParts = reader.nextLine().split(";");
                String name = lineParts[0];
                String score = lineParts[1];
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            System.out.println("ALL INFO: " + e);
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
    }
    
    @Override
    public List<String> getAll() {
        List<String> scoreList = new ArrayList<>();
        scoreList.add("123");
        scoreList.add("321");
        scoreList.add("tekstiä");
        
        return scoreList;
    }
    
}
