package com.example.ejerciciorecyclerrerofit;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.MiContenedorDeVistas> {

    private ArrayList<Incidencia> lista_contactos = new ArrayList<>();

    public MiAdaptador(ArrayList<Incidencia> lista_contactos) {
        this.lista_contactos = lista_contactos;
    }

    @NonNull
    @Override
    public MiContenedorDeVistas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.vista_contacto, parent, false);
        TextView fechini = vista.findViewById(R.id.fechIni);
        TextView fechfin = vista.findViewById(R.id.fechfin);

        TextView descricion = vista.findViewById(R.id.descripcion);
        MiContenedorDeVistas contenerdor = new MiContenedorDeVistas(vista);
        Log.d("contenedor", "creando contenedor de vistas");
        return contenerdor;
    }

    @Override
    public void onBindViewHolder(@NonNull MiContenedorDeVistas holder, int position) {
        Incidencia c = lista_contactos.get(position);
        holder.fechini.setText((c.getFh_inicio()));
        holder.fechfin.setText(c.getFh_fin());

        holder.descripcion.setText(String.valueOf(c.getDescripcion()));
        Log.d("contenedor", "vinculando position" + position);
    }

    @Override
    public int getItemCount() {
        return lista_contactos.size();
    }

    public static class MiContenedorDeVistas extends RecyclerView.ViewHolder {
        public TextView fechini,  fechfin, descripcion;

        public MiContenedorDeVistas(View vista) {
            super(vista);
            this.fechini = vista.findViewById(R.id.fechIni);
            this.fechfin = vista.findViewById(R.id.fechfin);

            this.descripcion = vista.findViewById(R.id.descripcion);
        }

    }


}