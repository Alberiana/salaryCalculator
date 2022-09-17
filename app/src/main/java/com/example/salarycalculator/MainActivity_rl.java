package com.example.salarycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity_rl extends AppCompatActivity {

    EditText name, surname, pagabr;
    TextView paga;
    Button kalkulo, fshije;
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
        kalkulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Double pagabr2=Double.parseDouble(pagabr.getText().toString());
                Double kpm=0.05*pagabr2;
                Double pagatatueshme=pagabr2-kpm;
                paga.setText(name.getText().toString()+ " "+surname.getText().toString()+" paga juaj bruto eshte "+ pagabr.getText().toString()+"\n"
                        + "Nga kjo page, kontributi pensional eshte "+kpm+" ku "+0.05 + "jane nga ju dhe  "+ 0.05 +" jane nga punedhenesi" +"\n"+
                        "Paga e tatueshme e juaja eshte "+ pagatatueshme
                );
            }
        });
    }
}