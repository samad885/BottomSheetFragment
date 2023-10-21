package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.viewHolder> {
    Context context;
    ArrayList<ChildModel> childModels;
    public interface ClickListener {
        void onClicked(ChildModel childModel);
    }

    ChildAdapter.ClickListener clickListener;

    public ChildAdapter(Context context, ArrayList<ChildModel> childModels, ChildAdapter.ClickListener clickListener) {
        this.context = context;
        this.childModels = childModels;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.child_item_layout, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        ChildModel childModel = childModels.get(position);
        holder.ind_num.setText(childModel.getPro_Num());
        holder.title.setText(childModel.getPro_name());

        holder.itemView.setOnClickListener(v -> {
            clickListener.onClicked(childModel);
        });
    }

    @Override
    public int getItemCount() {
        return childModels.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        TextView ind_num, title;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            ind_num = itemView.findViewById(R.id.ind_num);
            title = itemView.findViewById(R.id.title);
        }
    }
}
