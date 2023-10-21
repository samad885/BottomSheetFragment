package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.viewHolder> {
    Context context;
    ArrayList<Model> models;
    public interface ClickListener {
        void onClicked(Model model);
    }

    ClickListener clickListener;

    public Adapter(Context context, ArrayList<Model> models, ClickListener clickListener) {
        this.context = context;
        this.models = models;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public Adapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.viewHolder holder, int position) {
        Model model = models.get(position);
        holder.f_name.setText(model.getF_name());
        holder.name.setText(model.getName());

        holder.itemView.setOnClickListener(v -> {
            clickListener.onClicked(model);
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        TextView f_name, name;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            f_name = itemView.findViewById(R.id.f_name);
            name = itemView.findViewById(R.id.name);
        }
    }
}
