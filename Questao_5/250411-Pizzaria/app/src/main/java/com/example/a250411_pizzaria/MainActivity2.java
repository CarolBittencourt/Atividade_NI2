package com.example.a250411_pizzaria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private Button ButtonT2;
    private CheckBox cb1, cb2, cb3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        ButtonT2 = findViewById(R.id.ButtonT2);

        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void BtnT2 (View view){
        CheckBox();
    }
    public void CheckBox() {
        float resultado = 0;
        String saboresSelecionados = "";

        if (cb1.isChecked()) {
            resultado += 30f;
            saboresSelecionados += cb1.getText().toString() + "\n";
        }
        if (cb2.isChecked()) {
            resultado += 35f;
            saboresSelecionados += cb2.getText().toString() + "\n";
        }
        if (cb3.isChecked()) {
            resultado += 40f;
            saboresSelecionados += cb3.getText().toString() + "\n";
        }

        if (!cb1.isChecked() && !cb2.isChecked() && !cb3.isChecked()) {
            cb1.setError("Escolha pelo menos uma opção");
            cb2.setError("Escolha pelo menos uma opção");
            cb3.setError("Escolha pelo menos uma opção");
            Toast.makeText(this, "Você deve escolher pelo menos um sabor!", Toast.LENGTH_SHORT).show();
            return;
        }

// Enviar para próxima tela
        Intent intent = new Intent(this, MainActivity3.class);
        intent.putExtra("resultado", resultado);
        intent.putExtra("saboresSelecionados", saboresSelecionados);
        startActivity(intent);
        finish();
    }



}