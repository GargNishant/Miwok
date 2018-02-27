package com.example.nishantgarg.miwok.Helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nishantgarg.miwok.R;

import java.util.List;

/**
 * Created by Nishant Garg on 18-11-2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter( Context context, int resource,  List<Word> objects) {
        super(context, resource, objects);
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        View itemListView=convertView;
        if(itemListView==null){
            itemListView=LayoutInflater.from(getContext()).inflate(R.layout.word_list,parent,false);
        }
        Word currentWord=getItem(position);

        TextView nameTextView = (TextView) itemListView.findViewById(R.id.MiwokID);
        nameTextView.setText(currentWord.getmMiwokTranslation());
        TextView nameText = (TextView) itemListView.findViewById(R.id.EnglishID);
        nameText.setText(currentWord.getmEnglishTranslation());
        ImageView image = (ImageView) itemListView.findViewById(R.id.ImageViewID);
        image.setImageResource(currentWord.getmImageViewID());
        if(currentWord.isImagePresent) {
            image.setVisibility(View.VISIBLE);
        }
        else if(!currentWord.isImagePresent){
            image.setVisibility(View.GONE);
        }
        return itemListView;
    }
}