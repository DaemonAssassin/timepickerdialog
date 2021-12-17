package com.gmail.mateendev3.timepickerdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {
    Button btnSetTime;
    TextView tvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSetTime = findViewById(R.id.btn_set_time);
        tvTime = findViewById(R.id.tv_time);

        btnSetTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /*
               //Ya yay karlo
                DialogFragment dialog = new MyTimePicker();
                dialog.show(getSupportFragmentManager(), "CHOOSE_TIME");



                //Ya yay karlo
                TimePickerDialog dialog1 = showTimePickerDialog();
                dialog1.show();
                */

                //2nd Try with implementation of OnTimeSetListener in mainActivity
                MyTimePickerDialog dialog = new MyTimePickerDialog();
                dialog.show(getSupportFragmentManager(), "SHOW_TIME_PICKER");
            }
        });
    }

    private TimePickerDialog showTimePickerDialog() {

        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);

        TimePickerDialog dialog = new TimePickerDialog(
                MainActivity.this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tvTime.setText("Time: " + hourOfDay + ":" + minute);
                    }
                },
                hour,
                min,
                DateFormat.is24HourFormat(MainActivity.this)
        );

        return dialog;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        tvTime.setText("Time:: " + hourOfDay + ":" + minute);
    }
}