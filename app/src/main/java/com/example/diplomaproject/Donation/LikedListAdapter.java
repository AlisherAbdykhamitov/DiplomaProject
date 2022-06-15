package com.example.diplomaproject.Donation;

import android.annotation.SuppressLint;
import android.text.Html;
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

public class LikedListAdapter extends RecyclerView.Adapter<LikedListAdapter.LikedNewsViewHolder> {
    private final List<Donations> donationsList;

    @Nullable
    private final LikedListAdapter.ItemClickListener listener;
    private @Nullable
    final
    FragmentLikeListener fragmentLikeListener;



    public LikedListAdapter(List<Donations> donationsList, @Nullable ItemClickListener listener,
                            @Nullable FragmentLikeListener fragmentLikeListener) {

        this.donationsList = donationsList;
        this.listener = listener;
        this.fragmentLikeListener = fragmentLikeListener;

    }

    @NonNull
    @Override

    public LikedNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @SuppressLint("InflateParams") View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.donation_items, null, false);
        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        view.setLayoutParams(params);
        return new LikedNewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final LikedNewsViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        final Donations donations = donationsList.get(getItemViewType(position));
        holder.name.setText(donations.getName());
        String s = "<b>"+ donations.getName()+ "</b>" + " "+ donations.getSite();
        holder.site.setText(Html.fromHtml(s));
        holder.likeBtn.setImageResource(R.drawable.hearted);
        Glide.with(holder.image.getContext()).load(donations.getImage()).into(holder.image);


        holder.likeBtn.setOnClickListener(v -> {
            if (fragmentLikeListener != null)
                fragmentLikeListener.removeItemLike(donations);
        });

        holder.itemView.setOnClickListener(v -> {
            if (listener != null)
                listener.itemClick(position, donations);
        });
    }


    @Override
    public int getItemCount() {
        return donationsList.size();
    }

    public static class LikedNewsViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;
        TextView site;
        ImageButton likeBtn;

        public LikedNewsViewHolder(@NonNull View itemView) {

            super(itemView);
            name = itemView.findViewById(R.id.name);
            image = itemView.findViewById(R.id.image);
            site = itemView.findViewById(R.id.site);
            likeBtn = itemView.findViewById(R.id.likeBtn);
        }
    }

    interface ItemClickListener {
        void itemClick(int position, Donations item);

    }
    public int getItemViewType(int position){
        return position;
    }

    public interface FragmentLikeListener {
        void removeItemLike(Donations donations);
    }



}