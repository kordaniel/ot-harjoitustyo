package tetris.ui;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import tetris.Constants;
import tetris.resources.ResourceLoader;

public class AudioPlayer {
    
    private Media music;
    private MediaPlayer sfxBackgroundMusic;
    private ResourceLoader resources;

    public AudioPlayer(ResourceLoader resources) {
        this.resources = resources;
        
        this.music = new Media(this.resources.getBackgroundMusicURI());
        this.sfxBackgroundMusic  = new MediaPlayer(music);
        
        sfxBackgroundMusic.setCycleCount(Integer.MAX_VALUE);
        
        sfxBackgroundMusic.setVolume(Constants.DEFAULT_BG_MUSIC_VOLUME);
        sfxBackgroundMusic.play();
    }
    
    public void setBackgroundMusicVolume(double vol) {
        sfxBackgroundMusic.setVolume(vol);
    }
    
    public double getBackgroundMusicVolume() {
        return sfxBackgroundMusic.getVolume();
    }
    
    public void playBackgroundMusic() {
        if (sfxBackgroundMusic.getStatus() != MediaPlayer.Status.PLAYING) {
            sfxBackgroundMusic.play();
        }
    }
    
    public void stopBackgroundMusic() {
        sfxBackgroundMusic.stop();
    }
}
