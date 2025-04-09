package com.example.a250407_sistemadecompras;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView textResultado;
    private CheckBox cbArroz, cbFeijao, cbLeite, cbCarne, cbCoca;
    private Button btnTotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        cbArroz = findViewById(R.id.cbArroz);
        cbFeijao = findViewById(R.id.cbFeijao);
        cbLeite = findViewById(R.id.cbLeite);
        cbCarne = findViewById(R.id.cbCarne);
        cbCoca = findViewById(R.id.cbCoca);

        textResultado = findViewById(R.id.textResultado);
        btnTotal = findViewById(R.id.btnTotal);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void BtnTotal (View view){
        CheckBox();
    }


    public void CheckBox(){
        float resultado = 0;

        if(cbArroz.isChecked()){
            float produtoSelecionado = 2.69f;
            resultado += produtoSelecionado;
        }
        if(cbFeijao.isChecked()){
            float produtoSelecionado = 3.38f;
            resultado += produtoSelecionado;
        }
        if(cbLeite.isChecked()){
            float produtoSelecionado = 2.70f;
            resultado += produtoSelecionado;
        }
        if(cbCarne.isChecked()){
            float produtoSelecionado = 16.70f;
            resultado += produtoSelecionado;
        }
        if(cbCoca.isChecked()){
            float produtoSelecionado = 3.00f;
            resultado += produtoSelecionado;
        }
        textResultado.setText("Total: R$ " + String.format("%.2f", resultado));
    }



}