package br.com.pucgo.atividade;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;

public class RegistroDeEventos extends AppCompatActivity {

    EditText nomeEvento, dataEvento;
    Button voltar, registrarEvento;
    DatePickerDialog.OnDateSetListener datePicker;
    ListView eventos;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_de_eventos);

        eventos = findViewById(R.id.eventos);
        voltar = findViewById(R.id.btnVoltarEvento);
        registrarEvento = findViewById(R.id.btnRegistrarEvento);
        nomeEvento = findViewById(R.id.nomeEvento);
        dataEvento = findViewById(R.id.dataEvento);


        ArrayList<Evento> eventosRegistrados = new ArrayList<Evento>();
        //eventosRegistrados.add(new Evento(1, "Aula 1", "01/02/2000"));
        //eventosRegistrados.add(new Evento(2, "Aula 2", "02/02/2000"));
        Adaptador adaptador = new Adaptador(this, R.layout.eventos, eventosRegistrados);
        eventos.setAdapter(adaptador);

        registrarEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!nomeEvento.getText().toString().isEmpty() && !dataEvento.getText().toString().isEmpty()){
                    int contador;
                    if(eventosRegistrados.isEmpty()){contador = 1;}
                    else{contador = eventosRegistrados.get(eventosRegistrados.size()-1).getContador()+1;}
                    Evento evento = new Evento(contador, nomeEvento.getText().toString(), dataEvento.getText().toString());
                    eventosRegistrados.add(evento);
                }else{
                    Toast.makeText(RegistroDeEventos.this, "Preencher dados do evento", Toast.LENGTH_SHORT).show();
                }
            }
        });

        dataEvento.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int dia, mes, ano;
                dia = calendar.get(Calendar.DAY_OF_MONTH);
                mes = calendar.get(Calendar.MONTH);
                ano = calendar.get(Calendar.YEAR);
                DatePickerDialog dialog = new DatePickerDialog(
                        RegistroDeEventos.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        datePicker, ano, mes, dia
                );
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                return true;
            }
        });

        datePicker = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month += 1;
                String dataString = dayOfMonth + "/" + month + "/" + year;
                dataEvento.setText(dataString);
            }
        };

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegistroDeEventos.this, Menu.class);
                startActivity(i);
                finish();
            }
        });


    }
}
