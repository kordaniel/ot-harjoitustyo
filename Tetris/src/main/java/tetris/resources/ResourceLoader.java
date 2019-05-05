package tetris.resources;

/**
 * This class handles resources. Resources are placed inside the maven project
 * folder structure into src/main/resources. Maven packages these files
 * into the created executable jar-file. This class is used to create
 * URI:s that point to the correct file locations no matter where
 * the application is run from in the file structure or IDE.
 */
public class ResourceLoader {
    
    private final String backgroundMusicURI;

    public ResourceLoader() {
        backgroundMusicURI = getClass().getResource("/sounds/bg_music.wav").toString();
    }
    
    /**
     * 
     * @return String containing the correct file path for
     * the wav-file containing the background music.
     */
    public String getBackgroundMusicURI() {
        return backgroundMusicURI;
    }
    
}
