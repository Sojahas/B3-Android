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

    public UUID getmID() {
        return mID;
    }

    public String getmTitle() {
        return mTitle;
    }

    public Date getmDate() {
        return mDate;
    }

    public boolean ismSolved() {
        return mSolved;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public void setmSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }
}
