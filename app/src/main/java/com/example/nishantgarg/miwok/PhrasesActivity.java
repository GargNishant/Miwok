package com.example.nishantgarg.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends Activity {
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        ListView ParentView=(ListView)findViewById(R.id.list);

        final ArrayList<Word> words=new ArrayList<Word>();
        words.add(new Word("Miwok1","English1",R.raw.phrase_are_you_coming));
        words.add(new Word("Miwok2","English2",R.raw.phrase_come_here));
        words.add(new Word("Miwok3","English3",R.raw.phrase_how_are_you_feeling));
        words.add(new Word("Miwok4","English4",R.raw.phrase_im_coming));
        words.add(new Word("Miwok5","English5",R.raw.phrase_im_feeling_good));
        words.add(new Word("Miwok6","English6",R.raw.phrase_lets_go));
        words.add(new Word("Miwok7","English7",R.raw.phrase_my_name_is));
        words.add(new Word("Miwok8","English8",R.raw.phrase_what_is_your_name));
        words.add(new Word("Miwok9","English9",R.raw.phrase_where_are_you_going));

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
                mediaPlayer= MediaPlayer.create(PhrasesActivity.this,word.getAudioID());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }
}
