package com.example.android.musica;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

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
        TextView playerLauncher ;
        playerLauncher=(TextView) findViewById(R.id.launcher);
        playerLauncher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),playerActivity.class);
                startActivity(i);
            }
        });
    }


    private List<Song> buildSongs() {
        List<Song> songs = new ArrayList<Song>();
        songs.add(new Song(1, 333, "Hit sale", "Thérapie taxi", R.drawable.album1));
        songs.add(new Song(2, 333, "Aerials", "C'est ici que ça se passe !", R.drawable.album2));
        songs.add(new Song(3, 333, "Feel it still", "Que c'est beau...", R.drawable.album3));
        songs.add(new Song(4, 333, "Un autre que moi", "Fishbach", R.drawable.album4));
        songs.add(new Song(5, 333, "Breezblocks", "Alt-J", R.drawable.album1));
        return songs;
    }


}