package com.example.a250408_lojavirtual;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private Button ButtonT2;
    private EditText CampoNomeT2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        CampoNomeT2 = findViewById(R.id.CampoNomeT2);
        ButtonT2 = findViewById(R.id.ButtonT2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
       public void CadastroNome(View view){
           String nome = CampoNomeT2.getText().toString();

           if(!nome.isEmpty()) {
               Intent intent = new Intent(this, MainActivity3.class);
               Bundle bundle = new Bundle();
               intent.putExtra("CampoNome",nome);
               intent.putExtras(bundle);
               startActivity(intent);
               finish();
           } else{
               CampoNomeT2.setError("Por favor, digite seu nome!");
           }

        };

    }
