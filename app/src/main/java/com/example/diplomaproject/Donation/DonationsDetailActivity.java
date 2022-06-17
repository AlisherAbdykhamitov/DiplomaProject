package com.example.diplomaproject.Donation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.diplomaproject.R;
import com.example.diplomaproject.User.UserDashboard;
import com.stripe.android.PaymentConfiguration;
import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.PaymentSheetResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class DonationsDetailActivity extends AppCompatActivity {
    private ImageView likeBtn;

    private ImageView imageViewIntentResult;

    String SECRET_KEY = "sk_test_51LB3LrDtw3sjgzxcDD4brCvIFAIYy3LpvEQFyea2XTrkKbfqF2fhayzRvhRdi8egAxMdqRtFwO0EYJWnByoQUFB600KtyPAPyU";
    String PUBLIC_KEY = "pk_test_51LB3LrDtw3sjgzxcfcAmIzaAldXCgm6xCuDirpoOh4d9hUBdGNAr35aqDBIoBYGZiAAepgGlBi2iPj7RBUzTEqIP00KhDcPv37";
    PaymentSheet paymentSheet;
    String customerID;
    String EphericalKey;
    String ClientSecret;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donations_detail);

        imageViewIntentResult = findViewById(R.id.image);
        TextView name = findViewById(R.id.name);
        TextView site = findViewById(R.id.site);
        TextView description = findViewById(R.id.description);
        likeBtn = findViewById(R.id.likeBtn);
        Button backBtn = findViewById(R.id.backBtn);



        Button button = findViewById(R.id.button);


        final Donations donations = getIntent().getParcelableExtra("donations");

        Glide.with(this).load(donations.getImage()).into(imageViewIntentResult);

        name.setText(donations.getName());
        site.setText(donations.getSite());
        description.setText(donations.getDescription());
//        String s = "<b>" + donations.getName() + "</b>" + " " + donations.getSite();
        Boolean hearted = getIntent().getBooleanExtra("hearted", false);

        backBtn.setOnClickListener(view -> {
            onBackPressed();
        });


        likeBtn.setOnClickListener(v -> {
            Toast.makeText(v.getContext(), "Saved", Toast.LENGTH_SHORT).show();

            if (donations.getLikeBtn()==R.drawable.heart) {

                Glide.with(likeBtn.getContext()).load(R.drawable.hearted).into(likeBtn);

            } else {
                Glide.with(likeBtn.getContext()).load(R.drawable.heart).into(likeBtn);

            }

        });

//        PaymentConfiguration.init(this, PUBLIC_KEY);
//        paymentSheet = new PaymentSheet(this, this::onPaymentRewult);

        button.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), PaymentActivity.class);
            startActivity(intent);
            //PaymentFlow();
        });




//        StringRequest stringRequest = new StringRequest(Request.Method.POST,
//                "https://api.stripe.com/v1/customers",
//                response -> {
//
//                    try {
//                        JSONObject object = new JSONObject(response);
//                        customerID = object.getString("id");
//                        Toast.makeText(DonationsDetailActivity.this, customerID, Toast.LENGTH_SHORT).show();
//
//                        getEphericalKey(customerID);
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }, error -> {
//
//        }){
//            @Override
//            public Map<String, String> getHeaders() {
//                Map<String, String> header = new HashMap<>();
//                header.put("Authorization", "Bearer " + SECRET_KEY);
//                return header;
//            }
//        };
//
//        RequestQueue requestQueue = Volley.newRequestQueue(DonationsDetailActivity.this);
//        requestQueue.add(stringRequest);
    }

//    private void getEphericalKey(String customerID){
//
//        StringRequest stringRequest = new StringRequest(Request.Method.POST,
//                "https://api.stripe.com/v1/ephemeral_keys",
//                response -> {
//
//                    try {
//                        JSONObject object = new JSONObject(response);
//                        EphericalKey = object.getString("id");
//                        Toast.makeText(DonationsDetailActivity.this, EphericalKey, Toast.LENGTH_SHORT).show();
//
//                        getClientSecret(customerID, EphericalKey);
//
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//
//                }, error -> {
//
//        }){
//            @Override
//            public Map<String, String> getHeaders() {
//                Map<String, String> header = new HashMap<>();
//                header.put("Authorization", "Bearer " + SECRET_KEY);
//                header.put("Stripe-Version", "2020-08-27");
//                return header;
//            }
//
//            @NonNull
//            @Override
//            protected Map<String, String> getParams() {
//                Map<String, String> parametrs = new HashMap<>();
//                parametrs.put("customer", customerID);
//                return parametrs;
//            }
//        };
//
//        RequestQueue requestQueue = Volley.newRequestQueue(DonationsDetailActivity.this);
//        requestQueue.add(stringRequest);
//
//    }
//
//
//    private void getClientSecret(String customerID, String ephericalKey){
//
//        StringRequest stringRequest = new StringRequest(Request.Method.POST,
//                "https://api.stripe.com/v1/payment_intents",
//                response -> {
//
//                    try {
//                        JSONObject object = new JSONObject(response);
//                        ClientSecret = object.getString("client_secret");
//                        Toast.makeText(DonationsDetailActivity.this, ClientSecret, Toast.LENGTH_SHORT).show();
//
////                            PaymentFlow();
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//
//                }, error -> {
//
//        }){
//            @Override
//            public Map<String, String> getHeaders() {
//                Map<String, String> header = new HashMap<>();
//                header.put("Authorization", "Bearer " + SECRET_KEY);
//                return header;
//            }
//
//            @NonNull
//            @Override
//            protected Map<String, String> getParams() {
//                Map<String, String> params = new HashMap<>();
//                params.put("customer", customerID);
//                params.put("amount", "1000" + "00");
//                params.put("currency", "usd");
//                params.put("automatic_payment_methods[enabled]", "true");
//                return params;
//            }
//        };
//
//        RequestQueue requestQueue = Volley.newRequestQueue(DonationsDetailActivity.this);
//        requestQueue.add(stringRequest);
//
//    }
//
//    private void PaymentFlow(){
//
//        paymentSheet.presentWithPaymentIntent(
//                ClientSecret, new PaymentSheet.Configuration("ABC Company"
//                        ,new PaymentSheet.CustomerConfiguration(
//                        customerID,
//                        EphericalKey
//                ))
//        );
//    }
//
//    private void onPaymentRewult(PaymentSheetResult paymentSheetResult){
//        if(paymentSheetResult instanceof PaymentSheetResult.Completed){
//            Toast.makeText(this, "payment success", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
//            startActivity(intent);
//        }
//    }
}