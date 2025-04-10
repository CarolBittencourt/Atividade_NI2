package br.fecapccp.a250409_lanchefacil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    private Button ButtonT3;
    private TextView TextNome;
    private TextView TextPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);


        TextNome = findViewById(R.id.TextNome);
        TextPedido = findViewById(R.id.TextPedido);

        Bundle bundle = getIntent().getExtras();
        String nome = bundle.getString("CampoNomeT2");
        String lanche1 = bundle.getString("cb1");
        String lanche2 = bundle.getString("cb2");
        String lanche3 = bundle.getString("cb3");
        String lanche4 = bundle.getString("cb4");
        String lanche5 = bundle.getString("cb5");
        String lanche6 = bundle.getString("cb6");

        TextNome.setText(nome);
        TextPedido.setText(lanche1);
        TextPedido.setText(lanche2);
        TextPedido.setText(lanche3);
        TextPedido.setText(lanche4);
        TextPedido.setText(lanche5);
        TextPedido.setText(lanche6);


        //Voltando para tela inicial
        ButtonT3 = findViewById(R.id.ButtonT3);

        ButtonT3.setOnClickListener(View ->{
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}