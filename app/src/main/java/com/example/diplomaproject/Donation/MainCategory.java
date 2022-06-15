package com.example.diplomaproject.Donation;



import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;


import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.diplomaproject.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


import java.util.ArrayList;
import java.util.List;


public class MainCategory extends AppCompatActivity implements DonationsListAdapter.FragmentButtonListener,
        LikedListAdapter.FragmentLikeListener{
    LockableViewPager  pager;
    private MenuItem prevMenuItem;
    private BottomNavigationView bottomNavigationView;
    List<Fragment> list = new ArrayList<>();

    PageFragment pagefragment = new PageFragment();
    FragmentLike fragment = new FragmentLike();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_category);


        list.add(pagefragment);//добавляем фрагмент
        list.add(fragment);
        pager = findViewById(R.id.pager);
        pager.setSwipable(true);
        CustomPagerAdapter pagerAdapter = new CustomPagerAdapter(getSupportFragmentManager(), list);
        pager.setAdapter(pagerAdapter);

        bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.navigation_home:
                    pager.setCurrentItem(0, false);
                    bottomNavigationView.getMenu().findItem(R.id.navigation_home).setIcon(R.drawable.home);
                    bottomNavigationView.getMenu().findItem(R.id.navigation_likes).setIcon(R.drawable.heart);

                    break;
                case R.id.navigation_likes:
                    pager.setCurrentItem(1,false);
                    item.setIcon(R.drawable.hearted);
                    break;

            }

            return true;
        });

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null)
                    prevMenuItem.setChecked(false);
                else
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);

                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });




    }
    @Override
    public void myClick(Donations donations, int option) {

        if (option==1)
            fragment.saveNews(donations);
        else
            fragment.removeNews(donations);
    }


    public void removeItemLike(Donations donations) {
        pagefragment.removeLike(donations);
        fragment.removeLike(donations);
    }
}




