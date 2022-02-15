package com.codeit.juegoelahorcado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtLetra;
    Button btnVerificar,btnLimpiar;
    TextView tvLetra1, tvLetra2, tvLetra3, tvLetra4, tvAhoracado, tvResultado;

    int intentos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtLetra = findViewById(R.id.edtLetra);

        btnVerificar = findViewById(R.id.btnVerificar);
        btnLimpiar = findViewById(R.id.btnLimpiar);

        tvLetra1 = findViewById(R.id.tvLetra1);
        tvLetra2 = findViewById(R.id.tvLetra2);
        tvLetra3 = findViewById(R.id.tvLetra3);
        tvLetra4 = findViewById(R.id.tvLetra4);

        tvAhoracado = findViewById(R.id.tvAhoracado);
        tvResultado = findViewById(R.id.tvResultado);

        //funcionamiento de los botones
        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //primero verificar que no este vacio el edit text para ingresar las letras
                if (!edtLetra.getText().toString().isEmpty()){
                    //Las letras a adivinar son ETPS
                    String letraIngresada = edtLetra.getText().toString().trim().toUpperCase();
                    if (letraIngresada.equals("e") || letraIngresada.equals("E")){
                        tvLetra1.setText("E");
                    }else if (letraIngresada.equals("t") || letraIngresada.equals("T")){
                        tvLetra2.setText("T");
                    }else if (letraIngresada.equals("p") || letraIngresada.equals("P")){
                        tvLetra3.setText("P");
                    }else if (letraIngresada.equals("s") || letraIngresada.equals("S")){
                        tvLetra4.setText("S");
                    }else{
                        intentos++;
                    }

                    if (intentos==1){
                        tvAhoracado.setText("A");
                    }else if (intentos==2){
                        tvAhoracado.setText("AH");
                    }else if (intentos==3){
                        tvAhoracado.setText("AHO");
                    }else if (intentos==4){
                        tvAhoracado.setText("AHOR");
                    } else if (intentos==5){
                        tvAhoracado.setText("AHORC");
                    }else if (intentos==6){
                        tvAhoracado.setText("AHORCA");
                    }else if (intentos==7){
                        tvAhoracado.setText("AHORCAD");
                    }else if (intentos==8){
                        tvAhoracado.setText("AHORCADO");
                    }
                    if (intentos>=8){
                        tvResultado.setText("PERDI");
                        btnVerificar.setEnabled(false);
                    }

                    if(!tvLetra1.getText().toString().trim().isEmpty() &&
                            !tvLetra2.getText().toString().trim().isEmpty() &&
                            !tvLetra3.getText().toString().trim().isEmpty() &&
                            !tvLetra4.getText().toString().trim().isEmpty()){
                        tvResultado.setText("GANE");
                        btnVerificar.setEnabled(false);
                    }
                    edtLetra.setText("");
                }
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtLetra.setText("");
                tvLetra1.setText("");
                tvLetra2.setText("");
                tvLetra3.setText("");
                tvLetra4.setText("");
                tvAhoracado.setText("");
                tvResultado.setText("");
                intentos=0;
                btnVerificar.setEnabled(true);
            }
        });

    }
}
