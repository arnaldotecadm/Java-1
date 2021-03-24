package br.com.pucgo.atividade;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class JogoJankenpon extends AppCompatActivity {

    ImageView oponente, jogador;
    Button pedra, papel, tesoura, voltar;
    String jogadaJogador, resultado;
    Random valor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jogo_jankenpon);
        oponente = findViewById(R.id.oponente);
        jogador = findViewById(R.id.jogador);
        pedra = findViewById(R.id.btnPedra);
        papel = findViewById(R.id.btnPapel);
        tesoura = findViewById(R.id.btnTesoura);
        voltar = findViewById(R.id.btnVoltar2);
        valor = new Random();

        pedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jogadaJogador = "pedra";
                jogador.setImageResource(R.drawable.rock);
                calcular();
            }
        });

        papel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jogadaJogador = "papel";
                jogador.setImageResource(R.drawable.paper);
                calcular();
            }
        });

        tesoura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jogadaJogador = "tesoura";
                jogador.setImageResource(R.drawable.scissors);
                calcular();
            }
        });

        voltar.setOnClickListener(v -> finish());

    }

    public void calcular(){
        int valorSorteado = valor.nextInt(3);
        switch (valorSorteado){
            case 0:
                oponente.setImageResource(R.drawable.rock);
                break;
            case 1:
                oponente.setImageResource(R.drawable.paper);
                break;
            case 2:
                oponente.setImageResource(R.drawable.scissors);
                break;
        }

        TipoJogada jogador = TipoJogada.getEnumByNome(jogadaJogador);
        TipoJogada oponente = TipoJogada.getEnumByCodigo(valorSorteado);

        Boolean julga = jogador.julga(oponente);
        if(null == julga){
            resultado = "Empate";
        } else{
            resultado = julga ? "Voce Ganhou!" : "Voce Perdeu";
        }

        Toast.makeText(JogoJankenpon.this, resultado, Toast.LENGTH_LONG).show();
    }
}
