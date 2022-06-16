package com.example.diplomaproject.ClothesCategory;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.example.diplomaproject.R;

import java.util.List;

public class Clothes implements Parcelable{

    public static List<com.example.diplomaproject.ClothesCategory.Clothes> clothesList;
    private int image;
    private String name;
    private String site;
    private String description;



    private int likeBtn;
    private boolean hearted = false;




    public int getLikeBtn() { return likeBtn; }
    public void setLikeBtn(int likeBtn) { this.likeBtn = likeBtn; }





    public Clothes(int image, String name,  String site, String description) {
        this.image = image;
        this.name = name;
        this.site = site;
        this.description=description;
        this.likeBtn = R.drawable.heart;
    }



    protected Clothes(Parcel in) {
        image = in.readInt();
        name = in.readString();
        site = in.readString();
        description = in.readString();
    }

    public static final Creator<com.example.diplomaproject.ClothesCategory.Clothes> CREATOR = new Creator<com.example.diplomaproject.ClothesCategory.Clothes>() {
        @Override
        public com.example.diplomaproject.ClothesCategory.Clothes createFromParcel(Parcel in) {
            return new com.example.diplomaproject.ClothesCategory.Clothes(in);
        }

        @Override
        public com.example.diplomaproject.ClothesCategory.Clothes[] newArray(int size) {
            return new com.example.diplomaproject.ClothesCategory.Clothes[size];
        }
    };


    public boolean getHeart() {
        return hearted;
    }
    public void setHeart(boolean heart) {
        hearted=heart;
    }

    public int getImage() {return image;}

    public String getName() {
        return name;
    }

    public String getSite() {
        return site;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setheart(boolean hearted) {
        this.hearted = hearted;
    }

    public String getDescription(){return description;}
    public void setDescription(String description){ this.description=description;}

    @NonNull
    @Override
    public String toString() {
        return "Clothes{" + "name='" + name + '\'' +", image='" + image + '\'' +", site='" + site + '\'' +'}';
    }


    public int describeContents() {
        return 0;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(image);
        dest.writeString(name);
        dest.writeString(site);
        dest.writeString(description);
    }

}