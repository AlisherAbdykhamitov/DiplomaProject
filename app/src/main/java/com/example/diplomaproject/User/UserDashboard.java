package com.example.diplomaproject.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.diplomaproject.Adapter.RecyclerAdapter;
import com.example.diplomaproject.Adapter.RecyclerClass;
import com.example.diplomaproject.CategoryDonations;
import com.example.diplomaproject.Database.SessionClassManager;
import com.example.diplomaproject.Donation.MainCategory;
import com.example.diplomaproject.LoginSignup.StartUpScreen;
import com.example.diplomaproject.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;

public class UserDashboard extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener{

    static final float VALUE_END = 0.7f;
    //Var
    RecyclerView recyclerView, categoryView;
    RecyclerView.Adapter adapter;

   // private GradientDrawable gradient1, gradient2, gradient3, gradient4;
    ImageView menuIcon;
    LinearLayout linearLayout;


    //DrawMenu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);


        //bottomNavigationView = findViewById(R.id.bottom_navigation);



        //Hooks
       recyclerView = findViewById(R.id.recycler_view_first);
      // categoryView = findViewById(R.id.cat_recycler_view);
       menuIcon = findViewById(R.id.menu_icon);
       linearLayout = findViewById(R.id.content_view_layout);

       //Menu Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        navigationDrawer();
        recyclerView();


//        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                Fragment fragment = null;
//                switch (item.getItemId()){
//                    case R.id.home_nav:
//                        fragment = new MainFragment();
//                        break;
//                    case R.id.liked_nav:
//                        fragment = new LikeFragment();
//                        break;
//                    case R.id.profile_nav:
//                        fragment = new ProfileFragment();
//                        break;
//                }
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
//                return true;
//            }
//        });

    }

    //Nav Drway Func
    private void navigationDrawer() {

        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);
        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(drawerLayout.isDrawerVisible(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });
       animNavigation();
    }

    private void animNavigation() {
       // drawerLayout.setScrimColor(getResources().getColor(R.color.goodColor));
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                final float diffScaledOffset = slideOffset * (1-VALUE_END);
                final float offsetScale = 1 - diffScaledOffset;
                linearLayout.setScaleX(offsetScale);
                linearLayout.setScaleY(offsetScale);

                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = linearLayout.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                linearLayout.setTranslationX(xTranslation);


            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerVisible(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item){

        switch (item.getItemId()){

            case R.id.nav_login:
                SessionClassManager sessionClassManager = new SessionClassManager(this);
                if(sessionClassManager.checkLoginUser()){
                    Intent intent = new Intent(getApplicationContext(), StartUpScreen.class);
                    startActivity(intent);
                    break;

                }else{
                    Intent intent = new Intent(getApplicationContext(),UserProfile.class);
                    startActivity(intent);
                    break;
                }
            case R.id.nav_home:
                Intent intent4 = new Intent(getApplicationContext(), UserDashboard.class);
                startActivity(intent4);
                break;
            case R.id.nav_profile:
                Intent intent1 = new Intent(getApplicationContext(), UserProfile.class);
                startActivity(intent1);
                break;
            case R.id.nav_logout:
                SessionClassManager sessionClassManager1 = new SessionClassManager(this);
                sessionClassManager1.logoutUserFormSession();
                Intent intent2 = new Intent(getApplicationContext(), UserProfile.class);
                startActivity(intent2);
                break;
            case R.id.nav_categ:
                Intent intent3 = new Intent(getApplicationContext(), MainCategory.class);
                startActivity(intent3);
                break;

        }

        return true;
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

//    private void categoriesRecycler() {
//        //All Gradients
//        gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
//        gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
//        gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
//        gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});
//
//
//        ArrayList<CategoryHelperClass> categoriesHelperClasses = new ArrayList<>();
//        categoriesHelperClasses.add(new CategoryHelperClass(gradient1, R.drawable.food_cat, "Education"));
//        categoriesHelperClasses.add(new CategoryHelperClass(gradient2, R.drawable.food_cat, "HOSPITAL"));
//        categoriesHelperClasses.add(new CategoryHelperClass(gradient3, R.drawable.food_cat, "Restaurant"));
//        categoriesHelperClasses.add(new CategoryHelperClass(gradient4, R.drawable.food_cat, "Shopping"));
//        categoriesHelperClasses.add(new CategoryHelperClass(gradient1, R.drawable.food_cat, "Transport"));
//
//
//        categoryView.setHasFixedSize(true);
//        adapter = new CategoryAdapter(categoriesHelperClasses);
//        categoryView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//        categoryView.setAdapter(adapter);
//
//    }
    public void viewDonationCategory(View view){
        Intent intent =new Intent(getApplicationContext(), CategoryDonations.class);
        startActivity(intent);
    }

    public void goToCategories(View view){
        Intent intent = new Intent(getApplicationContext(), MainCategory.class);
        startActivity(intent);
    }
}
