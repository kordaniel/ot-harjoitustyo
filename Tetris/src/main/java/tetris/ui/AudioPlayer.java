package tetris.ui;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import tetris.Constants;
import tetris.resources.ResourceLoader;

public class AudioPlayer {

    private Media music;
    private MediaPlayer sfxBackgroundMusic;
    private ResourceLoader resources;

    public AudioPlayer(ResourceLoader resources) {
        this.resources = resources;

        this.music = new Media(this.resources.getBackgroundMusicURI());
        this.sfxBackgroundMusic = new MediaPlayer(music);
        
        this.sfxBackgroundMusic.setVolume(Constants.DEFAULT_BG_MUSIC_VOLUME);
        
        this.sfxBackgroundMusic.setStartTime(Duration.seconds(0));
        this.sfxBackgroundMusic.setStopTime(this.music.getDuration());
        
        this.sfxBackgroundMusic.setAutoPlay(true);
        this.sfxBackgroundMusic.setCycleCount(MediaPlayer.INDEFINITE);
        
        this.sfxBackgroundMusic.play();
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
        if (sfxBackgroundMusic.getStatus() != MediaPlayer.Status.PAUSED) {
            sfxBackgroundMusic.pause();
        }
    }
}
