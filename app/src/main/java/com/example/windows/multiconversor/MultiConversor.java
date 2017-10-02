package com.example.windows.multiconversor;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MultiConversor extends AppCompatActivity {

    private static int numero;

    //@Override
    public int exp, digito;
    double binario;

    String resultado;

    EditText num;
    TextView result;

    RadioGroup rgdenumero, rganumero;
    RadioButton abin,adec,debin,dedec;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_conversor);

        num= (EditText) findViewById(R.id.Etxt_numero);
        //variable num para recuperar el texto a convertir

        result= (TextView) findViewById(R.id.Txtv_conversion);
        //lugar donde se colocara el resulatado de la conversion

        rgdenumero= (RadioGroup)findViewById(R.id.rg_denumero);
        abin= (RadioButton) findViewById(R.id.radio_abin);
        adec= (RadioButton) findViewById(R.id.radio_adec);

        rganumero= (RadioGroup)findViewById(R.id.rg_anumero);
        dedec= (RadioButton) findViewById(R.id.radio_dedec);
        debin= (RadioButton) findViewById(R.id.radio_debin);

        rganumero.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group,int checkedId) {
                switch (checkedId){
                    case R.id.radio_adec:
                        result.setText(Integer.toHexString(Integer.parseInt(num.getText().toString())).toUpperCase());
                        break;
                    case R.id.radio_abin:
                        result.setText(Integer.toBinaryString(Integer.parseInt(num.getText().toString())));
                        break;
                    default:
                        break;
                }
            }
        });

        rgdenumero.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group,int checkedId) {
                switch (checkedId){
                    case R.id.radio_dedec:
                        result.setText("de decimal");
                        break;
                    case R.id.radio_debin:
                        result.setText("de binario");
                        break;
                    default:
                        break;
                }
            }
        });
    }



    public static String obtenerBinario(String x){
        numero=Integer.parseInt(x);

        ArrayList<String> binario = new ArrayList<String>();
        int resto;
        String binarioString = "";

        do{
            resto = numero%2;
            numero = numero/2;
            binario.add(0, Integer.toString(resto));
        }while(numero >= 2); //Haremos el bucle hasta que el cociente no se pueda dividir mas

        binario.add(0, Integer.toString(numero)); //Cogeremos el ultimo cociente

        //Cogemos cada uno de los elementos del ArrayList y los juntamos en un String
        for(int i = 0; i < binario.size(); i++){
            binarioString += binario.get(i);
        }
        return binarioString;
    }
}
