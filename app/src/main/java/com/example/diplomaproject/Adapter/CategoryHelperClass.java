package com.example.diplomaproject.Adapter;

import android.graphics.drawable.GradientDrawable;


public class CategoryHelperClass {
    GradientDrawable gradient;
    int image;
    String text;

    public CategoryHelperClass(GradientDrawable gradient, int image, String text) {
        this.gradient = gradient;
        this.image = image;
        this.text = text;
    }

    public GradientDrawable getBackground() {return gradient;}

    public int getImage() {return image;}

    public String getText() {return text;}


}
