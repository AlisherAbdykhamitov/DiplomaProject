package com.example.diplomaproject.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diplomaproject.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    ArrayList<RecyclerClass> recyclerClasses;

    public RecyclerAdapter(ArrayList<RecyclerClass> recyclerClasses) {
        this.recyclerClasses = recyclerClasses;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_card,parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

        RecyclerClass recyclerClass = recyclerClasses.get(position);

        holder.image.setImageResource(recyclerClass.getImage());
        holder.title.setText(recyclerClass.getTitle());
        holder.description.setText(recyclerClass.getDescription());

    }

    @Override
    public int getItemCount() {
        return recyclerClasses.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title, description;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);


            //hooks
            image = itemView.findViewById(R.id.image_recycler_view_first);
            title = itemView.findViewById(R.id.text_recycler_view_first);
            description = itemView.findViewById(R.id.desc_recycler_view_first);
        }
    }
}
