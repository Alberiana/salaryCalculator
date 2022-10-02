package com.example.salarycalculator.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.salarycalculator.DatabaseHelper;
import com.example.salarycalculator.R;
import com.example.salarycalculator.UsersTable;

public class MainActivity_rl extends AppCompatActivity {

    EditText name, surname, pagabr;
    TextView paga;
    Button kalkulo, fshije, shiko;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_rl);
        name=findViewById(R.id.name);
        surname=findViewById(R.id.surname);
        pagabr=findViewById(R.id.pagabr);
        paga=findViewById(R.id.paga);
        kalkulo=findViewById(R.id.kalkulo);
        fshije=findViewById(R.id.Fshije);
        shiko=findViewById(R.id.Shiko);
        kalkulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nameTxt=name.getText().toString();
                String surnameTxt=surname.getText().toString();

                Double pagabr2=Double.parseDouble(pagabr.getText().toString());
                Double kpm=0.05*pagabr2;
                Double pagatatueshme=pagabr2-kpm;
                    paga.setText(nameTxt+ " "+surnameTxt+" paga juaj bruto eshte "+ pagabr.getText().toString()+"\n"
                        + "Nga kjo page, kontributi pensional eshte "+kpm+" ku "+0.05 + "jane nga ju dhe  "+ 0.05 +" jane nga punedhenesi" +"\n"+
                        "Paga e tatueshme e juaja eshte "+ pagatatueshme
                );
            }
        });


        shiko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTxt=name.getText().toString();
                String surnameTxt=surname.getText().toString();
                Double paga=Double.parseDouble(pagabr.getText().toString());


                SQLiteDatabase objDB=new DatabaseHelper(MainActivity_rl.this).getWritableDatabase();
                ContentValues cv=new ContentValues();
                Double pagabr2=Double.parseDouble(pagabr.getText().toString());
                Double kpm=0.05*pagabr2;
                Double kontributi_pensional=Double.parseDouble(kpm.toString());
                Double pagatatueshme=pagabr2-kontributi_pensional;
                Double paga_tatueshme=Double.parseDouble(pagatatueshme.toString());
                cv.put(UsersTable.NAME,nameTxt);
                cv.put(UsersTable.surname, surnameTxt);
                cv.put(UsersTable.pagabr, paga);
                cv.put(UsersTable.kontributi_pensional, kontributi_pensional);
                cv.put(UsersTable.pagae_tatueshme, paga_tatueshme);

                long id=objDB.insert(UsersTable.TABLE_NAME,null, cv);
                if(id>0){
                    Toast.makeText(MainActivity_rl.this, "Regjistrimi u be me sukses!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity_rl.this, DetailsOfList.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity_rl.this, "Regjistrimi deshtoi", Toast.LENGTH_SHORT).show();
                }

            }
        });
//        fshije.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(MainActivity_rl.this, ListDataActivity.class);
//                startActivity(intent);
//            }
//        });
    }
//
//    public void AddData(String newEntry){
//        boolean insetData=mDatabaseHelper.addData(newEntry);
//        if(insetData){
//            toastMessage("Data Successfully Inserted");
//        }else{
//            toastMessage("Something went wrong");
//        }
//    }
//    private void toastMessage(String message){
//        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
//    }
}