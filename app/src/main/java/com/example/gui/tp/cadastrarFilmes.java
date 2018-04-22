package com.example.gui.tp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class cadastrarFilmes extends AppCompatActivity {

    EditText etFirstName,etLastName,etFavFood;
    Button btnAdd;
    DatabaseHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrarfilmes);
        etFavFood = (EditText) findViewById(R.id.etFavFood);
        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        myDB = new DatabaseHelper(this);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fName = etFirstName.getText().toString();
                String lName = etLastName.getText().toString();
                String fFood = etFavFood.getText().toString();
                if(fName.length() != 0 && lName.length() != 0 && fFood.length() != 0){
                    AddData(fName,lName, fFood);
                    etFavFood.setText("");
                    etLastName.setText("");
                    etFirstName.setText("");

                    //Chama a acitivity de listar filmes
                    Intent intent = new Intent(cadastrarFilmes.this,ViewListContents.class);
                    startActivity(intent);

                }else{
                    Toast.makeText(cadastrarFilmes.this,"You must put something in the text field!",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void AddData(String firstName,String lastName, String favFood ){
        boolean insertData = myDB.addData(firstName,lastName,favFood);

        if(insertData==true){
            Toast.makeText(cadastrarFilmes.this,"Successfully Entered Data!",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(cadastrarFilmes.this,"Something went wrong :(.",Toast.LENGTH_LONG).show();
        }
    }
}
