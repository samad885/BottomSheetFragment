package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class BlankFragment extends BottomSheetDialogFragment {
    RecyclerView recyclerView;
    ArrayList<ChildModel> childModels = new ArrayList<>();
    ChildAdapter adapter;
    private static View view;
    JSONObject userDetail;
    TextView cat_name;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        view = inflater.inflate(R.layout.fragment_blank, container, false);

        recyclerView = view.findViewById(R.id.child_rv);
        cat_name = view.findViewById(R.id.cat_name);
        cat_name.setText(getTag());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        try {
            JSONObject jsonObject = new JSONObject(loadJSONfromAssets());

            JSONArray userArray = jsonObject.getJSONArray(getTag());

            for (int i = 0; i < userArray.length(); i++) {
                userDetail = userArray.getJSONObject(i);
                childModels.add(new ChildModel(userDetail.getString("indNum"), userDetail.getString("queName"),
                        userDetail.getString("code"), userDetail.getString("output")));
            }

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        adapter = new ChildAdapter(getContext(), childModels, childModel -> {
            Toast.makeText(getContext(), "Child Clicked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getContext(), SecondActivity.class);
            intent.putExtra("code", childModel.getCode());
            intent.putExtra("output", childModel.getOutput());
            startActivity(intent);
        });
        recyclerView.setAdapter(adapter);
        return view;
    }

    private String loadJSONfromAssets() {
        String json;
        try {
            AssetManager assetManager = getContext().getAssets();
            InputStream inputStream = assetManager.open("other_pro.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return json;
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        super.onDismiss(dialog);
        childModels.clear();
    }

    @Override
    public void onCancel(@NonNull DialogInterface dialog) {
        super.onCancel(dialog);
        childModels.clear();
    }
}