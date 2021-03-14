package com.example.ejerciciofirebase1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ReciclerViewActivity extends AppCompatActivity {
    FirebaseDatabase db;
    List<ListElement> elements = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recicler_view);
        init();

    }

    private void init() {



       List<ListElement> l=Parse.getList();
        for (ListElement l1:l
             ) {
            Log.d("DD", l1.getNombre());

        }
        ListAdapter listAdapter = new ListAdapter(l, this);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);




    }

    public void met(List l){

    }
}