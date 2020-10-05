package id.ac.ui.cs.mobileprogramming.andriansyah.helloworld;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;
import androidx.annotation.Nullable;

public class BackgroundMusicService extends Service {
    MediaPlayer mediaPlayer;
    private Toast musicToast;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        mediaPlayer.setLooping(true); // Set looping
        mediaPlayer.setVolume(100, 100);
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();
        if(musicToast != null){
            musicToast.cancel();
        }
        musicToast = Toast.makeText(getApplicationContext(), "Playing music", Toast.LENGTH_SHORT);
        musicToast.show();
        return startId;
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        mediaPlayer.release();
        if(musicToast != null){
            musicToast.cancel();
        }
        musicToast = Toast.makeText(this, "Music is stopped", Toast.LENGTH_SHORT);
        musicToast.show();
    }
}
