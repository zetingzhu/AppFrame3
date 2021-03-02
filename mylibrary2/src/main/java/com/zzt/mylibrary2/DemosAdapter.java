package com.zzt.mylibrary2;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

/**
 * @author: zeting
 * @date: 2021/1/4
 */
public class DemosAdapter extends RecyclerView.Adapter<DemosAdapter.ViewHolder> {
    private List<ActDemo> dataset;


    public DemosAdapter(List<ActDemo> dataset) {
        this.dataset = dataset;
    }

    public static void setAdapterData(RecyclerView recyclerView, ActDemo[] dataArray) {
        setAdapterData(recyclerView, Arrays.asList(dataArray));
    }

    public static void setAdapterData(RecyclerView recyclerView, List<ActDemo> dataset) {
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(new DemosAdapter(dataset));
        }
    }

    @NonNull
    @Override
    public DemosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull DemosAdapter.ViewHolder holder, int position) {
        holder.title.setText(dataset.get(position).title);
        holder.description.setText(dataset.get(position).description);
        holder.activity = dataset.get(position).activity;
    }

    @Override
    public int getItemCount() {
        return dataset == null ? 0 : dataset.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        Class<?> activity = null;
        TextView title;
        TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            itemView.setOnClickListener(v -> {
                if (activity != null) {
                    itemView.getContext().startActivity(new Intent(itemView.getContext(), activity));
                }
            });
        }
    }


}
