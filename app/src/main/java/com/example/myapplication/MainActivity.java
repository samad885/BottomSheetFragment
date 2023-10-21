package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Adapter adapter;
    ArrayList<Model> models = new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.mani_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        models.add(new Model("B","Basic"));
        models.add(new Model("G","General"));
        models.add(new Model("A","Array"));
        models.add(new Model("S","String"));
        models.add(new Model("M","Matrix (2D Array)"));
        models.add(new Model("S","Sorting"));
        models.add(new Model("S","Searching"));
        models.add(new Model("F","Function"));
        models.add(new Model("O","Operator"));
        models.add(new Model("C","Conversion"));
        models.add(new Model("S","Structure and Union"));
        models.add(new Model("P","Pointer"));

        BlankFragment fragment = new BlankFragment();

        adapter = new Adapter(this, models, model -> {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
            fragment.show(getSupportFragmentManager(), model.getName());
        });
        recyclerView.setAdapter(adapter);
    }


}