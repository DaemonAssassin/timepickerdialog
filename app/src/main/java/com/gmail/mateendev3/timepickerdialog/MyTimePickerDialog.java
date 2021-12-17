package com.gmail.mateendev3.timepickerdialog;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class MyTimePickerDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);

        TimePickerDialog dialog =
                new TimePickerDialog(requireActivity(),
                        (TimePickerDialog.OnTimeSetListener) getActivity(),
                        hour,
                        min,
                        DateFormat.is24HourFormat(getActivity()));

        return dialog;
    }
}
