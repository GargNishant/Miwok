package com.example.nishantgarg.miwok.Fragments;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nishantgarg.miwok.Activities.FamilyActivity;
import com.example.nishantgarg.miwok.Helper.Word;
import com.example.nishantgarg.miwok.Helper.WordAdapter;
import com.example.nishantgarg.miwok.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FamilyFragment extends Fragment {
    MediaPlayer mediaPlayer;


    public FamilyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View rootView = inflater.inflate(R.layout.activity_category,container,false);

        ListView ParentView=(ListView)rootView.findViewById(R.id.list);

        final ArrayList<Word> words=new ArrayList<Word>();
        words.add(new Word(getString(R.string.miwok_family_daughter),getString(R.string.family_daughter),
                R.drawable.family_daughter,R.raw.family_daughter));
        words.add(new Word(getString(R.string.miwok_family_father),getString(R.string.family_father),
                R.drawable.family_father,R.raw.family_father));
        words.add(new Word(getString(R.string.miwok_family_grandfather),getString(R.string.family_grandfather),
                R.drawable.family_grandfather,R.raw.family_grandfather));
        words.add(new Word(getString(R.string.miwok_family_grandmother),getString(R.string.family_grandmother),
                R.drawable.family_grandmother,R.raw.family_grandmother));
        words.add(new Word(getString(R.string.family_mother),getString(R.string.miwok_family_mother),
                R.drawable.family_mother,R.raw.family_mother));
        words.add(new Word(getString(R.string.miwok_family_older_brother),getString(R.string.family_older_brother),
                R.drawable.family_older_brother,R.raw.family_older_brother));
        words.add(new Word(getString(R.string.miwok_family_older_sister),getString(R.string.family_older_sister),
                R.drawable.family_older_sister,R.raw.family_older_sister));
        words.add(new Word(getString(R.string.miwok_family_son),getString(R.string.family_son),
                R.drawable.family_son,R.raw.family_son));
        words.add(new Word(getString(R.string.miwok_family_younger_brother),getString(R.string.family_younger_brother),
                R.drawable.family_younger_brother,R.raw.family_younger_brother));

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
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word= words.get(i);
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
