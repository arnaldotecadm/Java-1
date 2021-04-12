package br.com.pucgo.atividade;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Adaptador extends ArrayAdapter<Evento> {
    private Context context;
    private int resourceList;


    public Adaptador(@NonNull Context context, int resource, @NonNull List<Evento> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resourceList = resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int contador = getItem(position).getContador();
        String nome = getItem(position).getNome();
        String data = getItem(position).getData();

        Evento eventos = new Evento(contador, nome, data);
        LayoutInflater inflater = LayoutInflater.from(context);

        convertView = inflater.inflate(resourceList, parent, false);
        TextView textViewContador =  convertView.findViewById(R.id.textoContador);
        TextView textViewNome =
                convertView.findViewById(R.id.textoNomeEvento);
        TextView textViewData =
                convertView.findViewById(R.id.textoDataEvento);


        textViewContador.setText(String.valueOf(contador));
        textViewNome.setText(nome);
        textViewData.setText(data);

        return convertView;
    }
}
