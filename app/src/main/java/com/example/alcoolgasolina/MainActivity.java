package com.example.alcoolgasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText campoAlcool, campoGasolina;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoAlcool     = findViewById(R.id.editAlcool);
        campoGasolina   = findViewById(R.id.editGasolina);
        resultado       = findViewById(R.id.textResultado);

    }

    public void calcular (View view){

        //Recuperar os Campos digitados
        String precoAlcool = campoAlcool.getText().toString();
        String precoGasolina = campoGasolina.getText().toString();

        //Validar campos digitados
        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);

        if( camposValidados ){

            //Convertendo string para números
            Double valorAlcool = Double.parseDouble( precoAlcool );
            Double valorGasolina = Double.parseDouble( precoGasolina );

            Double calculo = valorAlcool / valorGasolina;
            if( calculo >= 0.7 ){

                resultado.setText("Melhor abastecer com gasolina");

            }else{

                resultado.setText("Melhor abastecer com álcool");
            }

        }else{
            resultado.setText("Preencha os preços primeiro!");
        }

    }

    public Boolean validarCampos(String pAlcool, String pGasolina){

        Boolean camposValidados = true;

        if ( pAlcool == null || pAlcool.equals("") ) {

            camposValidados = false;

        }else if (pGasolina == null || pGasolina.equals("") ){

            camposValidados = false;
        }
        return camposValidados;
    }

}