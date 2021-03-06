package com.bignerdranch.android.criminalintent;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * Created by albus on 20-Oct-17.
 */

public class Crime {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private Calendar mTime;
    private boolean mSolved;
    private String mSuspect;

    public String getSuspect() {
        return mSuspect;
    }

    public void setSuspect(String suspect) {
        mSuspect = suspect;
    }

    public Crime() {
        this(UUID.randomUUID());
    }

    public Crime(UUID id) {
        mId = id;
        mDate = new Date();
    }


    public UUID getId() {
        return mId;
    }

    public String getTitle() {

        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public void setTime(Calendar time) {
        mTime.set(Calendar.HOUR_OF_DAY, time.get(Calendar.HOUR_OF_DAY));
        mTime.set(Calendar.MINUTE, time.get(Calendar.MINUTE));
    }
    public String getTimeString() {
        return android.text.format.DateFormat.format("hh:mm a", mTime).toString();
    }

    public String getPhotoFilename(){
        return "IMG_"+ getId().toString() + ".jpg";
    }

}
