package com.example.nishantgarg.miwok;

public class Word {
    private String mMiwokTranslation;
    private String mEnglishTranslation;
    private int mImageViewID;
    boolean isImagePresent;
    private int AudioID;

    public Word(String miwok, String english, int audioID){
        mMiwokTranslation=miwok;
        mEnglishTranslation=english;
        isImagePresent=false;
        AudioID=audioID;
    }

    Word(String miwok, String english, int Image, int audioID){
        mMiwokTranslation=miwok;
        mEnglishTranslation=english;
        mImageViewID=Image;
        isImagePresent=true;
        AudioID=audioID;
    }

    String getmEnglishTranslation() {
        return mEnglishTranslation;
    }

    String getmMiwokTranslation() {
        return mMiwokTranslation;
    }

    int getmImageViewID() {
        return mImageViewID;
    }

    public int getAudioID() {
        return AudioID;
    }
}
