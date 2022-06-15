package com.example.diplomaproject.Donation;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.diplomaproject.R;


public class DonationsDetailActivity extends AppCompatActivity {
    private ImageView likeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donations_detail);

        Button backBtn = findViewById(R.id.backBtn);
        ImageView image = findViewById(R.id.image);
        TextView name = findViewById(R.id.name);
        TextView site = findViewById(R.id.site);
        likeBtn = findViewById(R.id.likeBtn);


        final Donations donations = (Donations) getIntent().getParcelableExtra("news");
        Glide.with(this).load(donations.getImage()).into(image);
        name.setText(donations.getName());
        String s = "<b>" + donations.getName() + "</b>" + " " + donations.getSite();
        site.setText(Html.fromHtml(s));
        //Boolean hearted = getIntent().getBooleanExtra("hearted", false);

        backBtn.setOnClickListener(v -> onBackPressed());

        likeBtn.setOnClickListener(v -> {
            Toast.makeText(v.getContext(), "Like", Toast.LENGTH_SHORT).show();

            if (donations.getLikeBtn()==R.drawable.heart) {

                Glide.with(likeBtn.getContext()).load(R.drawable.hearted).into(likeBtn);

            } else {
                Glide.with(likeBtn.getContext()).load(R.drawable.heart).into(likeBtn);

            }

        });





    }
}