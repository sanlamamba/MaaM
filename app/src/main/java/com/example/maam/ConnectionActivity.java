package com.example.maam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ConnectionActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connection_activity);

        username = (EditText) findViewById(R.id.username_input);
        password = (EditText) findViewById(R.id.password_input);

        loginBtn= (Button) findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connect(username.getText().toString(), password.getText().toString());
            }
    });

    }
    private void alertMessage(String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(ConnectionActivity.this);
        builder.setTitle("Erreur")
                .setMessage("Veuillez remplir tout les champs avant de continuer")
                .setCancelable(false)
                .setPositiveButton("Reessayer", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        //Creating dialog box
        AlertDialog dialog  = builder.create();
        dialog.show();
    }


    private void Connect(String username, String password){
        if(username.isEmpty() && password.isEmpty() ){
            alertMessage("Veuillez remplir tout les champs avant de continuer");
        }else{
            Intent  intent = new Intent(ConnectionActivity.this, CreateForm.class);
            startActivity(intent);
        }
    }
}