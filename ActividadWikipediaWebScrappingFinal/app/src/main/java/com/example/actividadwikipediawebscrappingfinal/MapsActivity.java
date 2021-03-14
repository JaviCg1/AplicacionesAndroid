package com.example.actividadwikipediawebscrappingfinal;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.Document;

import java.io.IOException;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Button but;
    private EditText lng, lat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_final);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        but = findViewById(R.id.send);
        lat = findViewById(R.id.lat);
        lng = findViewById(R.id.lng);
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
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LatLng ciudad = new LatLng(Double.parseDouble(lat.getText().toString()), Double.parseDouble(lng.getText().toString()));
                mMap.addMarker(new MarkerOptions().position(ciudad).title("Marker in ciudad"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(ciudad));
            }
        });
        // Add a marker in Sydney and move the camera


    }

    public String obtenerDatos(String n){
        Document doc;
        try {
            doc = (Document) Jsoup.connect("https://es.wikipedia.org/wiki/Madrid").get();

            Element elemenPadre = (Element) doc.getElementById("sg-col-16-of-20 sg-col sg-col-8-of-12 sg-col-12-of-16");
            Elements elemensPadre = elemenPadre.getElementsByClass("rush-component s-expand-height");
            //("sg-col-inner");

            for (Element elemento : elemensPadre) {
                Element eImagen = elemento.getElementsByClass("s-image").first();
                Element eTitulo = elemento.select("span.a-size-base-plus").first();
                Element ePrecio = elemento.select("span.a-offscreen").first();
                String ruta = eImagen.absUrl("src");
                String titulo = eTitulo.text();
                String precio = ePrecio.text();
                System.out.println(titulo + " "+precio+" "+ruta);
            }


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}