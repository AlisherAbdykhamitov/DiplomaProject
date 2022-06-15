package com.example.diplomaproject.Donation;

import android.annotation.SuppressLint;
import android.text.Html;
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

public class DonationsListAdapter extends RecyclerView.Adapter<DonationsListAdapter.NewsViewHolder> {
    List<Donations> donationsList;
    @Nullable
    private final ItemClickListener listener;
    private @Nullable
    final
    FragmentButtonListener fragmentButtonListener;
    private @Nullable
    final
    FragmentLikeListener fragmentLikeListener;


    public DonationsListAdapter(List<Donations> donationsList, @Nullable ItemClickListener listener, @Nullable FragmentButtonListener fragmentButtonListener,
                                @Nullable FragmentLikeListener fragmentLikeListener) {
        Donations.donationsList = donationsList;
        this.donationsList = donationsList;
        this.listener = listener;
        this.fragmentButtonListener = fragmentButtonListener;
        this.fragmentLikeListener = fragmentLikeListener;
    }

    @NonNull
    @Override

    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @SuppressLint("InflateParams") View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.donation_items, null, false);
        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        view.setLayoutParams(params);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final NewsViewHolder holder, final int position) {


        final Donations donations = donationsList.get(getItemViewType(position));
        holder.name.setText(donations.getName());
        String s = "<b>" + donations.getName() + "</b>" + " " + donations.getSite();
        holder.site.setText(Html.fromHtml(s));

        Glide.with(holder.image.getContext()).load(donations.getImage()).into(holder.image);


        if (donations.getHeart()) holder.likeBtn.setImageResource(R.drawable.hearted);
        else holder.likeBtn.setImageResource(R.drawable.heart);

        holder.likeBtn.setOnClickListener(v -> {
            Toast.makeText(v.getContext(), "Like", Toast.LENGTH_SHORT).show();

            if (fragmentButtonListener != null) {
                if (!donations.getHeart()) {
                    holder.likeBtn.setImageResource(R.drawable.hearted);
                    fragmentButtonListener.myClick(donations, 1);
                    donations.setheart(true);

                } else {
                    holder.likeBtn.setImageResource(R.drawable.heart);

                    assert fragmentLikeListener != null;
                    fragmentLikeListener.removeItemLike(donations);
                    donations.setheart(false);
                }
            }

        });


        holder.itemView.setOnClickListener(v -> {
            if (listener != null)
                listener.itemClick(position, donations);

        });

    }

    @Override
    public int getItemCount() {
        return Donations.donationsList.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView image;
        TextView site;
        ImageButton likeBtn;

        public NewsViewHolder(@NonNull View itemView) {

            super(itemView);
            name = itemView.findViewById(R.id.name);
            image = itemView.findViewById(R.id.image);
            site = itemView.findViewById(R.id.  site);
            likeBtn = itemView.findViewById(R.id.likeBtn);
        }
    }

    interface ItemClickListener {
        void itemClick(int position, Donations item);

    }

    public interface FragmentLikeListener {
        void removeItemLike(Donations news);
    }

    public int getItemViewType(int position) {
        return position;
    }

    public void removeLike(Donations news) {
        int n = Donations.donationsList.indexOf(news);
        news.setHeart(false);
        news.setLikeBtn(R.drawable.heart);
        Donations.donationsList.set(n, news);
        donationsList.set(n,news);

        this.notifyItemChanged(n);
    }

    public interface FragmentButtonListener {
        void myClick(Donations donations, int option);
    }

}