package com.project.discoverskool.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.discoverskool.Classes.ItemDetails;
import com.project.discoverskool.Model;
import com.project.discoverskool.R;

import java.util.ArrayList;

public class InternAdapter extends RecyclerView.Adapter<InternAdapter.PopularSchoolViewHolder> {
    private Context context;
    private ArrayList<Model> modelArrayList;

    public InternAdapter(Context context, ArrayList<Model>modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }


    @Override
    public PopularSchoolViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_school_row_item, parent, false);
        PopularSchoolViewHolder holder = new PopularSchoolViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(PopularSchoolViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        Model model = modelArrayList.get(position);
        holder.name.setText(model.getName());
        holder.location.setText(model.getLocation());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ItemDetails.class);
                intent.putExtra("name",modelArrayList.get(position).getName());
                intent.putExtra("location",modelArrayList.get(position).getLocation());
                intent.putExtra("vacancy",modelArrayList.get(position).getVacancy());
                intent.putExtra("status",modelArrayList.get(position).getStatus());
                intent.putExtra("description",modelArrayList.get(position).getDescription());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public static final class PopularSchoolViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name, location;

        public PopularSchoolViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.school_Image);
            name = itemView.findViewById(R.id.school_title);
            location = itemView.findViewById(R.id.school_location);
        }
    }
}
