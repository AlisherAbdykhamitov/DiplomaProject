package com.example.diplomaproject.Donation;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.diplomaproject.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class FragmentLike extends Fragment {

    private RecyclerView recyclerView;
    private LikedListAdapter adapter;

    List<Donations> donationsList;

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        assert inflater != null;
        final ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_like, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));


        LikedListAdapter.ItemClickListener listener = (position, donations) -> {
            Intent intent = new Intent(getActivity(), DonationsDetailActivity.class);
            intent.putExtra("donations", donations);
            startActivity(intent);
        };


        LikedListAdapter.FragmentLikeListener fragmentLikeListener = donations -> ((MainCategory) requireActivity()).removeItemLike(donations);
        donationsList = new ArrayList<>();
        adapter = new LikedListAdapter(donationsList, listener, fragmentLikeListener);
        recyclerView.setAdapter(adapter);
        return rootView;
    }


    public void saveDonations(Donations donations) {
        donationsList.add(donations);
        Objects.requireNonNull(recyclerView.getAdapter()).notifyItemInserted(donationsList.size() - 1);
    }

    public void removeDonations(Donations donations) {
        if (donationsList.indexOf(donations)==0){
            donationsList.remove(donations);
        } else {
            int position = donationsList.indexOf(donations);
            donationsList.remove(donations);
            Objects.requireNonNull(recyclerView.getAdapter()).notifyItemRemoved(position);
        }
    }
    public void removeLike(Donations donations){
        int n = donationsList.indexOf(donations);
        this.removeDonations(donations);
        adapter.notifyItemRemoved(n);
    }


}