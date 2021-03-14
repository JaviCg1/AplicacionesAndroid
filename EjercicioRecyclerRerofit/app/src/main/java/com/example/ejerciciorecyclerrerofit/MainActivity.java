package com.example.ejerciciorecyclerrerofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  ClasePeticion.IRellenarSpinner {
    ArrayList<Incidencia> lista = new ArrayList<Incidencia>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ClasePeticion.pedirJSON(this);

        Incidencia c1= new Incidencia("Pepe","Perez" ,"Pepe@gmail.com");
        Incidencia c2= new Incidencia("Ana", "Torrojas" ,"Ana@gmail.com");
        Incidencia c3= new Incidencia("Lolo", "Manolo" ,"Lolo@gmail.com");
        Incidencia c4= new Incidencia("Filomena", "Hijaputa" ,"Filomena@gmail.com");
        Incidencia c5= new Incidencia("Toño", "Castaña" ,"toño@gmail.com");
        Incidencia c6= new Incidencia("Mari", "ConPintas" ,"Mari@gmail.com");
        Incidencia c7= new Incidencia("Jorge", "Nitales" ,"Jorge@gmail.com");
        Incidencia c8= new Incidencia("Xavi", "Robles" ,"Xavi@gmail.com");
        Incidencia c9= new Incidencia("almer", "Galarga" ,"Almer@gmail.com");
        Incidencia c10= new Incidencia("Miguel", "Parra" ,"Miguel@gmail.com");


        lista.add(c1);




    }

    @Override
    public void rellenarSpinner(List<Incidencia> ciudades) {
        for (Incidencia in: ciudades
             ) {
            lista.add(in);
            Log.d("Datass", in.getFh_inicio());
        }



        RecyclerView rec = findViewById(R.id.mi_Recycler);
        RecyclerView.LayoutManager gestor = new LinearLayoutManager(this);
        MiAdaptador adaptador = new MiAdaptador(lista);
        rec.setLayoutManager(gestor);
        rec.setAdapter(adaptador);

    }
}