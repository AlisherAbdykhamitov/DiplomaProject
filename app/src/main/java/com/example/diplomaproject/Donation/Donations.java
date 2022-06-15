package com.example.diplomaproject.Donation;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.example.diplomaproject.R;

import java.util.List;

public class Donations implements Parcelable{

    public static List<Donations> donationsList;
    private int image;
    private String name;
    private String site;
    private int likeBtn;
    private boolean hearted = false;

    public int getLikeBtn() { return likeBtn; }

    public void setLikeBtn(int likeBtn) { this.likeBtn = likeBtn; }


    public Donations(int image, String name,  String site) {
        this.image = image;
        this.name = name;
        this.site = site;
        this.likeBtn = R.drawable.heart;

    }
    protected Donations(Parcel in) {
        image = in.readInt();
        name = in.readString();
        site = in.readString();

    }

    public static final Creator<Donations> CREATOR = new Creator<Donations>() {
        @Override
        public Donations createFromParcel(Parcel in) {
            return new Donations(in);
        }

        @Override
        public Donations[] newArray(int size) {
            return new Donations[size];
        }
    };

    public boolean getHeart() {
        return hearted;
    }
    public void setHeart(boolean heart) {
        hearted=heart;
    }

    public int getImage() {
        return image;
    }

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

    @NonNull
    @Override
    public String toString() {
        return "Donations{" + "name='" + name + '\'' +", image='" + image + '\'' +", site='" + site + '\'' +'}';
    }


    public int describeContents() {
        return 0;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(image);
        dest.writeString(site);
    }

}
