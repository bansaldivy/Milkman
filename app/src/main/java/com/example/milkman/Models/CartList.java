package com.example.milkman.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class CartList {
    String title, imageUrl, price;

    public CartList() {

    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public CartList(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    /*public CartList(Parcel in) {
        super();
        readFromParcel(in);
    }

    public static final Parcelable.Creator<CartList> CREATOR = new Parcelable.Creator<CartList>() {
        public CartList createFromParcel(Parcel in) {
            return new CartList(in);
        }

        public CartList[] newArray(int size) {

            return new CartList[size];
        }
    };

    public void readFromParcel(Parcel in) {
        String[] result = new String[3];
        in.readStringArray(result);

        this.title = result[0];
        this.imageUrl = result[1];
        this.price = result[2];
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{this.title,this.imageUrl,this.price});
    }*/
}

