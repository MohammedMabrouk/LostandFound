package com.mabrouk.mohamed.lostandfound.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {
    private String itemName;
    private String itemDescription;
    private String postDateTime;
    private String itemOwner;
    private String city;
    private String district;
    private String imgUrl;
    private int numOfComments;
    private int numOfFollowers;

    public Item() {
        itemName = "";
        itemDescription = "";
        postDateTime = "";
        imgUrl = "";
        numOfComments = 0;
        numOfFollowers = 0;
        itemOwner = "";
        city = "";
        district = "";
    }

    public Item(String itemName,
                String itemDescription,
                String postDateTime,
                String itemOwner,
                String city,
                String district,
                String imgUrl,
                int numOfComments,
                int numOfFollowers) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.postDateTime = postDateTime;
        this.imgUrl = imgUrl;
        this.numOfComments = numOfComments;
        this.numOfFollowers = numOfFollowers;
        this.itemOwner = itemOwner;
        this.city = city;
        this.district = district;
    }

    protected Item(Parcel in) {
        itemName = in.readString();
        itemDescription = in.readString();
        postDateTime = in.readString();
        itemOwner = in.readString();
        city = in.readString();
        district = in.readString();
        imgUrl = in.readString();
        numOfComments = in.readInt();
        numOfFollowers = in.readInt();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getPostDateTime() {
        return postDateTime;
    }

    public void setPostDateTime(String postDateTime) {
        this.postDateTime = postDateTime;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getNumOfComments() {
        return numOfComments;
    }

    public void setNumOfComments(int numOfComments) {
        this.numOfComments = numOfComments;
    }

    public int getNumOfFollowers() {
        return numOfFollowers;
    }

    public void setNumOfFollowers(int numOfFollowers) {
        this.numOfFollowers = numOfFollowers;
    }

    public String getItemOwner() {
        return itemOwner;
    }

    public void setItemOwner(String itemOwner) {
        this.itemOwner = itemOwner;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(itemName);
        dest.writeString(itemDescription);
        dest.writeString(postDateTime);
        dest.writeString(itemOwner);
        dest.writeString(city);
        dest.writeString(district);
        dest.writeString(imgUrl);
        dest.writeInt(numOfComments);
        dest.writeInt(numOfFollowers);
    }
}
