package com.example.android.musica;

import android.app.Activity;
import android.graphics.Color;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tracklist);
        mListView = (ListView) findViewById(R.id.songList);

        List<Song> songs = buildSongs();

        SongAdapter adapter = new SongAdapter(MainActivity.this, songs);
        mListView.setAdapter(adapter);
    }

    private List<Song> buildSongs(){
        List<Song> songs = new ArrayList<Song>();
        songs.add(new Song(333, "Florent", "Mon premier tweet !", R.drawable.album1));
        songs.add(new Song(333, "Kevin", "C'est ici que ça se passe !", R.drawable.album2));
        songs.add(new Song(333, "Logan", "Que c'est beau...",R.drawable.album3));
        songs.add(new Song(333, "Mathieu", "Il est quelle heure ??",R.drawable.album4));
        songs.add(new Song(333, "Willy", "On y est presque",R.drawable.album1));
        return songs;
    }


    //Elements related to the player
    public void launchPlayer(View v) {
        setContentView(R.layout.player);

        //make full transparent statusBar
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }


        int res = R.drawable.progressgradient;

        ProgressBar myProgressBar = (ProgressBar) findViewById(R.id.time);
        myProgressBar.setProgressDrawable(getResources().getDrawable(res));

    }

    public static void setWindowFlag(Activity activity, final int bits, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }
}