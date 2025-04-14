package com.example.a250411_pizzaria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    private Button ButtonT3;
    private RadioGroup radiogroup1, radiogroup2;
    private RadioButton rb1, rb2, rb3, rb4, rb5;
    private float valorSabores = 0;
    private String saboresSelecionados = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        ButtonT3 = findViewById(R.id.ButtonT3);
        radiogroup1 = findViewById(R.id.radiogroup1);
        radiogroup2 = findViewById(R.id.radiogroup2);

        rb1 = findViewById(R.id.rb1); // Grande
        rb2 = findViewById(R.id.rb2); // Média
        rb3 = findViewById(R.id.rb3); // Pequena
        rb4 = findViewById(R.id.rb4); // Cartão
        rb5 = findViewById(R.id.rb5); // Dinheiro


        valorSabores = getIntent().getFloatExtra("resultado", 0);

        saboresSelecionados = getIntent().getStringExtra("saboresSelecionados");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void BtnT3(View view) {
        RadioGroup();
    }

    public void RadioGroup() {
        float soma = 0;
        String tamanho = "";
        String pagamento = "";

        // Verifica o tamanho selecionado
        if (rb1.isChecked()) {
            tamanho = rb1.getText().toString(); // Grande
            soma = 20f;
        } else if (rb2.isChecked()) {
            tamanho = rb2.getText().toString(); // Média
            soma = 15f;
        } else if (rb3.isChecked()) {
            tamanho = rb3.getText().toString(); // Pequena
            soma = 10f;
        } else {
            Toast.makeText(this, "Selecione o tamanho da pizza", Toast.LENGTH_SHORT).show();
            return;
        }

        // Verifica a forma de pagamento
        if (rb4.isChecked()) {
            pagamento = rb4.getText().toString(); // Cartão
        } else if (rb5.isChecked()) {
            pagamento = rb5.getText().toString(); // Dinheiro
        } else {
            Toast.makeText(this, "Selecione a forma de pagamento", Toast.LENGTH_SHORT).show();
            return;
        }

        float totalFinal = valorSabores + soma;

        Intent intent = new Intent(this, MainActivity4.class);
        intent.putExtra("tamanho", tamanho);
        intent.putExtra("saboresSelecionados", saboresSelecionados);
        intent.putExtra("pagamento", pagamento);
        intent.putExtra("total", totalFinal);
        startActivity(intent);
        finish();
    }
}
