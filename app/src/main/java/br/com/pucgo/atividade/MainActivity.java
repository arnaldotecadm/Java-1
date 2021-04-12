package br.com.pucgo.atividade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
/*1. Crie uma tela principal que contenha um
    layout que apresente uma estrutura organizadas
    com uma boa apresentação, seu nome, matrícula,
    curso e um botão para uma próxima tela.
            2. Na segunda tela, apresente opções para mais
    quatro novas telas:
    a) Um gerador de valores
    b) Jogo Jankenpon
    c) Uma caixa texto com um BOTÃO para um inversor de
    palavras.
            d) Um registro de evento.
            3. O gerador de valores deverá funcionar da
    seguinte forma: ao pressionar um botão, um
    número aleatório deverá ser apresentado na
    tela. Deverá possuir uma opção para gerar entre
    uma faixa de valores.
            4. O Jankenpon deverá apresentar três Botões
            (imagens) representando a pedra, tesoura ou o
    papel que ao ser pressionado, uma dessas 3
    opções deve ser mostrada na tela também
            (representando a IA), de modo aleatório e depois
    uma mensagem de vitória, derrota ou empate.
            5. Antes de ir para a penúltima tela, o usuário
    deverá digitar um texto na caixa de texto
            (EditText) e esse texto deverá ser levado para a
    última dela deste aplicativo. O texto deverá ser
    invertido.
            Exemplo:
    O usuário digitou “Olá Mundo” na caixa de texto.
    Deverá aparecer “odnuM álO” na próxima tela.
6. O registro de evento deverá conter um EditText, um
    DatePicker, um Button e um ListView, e sempre que o
    usuário digitar algo pelo EditText, será necessário e
    obrigatório colocar uma data e apertar o botão para
    registrar o evento no ListView.
6. Deverá aparecer a data e o texto no ListView, de
    forma que fique um contador de eventos na primeira
    coluna, a data na segunda e o evento em si, na terceira
    coluna do ListView. Será necessário construir uma lista
    customizada para esta listview.*/

    Button entrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entrar = findViewById(R.id.entrar);
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Menu.class);
                startActivity(i);
                finish();
            }
        });
    }
}