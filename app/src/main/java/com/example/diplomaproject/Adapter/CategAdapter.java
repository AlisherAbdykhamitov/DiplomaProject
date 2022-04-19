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

public class CategAdapter extends RecyclerView.Adapter<CategAdapter.AllCategoryHelperClass> {


    ArrayList<CategoryHelperClass> arrayList;

    public CategAdapter(ArrayList<CategoryHelperClass> arrayList){
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public CategAdapter.AllCategoryHelperClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categoried_card_design, parent, false);
        AllCategoryHelperClass hlp = new AllCategoryHelperClass(view);
        return hlp;
    }

    @Override
    public void onBindViewHolder(@NonNull CategAdapter.AllCategoryHelperClass holder, int position) {

        CategoryHelperClass helperClass = arrayList.get(position);

        holder.imageView.setImageResource(helperClass.getImage());
        holder.textView.setText(helperClass.getText());
        holder.relativeLayout.setBackground(helperClass.gradient);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class AllCategoryHelperClass extends RecyclerView.ViewHolder{


        RelativeLayout relativeLayout;
        ImageView imageView;
        TextView textView;

        public AllCategoryHelperClass(@NonNull View itemView) {
            super(itemView);


            relativeLayout = itemView.findViewById(R.id.relative_layout1);
            imageView = itemView.findViewById(R.id.image_card_view);
            textView = itemView.findViewById(R.id.text_card_view);
        }


    }
}
