package com.example.dialogs;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnAlertDialog, btnTimePickerDialog, btnDatePickerDialog;

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

    }

    private void initListeners() {
        btnAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Exam form Submission");
                builder.setMessage("Are you sure you want to submit");
                builder.setIcon(R.drawable.ic_launcher_background);
                builder.setPositiveButton("Yes" , new PoistiveButtonClickListener());
                builder.setNegativeButton("No",new NegativeButtonClickListener());
                builder.setNeutralButton("Okay",new NeutralButtonClickListener());

                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });

    }
    class PoistiveButtonClickListener implements DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialog, int which) {
           Toast.makeText(MainActivity.this,"Positive Btn Clicked "+ which,Toast.LENGTH_LONG).show();
        }
    }

    class NegativeButtonClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(MainActivity.this,"Negative Btn Clicked "+ which,Toast.LENGTH_LONG).show();
        }
    }

    class NeutralButtonClickListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(MainActivity.this,"Neutral Btn Clicked "+ which,Toast.LENGTH_LONG).show();
        }
    }
}