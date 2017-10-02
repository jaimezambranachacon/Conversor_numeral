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

    RadioGroup rganumero;
    RadioButton abin,adec,aoct,dedec;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_conversor);

        num= (EditText) findViewById(R.id.Etxt_numero);
        //variable num para recuperar el texto a convertir

        result= (TextView) findViewById(R.id.Txtv_conversion);
        //lugar donde se colocara el resulatado de la conversion

        rganumero= (RadioGroup)findViewById(R.id.rg_anumero);
        abin= (RadioButton) findViewById(R.id.radio_abin);
        adec= (RadioButton) findViewById(R.id.radio_adec);
        aoct= (RadioButton) findViewById(R.id.radio_aoct);

        rganumero.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group,int checkedId) {
                switch (checkedId){
                    case R.id.radio_adec:
                        result.setText(Integer.toHexString(Integer.parseInt(num.getText().toString())).toUpperCase());
                        break;
                    case R.id.radio_abin:
                        result.setText(Integer.toBinaryString(Integer.parseInt(num.getText().toString())));
                        break;
                    case R.id.radio_aoct:
                        result.setText(Integer.toOctalString((Integer.parseInt(num.getText().toString()))));
                        break;
                    default:
                        break;
                }
            }
        });


    }
}
