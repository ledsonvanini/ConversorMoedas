package com.example.conversormoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private final viewHolder mViewHolder = new viewHolder();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editValue = findViewById(R.id.edit_value);
        this.mViewHolder.textDolar = findViewById(R.id.text_dolar);
        this.mViewHolder.textEuro = findViewById(R.id.text_euro);
        this.mViewHolder.buttonCalculate = findViewById(R.id.button_calculate);
        this.mViewHolder.buttonClear = findViewById(R.id.button_clear);

        this.mViewHolder.buttonCalculate.setOnClickListener(this);
        this.mViewHolder.buttonClear.setOnClickListener(this);

        this.clearValues();

    }


    @Override
    public void onClick(View v) {
        String value = this.mViewHolder.editValue.getText().toString();
        if(v.getId() == R.id.button_clear){
            clearValues();
        }
        if (v.getId() == R.id.button_calculate){
            if ("".equals(value)){
                Toast.makeText(this, R.string.preencha_o_campo_vazio, Toast.LENGTH_LONG).show();
            }
             else {
                calculateCurrence();
            }
        }
    }

    private void calculateCurrence() {
        String value = this.mViewHolder.editValue.getText().toString();
        Double dolarPrice = 4.99;
        Double euroPrice = 5.49;

        Double realPrice = Double.valueOf(value);

        this.mViewHolder.textDolar.setText(String.format("%.2f", (realPrice / dolarPrice)));
        this.mViewHolder.textEuro.setText(String.format("%.2f", (realPrice / euroPrice)));
        this.mViewHolder.editValue.setText("");

    }

    private void clearValues() {
        this.mViewHolder.textDolar.setText("");
        this.mViewHolder.textEuro.setText("");
    }

    private static class viewHolder {
        EditText editValue;
        TextView textDolar;
        TextView textEuro;
        Button buttonCalculate;
        Button buttonClear;

    }

}