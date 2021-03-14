package com.example.ejerciciorecyclerrerofit;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;


public class ClasePeticion {

    public static void pedirJSON(final IRellenarSpinner referencia_llamante){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://informo.madrid.es/informo/")
                .addConverterFactory(SimpleXmlConverterFactory.create()).build();

        ObtenerXML servicio_peticion = retrofit.create(ObtenerXML.class);

        Call<List<Incidencia>> lista_ciudades = servicio_peticion.listarIncidencias();
        lista_ciudades.enqueue(new Callback<List<Incidencia>>() {

            @Override
            public void onResponse(Call<List<Incidencia>> call, Response<List<Incidencia>> response) {
                // TODO Auto-generated method stub
                List<Incidencia> lista_ciudades = response.body();
                Log.d("Respuesta", lista_ciudades.toString());
                referencia_llamante.rellenarSpinner(lista_ciudades);


            }




            @Override
            public void onFailure(Call<List<Incidencia>> call, Throwable t) {
                // TODO Auto-generated method stub

                Log.d("Respuesta", t.getLocalizedMessage());
            }
        });
    }
    public interface IRellenarSpinner {
        public void rellenarSpinner(List<Incidencia> ciudades);

    }
}
