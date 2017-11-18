package com.bignerdranch.android.criminalintent;


import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * Created by albus on 18-Nov-17.
 */

public class ZoomDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setTitle("Image Preview")
                .setPositiveButton("Ok",null)
                .create();
    }
}
