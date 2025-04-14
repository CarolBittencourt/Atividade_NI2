package com.example.a250411_pizzaria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity4 extends AppCompatActivity {

    private Button ButtonT4;
    private TextView ResumoPedidoT4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);

        ButtonT4 = findViewById(R.id.ButtonT4);

        ButtonT4.setOnClickListener(View ->{
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        });

        ResumoPedidoT4 = findViewById(R.id.ResumoPedidoT4);

        String tamanho = getIntent().getStringExtra("tamanho");
        String sabores = getIntent().getStringExtra("saboresSelecionados");
        String pagamento = getIntent().getStringExtra("pagamento");
        float total = getIntent().getFloatExtra("total", 0);

        String mensagem = "Sabores: " + sabores +
                "Tamanho: " + tamanho + "\n" +
                "Pagamento: " + pagamento + "\n" +
                "Total a pagar: R$ " + total;

        ResumoPedidoT4.setText(mensagem);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}