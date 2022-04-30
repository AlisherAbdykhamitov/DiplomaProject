package com.example.diplomaproject.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diplomaproject.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.HelperClass> {

    ArrayList<CategoryHelperClass> arrayList;

    public CategoryAdapter(ArrayList<CategoryHelperClass> arrayList){
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public HelperClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categoried_card_design,parent,false);
        HelperClass h = new HelperClass(view);
        return h;
    }

    @Override
    public void onBindViewHolder(@NonNull HelperClass holder, int position) {
        CategoryHelperClass helperClass = arrayList.get(position);

        holder.imageView.setImageResource(helperClass.getImage());
        holder.textView.setText(helperClass.getText());
        holder.relativeLayout.setBackground(helperClass.gradient);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class HelperClass extends RecyclerView.ViewHolder{

        RelativeLayout relativeLayout;
        ImageView imageView;
        TextView textView;

        public HelperClass(@NonNull View itemView) {
            super(itemView);

            relativeLayout = itemView.findViewById(R.id.relative_layout1);
            imageView = itemView.findViewById(R.id.image_card_view);
            textView = itemView.findViewById(R.id.text_card_view);
        }
    }
}
