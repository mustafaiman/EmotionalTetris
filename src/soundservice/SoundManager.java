package soundservice;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;

/**
 * Created by ayhun on 2.5.2015.
 */
public class SoundManager{
    private static MediaPlayer mp;
    private static String currentPlayMode = "neutral";
    private static String neutralPath       = "sound files/neutral";
    private static String frustratedPath    = "sound files/frustrated";
    private static String boredPath         = "sound files/bored";
    private static String peacefulPath      = "sound files/peaceful";
    private static String joyPath           = "sound files/joy";
    private static boolean playing = false;
    private static boolean turned_on = true;

    public static void playNeutral(){
        if(currentPlayMode.equals("neutral") && (mp != null) && playing) return;
        if (!turned_on) return;
        currentPlayMode = "neutral";
        File[] normal = getTracks(neutralPath);
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
        mp.setOnEndOfMedia(() -> SoundManager.playNeutral());
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

    public static void playJoy() {
        if(currentPlayMode.equals("joy") && (mp != null) && playing)return;
        if (!turned_on) return;
        currentPlayMode = "joy";
        File[] joy = getTracks(joyPath);
        URI song = joy[(int) (Math.random()*joy.length)].toURI();
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
        mp.setOnEndOfMedia(() -> SoundManager.playJoy());
        mp.play();
    }

    public static void playBored() {
        if(currentPlayMode.equals("bored") && (mp != null) && playing)return;
        if (!turned_on) return;
        currentPlayMode = "bored";
        File[] bored = getTracks(boredPath);
        URI song = bored[(int) (Math.random()*bored.length)].toURI();
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
        mp.setOnEndOfMedia(() -> SoundManager.playBored());
        mp.play();
    }

    public static void playPeaceful() {
        if(currentPlayMode.equals("peaceful") && (mp != null) && playing)return;
        if (!turned_on) return;
        currentPlayMode = "peaceful";
        File[] peaceful = getTracks(peacefulPath);
        URI song = peaceful[(int) (Math.random()*peaceful.length)].toURI();
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
        mp.setOnEndOfMedia(() -> SoundManager.playPeaceful());
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
            playNeutral();
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
