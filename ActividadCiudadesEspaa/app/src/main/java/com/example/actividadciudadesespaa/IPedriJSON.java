package com.example.actividadciudadesespaa;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IPedriJSON {

        //https://simplemaps.com/static/data/country-cities/es/es.json
        @GET("static/data/country-cities/es/es.json")
        Call<List<Ciudad>> listarCiudades();


}
