package com.example.diplomaproject.ClothesCategory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.diplomaproject.R;

import java.util.List;

public class ClothesListAdapter extends RecyclerView.Adapter<ClothesListAdapter.ClothesViewHolder> {
    List<Clothes> clothesList;
    @Nullable
    private final com.example.diplomaproject.ClothesCategory.ClothesListAdapter.ItemClickListener listener;
    private @Nullable
    final
    com.example.diplomaproject.ClothesCategory.ClothesListAdapter.FragmentButtonListenerClothes fragmentButtonListener;
    private @Nullable
    final
    ClothesListAdapter.FragmentLikeListenerClothes fragmentLikeListener;


    public ClothesListAdapter(List<Clothes> clothesList, @Nullable com.example.diplomaproject.ClothesCategory.ClothesListAdapter.ItemClickListener listener, @Nullable com.example.diplomaproject.ClothesCategory.ClothesListAdapter.FragmentButtonListenerClothes fragmentButtonListener,
                                @Nullable ClothesListAdapter.FragmentLikeListenerClothes fragmentLikeListener) {
        Clothes.clothesList = clothesList;
        this.clothesList = clothesList;
        this.listener = listener;
        this.fragmentButtonListener = fragmentButtonListener;
        this.fragmentLikeListener = fragmentLikeListener;
    }

    @NonNull
    @Override

    public ClothesListAdapter.ClothesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.clothes_items, null, false);
        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        view.setLayoutParams(params);
        return new ClothesListAdapter.ClothesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ClothesListAdapter.ClothesViewHolder holder, final int position) {


        final Clothes clothes = clothesList.get(getItemViewType(position));
        Glide.with(holder.image.getContext()).load(clothes.getImage()).into(holder.image);
        holder.name.setText(clothes.getName());
        holder.site.setText(clothes.getSite());
        holder.description.setText(clothes.getDescription());



        if (clothes.getHeart()) holder.likeBtn.setImageResource(R.drawable.hearted);
        else holder.likeBtn.setImageResource(R.drawable.heart);

        holder.likeBtn.setOnClickListener(v -> {
            Toast.makeText(v.getContext(), "Like", Toast.LENGTH_SHORT).show();

            if (fragmentButtonListener != null) {
                if (!clothes.getHeart()) {
                    holder.likeBtn.setImageResource(R.drawable.hearted);
                    fragmentButtonListener.myClick(clothes, 1);
                    clothes.setheart(true);

                } else {
                    holder.likeBtn.setImageResource(R.drawable.heart);

                    fragmentLikeListener.removeItemLike(clothes);
                    clothes.setheart(false);
                }
            }

        });


        holder.itemView.setOnClickListener(v -> {
            if (listener != null)
                listener.itemClick(position, clothes);

        });

    }

    @Override
    public int getItemCount() {
        return Clothes.clothesList.size();
    }

    public static class ClothesViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name;
        TextView site;
        ImageButton likeBtn;
        TextView description;

        public ClothesViewHolder(@NonNull View itemView) {

            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            site = itemView.findViewById(R.id.site);
            description = itemView.findViewById(R.id.description);
            likeBtn = itemView.findViewById(R.id.likeBtn);
        }
    }

    interface ItemClickListener {
        void itemClick(int position, Clothes item);

    }

    public interface FragmentLikeListenerClothes {
        void removeItemLike(Clothes clothes);
    }

    public int getItemViewType(int position) {
        return position;
    }

    public void removeLike(Clothes clothes) {
        int n = Clothes.clothesList.indexOf(clothes);
        clothes.setHeart(false);
        clothes.setLikeBtn(R.drawable.heart);
        Clothes.clothesList.set(n, clothes);
        clothesList.set(n,clothes);

        this.notifyItemChanged(n);
    }

    public interface FragmentButtonListenerClothes {
        void myClick(Clothes clothes, int option);
    }

}