package com.example.maam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateForm extends AppCompatActivity {
    private EditText name;
    private EditText email;
    private EditText matricule;
    private EditText groupe;
    private Button viewList;
    private Button create;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_form);
        this.name = (EditText) findViewById(R.id.name_input);
        this.email = (EditText) findViewById(R.id.email_input);
        this.matricule = (EditText) findViewById(R.id.matricule_input);
        this.groupe = (EditText) findViewById(R.id.groupe_input);
        this.viewList = (Button) findViewById(R.id.viewList);
        this.create = (Button) findViewById(R.id.creerBtn);



        this.viewList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewList();
            }
        });

        this.create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                create(name.getText().toString(), email.getText().toString(),matricule.getText().toString(),groupe.getText().toString());
            }
        });
    }


    public void create(String name, String email, String matricule, String groupe){
        if(name.isEmpty() || email.isEmpty() || matricule.isEmpty() || groupe.isEmpty()){
            alertMessage("Veuillez remplir tout les champs avant de continuer", false, "" );
        }else{
            alertMessage("",true, name);
            resetForm();
        }
    }
    public void resetForm (){
        name.setText("");
        email.setText("");
        matricule.setText("");
        groupe.setText("");
    }
    public void viewList (){
        alertMessage("Ooops une erreur se passer, veuillez reessayer plus tard",false,"");
    }
    private void alertMessage(String message,boolean type, String name) {
        AlertDialog.Builder builder = new AlertDialog.Builder(CreateForm.this);
        builder.setTitle(type?"Succes": "Erreur")
                .setMessage(type?"L'etudiant " + name + " a ete creer avec succes": message )
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                });

        //Creating dialog box
        AlertDialog dialog  = builder.create();
        dialog.show();
    }
}