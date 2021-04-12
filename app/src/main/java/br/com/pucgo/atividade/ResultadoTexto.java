package br.com.pucgo.atividade;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ResultadoTexto extends AppCompatActivity {

    Button voltar;
    EditText textoInvertido;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado_texto);
        voltar = findViewById(R.id.botaoVoltar2);
        textoInvertido = findViewById(R.id.textoInvertido);
        Intent intent = getIntent();
        String texto = intent.getStringExtra("textoInvertido");
        textoInvertido.setText(texto);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ResultadoTexto.this, InversorDePalavras.class);
                startActivity(i);
                finish();
            }
        });
    }
}
