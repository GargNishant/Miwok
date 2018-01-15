package com.example.nishantgarg.miwok;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Nishant Garg on 18-11-2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    MediaPlayer mediaPlayer;

    public WordAdapter( Context context, int resource,  List<Word> objects) {
        super(context, resource, objects);
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        View itemlistView=convertView;
        MediaPlayer mediaPlayer;
        if(itemlistView==null){
            itemlistView=LayoutInflater.from(getContext()).inflate(R.layout.word_list,parent,false);
        }
        Word currentWord=getItem(position);

        TextView nameTextView = (TextView) itemlistView.findViewById(R.id.MiwokID);
        nameTextView.setText(currentWord.getmMiwokTranslation());
        TextView nameText = (TextView) itemlistView.findViewById(R.id.EnglishID);
        nameText.setText(currentWord.getmEnglishTranslation());
        ImageView image = (ImageView) itemlistView.findViewById(R.id.ImageViewID);
        image.setImageResource(currentWord.getmImageViewID());
        if(currentWord.isImagePresent) {
            image.setVisibility(View.VISIBLE);
        }
        else if(!currentWord.isImagePresent){
            image.setVisibility(View.GONE);
        }
        return itemlistView;
    }
}