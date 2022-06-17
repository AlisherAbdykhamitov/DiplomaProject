package com.example.diplomaproject.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.diplomaproject.Adapter.CategoryAdapter;
import com.example.diplomaproject.Adapter.CategoryHelperClass;
import com.example.diplomaproject.Adapter.RecyclerAdapter;
import com.example.diplomaproject.Adapter.RecyclerClass;
import com.example.diplomaproject.ClothesCategory.MainClothes;
import com.example.diplomaproject.Database.SessionClassManager;
import com.example.diplomaproject.Donation.MainCategory;
import com.example.diplomaproject.LoginSignup.StartUpScreen;
import com.example.diplomaproject.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener{

    static final float VALUE_END = 0.7f;
    //Var
    RecyclerView recyclerView, categoryView;
    RecyclerView.Adapter adapter;

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
            case R.id.nav_clothes:
                Intent intent5 = new Intent(getApplicationContext(), MainClothes.class);
                startActivity(intent5);
                break;

        }

        return true;
    }

    private void recyclerView(){

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<RecyclerClass> recyclerClasses = new ArrayList<>();

        recyclerClasses.add(new RecyclerClass(R.drawable.recycler_view_first, "Help","A set of volunteer help situations. Volunteers at work. Helping people, animals and nature. Charity donation.","Winston Churchill"));
        recyclerClasses.add(new RecyclerClass(R.drawable.recycler_view_second, "Love","I love you not for who you are, but for who I am when I am with you.","Gabriel Garcia Marquez"));
        recyclerClasses.add(new RecyclerClass(R.drawable.recycler_view_third, "Family","Feelings should develop into a family, and not into a lump in the throat that interferes with life.","Lina Keycher"));

        adapter = new RecyclerAdapter(recyclerClasses);
        recyclerView.setAdapter(adapter);


    }

    public void goToCategories(View view){
        Intent intent = new Intent(getApplicationContext(), MainCategory.class);
        startActivity(intent);
    }

    public void ViewAllCategories(View view){
        Intent intent = new Intent(getApplicationContext(), MainCategory.class);
        startActivity(intent);
    }

    public void goToClothes(View view){
        Intent intent = new Intent(getApplicationContext(), MainClothes.class);
        startActivity(intent);

    }
}
