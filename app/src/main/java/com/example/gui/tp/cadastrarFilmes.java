package com.example.gui.tp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class cadastrarFilmes extends AppCompatActivity {

    EditText etNome, etGenero, etDiretor, etAno, etFaixa;
    Button btnAdd;
    DatabaseHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrarfilmes);
        etDiretor = (EditText) findViewById(R.id.etDiretor);
        etAno = (EditText) findViewById(R.id.etAno);
        etFaixa = (EditText) findViewById(R.id.etFaixa);
        etNome = (EditText) findViewById(R.id.etNome);
        etGenero = (EditText) findViewById(R.id.etGenero);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        myDB = new DatabaseHelper(this);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fNome = etNome.getText().toString();
                String fGenero = etGenero.getText().toString();
                String fFaixa = etFaixa.getText().toString();
                String fDiretor = etDiretor.getText().toString();
                String fAno = etAno.getText().toString();
                if(fNome.length() != 0 && fGenero.length() != 0 && fDiretor.length() != 0 && fAno.length() != 0 && fFaixa.length() != 0){
                    AddData(fNome,fGenero, fDiretor, fAno, fFaixa);
                    etDiretor.setText("");
                    etAno.setText("");
                    etFaixa.setText("");
                    etGenero.setText("");
                    etNome.setText("");

                    //Chama a acitivity de listar filmes
                    Intent intent = new Intent(cadastrarFilmes.this,ViewListContents.class);
                    startActivity(intent);

                }else{
                    Toast.makeText(cadastrarFilmes.this,"You must put something in the text field!",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void AddData(String Nome,String Genero, String Diretor, String Ano, String Faixa){
        boolean insertData = myDB.addData(Nome,Genero,Diretor, Ano, Faixa);

        if(insertData==true){
            Toast.makeText(cadastrarFilmes.this,"Successfully Entered Data!",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(cadastrarFilmes.this,"Something went wrong :(.",Toast.LENGTH_LONG).show();
        }
    }
}
