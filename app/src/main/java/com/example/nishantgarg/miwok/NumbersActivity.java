package com.example.nishantgarg.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends Activity {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        ListView ParentView=(ListView)findViewById(R.id.list);

        final ArrayList<Word> words=new ArrayList<Word>();
        words.add(new Word("Miwok1","English1",R.mipmap.ic_launcher,R.raw.number_four));
        words.add(new Word("Miwok2","English2",R.mipmap.ic_launcher,R.raw.number_ten));
        words.add(new Word("Miwok3","English3",R.mipmap.ic_launcher,R.raw.number_one));
        words.add(new Word("Miwok4","English4",R.mipmap.ic_launcher,R.raw.number_four));
        words.add(new Word("Miwok5","English5",R.mipmap.ic_launcher,R.raw.number_seven));
        words.add(new Word("Miwok6","English6",R.mipmap.ic_launcher,R.raw.number_two));
        words.add(new Word("Miwok7","English7",R.mipmap.ic_launcher,R.raw.number_three));
        words.add(new Word("Miwok8","English8",R.mipmap.ic_launcher,R.raw.number_eight));
        words.add(new Word("Miwok9","English9",R.mipmap.ic_launcher,R.raw.number_nine));
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
            public void onItemClick(AdapterView<?> adapterView, View view, int positionOfItemClicked, long id) {
                Word word= words.get(positionOfItemClicked);
                if(mediaPlayer!=null){
                    mediaPlayer.release();
                    mediaPlayer=null;
                }
                mediaPlayer= MediaPlayer.create(NumbersActivity.this,word.getAudioID());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }
}