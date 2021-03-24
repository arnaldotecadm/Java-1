package br.com.pucgo.atividade;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import br.com.pucgo.atividade.utils.SystemServiceUtil;

public class SorteadorDeValores extends AppCompatActivity {
    Button sortear, voltar;
    EditText valorMinimo, valorMaximo;
    TextView valorSorteado;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sorteador_de_valores);
        sortear = findViewById(R.id.sortearValores);
        voltar = findViewById(R.id.btnVoltar1);
        valorMinimo = findViewById(R.id.valorMinimo);
        valorMaximo = findViewById(R.id.valorMaximo);
        valorSorteado = findViewById(R.id.valorSorteado);
        final Random valor = new Random();

        sortear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SystemServiceUtil.hideKeyboard(getCurrentFocus(), SorteadorDeValores.this);

                int minimo = 0, maximo = 100;
                boolean tem2Numeros, numeroOK;
                tem2Numeros = true;
                numeroOK = true;
                if(!valorMinimo.getText().toString().isEmpty() && !valorMaximo.getText().toString().isEmpty()){
                    int novoMinimo = Integer.parseInt(valorMinimo.getText().toString());
                    int novoMaximo = Integer.parseInt(valorMaximo.getText().toString());
                    if((novoMinimo <= 100 && novoMaximo <= 100)) {
                        if(novoMinimo <= novoMaximo){
                            minimo = novoMinimo;
                            maximo = novoMaximo;
                        }else{
                            numeroOK = false;
                            Toast.makeText(SorteadorDeValores.this, "Valor mínimo deve ser\nmenor que valor máximo!", Toast.LENGTH_LONG).show();
                            valorMinimo.setText("");
                            valorMaximo.setText("");
                            minimo = 0;
                            maximo = 100;
                        }

                    }else {
                        numeroOK = false;
                        Toast.makeText(SorteadorDeValores.this, "Valor Mínimo: 0\nValor Máximo: 100", Toast.LENGTH_LONG).show();
                        valorMinimo.setText("");
                        valorMaximo.setText("");
                        minimo = 0;
                        maximo = 100;
                    }
                }else if(!valorMinimo.getText().toString().isEmpty() || !valorMaximo.getText().toString().isEmpty()){
                    tem2Numeros = false;
                    Toast.makeText(SorteadorDeValores.this, "Defina valor mínimo e máximo!", Toast.LENGTH_LONG).show();
                    valorMinimo.setText("");
                    valorMaximo.setText("");
                    minimo = 0;
                    maximo = 100;
                }

                if(numeroOK && tem2Numeros){
                    int valor2 = valor.nextInt(maximo - minimo + 1) + minimo;
                    valorSorteado.setText(String.valueOf(valor2));
                }else{
                    valorSorteado.setText(String.valueOf(0));
                }

            }
        });

        voltar.setOnClickListener(v -> {
            try {
                finalize();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }
}
