package com.example.ejemplolineapolyline;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private EditText et_latitud, et_longitud;
    private Button btn_insertar_punto;
    private PolylineOptions opciones_polyline=new PolylineOptions().color(Color.BLUE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        iniciaizar();

    }

    private void iniciaizar() {
        et_latitud = findViewById(R.id.et_latitud);
        et_longitud = findViewById(R.id.et_longitud);
        btn_insertar_punto =(Button) findViewById(R.id.btn_insertar);
        btn_insertar_punto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Double ltd = Double.parseDouble(et_latitud.getText().toString());
               Double lng = Double.parseDouble(et_longitud.getText().toString());
                Log.d("Datas", ""+lng);
               LatLng punto = new LatLng(ltd, lng);
               opciones_polyline.add(punto);
               mMap.addPolyline(opciones_polyline);
            }
        });
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}