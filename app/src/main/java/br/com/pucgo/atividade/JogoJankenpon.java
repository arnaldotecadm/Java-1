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
    String jogadaOponente, jogadaJogador, resultado;
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

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(JogoJankenpon.this, Menu.class);
                startActivity(i);
                finish();
            }
        });

    }

    public void calcular(){
        int valorSorteado = valor.nextInt(3);
        switch (valorSorteado){
            case 0:
                jogadaOponente = "pedra";
                oponente.setImageResource(R.drawable.rock);
                break;
            case 1:
                jogadaOponente = "papel";
                oponente.setImageResource(R.drawable.paper);
                break;
            case 2:
                jogadaOponente = "tesoura";
                oponente.setImageResource(R.drawable.scissors);
                break;
        }

        if(jogadaJogador.equals("pedra") && jogadaOponente.equals("papel")){
            resultado = "Você perdeu!";
        } else if(jogadaJogador.equals("pedra") && jogadaOponente.equals("tesoura")){
            resultado = "Você ganhou!";
        } else if(jogadaJogador.equals("papel") && jogadaOponente.equals("pedra")){
            resultado = "Você ganhou!";
        } else if(jogadaJogador.equals("papel") && jogadaOponente.equals("tesoura")){
            resultado = "Você perdeu!";
        } else if(jogadaJogador.equals("tesoura") && jogadaOponente.equals("papel")){
            resultado = "Você ganhou!";
        } else if(jogadaJogador.equals("tesoura") && jogadaOponente.equals("pedra")){
            resultado = "Você perdeu!";
        } else if(jogadaJogador.equals("pedra") && jogadaOponente.equals("pedra")){
            resultado = "Empate!";
        } else if(jogadaJogador.equals("papel") && jogadaOponente.equals("papel")){
            resultado = "Empate!";
        } else if(jogadaJogador.equals("tesoura") && jogadaOponente.equals("tesoura")){
            resultado = "Empate!";
        }

        Toast.makeText(JogoJankenpon.this, resultado, Toast.LENGTH_LONG).show();
    }
}
