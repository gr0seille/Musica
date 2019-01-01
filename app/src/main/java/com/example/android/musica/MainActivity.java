package com.example.android.musica;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

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
        TextView playerLauncher ;
        playerLauncher=(TextView) findViewById(R.id.launcher);
        playerLauncher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),PlayerActivity.class);
                startActivity(i);
            }
        });

        //set the listener to launch the playlist
        Button artistLauncher ;
        artistLauncher = (Button) findViewById(R.id.artistLauncher);
        artistLauncher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ArtistActivity.class);
                startActivity(i);
            }
        });
    }

    private List<Song> buildSongs(){
        List<Song> songs = new ArrayList<Song>();
        songs.add(new Song(1,333, "Florent", "Mon premier tweet !", R.drawable.album1));
        songs.add(new Song(2,333, "Kevin", "C'est ici que ça se passe !", R.drawable.album2));
        songs.add(new Song(3,333, "Logan", "Que c'est beau...",R.drawable.album3));
        songs.add(new Song(4,333, "Mathieu", "Il est quelle heure ??",R.drawable.album4));
        songs.add(new Song(5,333, "Willy", "On y est presque",R.drawable.album1));
        return songs;
    }
}
