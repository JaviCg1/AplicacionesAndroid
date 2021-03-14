package com.example.jsonincidenciacovid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //data: "<html></html>"
        wv= findViewById(R.id.webView);


        Retrofit r= new Retrofit.Builder()
                .baseUrl("http://datos.comunidad.madrid/catalogo/dataset/7da43feb-8d4d-47e0-abd5-3d022d29d09e/resource/877fa8f5-cd6c-4e44-9df5-0fb60944a841/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        ServicioPedimosIncidencia servicio = r.create(ServicioPedimosIncidencia.class);
       Call<data>llamada= servicio.cogerData();


       llamada.enqueue(new Callback<data>() {
           @Override
           public void onResponse(Call<data> call, Response<data> response) {
               System.out.println("Funsiona");
               Log.d("Respuesta", response.body().toString());
               data d = response.body();
                    d.toString();
               List<Incidencia> lista = d.getData();
               HTML h= new HTML();
               String html=h.crearTablaHTML(d);
               wv.loadData(html, "text/html", "utf-8");
           }

           @Override
           public void onFailure(Call<data> call, Throwable t) {
               Log.d("Respuesta", t.getLocalizedMessage());
           }
       });


        }
    }
