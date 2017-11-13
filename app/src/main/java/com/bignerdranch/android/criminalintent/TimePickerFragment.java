package com.bignerdranch.android.criminalintent;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by albus on 05-Nov-17.
 */

public class TimePickerFragment extends DialogFragment {

    private static final String ARG_DATE = "date";

    public static final String EXTRA_TIME = "com.bignerdranch.android.criminalIntent.time";

    private TimePicker mTimePicker;

    private Date mDate;

    public static TimePickerFragment newInstance(Date date){
        Bundle args = new Bundle();
        args.putSerializable(ARG_DATE, date);

        TimePickerFragment fragment = new TimePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mDate = (Date) getArguments().getSerializable(ARG_DATE);

        View v = LayoutInflater.from(getActivity())
                .inflate(R.layout.dialog_time,null);

        mTimePicker = (TimePicker) v.findViewById(R.id.dialog_time_picker);

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle("TIME OF CRIME")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        /*int hour = 0;
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                            hour = mTimePicker.getHour();
                        }else{
                            hour = mTimePicker.getCurrentHour();
                        }
                        int minute = 0;
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                            minute = mTimePicker.getMinute();
                        }else{
                            minute = mTimePicker.getCurrentMinute();
                        }
                         Date date = new GregorianCalendar(2017,12,1,hour,minute).getTime();

                        Calendar cal = Calendar.getInstance();
                        cal.setTime(date);
                        sendResult(Activity.RESULT_OK,cal);*/

                        Calendar cal = Calendar.getInstance();

                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                            cal.set(Calendar.HOUR_OF_DAY,mTimePicker.getHour());
                            cal.set(Calendar.MINUTE,mTimePicker.getMinute());
                            cal.set(Calendar.SECOND,0);
                            cal.set(Calendar.MILLISECOND,0);
                        }else{
                            cal.set(Calendar.HOUR_OF_DAY,mTimePicker.getCurrentHour());
                            cal.set(Calendar.MINUTE,mTimePicker.getCurrentMinute());
                            cal.set(Calendar.SECOND,0);
                            cal.set(Calendar.MILLISECOND,0);
                        }
                        mDate = cal.getTime();

                        sendResult(Activity.RESULT_OK,mDate);

                    }
                })
                .create();
    }

    private void sendResult(int resultCode, Date date) {
        if(getTargetFragment() == null){
            return;
        }

        Intent intent = new Intent();
        intent.putExtra(EXTRA_TIME,date);

        getTargetFragment().onActivityResult(getTargetRequestCode(),resultCode,intent);
    }
}
