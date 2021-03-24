package br.com.pucgo.atividade;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegistroDeEventos extends AppCompatActivity {

    @BindView(R.id.nomeEvento)
    EditText nomeEvento;
    @BindView((R.id.dataEvento))
    EditText dataEvento;
    @BindView(R.id.btnVoltarEvento)
    Button voltar;
    @BindView(R.id.btnRegistrarEvento)
    Button registrarEvento;
    DatePickerDialog.OnDateSetListener datePicker;
    @BindView(R.id.eventos)
    ListView eventos;

    private ArrayList<Evento> eventosRegistrados = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_de_eventos);

        // Isso aqui faz a magica da ligacao entre componente da tela e as propriedades
        ButterKnife.bind(this);

        Adaptador adaptador = new Adaptador(this, R.layout.eventos, eventosRegistrados);

        eventos.setAdapter(adaptador);

        /**
         * Aqui podemos simplificar a chamada do metodo onClick
         * visto que so possui um metodo que precisamos implementar
         * o mesmo vale para os metodos que seguem esta logica
         */
        registrarEvento.setOnClickListener((view) -> {
            if (!nomeEvento.getText().toString().isEmpty() && !dataEvento.getText().toString().isEmpty()) {
                int contador;
                if (eventosRegistrados.isEmpty()) {
                    contador = 1;
                } else {
                    contador = eventosRegistrados.get(eventosRegistrados.size() - 1).getContador() + 1;
                }
                Evento evento = new Evento(contador, nomeEvento.getText().toString(), dataEvento.getText().toString());
                eventosRegistrados.add(evento);
                //Interessante para fazer o adaptador se atualizar no momento do click;
                // Sem isso o adapter nao sabe que existem novos dados
                adaptador.notifyDataSetChanged();
            } else {
                Toast.makeText(RegistroDeEventos.this, "Preencher dados do evento ", Toast.LENGTH_SHORT).show();
            }
        });

        dataEvento.setOnLongClickListener((view) -> {
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
        });

        datePicker = (view, year, month, dayOfMonth) -> {
            month += 1;
            String dataString = String.format("%s/%s/%s", dayOfMonth, month, year);
            dataEvento.setText(dataString);
        };

        voltar.setOnClickListener(v -> { finish(); });


    }
}
