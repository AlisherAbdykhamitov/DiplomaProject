package com.example.diplomaproject.ClothesCategory;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.diplomaproject.R;
import com.example.diplomaproject.User.UserDashboard;

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
        ImageView backBtn = rootView.findViewById(R.id.backBtn);
        backBtn.setOnClickListener(view -> onBackPressed());
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

    private void onBackPressed() {
        Intent intent = new Intent(getContext(), UserDashboard.class);
        startActivity(intent);
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

        image.add(R.drawable.sarai);
        name.add("Sarai: Donate your clothes\n");
        site.add("By sarai.kz\n");
        description.add("SARAI will help you unload unnecessary things cluttering up your house for free. All this is given a second life for secondary consumption. Items are accepted without marriage in working order. If you have not accumulated unnecessary luggage, you can team up with neighbors and call the service all together, or personally take them to the reception point.");

        image.add(R.drawable.teplo);
        name.add("Share the Warmth “Teplo”  ");
        site.add("By teplo.kz");
        description.add("The TEPLO social and charitable project was founded in January 2017. During the work of the project, clothes were collected for 500 thousand people.\n" +
                "\n" +
                "You can leave things in boxes specially installed around the city, after which they will be sent to low-income families, orphanages and social assistance centers. Items that prove unwearable will be used to insulate animal shelters during the winter.");

        image.add(R.drawable.dara2);
        name.add("Donate your clothes to \"Dar\"  Foundation ");
        site.add("By of dara.kz");
        description.add("The main goal of the fund is to help children in difficult situations, such as orphans, children left without parental care, large families, children with disabilities, as well as children in need of treatment.\n" +
                "During the operation of the fund, more than a dozen shares of promotions have been implemented.");

        image.add(R.drawable.ccccc);
        name.add("Charity shop in \"Keremet\"");
        site.add("By Caritas.org");
        description.add("Caritas Kazakhstan was founded in 1997 in response to the rise of poverty after the collapse of the Soviet Union. Its initiatives included soup kitchens across the country, orphanages and centers for homeless people. Caritas Kazakhstan’s head office is located in Almaty; it unites 4 Dioceses with their respective regional organizations.");

        image.add(R.drawable.clothes_);
        name.add("Second wind");
        site.add("By vtoroe.ru/");
        description.add("More than two million tons of clothes and textile waste are thrown away in Russia every year. Clothing takes up to 200 years to decompose, and in the process releases methane, pollutes soil and groundwater, and increases landfill volume. At the same time, 15% of Russian families cannot afford to buy clothes.");
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