package tetris.resources;

public class ResourceLoader {
    
    private final String backgroundMusicURI;

    public ResourceLoader() {
        backgroundMusicURI = getClass().getResource("/sounds/bg_music.wav").toString();
    }
    
    public String getBackgroundMusicURI() {
        return backgroundMusicURI;
    }
    
}
