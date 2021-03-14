package com.example.ejerciciorecyclerrerofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ObtenerXML {

    //https://simplemaps.com/static/data/country-cities/es/es.json
    @GET("tmadrid/incid_aytomadrid.xml")
    Call<List<Incidencia>> listarIncidencias();

}
