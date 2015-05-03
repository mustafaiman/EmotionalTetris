package soundservice;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

/**
 * Created by ayhun on 2.5.2015.
 */
public class SoundManager{
    private static MediaPlayer mp;
    private static String currentPlayMode = "normal";
    private static String normalPath = "sound files/normal";
    private static String frustratedPath = "sound files/frustrated";
    private static String victorySong = "sound files/Victory.mp3";
    private static boolean playing = false;
    private static boolean turned_on = true;

    public static void playNormal(){
        if(currentPlayMode.equals("normal") && (mp != null) && playing) return;
        if (!turned_on) return;
        currentPlayMode = "normal";
        File[] normal = getTracks(normalPath);
        URI song = normal[(int) (Math.random()*normal.length)].toURI();
        Media hit = new Media(song.toString());
        if(mp == null)
            mp = new MediaPlayer(hit);
        else{
            mp.stop();
            mp = new MediaPlayer(hit);
        }
        mp.setOnPlaying(() -> playing = true);
        mp.setOnStopped(() -> playing = false);
        mp.setOnError(() -> playing = false);
        mp.setOnEndOfMedia(() -> SoundManager.playNormal());
        mp.play();
    }

    public static void playFrustrated(){
        if(currentPlayMode.equals("frustrated") && (mp != null) && playing)return;
        if (!turned_on) return;
        currentPlayMode = "frustrated";
        File[] frustrated = getTracks(frustratedPath);
        URI song = frustrated[(int) (Math.random()*frustrated.length)].toURI();
        Media hit = new Media(song.toString());
        if(mp == null)
            mp = new MediaPlayer(hit);
        else{
            mp.stop();
            mp = new MediaPlayer(hit);
        }
        mp.setOnPlaying(() -> playing = true);
        mp.setOnStopped(() -> playing = false);
        mp.setOnError(() -> playing = false);
        mp.setOnEndOfMedia(() -> SoundManager.playFrustrated());
        mp.play();
    }

    public static void playVictory() {
        if (currentPlayMode.equals("victory") && (mp != null) && playing) return;
        if (!turned_on) return;
        currentPlayMode = "victory";
        Media hit = new Media(new File(victorySong).getAbsolutePath());
        if (mp == null)
            mp = new MediaPlayer(hit);
        else {
            mp.stop();
            mp = new MediaPlayer(hit);
        }
        mp.setOnPlaying(() -> playing = true);
        mp.setOnStopped(() -> playing = false);
        mp.setOnError(() -> playing = false);
        mp.setOnEndOfMedia(() -> SoundManager.playVictory());
        mp.play();
    }

    public static void stop(){
        if ((mp != null) && playing) {
            playing = false;
            mp.stop();
        }
    }

    public static void toggle(){
        if (!turned_on) {
            turned_on = true;
            playNormal();
        } else {
            turned_on = false;
            stop();
        }
    }


    private static File[] getTracks(String directory) {
        File dir = new File(directory);
        File[] a = dir.listFiles();
        ArrayList<File> list = new ArrayList<File>();
        for (File f : a) {
            if (f.getName().endsWith(".mp3")) {
                list.add(f);
            }
        }
        File[] ret = new File[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
