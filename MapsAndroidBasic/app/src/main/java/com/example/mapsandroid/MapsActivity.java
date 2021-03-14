package com.example.mapsandroid;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Spinner spinner;
    Button button;
    ArrayList<LatLng> location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        location = new ArrayList<LatLng>();

        LatLng murcia = new LatLng(37.99238, -1.130543);
        location.add(murcia);
        LatLng varsovia = new LatLng( 52.225797, 21.00642);
        location.add(varsovia);
        LatLng berlin = new LatLng( 52.517037, 13.38886);
        location.add(berlin);

        button = findViewById(R.id.button);
        spinner = findViewById(R.id.spinner);

        ArrayAdapter<LatLng> adaptadorProvincias = new ArrayAdapter<LatLng>(this, R.layout.support_simple_spinner_dropdown_item, location);
        spinner.setAdapter(adaptadorProvincias);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LatLng murcia = (LatLng) spinner.getSelectedItem();
                mMap.addMarker(new MarkerOptions().position(murcia).title("Marker in "+spinner.getSelectedItem().getClass().getSimpleName()));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(murcia));
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