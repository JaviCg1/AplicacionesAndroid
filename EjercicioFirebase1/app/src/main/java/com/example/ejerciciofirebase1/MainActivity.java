package com.example.ejerciciofirebase1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText tname;
    EditText tmail;
    Button but, change;
    FirebaseDatabase db;
    DatabaseReference referencia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = FirebaseDatabase.getInstance();
        referencia = db.getReference("agenda");
        Contacto c = new Contacto("Manolo", "manologonzalez@gmail.com");
        tname = findViewById(R.id.idnombre);
        tmail = findViewById(R.id.idmail);
        but = findViewById(R.id.button);
        change = findViewById(R.id.change);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String nombre =  tname.getText().toString();
               String email =  tmail.getText().toString();
               Contacto c = new Contacto(nombre, email);


               referencia.push().setValue(c);
                referencia.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        Iterable<DataSnapshot>datos=dataSnapshot.getChildren();
                        for (DataSnapshot d:datos) {
                            Contacto c2 = d.getValue(Contacto.class);
                            List<ListElement> elements = new ArrayList<>();
                            elements.add(new ListElement("Black",c2.getNombre(),c2.getEmail()));
                            Parse.setList(elements);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Log.d("Datas", databaseError.getMessage());
                    }
                });
            }
        });

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                referencia.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        Iterable<DataSnapshot>datos=dataSnapshot.getChildren();
                        for (DataSnapshot d:datos) {
                            Contacto c2 = d.getValue(Contacto.class);
                            List<ListElement> elements = new ArrayList<>();
                            elements.add(new ListElement("Black",c2.getNombre(),c2.getEmail()));
                            Parse.setList(elements);
                            Log.d("Datas", "Holiiis");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Log.d("Datas", databaseError.getMessage());
                    }
                });
                Intent intent = new Intent(MainActivity.this, ReciclerViewActivity.class);
                startActivity(intent);

            }
        });





    }
}