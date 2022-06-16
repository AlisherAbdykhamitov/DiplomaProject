package com.example.diplomaproject.ClothesCategory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.diplomaproject.R;

import java.util.List;


public class ClothesLikedListAdapter extends RecyclerView.Adapter<com.example.diplomaproject.ClothesCategory.ClothesLikedListAdapter.LikedClothesViewHolder> {
    private final List<Clothes> clothesList;
    private boolean hearted = false;
    @Nullable
    private final com.example.diplomaproject.ClothesCategory.ClothesLikedListAdapter.ItemClickListener listener;
    private @Nullable
    com.example.diplomaproject.ClothesCategory.ClothesLikedListAdapter.FragmentLikeListener fragmentLikeListener;



    public ClothesLikedListAdapter(List<Clothes> clothesList, @Nullable com.example.diplomaproject.ClothesCategory.ClothesLikedListAdapter.ItemClickListener listener,
                            @Nullable com.example.diplomaproject.ClothesCategory.ClothesLikedListAdapter.FragmentLikeListener fragmentLikeListener) {

        this.clothesList = clothesList;
        this.listener = listener;
        this.fragmentLikeListener = fragmentLikeListener;

    }

    @NonNull
    @Override

    public com.example.diplomaproject.ClothesCategory.ClothesLikedListAdapter.LikedClothesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.clothes_items, null, false);
        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        view.setLayoutParams(params);
        return new com.example.diplomaproject.ClothesCategory.ClothesLikedListAdapter.LikedClothesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final com.example.diplomaproject.ClothesCategory.ClothesLikedListAdapter.LikedClothesViewHolder holder, final int position) {

        final Clothes clothes = clothesList.get(getItemViewType(position));
        Glide.with(holder.image.getContext()).load(clothes.getImage()).into(holder.image);
        holder.name.setText(clothes.getName());
        holder.site.setText(clothes.getSite());
        holder.description.setText(clothes.getDescription());
        holder.likeBtn.setImageResource(R.drawable.hearted);



        holder.likeBtn.setOnClickListener(v -> {
            if (fragmentLikeListener != null)
                fragmentLikeListener.removeItemLike(clothes);
        });

        holder.itemView.setOnClickListener(v -> {
            if (listener != null)
                listener.itemClick(position, clothes);
        });
    }


    @Override
    public int getItemCount() {
        return clothesList.size();
    }

    public static class LikedClothesViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView site;
        ImageButton likeBtn;
        TextView description;

        public LikedClothesViewHolder(@NonNull View itemView) {

            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            site = itemView.findViewById(R.id.site);
            likeBtn = itemView.findViewById(R.id.likeBtn);
            description = itemView.findViewById(R.id.description);
        }
    }

    interface ItemClickListener {
        void itemClick(int position, Clothes item);

    }
    public int getItemViewType(int position){
        return position;
    }

    public interface FragmentLikeListener {
        void removeItemLike(Clothes clothes);
    }



}
