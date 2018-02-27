package com.example.nishantgarg.miwok.Fragments;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.nishantgarg.miwok.Helper.Word;
import com.example.nishantgarg.miwok.Helper.WordAdapter;
import com.example.nishantgarg.miwok.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumbersFragment extends Fragment {
    MediaPlayer mediaPlayer;
    public NumbersFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_numbers,container,false);

        ListView ParentView=(ListView)rootView.findViewById(R.id.list);

        final ArrayList<Word> words=new ArrayList<Word>();

        words.add(new Word(getString(R.string.miwok_number_one),getString(R.string.number_one),
                R.drawable.number_one,R.raw.number_one));
        words.add(new Word(getString(R.string.miwok_number_two),getString(R.string.number_two),
                R.drawable.number_two,R.raw.number_two));
        words.add(new Word(getString(R.string.miwok_number_three),getString(R.string.number_three),
                R.drawable.number_three,R.raw.number_three));
        words.add(new Word(getString(R.string.miwok_number_four),getString(R.string.number_four),
                R.drawable.number_four,R.raw.number_four));
        words.add(new Word(getString(R.string.miwok_number_five),getString(R.string.number_five),
                R.drawable.number_five,R.raw.number_five));
        words.add(new Word(getString(R.string.miwok_number_six),getString(R.string.number_six),
                R.drawable.number_six,R.raw.number_six));
        words.add(new Word(getString(R.string.miwok_number_seven),getString(R.string.number_seven),
                R.drawable.number_seven,R.raw.number_seven));
        words.add(new Word(getString(R.string.miwok_number_eight),getString(R.string.number_eight),
                R.drawable.number_eight,R.raw.number_eight));
        words.add(new Word(getString(R.string.miwok_number_nine),getString(R.string.number_nine),
                R.drawable.number_nine,R.raw.number_nine));
        words.add(new Word(getString(R.string.miwok_number_ten),getString(R.string.number_ten),
                R.drawable.number_ten,R.raw.number_ten));


        WordAdapter wordAdapter=new WordAdapter(getActivity(),0,words);
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
                mediaPlayer= MediaPlayer.create(getActivity(),word.getAudioID());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        if(mediaPlayer!=null){
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }

}
