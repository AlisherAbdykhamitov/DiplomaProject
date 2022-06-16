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

public class LikedListAdapter extends RecyclerView.Adapter<LikedListAdapter.LikedDonationsViewHolder> {
    private final List<Donations> donationsList;
    private boolean hearted = false;
    @Nullable
    private final LikedListAdapter.ItemClickListener listener;
    private @Nullable
    FragmentLikeListener fragmentLikeListener;



    public LikedListAdapter(List<Donations> donationsList, @Nullable ItemClickListener listener,
                            @Nullable FragmentLikeListener fragmentLikeListener) {

        this.donationsList = donationsList;
        this.listener = listener;
        this.fragmentLikeListener = fragmentLikeListener;

    }

    @NonNull
    @Override

    public LikedDonationsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.donation_items, null, false);
        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        view.setLayoutParams(params);
        return new LikedDonationsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final LikedDonationsViewHolder holder, final int position) {

        final Donations donations = donationsList.get(getItemViewType(position));
        Glide.with(holder.image.getContext()).load(donations.getImage()).into(holder.image);
        holder.name.setText(donations.getName());
//        String s = "<b>"+ donations.getName()+ "</b>" + " "+ donations.getSite();
        holder.site.setText(donations.getSite());
        holder.description.setText(donations.getDescription());
        holder.likeBtn.setImageResource(R.drawable.hearted);



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

    public static class LikedDonationsViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView site;
        ImageButton likeBtn;
        TextView description;

        public LikedDonationsViewHolder(@NonNull View itemView) {

            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            site = itemView.findViewById(R.id.site);
            likeBtn = itemView.findViewById(R.id.likeBtn);
            description = itemView.findViewById(R.id.description);
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