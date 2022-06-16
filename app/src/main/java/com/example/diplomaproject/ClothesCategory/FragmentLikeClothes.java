package com.example.diplomaproject.ClothesCategory;

import android.content.Intent;
import android.os.Bundle;

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

public class FragmentLikeClothes extends Fragment {

    private RecyclerView recyclerView;
    private ClothesLikedListAdapter adapterOne;

    List<Clothes> clothesList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        assert inflater != null;
        final ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_like_clothes, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerViewClothes);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));


        ClothesLikedListAdapter.ItemClickListener listener = (position, clothes) -> {
            Intent intent = new Intent(getActivity(), ClothesDetail.class);
            intent.putExtra("clothes", clothes);
            startActivity(intent);
        };

        ClothesLikedListAdapter.FragmentLikeListener fragmentLikeListener = clothes -> ((MainClothes) requireActivity()).removeItemLike(clothes);
        clothesList = new ArrayList<>();
        adapterOne = new ClothesLikedListAdapter(clothesList, listener, fragmentLikeListener);
        recyclerView.setAdapter(adapterOne);
        return rootView;
    }

    public void saveClothes(Clothes clothes) {
        clothesList.add(clothes);
        Objects.requireNonNull(recyclerView.getAdapter()).notifyItemInserted(clothesList.size() - 1);
    }

    public void removeClothes(Clothes clothes) {
        if (clothesList.indexOf(clothes)==0){
            clothesList.remove(clothes);
        } else {
            int position = clothesList.indexOf(clothes);
            clothesList.remove(clothes);
            Objects.requireNonNull(recyclerView.getAdapter()).notifyItemRemoved(position);
        }
    }
    public void removeLike(Clothes clothes){
        int n = clothesList.indexOf(clothes);
        this.removeClothes(clothes);
        adapterOne.notifyItemRemoved(n);
    }
}