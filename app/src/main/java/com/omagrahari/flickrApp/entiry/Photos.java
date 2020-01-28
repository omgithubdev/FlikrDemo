package com.omagrahari.flickrApp.entiry;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.google.gson.annotations.SerializedName;
import com.omagrahari.flickrApp.R;
import com.squareup.picasso.Picasso;


/**
 * Created by omprakash on 28,January,2020
 */
public class Photos implements Parcelable {
    @SerializedName("id")
    String id;
    @SerializedName("owner")
    String owner;
    @SerializedName("secret")
    String secret;
    @SerializedName("server")
    String server;
    @SerializedName("farm")
    String farm;
    @SerializedName("title")
    String title;
    @SerializedName("ispublic")
    String ispublic;
    @SerializedName("isfriend")
    String isfriend;
    @SerializedName("isfamily")
    String isfamily;

    protected Photos(Parcel in) {
        id = in.readString();
        owner = in.readString();
        secret = in.readString();
        server = in.readString();
        farm = in.readString();
        title = in.readString();
        ispublic = in.readString();
        isfriend = in.readString();
        isfamily = in.readString();
    }

    public static final Creator<Photos> CREATOR = new Creator<Photos>() {
        @Override
        public Photos createFromParcel(Parcel in) {
            return new Photos(in);
        }

        @Override
        public Photos[] newArray(int size) {
            return new Photos[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getFarm() {
        return farm;
    }

    public void setFarm(String farm) {
        this.farm = farm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIspublic() {
        return ispublic;
    }

    public void setIspublic(String ispublic) {
        this.ispublic = ispublic;
    }

    public String getIsfriend() {
        return isfriend;
    }

    public void setIsfriend(String isfriend) {
        this.isfriend = isfriend;
    }

    public String getIsfamily() {
        return isfamily;
    }

    public void setIsfamily(String isfamily) {
        this.isfamily = isfamily;
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {

        if (url != null)
            Picasso.get().load(url).placeholder(R.drawable.placeholder_img).into(imageView);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(owner);
        parcel.writeString(secret);
        parcel.writeString(server);
        parcel.writeString(farm);
        parcel.writeString(title);
        parcel.writeString(ispublic);
        parcel.writeString(isfriend);
        parcel.writeString(isfamily);
    }
}
