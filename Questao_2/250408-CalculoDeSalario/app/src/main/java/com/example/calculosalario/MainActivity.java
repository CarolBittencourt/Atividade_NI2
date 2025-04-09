package com.example.calculosalario;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

   private EditText editSalario;
   private TextView textResultado;
   private RadioGroup radioGroup;
   private RadioButton radioButton, radioButton2, radioButton3;
   private Button btnMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editSalario = findViewById(R.id.editSalario);

        radioGroup =findViewById(R.id.radioGroup);

        radioButton= findViewById(R.id.radioButton);
        radioButton2= findViewById(R.id.radioButton2);
        radioButton3= findViewById(R.id.radioButton3);

        btnMostrar = findViewById(R.id.btnMostrar);

        textResultado = findViewById(R.id.textResultado);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnMostrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view){
                enviar();
            }
        });
    }



    public void enviar(){
        RadioGroup();
    }

    public void RadioGroup () {
    String CampoSalario = editSalario.getText().toString();

    float salario = Float.parseFloat(CampoSalario);
    float novoSalario = 0;

        if(radioButton.isChecked()){
            novoSalario = salario*1.40f;
        }
        if(radioButton2.isChecked()){
            novoSalario = salario*1.45f;
        }
        if(radioButton3.isChecked()){
            novoSalario = salario*1.50f;
        }
        textResultado.setText("Total: R$ " + novoSalario);
    }
}