package es.master.p3_retrofitweb.hotel;

import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.SerializedName;

public class ThumbURL {

    @SerializedName("srpDesktop")
    private String imageURL;

    public ThumbURL() {
        // Constructor vacío
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @NonNull
    @Override
    public String toString() {
        return "ThumbURL{" +
                "imageURL='" + imageURL + '\'' +
                '}';
    }
}
