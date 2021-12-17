package com.gmail.mateendev3.timepickerdialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.DrawableRes;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class MyTimePicker extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);

        TimePickerDialog pickerDialog =
                new TimePickerDialog(
                        requireActivity(),
                        this,
                        hour,
                        min,
                        DateFormat.is24HourFormat(requireActivity())
                );

        return pickerDialog;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        TextView tvTime = requireActivity().findViewById(R.id.tv_time);
        tvTime.setText("Time: " + hourOfDay + ":" + minute);
    }
}
