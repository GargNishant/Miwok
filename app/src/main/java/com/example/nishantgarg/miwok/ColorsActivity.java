package com.example.nishantgarg.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends Activity {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        ListView ParentView=(ListView)findViewById(R.id.list);

        final ArrayList<Word> words=new ArrayList<Word>();
        words.add(new Word(getString(R.string.miwok_color_black),getString(R.string.color_black),
                R.drawable.color_black,R.raw.color_black));
        words.add(new Word(getString(R.string.miwok_color_brown),getString(R.string.color_brown),
                R.drawable.color_brown,R.raw.color_brown));
        words.add(new Word(getString(R.string.miwok_color_dusty_yellow),getString(R.string.color_dusty_yellow),
                R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        words.add(new Word(getString(R.string.miwok_color_gray),getString(R.string.color_gray),
                R.drawable.color_gray,R.raw.color_gray));
        words.add(new Word(getString(R.string.miwok_color_green),getString(R.string.color_green),
                R.drawable.color_green,R.raw.color_green));
        words.add(new Word(getString(R.string.miwok_color_mustard_yellow),getString(R.string.color_mustard_yellow),
                R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));
        words.add(new Word(getString(R.string.miwok_color_red),getString(R.string.color_red),
                R.drawable.color_red,R.raw.color_red));
        words.add(new Word(getString(R.string.miwok_color_white),getString(R.string.color_white),
                R.drawable.color_white,R.raw.color_white));
        words.add(new Word(getString(R.string.miwok_color_black),getString(R.string.color_black),
                R.drawable.color_black,R.raw.color_black));

        WordAdapter wordAdapter=new WordAdapter(this,0,words);
        ParentView.setAdapter(wordAdapter);

        final MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                // Now that the sound file has finished playing, release the media player resources.
                if(mediaPlayer!=null){
                    mediaPlayer.release();
                    mediaPlayer=null;
                }
            }
        };

        ParentView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word= words.get(i);
                if(mediaPlayer!=null){
                    mediaPlayer.release();
                    mediaPlayer=null;
                }
                mediaPlayer= MediaPlayer.create(ColorsActivity.this,word.getAudioID());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }
}
