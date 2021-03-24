package br.com.pucgo.atividade;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class InversorDePalavras extends AppCompatActivity {

    EditText textoInverter;
    Button voltar, inverter;
    String textoInvertido;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inversor_de_palavras);

        voltar = findViewById(R.id.botaoVoltar);
        inverter = findViewById(R.id.btnInverter);
        textoInverter = findViewById(R.id.textoInverter);

        inverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!textoInverter.getText().toString().isEmpty()){
                    StringBuffer stringBuffer = new StringBuffer(textoInverter.getText().toString());
                    stringBuffer.reverse();
                    textoInvertido = stringBuffer.toString();
                    Intent i = new Intent(InversorDePalavras.this, ResultadoTexto.class);
                    i.putExtra("textoInvertido", textoInvertido);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(InversorDePalavras.this, "Digitar texto!", Toast.LENGTH_LONG).show();
                }
            }
        });

        voltar.setOnClickListener(v -> finish());
    }
}
