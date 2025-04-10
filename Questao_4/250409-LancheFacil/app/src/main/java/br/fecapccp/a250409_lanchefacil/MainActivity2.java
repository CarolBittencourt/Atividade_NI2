package br.fecapccp.a250409_lanchefacil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private Button ButtonT2;
    private EditText CampoNomeT2;
    private CheckBox cb1, cb2, cb3, cb4, cb5, cb6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        CampoNomeT2 = findViewById(R.id.CampoNomeT2);
        ButtonT2 = findViewById(R.id.ButtonT2);
        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        cb4 = findViewById(R.id.cb4);
        cb5 = findViewById(R.id.cb5);
        cb6 = findViewById(R.id.cb6);

        //Vai para a T3
        ButtonT2.setOnClickListener(View -> {
            Intent intent = new Intent(this, MainActivity3.class);
            startActivity(intent);
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void ButtonT2 (View view){
        CheckBox();
    }

    public void CheckBox() {
        String nome = CampoNomeT2.getText().toString();
        String lanche1 = cb1.getText().toString();
        String lanche2 = cb2.getText().toString();
        String lanche3 = cb3.getText().toString();
        String lanche4 = cb4.getText().toString();
        String lanche5 = cb5.getText().toString();
        String lanche6 = cb6.getText().toString();

        if (!nome.isEmpty()) {
            Intent intent = new Intent(this, MainActivity3.class);
            Bundle bundle = new Bundle();
            intent.putExtra("CampoNomeT2", nome);
            intent.putExtra("cb1", lanche1);
            intent.putExtra("cb2", lanche2);
            intent.putExtra("cb3", lanche3);
            intent.putExtra("cb4", lanche4);
            intent.putExtra("cb5", lanche5);
            intent.putExtra("cb6", lanche6);
            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        } else {
            CampoNomeT2.setError("Por favor, digite seu nome!");
        }

    }
}