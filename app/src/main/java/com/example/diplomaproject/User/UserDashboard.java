package com.example.diplomaproject.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.diplomaproject.Adapter.CategoryAdapter;
import com.example.diplomaproject.Adapter.CategoryHelperClass;
import com.example.diplomaproject.Adapter.RecyclerAdapter;
import com.example.diplomaproject.Adapter.RecyclerClass;
import com.example.diplomaproject.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity {

    //Var
    RecyclerView recyclerView, categoryView;
    RecyclerView.Adapter adapter;
    private GradientDrawable gradient1, gradient2, gradient3, gradient4;

    //DrawMenu
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        //Hooks
       recyclerView = findViewById(R.id.recycler_view_first);
       categoryView = findViewById(R.id.cat_recycler_view);

       //Menu Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

       //Functions
        recyclerView();
        categoriesRecycler();

    }


    private void recyclerView(){

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<RecyclerClass> recyclerClasses = new ArrayList<>();

        recyclerClasses.add(new RecyclerClass(R.drawable.recycler_view_first, "Help","A set of volunteer help situations. Volunteers at work. Helping people, animals and nature. Charity donation."));
        recyclerClasses.add(new RecyclerClass(R.drawable.recycler_view_first, "Help","A set of volunteer help situations. Volunteers at work. Helping people, animals and nature. Charity donation."));
        recyclerClasses.add(new RecyclerClass(R.drawable.recycler_view_first, "Help","A set of volunteer help situations. Volunteers at work. Helping people, animals and nature. Charity donation."));

        adapter = new RecyclerAdapter(recyclerClasses);
        recyclerView.setAdapter(adapter);


    }
    private void categoriesRecycler() {
        //All Gradients
        gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
        gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});


        ArrayList<CategoryHelperClass> categoriesHelperClasses = new ArrayList<>();
        categoriesHelperClasses.add(new CategoryHelperClass(gradient1, R.drawable.food_cat, "Education"));
        categoriesHelperClasses.add(new CategoryHelperClass(gradient2, R.drawable.food_cat, "HOSPITAL"));
        categoriesHelperClasses.add(new CategoryHelperClass(gradient3, R.drawable.food_cat, "Restaurant"));
        categoriesHelperClasses.add(new CategoryHelperClass(gradient4, R.drawable.food_cat, "Shopping"));
        categoriesHelperClasses.add(new CategoryHelperClass(gradient1, R.drawable.food_cat, "Transport"));


        categoryView.setHasFixedSize(true);
        adapter = new CategoryAdapter(categoriesHelperClasses);
        categoryView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        categoryView.setAdapter(adapter);

    }
    }
