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


public class ClothesPageFragment extends Fragment {

    private ClothesListAdapter adapter;
    private RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(
                R.layout.fragment_clothes_page, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerViewClothes);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));

        ClothesListAdapter.ItemClickListener listener = (position, item) -> {
            Intent intent = new Intent(rootView.getContext(), ClothesDetail.class);
            intent.putExtra("clothes", item);
            startActivity(intent);
        };
        ClothesListAdapter.FragmentButtonListenerClothes fragmentButtonListener = (clothes, option) -> ((MainClothes) requireActivity()).myClick(clothes, option);

        ClothesListAdapter.FragmentLikeListenerClothes fragmentLikeListenerClothes = clothes -> ((MainClothes) requireActivity()).removeItemLike(clothes);


        adapter = new ClothesListAdapter(clothesGenerator(), listener, fragmentButtonListener, fragmentLikeListenerClothes);
        recyclerView.setAdapter(adapter);


        return rootView;

    }

    public void removeLike(Clothes clothes) {
        adapter.removeLike(clothes);
    }

    public static List<Clothes> clothesGenerator() {
        List<Clothes> items = new ArrayList<>();

        ArrayList<Integer> image = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> site = new ArrayList<>();
        ArrayList<String> description = new ArrayList<>();

        image.add(R.drawable.sabi1);
        name.add("Saby Charitable Foundation\n");
        site.add("By saby.kz\n");
        description.add("The Mission of Saby Foundation is to enhance the understanding by the general public of charitable activities, and to make philanthropy effective for charity recipients and attractive for sponsors. \n" +
                "\n" +
                "Programs of Foundation:\n" +
                " \n" +
                "Ecological program \n" +
                "Project \"School-Gymnasium No. 174. Coaching\" \n" +
                "Building project Orkendeu\n" +
                "Sport-Health-Achievements\n" +
                "Education program\n" +
                "Medical Project\n");

        image.add(R.drawable.sh1);
        name.add("Shugyla Charitable Foundation");
        site.add("By shugyla.kz");
        description.add("Organzization goals:\n" +
                "\n" +
                "contribution to the formation of a conscious and healthy lifestyle of society, especially young people\n" +
                "implementation of socially significant projects\n" +
                "organization and holding of events aimed at charity\n" +
                " \n" +
                "Organization tasks includes conducting on-site preventive medical examinations of the rural population in order to detect diseases at an early stage and prevent their development. ");

        image.add(R.drawable.dara2);
        name.add("\"Dara\"Charitable Foundation ");
        site.add("By of dara.kz");
        description.add("The main goal of the fund is to help children in difficult situations, such as orphans, children left without parental care, large families, children with disabilities, as well as children in need of treatment.\n" +
                "During the operation of the fund, more than a dozen shares of promotions have been implemented.");

        image.add(R.drawable.car12);
        name.add("Caritas Charitable Organization");
        site.add("By Caritas.org");
        description.add("Caritas Kazakhstan was founded in 1997 in response to the rise of poverty after the collapse of the Soviet Union. Its initiatives included soup kitchens across the country, orphanages and centers for homeless people. Caritas Kazakhstan’s head office is located in Almaty; it unites 4 Dioceses with their respective regional organizations.");

        image.add(R.drawable.ukra);
        name.add("Ukraine Crisis Relief Fund");
        site.add("By Global.org");
        description.add("Russia has invaded Ukraine in the biggest state-against-state attack since World War II. Millions of civilians are caught in the middle of an escalating war and humanitarian crisis, and casualties are rising. Your donation to this fund will support Ukrainians in need, with a focus on the most vulnerable, including children.");

        image.add(R.drawable.below);
        name.add("");
        site.add("");
        description.add("");


        for (int i = 0; i < image.size(); i++) {
            Clothes clothes = new Clothes(
                    image.get(i),
                    name.get(i),
                    site.get(i),
                    description.get(i)
            );
            items.add(clothes);
        }
        return items;
    }
}