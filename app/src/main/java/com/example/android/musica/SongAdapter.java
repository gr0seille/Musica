package com.example.android.musica;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

//We make the adapter
public class SongAdapter extends ArrayAdapter<Song> {

    //we make a list of songs to display
    public SongAdapter(Context context, List<Song> songs) {
        super(context, 0, songs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //convertView is null if we must create it,
        if(convertView == null){
            //We fetch our row of song (layout) through a LayoutInflater,
            //its job is to put the song.xml into a View object
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.song,parent, false);
        }

        SongViewHolder viewHolder = (SongViewHolder) convertView.getTag();
        if(viewHolder == null){
            //If it's empty then we create a new ViewHolder
            viewHolder = new SongViewHolder();
            viewHolder.songName = (TextView) convertView.findViewById(R.id.songName);
            viewHolder.artist = (TextView) convertView.findViewById(R.id.artist);
            viewHolder.album = (ImageView) convertView.findViewById(R.id.album);
            viewHolder.songId = (TextView) convertView.findViewById(R.id.songId);

            convertView.setTag(viewHolder);
        }

        //We get the item position into the list of songs
        Song song = getItem(position);

        //we fill it with the correct data
       // viewHolder.songId.setText(song.getSongId());
        viewHolder.songId.setText(String.valueOf(song.getSongId()));
        viewHolder.songName.setText(song.getSongName());
        viewHolder.artist.setText(song.getArtist());
        viewHolder.album.setImageResource(song.getAlbum());



        //we send back the view to the adapter so that it could display it
        //and recycle it once it's out of sight

        return convertView;
    }

    private class SongViewHolder{
        public TextView songName;
        public TextView artist;
        public ImageView album;
        public TextView songId;
    }
}