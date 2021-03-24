package br.com.pucgo.atividade;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Menu extends AppCompatActivity {

    @BindView(R.id.btnVoltarMenu)
    Button voltar;
    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.btn3)
    Button btn3;
    @BindView(R.id.btn4)
    Button btn4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        ButterKnife.bind(this);

        btn1.setOnClickListener(v -> {
            Intent i = new Intent(Menu.this, SorteadorDeValores.class);
            startActivity(i);
        });
        btn2.setOnClickListener(v -> {
            Intent i = new Intent(Menu.this, JogoJankenpon.class);
            startActivity(i);
        });
        btn3.setOnClickListener(v -> {
            Intent i = new Intent(Menu.this, InversorDePalavras.class);
            startActivity(i);
        });
        btn4.setOnClickListener(v -> {
            Intent i = new Intent(Menu.this, RegistroDeEventos.class);
            startActivity(i);
        });
        voltar.setOnClickListener(v -> {
            Intent i = new Intent(Menu.this, MainActivity.class);
            startActivity(i);
        });
    }
}
