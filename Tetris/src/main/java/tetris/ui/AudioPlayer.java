package tetris.ui;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import tetris.Constants;

public class AudioPlayer {
    
    Media music;
    MediaPlayer sfxBackgroundMusic;

    public AudioPlayer() {
        this.music = new Media(
                Constants.FILE_BG_MUSIC.toURI().toString());
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
