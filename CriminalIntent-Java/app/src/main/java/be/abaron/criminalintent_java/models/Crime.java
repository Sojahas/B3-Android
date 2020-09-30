package be.abaron.criminalintent_java.models;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Crime {


    //Attributs
    UUID mID;
    String mTitle;
    Date mDate;
    boolean mSolved;

    public Crime() {
        this.mID = UUID.randomUUID();
        today();
    }

    @SuppressLint("SimpleDateFormat")
    public void today() {
        mDate = new Date();
        new SimpleDateFormat("dd-MM-yyyy").format(mDate);
    }

    public UUID getID() {
        return mID;
    }

    public String getTitle() {
        return mTitle;
    }

    public Date getDate() {
        return mDate;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }

    public void setSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }
}
