package com.example.actividadciudadesespaa;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MapaCiudadesWikipedia extends FragmentActivity implements OnMapReadyCallback, ClasePeticion.IRellenarSpinner{
    private GoogleMap mapa;
    private Context contexto = this;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    public void rellenarSpinner(List<Ciudad> ciudades) {
        for (Ciudad c : ciudades
             ) {
            Double lat = Double.parseDouble(c.getLat());
            Double lng = Double.parseDouble(c.getLng());
            LatLng posicion = new LatLng(lat, lng);
            MarkerOptions opciones_marcador= new MarkerOptions().position(posicion).title(c.getCity()+" "+c.getPopulation());
            Marker marcador = mapa.addMarker(opciones_marcador);
            marcador.setTag(c);

        }
        mapa.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Ciudad ciudad_clicada = (Ciudad) marker.getTag();
                //Log.d("Clicada", ciudad_clicada.toString());
                Intent i = new Intent(contexto, ActivityWikipedia.class);
                i.putExtra("ciudad", ciudad_clicada.getCity());
                startActivity(i);
                return false;
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapa=googleMap;
        ClasePeticion.pedirJSON(this);
    }
}
