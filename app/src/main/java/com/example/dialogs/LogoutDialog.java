package com.example.dialogs;

import android.app.Dialog;
import android.content.Context;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class LogoutDialog extends Dialog {
    private OnLogoutDialogClickListener onLogoutDialogClickListener;

    interface OnLogoutDialogClickListener{
      void onSuccess();
      void onFailure();
    }

    public void setOnLogoutDialogClickListener(OnLogoutDialogClickListener onLogoutDialogClickListener){
        this.onLogoutDialogClickListener = onLogoutDialogClickListener;
    }
    TextView txtView1,txtView2;
    Button btnYes,btnNo;
    public LogoutDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.logout_dialog);
        initViews();
        initListeners();
    }

    private void initViews() {
        txtView1=findViewById(R.id.txtView1);
        txtView2=findViewById(R.id.txtView2);
        btnYes=findViewById(R.id.btnYes);
        btnNo=findViewById(R.id.btnNo);
    }

    private void initListeners() {
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLogoutDialogClickListener.onSuccess();

               //Log.e("tag","Yes click listener");
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLogoutDialogClickListener.onFailure();
               //Log.e("tag","No click listener");
            }
        });
    }
}
