package com.example.dialogs;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnAlertDialog, btnTimePickerDialog, btnDatePickerDialog, btnLogoutDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListeners();

    }

    private void initViews() {
        btnAlertDialog = findViewById(R.id.btnAlertDialog);
        btnTimePickerDialog = findViewById(R.id.btnTimePickerDialog);
        btnDatePickerDialog = findViewById(R.id.btnDatePickerDialog);
        btnLogoutDialog = findViewById(R.id.btnLogoutDialog);

    }

    private void initListeners() {
        btnAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Exam form Submission");
                builder.setMessage("Are you sure you want to submit");
                builder.setIcon(R.drawable.ic_launcher_foreground);
                builder.setPositiveButton("Yes", new AlertDialogButtonListener());
                builder.setNegativeButton("No", new AlertDialogButtonListener());
                //builder.setNeutralButton("Okay",new NeutralButtonClickListener());

                //passing the object of anonymous class using dialog interface
                builder.setNeutralButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Neutral Btn Clicked " + which, Toast.LENGTH_LONG).show();
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });
        btnTimePickerDialog.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,new TimePickerDialogButtonListener(),11,34,true);
                timePickerDialog.show();
            }

            });
        btnDatePickerDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialogButtonListener(), 25, 05, 21);
                datePickerDialog.show();
            }
        });

        btnLogoutDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogoutDialog logoutDialog = new LogoutDialog(MainActivity.this);
                logoutDialog.setOnLogoutDialogClickListener(new LogoutDialogClickListener());
                logoutDialog.show();
            }
        });
    }

    class LogoutDialogClickListener implements LogoutDialog.OnLogoutDialogClickListener {
        @Override
        public void onSuccess() {
            Log.e("tag", "on Success");
            Toast.makeText(MainActivity.this, "Logout Successful!", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onFailure() {
            Log.e("tag", "on Failure");
            Toast.makeText(MainActivity.this, "Logout Failure!",Toast.LENGTH_SHORT).show();
        }
    }

    class TimePickerDialogButtonListener implements TimePickerDialog.OnTimeSetListener {

        @Override
        public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
            Log.e("tag", "time picker" + timePicker + " " + hourOfDay + " " + minute);
        }
    }

    class DatePickerDialogButtonListener implements DatePickerDialog.OnDateSetListener {

        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
            Log.e("tag", "date picker" + datePicker + " " + year + " " + month + " " + dayOfMonth);
        }
    }


    class AlertDialogButtonListener implements DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialog, int which) {
            if (which == -1) {
                Toast.makeText(MainActivity.this, "Positive Btn Clicked " + which, Toast.LENGTH_LONG).show();
            } else if (which == -2) {
                Toast.makeText(MainActivity.this, "Negative Btn Clicked " + which, Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this, "Neutral Btn Clicked " + which, Toast.LENGTH_LONG).show();
            }
        }
    }

    class PoistiveButtonClickListener implements DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(MainActivity.this, "Positive Btn Clicked " + which, Toast.LENGTH_LONG).show();
        }
    }

    class NegativeButtonClickListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(MainActivity.this, "Negative Btn Clicked " + which, Toast.LENGTH_LONG).show();
        }
    }

    class NeutralButtonClickListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(MainActivity.this, "Neutral Btn Clicked " + which, Toast.LENGTH_LONG).show();
        }
    }
}