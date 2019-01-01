package com.example.android.musica;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

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

        //set the listener to launch the player
        ImageView playerLauncher ;
        playerLauncher=(ImageView) findViewById(R.id.launcher);
        playerLauncher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ArtistActivity.class);
                startActivity(i);
            }
        });

        //set the listener to launch the playlist
        Button artistLauncher ;
        artistLauncher = (Button) findViewById(R.id.artistLauncher);
        artistLauncher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),PlayerActivity.class);
                startActivity(i);
            }
        });

    }

    private List<Song> buildSongs(){
        List<Song> songs = new ArrayList<Song>();
        songs.add(new Song(1,333, "Hit sale", "Thérapie taxi", R.drawable.album1));
        songs.add(new Song(2,333, "Aerials", "System of a down", R.drawable.album2));
        songs.add(new Song(3,333, "Feel it still", "Portugal. The man",R.drawable.album3));
        return songs;
    }
}
