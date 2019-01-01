package com.example.android.musica;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tracklist);
        mListView = (ListView) findViewById(R.id.songList);

        List<Song> songs = buildSongs();

        SongAdapter adapter = new SongAdapter(MainActivity.this, songs);
        mListView.setAdapter(adapter);
    }

    public void openPlayerActivity(View view) {
        Intent i = new Intent(this, playerActivity.class);
        startActivity(i);
    }

//    //add listener on button
//    public void addListenerOnButton() {
//
//        button = (Button) findViewById(R.id.launcher);
//
//        button.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View arg0) {
//
//                Intent browserIntent =
//                        new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.mkyong.com"));
//                startActivity(browserIntent);
//
//            }
//
//        });
//    }


    private List<Song> buildSongs() {
        List<Song> songs = new ArrayList<Song>();
        songs.add(new Song(1, 333, "Florent", "Mon premier tweet !", R.drawable.album1));
        songs.add(new Song(2,333, "Kevin", "C'est ici que ça se passe !", R.drawable.album2));
        songs.add(new Song(3,333, "Logan", "Que c'est beau...", R.drawable.album3));
        songs.add(new Song(4,333, "Mathieu", "Il est quelle heure ??", R.drawable.album4));
        songs.add(new Song(5,333, "Willy", "On y est presque", R.drawable.album1));
        return songs;
    }


}